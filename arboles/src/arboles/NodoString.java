package arboles;

/**
 * La clase modela un nodo con datos de tipos String
 */

public class NodoString extends Nodo{
    
    /**
     * Almacena el dato
     */
    public String valor;
    
    /**
     * Hace referencia al hijo izquierdo
     */
    public NodoString izq;
    
    /**
     * Hace referencia al hijo derecho
     */
    public NodoString der;

    
    /**
     * Método constructor del nodo
     * @param s es el dato almacenado
     */
    NodoString(String s){
        valor = s;
        izq = der = null;
    }
    
    /**
     * Asigna la referencia del nodo izquierdo
     * @param nodo es el nodo hijo izquierdo
     */
    public void setIzq(NodoString nodo){
        izq = nodo;
    }
    
    /**
     * Asigna la referencia del nodo derecho
     * @param nodo es el nodo hijo derecho
     */
    public void setDer(NodoString nodo){
        der = nodo;
    }
    
    /**
     * @return devuelve el hijo izquierdo
     */
    public NodoString getIzq(){
        return izq;
    }
    
    /**
     * @return devuelve el hijo derecho
     */
    public NodoString getDer(){
        return der;
    }
    
    /**
     * @return devuelve el dato del nodo
     */
    public String getDato(){
        return valor;
    }
}
