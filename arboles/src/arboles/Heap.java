package arboles;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 
 *La clase modela una estructura Heap
 * @author Equipo 5
 */
public class Heap extends ArbolBin {
    
    /**
     * Agrega un nodo a la primera posición disponible
     * @param nodo El nodo a agregar
     */
    public void add(Nodo nodo){
        if(root==null){
            System.out.println("Agregando "+nodo.valor+" como raiz");
            root=nodo;
            return;
        }
        Nodo r=root;
        LinkedList<Nodo> queue = new LinkedList();
        queue.add(r);
        while(!queue.isEmpty()){
            r = (Nodo)queue.poll();
            if(r==null)
                continue;
            if(r.isLeaf()){
                System.out.println("Agregando "+nodo.valor+" a la izquierda de "+r.valor);
                r.setIzq(nodo);
                break;
            }
            if(r.izq!=null&&r.der==null){
                System.out.println("Agregando "+nodo.valor+" a la derecha de "+r.valor);
                r.setDer(nodo);
                break;
            }
            queue.add(r.izq);
            queue.add(r.der);
            
        }
        System.out.println("Heapify para "+nodo.valor);
        heapify(nodo);
    }
    
    /**
     * Asegura que el heap mantenga su estructura, verificando que todos los padres del nodo tengan valores mayores
     * @param nodo El nodo desde comienza el heapify
     */
    private void heapify(Nodo nodo){
        if(nodo==root)
            return;
        Nodo padre=searchParent(nodo);
        System.out.println(padre.valor+"<"+nodo.valor+"?: "+(padre.valor<nodo.valor));
        if(padre.valor<nodo.valor){
            System.out.println("Cambiando "+padre.valor+" y "+nodo.valor);
            swapPadreHijo(padre,nodo);
            heapify(nodo);
        }
        heapify(padre);
    }
    
    /**
     * Busca un nodo con el valor especificado y lo elimina del árbol
     * @param valor El valor que se quiere eliminar del árbol. En caso de haber más de 1, se elimina el primero que se encuentre
     * @return True si se realizó la operación, False si no
     */
    public Boolean remove(int valor){
        System.out.println("Eliminando "+valor);
        Nodo n=encontrarNodo(valor);
        if(n!=null){
            System.out.println(n.valor);
            if(n==root){
                eliminarRaiz();
                return true;
            }
            if(n==lastElement()){
                searchParent(n).disconnect(getLadoHijo(searchParent(n), n));
                return true;
            }
            swapWithLast(n);
            disconnectLast();
            bfsHeapify();
            return true;
        }
        return false;
    }
    
    /**
     * Se asegura que el árbol tiene la estructura de heap, verificando todo el árbol de arriba a bajo
     */
    private void bfsHeapify(){
        Nodo r = this.root;
        Queue<Nodo> queue = new LinkedList();
        if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r = (Nodo)queue.poll();
                if(r==null)
                    continue;
                if(r.izq!=null){
                    if(r.izq.valor>r.valor)
                        heapify(r.izq);
                    queue.add(r.izq);
                }
                if(r.der!=null){
                    if(r.der.valor>r.valor)
                        heapify(r.der);
                   queue.add(r.der); 
                }  
            }
        }
    }
    
    /**
     * Se elimina la raíz del heap
     */
    public void eliminarRaiz(){
        if(root.isLeaf()){
            root=null;
            return;
        }
        Nodo ultimo=lastElement();
        searchParent(ultimo).disconnect(getLadoHijo(searchParent(ultimo), ultimo));
        ultimo.setDer(root.der);
        ultimo.setIzq(root.izq);
        root=ultimo;
        System.out.println(lastElement().valor);
        heapify(lastElement());
    }
     /**
     * Busca el último elemento en el árbol
     * @return El último elemento del árbol
     */
    public Nodo lastElement(){
        Nodo ultimo;
        LinkedList<Nodo> l=getBreadthFirst();
        while((ultimo=l.removeLast())==null);
        return ultimo;
    }
    
    /**
     * Se elimina el ultimo elemento del árbol
     */
    private void disconnectLast(){
        Nodo last=lastElement();
        Nodo padre=searchParent(last);
        padre.disconnect(getLadoHijo(padre, last));
    }
    
     /**
     * Se intercambia el nodo proporcionado por el último nodo del árbol
     * @param n1 El nodo a intercambiar
     */
    private void swapWithLast(Nodo n1){
        Nodo last,padreLast,padren1,a1,a2;
        last=lastElement();
        padreLast=searchParent(last);
        padren1=searchParent(n1);
        int ladoLast=getLadoHijo(padreLast, last);
        int ladoN1=getLadoHijo(padren1, n1);
        a1=n1.izq;
        a2=n1.der;
        n1.izq=null;
        n1.der=null;
        padreLast.setLado(n1, ladoLast);
        last.izq=a1;
        last.der=a2;
        padren1.setLado(last, ladoN1);
    }
    
    /**
     * Se intercambian los nodos cuando uno es el padre del otro
     * @param padre El nodo padre a intercambiar
     * @param hijo El nodo hijo a intercambir
     */
    public void swapPadreHijo(Nodo padre, Nodo hijo){
        Nodo a1,a2,a3;
        int lado;
        int otroLado;
        Nodo abuelo=null;
        if(padre!=root){
            abuelo=searchParent(padre);
        }
        lado=getLadoHijo(padre, hijo);
        a2=hijo.izq;
        a3=hijo.der;
        if(lado==0){
            a1=padre.der;
            otroLado=1;
        }else{
            a1=padre.izq;
            otroLado=0;
        }
        padre.setIzq(a2);
        padre.setDer(a3);
        if(abuelo!=null)
            abuelo.setLado(hijo,getLadoHijo(abuelo, padre));
        else
            root=hijo;
        hijo.setLado(padre, lado);
        hijo.setLado(a1, otroLado);
    }
}
