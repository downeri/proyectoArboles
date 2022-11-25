/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

/**
 *
 * @author Downe
 */
public class Pruebas {
    public static void main(String [] args){
       ArbolAVL a=new ArbolAVL();
       a.add(new Nodo(10));
       a.add(new Nodo(5));
       a.add(new Nodo(8));
       a.add(new Nodo(4));
       a.add(new Nodo(1));
       a.breadthFirst();
       System.out.print(a.calcularAltura(a.root));
       a.calcularRotacion(-1);
       a.calcularRotacion(-2);
       a.calcularRotacion(0);
       a.calcularRotacion(1);
       a.calcularRotacion(2);
    }
}
