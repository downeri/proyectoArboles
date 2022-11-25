package arboles;

import java.util.LinkedList;
import java.util.Queue;

public class ArbolAVL extends ArbolBinBusq{

    @Override
    public void add(Nodo nodo){
        System.out.println("Suuu");
        if(this.root==null){
            this.root=nodo;
            return;
        }
        Nodo current=this.root;
        Nodo last=this.root;
        LinkedList<Nodo> padres=new LinkedList<>();
        LinkedList<Integer> lados=new LinkedList<>();
        int lado=-1;
        while(current!=null){
            last=current;
            padres.addFirst(last);
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
            lados.addFirst(lado);
        }
        last.setLado(nodo, lado);
    }
    
    private void equilibrar(LinkedList<Nodo> padres){
        int iz,dere,factorEquilibrio;
        for(Nodo i:padres){
            calcularFactorDeEquilibrio(i);
        }
    }
    
    private int calcularFactorDeEquilibrio(Nodo i){
        int iz=calcularAltura(i.izq);
        int dere=calcularAltura(i.der);
        return dere-iz;
    }
    
    public void calcularRotacion(int factorEquilibrio){
        switch(factorEquilibrio){
            case -1:
            case 0:
            case 1:
                System.out.println("No se necesita rotacion");
            break;
            case -2:
            case 2:
                System.out.println("Se necesita rotacion");
            break;
                
        }
    }
    
    public int calcularAltura(Nodo nodo){
        return calcularAlturaS(nodo)-1;
    }
    
    private int calcularAlturaS(Nodo nodo){
        if(nodo==null)
            return 0;
        int i=calcularAlturaS(nodo.izq);
        int d=calcularAlturaS(nodo.der);
        return (Integer.max(i, d)+1);
    }
    


    public LinkedList<Nodo> getBFS(){
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
    
    @Override
    public void breadthFirst(){
        LinkedList<Nodo> l=getBFS();
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
}
