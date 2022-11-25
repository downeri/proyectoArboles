
package arboles;


public class Pruebas {
    public static void main(String [] args){
       ArbolAVL a=new ArbolAVL();
       a.add(new Nodo(9));
       a.add(new Nodo(4));
       a.add(new Nodo(7));
       a.add(new Nodo(16));
       a.add(new Nodo(13));
       a.add(new Nodo(15));
       a.add(new Nodo(19));
       a.add(new Nodo(20));
       a.add(new Nodo(25));
       a.add(new Nodo(21));
       a.breadthFirst();
    }
}
