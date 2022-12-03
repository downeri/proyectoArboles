package arboles;

/**
 * La clase modela un árbol binario de busqueda
 * @author Equipo 5
 */
public class ArbolBinBusq extends ArbolBin{
    

    /**
     * Encuentra la posición que le corresponde al nodo de acuerdo a su valor y lo inserta en el árbol
     * @param nodo El nodo a insertar en el árbol
     */
    public void add(Nodo nodo){
        if(this.root==null){
            this.root=nodo;
            return;
        }
        Nodo current=this.root;
        Nodo last=this.root;
        int lado=-1;
        while(current!=null){
            last=current;
            if(nodo.valor==current.valor){
                System.out.println("El valor ya se encuentra en el árbol");
                return;
            }
            if(nodo.valor<current.valor){
                current=current.izq;
                lado=0;
            }
            else{
                current=current.der;
                lado=1;
            }
        }
        last.setLado(nodo, lado);
    }
    
    /**
     * Verifica si hay un valor en el árbol de búsqueda
     * @param valor El numero que se desea localizar
     * @return True si se encuentra el valor en el árbol. False si no
     */
    @Override
    public Boolean buscar(int valor){
        Nodo current=this.root;
        while(current!=null){
            if(valor==current.valor)
                return true;
            else if(valor<current.valor)
                current=current.izq;
            else if(valor>current.valor)
                current=current.der;
        }
        return false;
    }
    
    /**
     * Busca un nodo con cierto valor
     * @param valor El numero entero a buscar
     * @return El nodo con el valor esperado, null si no hay ninguno
     */
     public Nodo buscarNodoPorValor(int valor){
        Nodo current=this.root;
        while(current!=null){
            if(valor==current.valor)
                return current;
            else if(valor<current.valor)
                current=current.izq;
            else if(valor>current.valor)
                current=current.der;
        }
        return null;
    }
    
    /**
     * Elimina un nodo del árbol
     * @param nodo El nodo que se desea eliminar
     */
     @Override
     public void remove(Nodo nodo){
        if(nodo==root){
            if(nodo.isLeaf()){
                root=null;
                return;
            }
            if(nodo.der==null&&nodo.izq!=null){
                root=nodo.izq;
                return;
            }
            if(nodo.der!=null&&nodo.izq==null){
               root=nodo.der;
               return;
            }
            if(nodo.der!=null&&nodo.izq!=null){
                Nodo predecesor=searchPredecesor(nodo);
                if(predecesor!=nodo.izq){
                    searchParent(predecesor).disconnect(1);
                    predecesor.setIzq(nodo.izq);
                    predecesor.setDer(nodo.der);
                    root=predecesor;
                }else{
                    nodo.disconnect(0);
                    predecesor.setDer(nodo.der);
                    root=predecesor;
                }
            }
        }
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
                Nodo predecesor=searchPredecesor(nodo);
                if(predecesor!=nodo.izq){
                    searchParent(predecesor).disconnect(1);
                    predecesor.setIzq(nodo.izq);
                    predecesor.setDer(nodo.der);
                    nodoPadre.setLado(predecesor, lado);
                }else{
                    nodo.disconnect(0);
                    predecesor.setDer(nodo.der);
                    nodoPadre.setLado(predecesor, lado);
                }
            }
        }
    }
     
    /**
     * Busca el predecesor de un nodo
     * @param nodo El nodo del que se desea conocer el predecesor (Nodo más grande del subárbol izquierdo)
     * @return El nodo predecesor del nodo
     */
    private Nodo searchPredecesor(Nodo nodo){
        Nodo next=nodo.izq;
        while(next.der!=null){
            next=next.der;
        }
        return next;
    }
}
