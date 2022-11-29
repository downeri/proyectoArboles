package arboles;

/**
 *
 * @author danie
 */
public class NodoString extends Nodo{
    public String valor;
    public NodoString izq;
    public NodoString der;
    
    NodoString(String s){
        valor = s;
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
        return valor;
    }
}
