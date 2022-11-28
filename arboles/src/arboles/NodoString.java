package arboles;

/**
 *
 * @author danie
 */
public class NodoString {
    String dato;
    NodoString izq;
    NodoString der;
    
    NodoString(String s){
        dato = s;
        izq = der = null;
    }
    
    public void setIzq(NodoString nodo){
        izq = nodo;
    }
    
    public void setDer(NodoString nodo){
        der = nodo;
    }
    
    public NodoString getIzq(){
        return izq;
    }
    
    public NodoString getDer(){
        return der;
    }
    
    public String getDato(){
        return dato;
    }
}
