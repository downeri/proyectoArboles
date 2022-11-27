/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles.GUI;


import arboles.ArbolBin;
import arboles.Nodo;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Downe
 */
public class TreeImage {
    
    ArbolBin arbol;
    BufferedImage image;
    int width;
    int height;
    Graphics2D g2d;
    
    public TreeImage(ArbolBin arbol){
        this.arbol=arbol;
        int al=(arbol.calcularAltura(arbol.root)+1);
        this.height=al*100;
        this.width=(int) (Math.pow(al,2)*70);
        image=new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g2d=(Graphics2D) image.getGraphics();
    }
    
    
    public BufferedImage generarImagenArbol(){
        g2d.setColor(new Color(240,240,240));
        g2d.fillRect(0, 0, width, height);
        g2d.setColor(Color.BLACK);
        int x=(width/2)-25;
        int y=50;
        preOrderPrint(arbol.root,x,y);
        return image;
    }

    private void preOrderPrint(Nodo nodo, int x, int y) {
        if(nodo==null)
            return;
        g2d.drawOval(x, y, 50, 50);
        char[] num=String.valueOf(nodo.valor).toCharArray();
        g2d.drawChars(num, 0, num.length, x+15, y+25);
        float asab=arbol.calcularAltura(nodo);
        if(asab==1)
            asab+=0.5;
        if(nodo.izq!=null)
            g2d.drawLine(x+25, y+50, (int) (x-(20*Math.pow(asab,2)))+25, y+75);
        if(nodo.der!=null)
            g2d.drawLine(x+25, y+50, (int) (x+(20*Math.pow(asab,2)))+25, y+75);
        preOrderPrint(nodo.izq, (int) (x-(20*Math.pow(asab,2))),y+75);
        preOrderPrint(nodo.der,(int) (x+(20*Math.pow(asab,2))),y+75);
    }

    private void mostrarImagen() {
        Desktop d=Desktop.getDesktop();
        File file=new File("Imagen.png");
        try {
            ImageIO.write(image, "png", file);
            d.open(file);
        } catch (IOException ex) {
            Logger.getLogger(TreeImage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
