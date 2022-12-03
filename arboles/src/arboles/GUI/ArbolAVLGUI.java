/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles.GUI;

import arboles.ArbolAVL;
import arboles.Nodo;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * La clase permite la operación de las biblioteca creada de Arbol AVL
 * @author Equipo 5
 */
public final class ArbolAVLGUI extends javax.swing.JFrame {

    /**
     * El árbol con el que se trabaja
     */
    ArbolAVL arbol;
    
    /**
     * Constructor
     */
    public ArbolAVLGUI() {
        initComponents();
        arbol=new ArbolAVL();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton6 = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        addTextField = new javax.swing.JTextField();
        searchTextField = new javax.swing.JTextField();
        removeTextField = new javax.swing.JTextField();
        showButton = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton6.setText("jButton6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Árbol AVL");
        setResizable(false);

        addButton.setText("Agregar a árbol");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        searchButton.setText("Buscar un valor");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Eliminar clave");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        backButton.setText("Menú Anterior");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        addTextField.setToolTipText("");
        addTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                addTextFieldKeyPressed(evt);
            }
        });

        searchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchTextFieldKeyPressed(evt);
            }
        });

        removeTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                removeTextFieldKeyPressed(evt);
            }
        });

        showButton.setText("Mostrar árbol");
        showButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(92, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(showButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(addTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                                    .addComponent(searchTextField)
                                    .addComponent(removeTextField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(removeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(searchButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(84, 84, 84))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(addTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchButton)
                    .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeButton)
                    .addComponent(removeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(showButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                .addComponent(backButton)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

                                           
    /**
     * Si existe un árbol, crea un objeto TreeImage con el árbol y lo muestra
     */
    private void mostrar() {                                           
        if(arbol.root==null)
            JOptionPane.showMessageDialog(this, "No hay elementos para mostrar","Mensaje",JOptionPane.WARNING_MESSAGE);
        else{
            TreeImage t=new TreeImage(arbol);
            t.generarImagenArbol();
            t.mostrarImagen();
        }
    }   
    
    /**
    * Eventos a realizar si el boton de agregar es presionado
    * @param evt El evento ocurrido
    */
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        agregar();
    }  
    
    /**
    * Eventos a realizar si el boton de buscar es presionado
    * @param evt El evento ocurrido
    */
    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        buscar();
    }//GEN-LAST:event_searchButtonActionPerformed
    /**
    * Eventos a realizar si el boton de eliminar es presionado
    * @param evt El evento ocurrido
    */
    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        eliminar();
    }//GEN-LAST:event_removeButtonActionPerformed
    /**
    * Eventos a realizar si el boton de regresar es presionado
    * @param evt El evento ocurrido
    */
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed
    /**
     * Se obtiene el texto de addTextField y agrega el valor entero al árbol
     */
    private void addTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addTextFieldKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            agregar();
        }
    }//GEN-LAST:event_addTextFieldKeyPressed
    /**
     * Se obtiene el texto de searchTextField y busca el valor en el árbol
     */
    private void searchTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            buscar();
        }
    }//GEN-LAST:event_searchTextFieldKeyPressed
    /**
     * Se obtiene el texto de remove TextField y elimina el valor en el árbol
     */
    private void removeTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_removeTextFieldKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            eliminar();
        }
    }//GEN-LAST:event_removeTextFieldKeyPressed
    /**
    * Eventos a realizar si el boton de mostrar es presionado
    * @param evt El evento ocurrido
    */
    private void showButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButtonActionPerformed
        mostrar();
    }//GEN-LAST:event_showButtonActionPerformed

    /**
     * Lee el texto en addTextField, lo convierte a entero y lo inserta en el árbol
     */
    private void agregar(){
        String o=addTextField.getText();
        try{
            if(arbol.buscar(Integer.parseInt(o)))
                JOptionPane.showMessageDialog(this, "El valor se encuentra en el árbol, no se puede insertar","Mensaje",JOptionPane.WARNING_MESSAGE);
            else{
                arbol.add(new Nodo(Integer.parseInt(o)));
                JOptionPane.showMessageDialog(this, "El valor se ha insertado con éxito","Mensaje",JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(NumberFormatException u){
            JOptionPane.showMessageDialog(this, "No es un numero");
        }
        addTextField.setText("");
    }
    
    /**
     * Lee el texto en searchTextField, lo convierte a entero y lo busca en el árbol
     */
    private void buscar() {
        String o=searchTextField.getText();
        try{
            if(arbol.buscar(Integer.parseInt(o)))
                JOptionPane.showMessageDialog(this, "El valor se encuentra en el árbol :D");
            else
                JOptionPane.showMessageDialog(this, "El valor no se encuentra en el árbol :(");
        }catch(NumberFormatException u){
            JOptionPane.showMessageDialog(this, "No es un numero");
        }
        searchTextField.setText("");
    }
    
    /**
     * Lee el texto en searchTextField, lo convierte a entero y lo elimina del árbol
     */
    private void eliminar() {
        String o=removeTextField.getText();
        try{
            if(arbol.remove(Integer.parseInt(o)))
                JOptionPane.showMessageDialog(this, "El valor se ha removido del árbol :D");
            else
                JOptionPane.showMessageDialog(this, "El valor no se encuentra en el árbol :(");
        }catch(NumberFormatException u){
            JOptionPane.showMessageDialog(this, "No es un numero");
        }
        removeTextField.setText("");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField addTextField;
    public javax.swing.JButton backButton;
    private javax.swing.JButton jButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton removeButton;
    private javax.swing.JTextField removeTextField;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JButton showButton;
    // End of variables declaration//GEN-END:variables

    
}
