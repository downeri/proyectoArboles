package arboles;



import java.util.LinkedList;
import java.util.Queue;

/**
 * Modela un árbol binario general
 * @author Prof. Tista García Edgar, modificado por Equipo 5
 */
public class ArbolBin {
    /**
     * La raíz del aarbol
     */
    Nodo root;
    
    /**
     * Crea un árbol vacío
     */
    public ArbolBin(){
        root=null;
    }
    
    /**
     * Crea un árbol con el nodo raíz con el valor especificado
     * @param val El valor que tendrpa el nodo raiz
     */
    public ArbolBin(int val){
        root=new Nodo(val);
    }
    
    /**
     * Crea un árbol con el nodo especificado como raíz
     * @param root El nodo que se establece como raíz
     */
    public ArbolBin(Nodo root){
        this.root=root;
    }
    
    public void add(Nodo padre, Nodo hijo, int lado){
	if(lado==0)
            padre.setIzq(hijo);
	else
            padre.setDer(hijo);
    }
    
    /**
     * Elimina el nodo especificado del árbol
     * @param nodo El nodo que se quiere eliminar del árbol
     */
    public void remove(Nodo nodo){
        Nodo nodoPadre=searchParent(nodo);
        if(nodoPadre==null)
            System.out.print("No existe el nodo en el árbol");
        else{
            int lado;
            if(nodoPadre.izq==nodo)
                lado=0;
            else
                lado=1;
            if(nodo.isLeaf()){
                nodoPadre.disconnect(lado);
                return;
            }
            if(nodo.der==null&&nodo.izq!=null){
                nodoPadre.setLado(nodo.izq, lado);
                return;
            }
            if(nodo.der!=null&&nodo.izq==null){
               nodoPadre.setLado(nodo.der, lado); 
               return;
            }
            if(nodo.der!=null&&nodo.izq!=null){
                Nodo next=nodo.izq;
                while(next.izq!=null){
                    if(next.izq==null)
                        break;
                    next=next.izq;
                }
                searchParent(next).disconnect(0);
                next.setIzq(next.izq);
                next.setDer(next.der);
                nodoPadre.setLado(next, lado);
            }
        }
    }
    
    /**
     * Genera una lista de los nodos contenidos en el árbol utilizando el recorrido BreadthFirstSearch
     * @return Una lista ligada del recorrido BFS del árbol
     */
    public LinkedList<Nodo> getBreadthFirst(){
        LinkedList<Nodo> BFS=new LinkedList<>();
        System.out.println("\n\nÁrbol: ");
        Nodo r = root;
	Queue<Nodo> queue = new LinkedList();
	if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r = (Nodo)queue.poll();
                if(r!=null){
                    BFS.add(r);
                    if(r.izq!=null)
                        queue.add(r.izq);
                    else
                        queue.add(null);
                    if(r.der!=null)
                        queue.add(r.der);
                    else
                        queue.add(null);
                }else{
                    BFS.add(null);
                }
            }
	}
        return BFS;
    }
    /**
     * Imprime en consola el recorrido Breadth First Search del árbol
     */
    public void breadthFirst(){
        LinkedList<Nodo> l=getBreadthFirst();
        int i=-1;
        for(Nodo n: l){
            i++;
            if(n!=null){
                if(n.isLeaf())
                    System.out.println(n.valor+" Sin hijos");
                else if(n.izq==null&&n.der!=null)
                    System.out.println(n.valor+". Sin hijo izquierdo. Hijo derecho: "+n.der.valor);  
                else if(n.izq!=null&&n.der==null)
                    System.out.println(n.valor+" Hijo iquierdo: "+n.izq.valor+" Sin hijo derecho");  
                else if(n.izq!=null&&n.der!=null)
                    System.out.println(n.valor+" Hijo iquierdo: "+n.izq.valor+" Hijo derecho: "+n.der.valor);  
            }
        }
        System.out.println("");
    }
    
    /**
     * Busca el nodo padre de un nodo especificado
     * @param nodoABuscar El nodo del cual se desea conocer su nodo padre
     * @return El nodo padre del nodo especificado
     */
    public Nodo searchParent(Nodo nodoABuscar){
        Nodo r = this.root;
	Queue<Nodo> queue = new LinkedList();
	if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r = (Nodo)queue.poll();
		if(r.izq!=null){
                    if(r.izq.equals(nodoABuscar))
                        return r;
                    queue.add(r.izq);
                }
		if(r.der!=null){
                    if(r.der.equals(nodoABuscar))
                        return r;
                    queue.add(r.der);
                }
            }
	}
        return null;
    }
    /**
     * Busca si el nodo se encuentra en el árbol
     * @param nodoABuscar El nodo que se quiere verificar si está en el árbol
     * @return True si el nodo está en el árbol, False si no
     */
    public Boolean buscar(Nodo nodoABuscar){
        Nodo r = this.root;
	Queue<Nodo> queue = new LinkedList();
	if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r = (Nodo)queue.poll();
		if(r.izq!=null){
                    if(r.izq.equals(nodoABuscar))
                        return true;
                    queue.add(r.izq);  
                }
		if(r.der!=null){
                    if(r.der.equals(nodoABuscar))
                        return true;
                    queue.add(r.der);
                }
            }
	}
        return false;
    }
    /**
     * Busca en el arbol si existe un nodo con el valor especificado
     * @param valor El numero entero que se quiere encontrar en el árbol
     * @return True si el nodo está en el árbol, False si no
     */
    public Boolean buscar(int valor){
        Nodo r = this.root;
	Queue<Nodo> queue = new LinkedList();
	if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r = (Nodo)queue.poll();
		if(r.izq!=null){
                    if(r.izq.valor==valor)
                        return true;
                    queue.add(r.izq);  
                }
		if(r.der!=null){
                    if(r.der.valor==valor)
                        return true;
                    queue.add(r.der);
                }
            }
	}
        return false;
    }
     
}
