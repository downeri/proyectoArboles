package arboles;

import java.util.LinkedList;

/**
 * Representa aun Árbol AVL, el cual es un árbol binario de búsqueda que siempre se encuentra balanceado
 * @author Equipo 5
 */
public class ArbolAVL extends ArbolBinBusq{
    /**
     * Inserta un nodo nuevo al Arbol AVL, asegurandose de que este se encuentre balanceado
     * @param nodo El nodo que se va a insertar 
     */
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
        }
        last.setLado(nodo, lado);
        equilibrar(padres,nodo);
    }
    
    /**
     * Se encarga de revisar si los nodos superiores al nodo insertado se encuentran balanceados
     * @param padres La lista de los nodos que llevan hacia el nodo insertado
     * @param nodoAInsertar El nodo que se busca insertar
     */
    private void equilibrar(LinkedList<Nodo> padres, Nodo nodoAInsertar){
        int factorEquilibrio;
        for(Nodo i:padres){
            factorEquilibrio=calcularFactorDeEquilibrio(i);
            rotar(i, factorEquilibrio, nodoAInsertar);
        }
    }
    
    /**
     * Calcula y regresa el factor de equilibrio. Este indica si los subarboles del nodo se encuentran balanceados
     * @param i El nodo al que se analizarán los subarboles
     * @return Devuelve el valor del factor de equilibrio, que puede ser -2, -1, 0, 1 o 2
     */
    private int calcularFactorDeEquilibrio(Nodo i){
        int iz=calcularAltura(i.izq);
        int dere=calcularAltura(i.der);
        return dere-iz;
    }
    
    /**
     * Realiza las rotaciones en el nodo para que sus subarboles se encuentren equilibrados
     * @param nodo El nodo donde se realizarán las rotaciones
     * @param factorEquilibrio El factor de equilibrio indica qué rotacion se debe efectuar
     * @param nodoAInsertar El nodo que se desea Insertar/Eliminar
     */
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
        Nodo a1,a2,a3;
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
    
    /**
     * Dependiendo del factor equilibrio y del camino que se necesita recorrer para la inserción o eliminación, indica qué tipo de rotación necesita hacer
     * @param factorEquilibrio El factor de equilibrio del nodo
     * @param y El siguiente nodo en el recorrido.
     * @param nodoAInsertar El nodo a insertar/eliminar
     * @return Regresa un valor entero dependiendo del tipo de rotacion. 1.Izquierda-Izquierda 2 Izquierda-Derecha 3.Derecha-Derecha 4.Derecha-Izquierda
     */
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
    
    
    
    /**
     * Elimina un nodo del árbol
     * @param nodo El nodo que se desea eliminar
     */
    @Override
    public void remove(Nodo nodo){
        if(nodo==root){
            root=null;
            return;
        }
        super.remove(nodo);
        LinkedList<Nodo> bfs=this.getBreadthFirst();
        LinkedList<Nodo> bfsNoNull=new LinkedList<>();
        for(Nodo n:bfs){
            if(n!=null)
                bfsNoNull.add(n);
        }
        equilibrar(bfsNoNull, nodo);
    }
    
    /**
     * Busca un nodo que contenga el valor especificado y lo elimina del árbol
     * @param valor El valor numérico que se desea eliminar del árbol
     * @return True si la operación se realizó, false si no
     */
    public boolean remove(int valor){
        Nodo n=buscarNodoPorValor(valor);
        if(n!=null){
            remove(n);
            return true;
        }
        return false;
    }
}
