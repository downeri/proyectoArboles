/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

import java.util.LinkedList;

/**
 *
 * @author Downe
 */
public class Heap extends ArbolBin {
    int i;
    public void add(Nodo nodo){
        if(root==null){
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
        heapify(nodo);
    }
    
    private void heapify(Nodo nodo){
        if(nodo==root)
            return;
        Nodo padre=searchParent(nodo);
        int lado=getLadoHijo(padre, nodo);
        int otroLado;
        Nodo abuelo=null;
        if(padre!=root){
            abuelo=searchParent(padre);
        }
        
        Nodo a1,a2,a3;
        if(padre.valor<nodo.valor){
            lado=getLadoHijo(padre, nodo);
            a2=nodo.izq;
            a3=nodo.der;
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
                abuelo.setLado(nodo,getLadoHijo(abuelo, padre));
            else
                root=nodo;
            nodo.setLado(padre, lado);
            nodo.setLado(a1, otroLado);
            heapify(nodo);
        }
    }
}
