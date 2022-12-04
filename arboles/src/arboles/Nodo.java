package arboles;

/**
 *Representa a un nodo del árbol
 * @author Prof. Tista Garcia Edgar, modificado por Equipo 5
 */
public class Nodo {
    
    /**
     * El contenido del nodo
     */
    public int valor;
    /**
     * Apuntador hacia su nodo hijo izqierdo
     */
    public Nodo izq = null;
    /**
     * Apuntador hacia su nodo hijo derecho
     */
    public Nodo der = null;
    
    /**
     * Crea un nodo con valor 0 y sun nodos hijos
     */
    public Nodo(){
        izq=der=null;
    }
    /**
     * Crea un nodo con un valor especificado y sin hijos
     * @param data El valor que se desea tenga el nodo creado
     */
    public Nodo(int data){
        this(data,null,null);
    }
    /**
     * Crea un nodo especificando su valor y sus nodos hijos
     * @param data El valor que se desea tenga el nodo creado
     * @param lt El nodo hijo izquierdo
     * @param rt El nodo hijo derecho
     */
    public Nodo(int data, Nodo lt, Nodo rt){
        valor=data;
        izq = lt;
        der = rt;
    }   
    
    /**
     * Establece como hijo izquierdo el nodo proporcionado
     * @param izq El nodo a establecer como hijo izquierdo
     */
    public void setIzq(Nodo izq) {
        this.izq = izq;
    }
    
    /**
     * Establece como hijo derecho el nodo proporcionado
     * @param der El nodo a establecer como hijo derecho
     */
    public void setDer(Nodo der) {
        this.der = der;
    }
    
    /**
     * Establece como hijo, ya sea derecho o izqiuerdo, el nodo proporcionado dependiendo de lo indicado por el entero
     * @param nodo El nodo que se desea establecer como hijo
     * @param lado El lado en el cual será establecido. 0. Izquierdo Cualquier otro. Derecho
     */
    public void setLado(Nodo nodo, int lado){
        if(lado==0)
            this.izq=nodo;
        else if(lado>0)
            this.der=nodo;
    }
    
    /**
     * Indica si el nodo es un nodo hoja
     * @return True si es una hoja. False si no es una hoja
     */
    public Boolean isLeaf(){
        if(this.der==null&&this.izq==null)
            return true;
        return false;
    }
    /**
     * Desconecta al nodo padre del nodo hijo indicado por el lado
     * @param lado El lado el cual será desconectado del padre. 0. Izquierdo Cualquier otro. Derecho
     */
    public void disconnect(int lado){
        if(lado==0)
            this.izq=null;
        else
            this.der=null;
    }
    
}
