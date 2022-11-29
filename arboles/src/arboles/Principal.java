package arboles;

import arboles.GUI.TreeImage;
import arboles.GUI.TreeImageString;

public class Principal {
    public static void main(String [] args){
       System.out.println("\n============");
       ArbolExpArit arbolito = new ArbolExpArit("1+2-4/3*(5+8))");
       arbolito.postOrden();
       
       System.out.println("\n============");
       ArbolExpArit arbolito1 = new ArbolExpArit("3+5+1*2/(2+9^2*(5*9)-8)");
       arbolito1.postOrden();
       
       System.out.println("\n============");
       ArbolExpArit arbolito2 = new ArbolExpArit("((9+2)*4-3/4)");
       arbolito2.postOrden();
       
       System.out.println("\n========h====");
       ArbolExpArit arbolito3 = new ArbolExpArit("(1+2^3+2)+3");
       arbolito3.postOrden();
       System.out.println(arbolito3.root.der.valor);
       
        TreeImageString u=new TreeImageString(arbolito3);
       u.generarImagenArbol();
       u.mostrarImagen();
//        Heap a=new Heap();
//        a.add(new Nodo(1));
//        a.add(new Nodo(2));
//        a.add(new Nodo(3));
//        a.add(new Nodo(4));
//        a.add(new Nodo(9));
//        a.add(new Nodo(5));
//        a.add(new Nodo(6));
//        a.add(new Nodo(7));
//        a.add(new Nodo(8));
//        
//        
//
//       
//       
//       a.breadthFirst();
//       TreeImage o=new TreeImage(a);
//       o.generarImagenArbol();
       
       
    }
}
