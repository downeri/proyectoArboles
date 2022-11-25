package arboles;

import java.util.LinkedList;
import java.util.Queue;

public class ArbolAVL extends ArbolBinBusq{

    @Override
    public void add(Nodo nodo){
        System.out.println("Agregando "+nodo.valor);
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
        equilibrar(padres,nodo);
    }
    
    private void equilibrar(LinkedList<Nodo> padres, Nodo nodoAInsertar){
        Nodo z,y,x;
        int factorEquilibrio;
        for(Nodo i:padres){
            factorEquilibrio=calcularFactorDeEquilibrio(i);
            rotar(i, factorEquilibrio, nodoAInsertar);
        }
    }
    
    private int calcularFactorDeEquilibrio(Nodo i){
        int iz=calcularAltura(i.izq);
        int dere=calcularAltura(i.der);
        return dere-iz;
    }
    
    private void rotar(Nodo nodo, int factorEquilibrio, Nodo nodoAInsertar){
        Nodo z=nodo,x,y=nodo;
        int subRotacion=0;
        switch(factorEquilibrio){
            case -1:
            case 0:
            case 1:
                System.out.println(nodo.valor+" no necesita rotacion");
            break;
            case -2:
                z=nodo;
                y=z.izq;
                subRotacion=calcularSubRotacion(factorEquilibrio, y, nodoAInsertar);
            break;
            case 2:
                z=nodo;
                y=z.der;
                subRotacion=calcularSubRotacion(factorEquilibrio, y, nodoAInsertar);
            break;
            default:
                System.out.println(nodo.valor+" es imposible en AVL");
            break;   
        }
        Nodo a1,a2,a3,a4;
        if(subRotacion!=0){
            int lado=0;
            Nodo padre=searchParent(z);
            if(z!=root){
                if(padre.izq==z)
                    lado=0;
                else
                    lado=1;
            }
            switch(subRotacion){
                case 2:
                    System.out.println("Ejecutando rotacion izq der");
                    x=y.der;
                    a2=x.izq;
                    z.izq=x;
                    x.izq=y;
                    y.der=a2;
                    a1=y;
                    y=x;
                    x=a1;
                    
                case 1:
                    System.out.println("Ejecutando rotacion izq izq");
                    x=y.izq;
                    a3=y.der;
                    y.izq=x;
                    y.der=z;
                    z.izq=a3;
                    if(z==root)
                        root=y;
                    else
                        padre.setLado(y, lado);
                break;
                case 4:
                    System.out.println("Ejecutando rotacion der izq");
                    x=y.izq;
                    a3=x.der;
                    z.der=x;
                    x.der=y;
                    y.izq=a3;
                    a1=y;
                    y=x;
                    x=a1;
                case 3:
                    System.out.println("Ejecutando rotacion der der");
                    x=y.der;
                    a2=y.izq;
                    y.izq=z;
                    y.der=x;
                    z.der=a2;  
                    if(z==root)
                        root=y;
                    else
                        padre.setLado(y, lado);
                break;
            }
        } 
    }
    
    private int calcularSubRotacion(int factorEquilibrio, Nodo y, Nodo nodoAInsertar){
        if(factorEquilibrio==-2&&nodoAInsertar.valor<y.valor)
            return 1;
        else if(factorEquilibrio==-2&&nodoAInsertar.valor>y.valor)
            return 2;
        else if(factorEquilibrio==2&&nodoAInsertar.valor>y.valor)
            return 3;
        else if(factorEquilibrio==2&&nodoAInsertar.valor<y.valor)
            return 4;
        return 0;
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
