package arboles;

/**
 * La clase modela una arbol de expresiones aritmeticas
 * donde cada nodo almacena datos de tipo string
 */
import java.util.Stack;
import java.util.ArrayList;

public class ArbolExpArit extends ArbolBin {


    /**
     * La referencia del nodo raíz
     */
    NodoString root;

    /**
     * Método constructor
     * @param expresion es la cadena de caracteres que representa la expresion
     */
    ArbolExpArit(String expresion) {
        expresion = expresion.replaceAll("\\s", "");
        if (validez(expresion)) {
            root = Creacion(expresion);
        } else {
            root = null;
        }
    }

    /**
     * Permite identificar si un caracter es un operador valido
     * @param c es el caracter evaluado
     * @return true en caso de ser valido o false en caso contrario
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

    /**
     * Verifica la validez de la expresion 
     * @param expresion
     * @return un valor booleano true en caso de ser valida,
     * de lo contrario devuelve un false
     */
    private boolean validez(String expresion) {
        Stack<Character> parentesis = new Stack<>();
        for (int i = 0; i < expresion.length(); i++) {
            if (!Character.isDigit(expresion.charAt(i))) {
                if (isOperator(expresion.charAt(i))) {
                    if (expresion.charAt(i) == '(') {
                        parentesis.push('(');
                    } else if (expresion.charAt(i) == ')' && !parentesis.empty()) {
                        parentesis.pop();
                    } else if (expresion.charAt(i) == ')' && parentesis.empty()) {
                        return false;
                    } else if (i + 1 < expresion.length()) {
                        switch (expresion.charAt(i + 1)) {
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

    /**
     * Crea subarboles
     * @param nodo es la raiz del subarbol
     * @param izq es el hijo izquierdo del subarbol
     * @param der es de hijo derecho del subarbol
     * @return la raíz del subarbol construido
     */
    private NodoString subArbol(NodoString nodo, NodoString izq, NodoString der) {
        nodo.setIzq(izq);
        nodo.setDer(der);
        return nodo;
    }

    /**
     * Jeraquiza las prioridades de los operadores
     * @param s es el operador evaluado
     * @return el valor de prioridad que ocupa, entre más alto, mayor prioridad
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

    /**
     * Construte terminos a partir de las pilas de terminos y operadores
     * @param pTerminos es la pila de terminos
     * @param pOperaciones es la pila de operadores
     * @return el subarbol del termino creado
     */
    private NodoString construirTermino(Stack<NodoString> pTerminos, Stack<NodoString> pOperaciones) {
        NodoString b = pTerminos.pop();
        NodoString a = pTerminos.pop();
        NodoString operacion = pOperaciones.pop();
        return subArbol(operacion, a, b);
    }

    /**
     * Obtiene los intervalos para cada termino y operacion inicial
     * @param ec es la expresión evaluada
     * @param i la posición actual en la expresion
     * @return el intervalo del elemento
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

    /**
     * Convierte la cadena en un Array con cada termino como elemento
     * @param expresion es la expresion a convertir
     * @return el Array de terminos
     */
    private ArrayList<String> toArrayList(String expresion) {
        ArrayList<String> ec = new ArrayList<>();
        for (int i = 0; i < expresion.length();) {
            int j = getIndexNumbers(expresion, i);
            ec.add(expresion.substring(i, i + j));
            i += j;
        }
        return ec;
    }

    /**
     * Crea ell árbol de expresion aritmetica de izquierda a derecha y desde la
     * más alta prioridad hasta la mínima
     * @param expresion es la expresion a convertir en árbol
     * @return el arbol de expresion aritmetica construido o un valor null
     */
    private NodoString Creacion(String expresion) {
        Stack<NodoString> pilaTerminos = new Stack<>();
        Stack<NodoString> pilaOperaciones = new Stack<>();
        NodoString nodoTermino;

        ArrayList<String> ec = toArrayList(expresion);

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

        if(!pilaTerminos.empty()){
            return pilaTerminos.pop();
        }
        return null;
    }


    /**
     * Recorre en postOrden pero también realiza la operacion aritmetica
     */
    public void postOrden() {
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

    /**
     * Realiza el recorrido recursivo, realiza la operación en notación polaca inversa
     * usando una pila y almacena el postOrden en un ArrayList
     * @param nodo es el nodo actual del recorrido
     * @param expresion la expresion aritmetica 
     * @param listaPostOrden  el ArrayList donde se guarda el recorrido postOrden
     */
    private void postOrden(NodoString nodo, Stack<String> expresion, ArrayList<String> listaPostOrden) {
        if (nodo == null) {
            return;
        }
        postOrden(nodo.getIzq(), expresion, listaPostOrden);
        postOrden(nodo.getDer(), expresion, listaPostOrden);

        String dato = nodo.getDato();
        expresion.push(dato);
        listaPostOrden.add(dato);

        resolverEcuacion(expresion, dato);
    }

    /**
     * Resuelve la expresion por medio de la notacion polaca inversa
     * @param expresion la expresion evaluada
     * @param dato es la operación que se realiza
     */
    private void resolverEcuacion(Stack<String> expresion, String dato) {
        if (isOperator(dato.charAt(0))) {
            String operador = expresion.pop();
            double b = Double.parseDouble(expresion.pop());
            double a = Double.parseDouble(expresion.pop());

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
            expresion.push(String.valueOf(doble));
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
