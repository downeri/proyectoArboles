/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles.GUI;


import arboles.ArbolExpArit;
import arboles.NodoString;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *La Clase que genera una imagen a partir de un árbol binario con nodo tipo string
 * @author Equipo 5
 */
public class TreeImageString extends TreeImage{
    
    /**
     * Arbol con el que se trabaja
     */
    ArbolExpArit arbol;
    
    /**
     * Constructor, crea un objeto de la clase
     * @param arbol El árbol que se utilizará 
     */
    public TreeImageString(ArbolExpArit arbol){
        super();
        this.arbol=arbol;
        int al=(arbol.calcularAltura(arbol.root)+1);
        this.height=al*100;
        this.width=(int) (Math.pow(al,2)*70);
        image=new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g2d=(Graphics2D) image.getGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    }
    
    /**
     * Crea una imagen a partir del árbol binario
     * @return Imagen del árbol
     */
    @Override
    public BufferedImage generarImagenArbol(){
        g2d.setColor(new Color(240,240,240));
        g2d.fillRect(0, 0, width, height);
        g2d.setColor(Color.BLACK);
        int x=(width/2)-25;
        int y=50;
        preOrderPrint(arbol.root,x,y);
        return image;
    }
    /**
     * Genera circulos y lineas para ilustrar un árbol binario
     * @param nodo El nodo que estpa siendo impreso
     * @param x Posición del nodo en x
     * @param y Posición del nodo en y
     */
    private void preOrderPrint(NodoString nodo, int x, int y) {
        if(nodo==null)
            return;
        g2d.drawOval(x, y, 50, 50);
        String num=String.valueOf(nodo.valor);
        g2d.drawString(num, x+15, y+25);
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
    
    /**
     * Guarda la imagen y la abre
     */
    @Override
    public void mostrarImagen() {
        Desktop d=Desktop.getDesktop();
        File file=new File("Imagen.png");
        try {
            ImageIO.write(image, "png", file);
            d.open(file);
        } catch (IOException ex) {
            Logger.getLogger(TreeImageString.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
