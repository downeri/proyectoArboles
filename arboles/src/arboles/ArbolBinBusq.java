package arboles;

public class ArbolBinBusq extends ArbolBin{
    
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
    
     @Override
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
                Nodo predecesor=searchPredecesor(nodo);
                searchParent(predecesor).disconnect(1);
                predecesor.setIzq(nodo.izq);
                predecesor.setDer(nodo.der);
                nodoPadre.setLado(predecesor, lado);
            }
        }
    }
     
     
    private Nodo searchPredecesor(Nodo nodo){
        Nodo next=nodo.izq;
        while(next.der!=null){
            next=next.der;
        }
        return next;
    }
}
