package arboles;

/**
 *
 * @author danie
 */
import java.util.Stack;
import java.util.ArrayList;

public class ArbolExpArit extends ArbolBin {

    public NodoString root;
    
    /*
        Método constructor
        Elimina todo espacio, tabulacion y otros raros
        Se verifica la validez de la ecuacion 
    */
    public ArbolExpArit(String ecuacion) {
        ecuacion = ecuacion.replaceAll("\\s", "");
        if (validez(ecuacion)) {
            root = Creacion(ecuacion);
        } else {
            root = null;
        }
    }

    /*
        Devuelve un valor booleano según sea valido o no
    */
    private boolean isOperator(char c) {
        switch (c) {
            case ('('):
            case (')'):
            case ('^'):
            case ('*'):
            case ('/'):
            case ('+'):
            case ('-'):
                return true;
            default:
                return false;
        }
    }

    /*
        Se verifica la validez de la ecuacion 
        Revisando que no haya dos simbolos operadores seguidos (excepto parentesis)
        Y que los parentesis estén bien escritos
    */
    private boolean validez(String ecuacion) {
        Stack<Character> parentesis = new Stack<>();
        for (int i = 0; i < ecuacion.length(); i++) {
            if (!Character.isDigit(ecuacion.charAt(i))) {
                if (isOperator(ecuacion.charAt(i))) {
                    if (ecuacion.charAt(i) == '(') {
                        parentesis.push('(');
                    } else if (ecuacion.charAt(i) == ')' && !parentesis.empty()) {
                        parentesis.pop();
                    } else if (ecuacion.charAt(i) == ')' && parentesis.empty()) {
                        return false;
                    } else if (i + 1 < ecuacion.length()) {
                        switch (ecuacion.charAt(i + 1)) {
                            case ('^'):
                            case ('*'):
                            case ('/'):
                            case ('+'):
                            case ('-'):
                                return false;
                        }
                    }

                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /*
        Permite crear un subarboles
    */
    private NodoString subArbol(NodoString nodo, NodoString izq, NodoString der) {
        nodo.setIzq(izq);
        nodo.setDer(der);
        return nodo;
    }

    /*
        Devuelve un valor de prioridad entre más grande más prioridad
        Considera a los parentesis como la mayor prioridad
    */
    private short prioridad(String s) {
        char c = s.charAt(0);
        switch (c) {
            case ('+'):
            case ('-'):
                return 1;
            case ('*'):
            case ('/'):
                return 2;
            case ('^'):
                return 3;
            default:
                return 0;
        }
    }

    /*
    Desapila 2 elementos de los terminos y un operador para unirlos en un solo termino 
    */
    private NodoString construirTermino(Stack<NodoString> pTerminos, Stack<NodoString> pOperaciones) {
        NodoString b = pTerminos.pop();
        NodoString a = pTerminos.pop();
        NodoString operacion = pOperaciones.pop();
        return subArbol(operacion, a, b);
    }

    /*
        Permite obtener números de más de una cifra, si no es un número no hace nada
    */
    private int getIndexNumbers(String ec, int i) {
        int index = 1;
        if (isOperator(ec.charAt(i))) {
            return 1;
        }
        for (int j = i; j < ec.length(); j++) {
            index = j - i + 1;
            if (j + 1 >= ec.length()) {
                break;
            } else if (!(Character.isDigit(ec.charAt(j + 1)))) {
                break;
            }
        }
        return index;
    }

    /*
        Convierte la cadena de caracteres en un arreglo con cada termino
        Si hay dos numeros seguidos se verifica aquí
    */
    private ArrayList<String> toArrayList(String ecuacion) {
        ArrayList<String> ec = new ArrayList<>();
        for (int i = 0; i < ecuacion.length();) {
            int j = getIndexNumbers(ecuacion, i);
            ec.add(ecuacion.substring(i, i + j));
            i += j;
        }
        return ec;
    }

    /*
        -Crea el árbol de expresiones aritmeticas
        -Si es un número el termino evaluado va a la pila de terminos
        -Si no va a la pila de operaciones
        -Se crean subarboles de izquierda a derecha leyendo el arreglo de la
        expresion aritmetica. Formando subárboles según la prioridad del operador
        -Formando subarboles al desapilar las pilas, 2 de terminos y uno de operacion,
        operacion es el padre de estos, el subarbol es un nuevo termino y se apila
        -Como lo que está dentro del parentesis se realiza primero, se crea un subárbol
        de todo lo que esté contenido en ello
        -Una vez se recorre todo el arreglo si aun quedan terminos en las pilas
        se van desapilando los terminos y creando subarboles hasta que solo quede uno
        ese subarbol es el arbol de expresion aritmetica
    */
    private NodoString Creacion(String ecuacion) {
        Stack<NodoString> pilaTerminos = new Stack<>();
        Stack<NodoString> pilaOperaciones = new Stack<>();
        NodoString nodoTermino;

        ArrayList<String> ec = toArrayList(ecuacion);

        for (int i = 0; i < ec.size(); i++) {
            String termino = ec.get(i);
            nodoTermino = new NodoString(termino);
            if (!isOperator(termino.charAt(0))) {
                pilaTerminos.push(nodoTermino);
            } else {
                switch (termino.charAt(0)) {
                    case ('('):
                        pilaOperaciones.push(nodoTermino);
                        break;
                    case (')'):
                        while (!pilaOperaciones.empty() && !(pilaOperaciones.peek()).getDato().equals("(")) {
                            pilaTerminos.push(construirTermino(pilaTerminos, pilaOperaciones));
                        }
                        pilaOperaciones.pop();
                        break;
                    default:
                        while (!pilaOperaciones.empty() && prioridad(termino) <= prioridad((pilaOperaciones.peek()).getDato())) {
                            pilaTerminos.push(construirTermino(pilaTerminos, pilaOperaciones));
                        }
                        pilaOperaciones.push(nodoTermino);
                }
            }
        }
        while (!pilaOperaciones.empty()) {
            pilaTerminos.push(construirTermino(pilaTerminos, pilaOperaciones));
        }

        return pilaTerminos.pop();
    }

    /*
        Recorre en postOrden pero también realiza la operacion aritmetica
    */
    public String postOrden() {
        ArrayList<String> list = new ArrayList<>();
        Stack<String> ecuacion = new Stack<>();
        System.out.print("Postorder:");
        postOrden(root, ecuacion, list);

        System.out.println(list);
        if (!ecuacion.empty()) {
            String u=ecuacion.pop();
            System.out.println("La solución de la ecuacion es: " + u);
            return u;
        } else {
            System.out.println("Ecuacion no valida");
        }
        return "Ecuacion no valida";
    }

    /*
        Realiza el verdadero recorrido y con una pila realiza la operacion por la notacion polaca inversa
    */
    private void postOrden(NodoString nodo, Stack<String> ecuacion, ArrayList<String> listaPostOrden) {
        if (nodo == null) {
            return;
        }
        postOrden(nodo.getIzq(), ecuacion, listaPostOrden);
        postOrden(nodo.getDer(), ecuacion, listaPostOrden);

        String dato = nodo.getDato();
        ecuacion.push(dato);
        listaPostOrden.add(dato);

        resolverEcuacion(ecuacion, dato);
    }

    /*
        Resuelve la operacion con una pila
    */
    private void resolverEcuacion(Stack<String> ecuacion, String dato) {
        if (isOperator(dato.charAt(0))) {
            String operador = ecuacion.pop();
            double b = Double.parseDouble(ecuacion.pop());
            double a = Double.parseDouble(ecuacion.pop());

            double doble;
            switch (operador.charAt(0)) {
                case ('+'):
                    doble = a + b;
                    break;
                case ('-'):
                    doble = a - b;
                    break;
                case ('*'):
                    doble = a * b;
                    break;
                case ('/'):
                    doble = a / b;
                    break;
                default:
                    doble = Math.pow(a, b);
            }
            ecuacion.push(String.valueOf(doble));
        }
    }
    
    public int calcularAltura(NodoString nodo){
        return calcularAlturaS(nodo)-1;
    }
    

    private int calcularAlturaS(NodoString nodo){
        if(nodo==null)
            return 0;
        int i=calcularAlturaS(nodo.izq);
        int d=calcularAlturaS(nodo.der);
        return (Integer.max(i, d)+1);
    }
}
