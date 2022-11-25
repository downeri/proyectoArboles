package arboles;



import java.util.LinkedList;
import java.util.Queue;


public class ArbolBin {
    Nodo root;
    
    public ArbolBin(){
        root=null;
    }
    
    public ArbolBin(int val){
        root=new Nodo(val);
    }
    
    public ArbolBin(Nodo root){
        this.root=root;
    }
    
    public void add(Nodo padre, Nodo hijo, int lado){
	if(lado==0)
            padre.setIzq(hijo);
	else
            padre.setDer(hijo);
    }
    
    public void breadthAdd(Nodo nodo, Nodo nodo2){
        Nodo r = this.root;
        LinkedList<Nodo> queue = new LinkedList();
        queue.add(r);
        while(!queue.isEmpty()){
            r = (Nodo)queue.poll();
            if(r==null)
                continue;
            if(r.isLeaf()){
                r.setIzq(nodo);
                r.setDer(nodo2);
                break;
            }
            queue.add(r.izq);
            queue.add(r.der);
        }
    }
    
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
    
    public void breadthFirst(LinkedList<Nodo> l){
        int i=-1;
        for(Nodo n: l){
            i++;
            if(n==null)
                System.out.print("["+i+"]"+"/ ");
            else
                System.out.print("["+i+"]"+n.valor+" ");
        }
        System.out.println("");
    }
    
    
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
     
    public void inOrder(){
        System.out.print("Inorder: {");
        doInOrder(this.root);
        System.out.println("}");
    }
    
    private void doInOrder(Nodo nodo){
        if(nodo==null)
            return;
        doInOrder(nodo.izq);
        System.out.print(nodo.valor+" ");
        doInOrder(nodo.der);
    }
    
    public void preOrder(){
        System.out.print("Preorder{");
        doPreOrder(this.root);
        System.out.println("}");
    }
    
    private void doPreOrder(Nodo nodo){
        if(nodo==null)
            return;
        System.out.print(nodo.valor+" ");
        doPreOrder(nodo.izq);
        doPreOrder(nodo.der);
    }
    
    public void postOrder(){
        System.out.print("Postorder: {");
        doPostOrder(this.root);
        System.out.println("}");
    }
    
    private void doPostOrder(Nodo nodo){
        if(nodo==null)
            return;
        doPostOrder(nodo.izq);
        doPostOrder(nodo.der);
        System.out.print(nodo.valor+" ");
    }
}
