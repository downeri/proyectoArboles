package arboles;

/**
 *
 * @author danie
 */
import java.util.Stack;
import java.util.ArrayList;

public class ArbolExpArit {

    NodoString root;

    ArbolExpArit(String ecuacion) { //Metodo constructor
        ecuacion = ecuacion.replaceAll("\\s", ""); //Elimina todo espacio, tabulacion y otros raros
        if (validez(ecuacion)) { //Se verifica que la esctructura de la ec sea valida
            root = Creacion(ecuacion); //si lo es se crea el arbol
        } else {
            root = null; //Si no se retorna un arbol vacio
        }
    }

    private boolean isOperator(char c) { //Devuelve un valor booleano según sea valido o no
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

    private NodoString subArbol(NodoString nodo, NodoString izq, NodoString der) { //Crea un subarbol
        nodo.setIzq(izq);
        nodo.setDer(der);
        return nodo;
    }

    private short prioridad(String s) { //devuelve un valor de prioridad entre más grande más prioridad
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
                return 0; //Para el '(' y el ')'
        }
    }

    //Desapila 2 elementos de los terminos y un operador para unirlos en un solo termino 
    private NodoString construirTermino(Stack<NodoString> pTerminos, Stack<NodoString> pOperaciones) {
        NodoString b = pTerminos.pop();
        NodoString a = pTerminos.pop();
        NodoString operacion = pOperaciones.pop();
        return subArbol(operacion, a, b);
    }

    //Permite obtener números de más de una cifra, si no es un número no hace nada
    private int getIndexNumbers(String ec, int i) {
        int index = 1;
        if (isOperator(ec.charAt(i))) { //Si no es numero no hace nada
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

    //Convierte la cadena de caracteres en un arreglo con cada termino
    private ArrayList<String> toArrayList(String ecuacion) {
        ArrayList<String> ec = new ArrayList<>();
        for (int i = 0; i < ecuacion.length();) {
            int j = getIndexNumbers(ecuacion, i);
            ec.add(ecuacion.substring(i, i + j)); //En el caso de que se ingresen numeros de más de un digito
            i += j;
        }
        return ec;
    }

    //Crea el árbol de expresiones aritmeticas
    private NodoString Creacion(String ecuacion) {
        Stack<NodoString> pilaTerminos = new Stack<>();
        Stack<NodoString> pilaOperaciones = new Stack<>();
        NodoString nodoTermino;

        ArrayList<String> ec = toArrayList(ecuacion);

        for (int i = 0; i < ec.size(); i++) {
            String termino = ec.get(i);
            nodoTermino = new NodoString(termino);
            if (!isOperator(termino.charAt(0))) {
                pilaTerminos.push(nodoTermino); //añade los números
            } else { //Si no es un número
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
                    default: //Si no es un parentesis
                        while (!pilaOperaciones.empty() && prioridad(termino) <= prioridad((pilaOperaciones.peek()).getDato())) {
                            pilaTerminos.push(construirTermino(pilaTerminos, pilaOperaciones));
                        }
                        pilaOperaciones.push(nodoTermino);
                }
            }
        }
        while (!pilaOperaciones.empty()) { //Si quedan elementos (Seran los de menor jerarquía)
            pilaTerminos.push(construirTermino(pilaTerminos, pilaOperaciones));
        }

        //Devuelve el árbol que es lo único que queda
        return pilaTerminos.pop();
    }

    //Recorre en postOrden pero también realiza la operacion aritmetica
    public void postOrden() {
        ArrayList<String> list = new ArrayList<>();
        Stack<String> ecuacion = new Stack<>();
        System.out.print("Postorder:");
        postOrden(root, ecuacion, list);

        System.out.println(list);
        if (!ecuacion.empty()) {
            System.out.println("La solución de la ecuacion es: " + ecuacion.pop()); //Si es una operacion valida
        } else {
            System.out.println("Ecuacion no valida");
        }
    }

    //Realiza el verdadero recorrido y con una pila realiza la operacion por la notacion polaca inversa
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

    //Resuelve la operacion con una pila
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
}
