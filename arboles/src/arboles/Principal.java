package arboles;

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
       
       System.out.println("\n============");
       ArbolExpArit arbolito3 = new ArbolExpArit("(1+2^3+2)+3");
       arbolito3.postOrden();
    }
}
