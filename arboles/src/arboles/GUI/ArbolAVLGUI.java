package arboles.GUI;

import arboles.ArbolAVL;
import arboles.Nodo;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * La clase permite la operación de las bibliotecas creadas
 * @author Equipo 5
 */
public final class ArbolAVLGUI extends javax.swing.JFrame {

    /**
     * El árbol AVL sobre el que se va a trabajar
     */
    ArbolAVL arbol;
    
    /**
     * Método constructor
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

        addButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        showButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        addTextField = new javax.swing.JTextField();
        seatchTextField = new javax.swing.JTextField();
        removeTextField = new javax.swing.JTextField();

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

        showButton.setText("Mostrar árbol");
        showButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButtonActionPerformed(evt);
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

        seatchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                seatchTextFieldKeyPressed(evt);
            }
        });

        removeTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                removeTextFieldKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(showButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(addTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                                    .addComponent(seatchTextField)
                                    .addComponent(removeTextField, javax.swing.GroupLayout.Alignment.TRAILING))
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
                    .addComponent(seatchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeButton)
                    .addComponent(removeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(showButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                .addComponent(backButton)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        agregar();
    }//GEN-LAST:event_addButtonActionPerformed
    /**
     * Eventos a realizar si el boton de agregar es presionado
     * @param evt El evento ocurrido
     */
    private void showButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButtonActionPerformed
        if(arbol.root==null)
            JOptionPane.showMessageDialog(this, "No hay elementos para mostrar","Mensaje",JOptionPane.WARNING_MESSAGE);
        else{
            TreeImage t=new TreeImage(arbol);
            Image i=t.generarImagenArbol();
            ImageIcon icon=new ImageIcon(i);
            icon.setImage(icon.getImage().getScaledInstance(490, 350, Image.SCALE_DEFAULT));
            t.mostrarImagen();
        }
    }//GEN-LAST:event_showButtonActionPerformed
    /**
     * Eventos a realizar si el boton de busqueda es presionado
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
     * Eventos a realizar si se escribe en el campo un salto de linea
     * @param evt El evento ocurrido
     */
    private void addTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addTextFieldKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            agregar();
        }
    }//GEN-LAST:event_addTextFieldKeyPressed
    /**
     * Eventos a realizar si se escribe en el campo un salto de linea
     * @param evt El evento ocurrido
     */
    private void seatchTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_seatchTextFieldKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            buscar();
        }
    }//GEN-LAST:event_seatchTextFieldKeyPressed
    /**
     * Eventos a realizar si se escribe en el campo un salto de linea
     * @param evt El evento ocurrido
     */
    private void removeTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_removeTextFieldKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            eliminar();
        }
    }//GEN-LAST:event_removeTextFieldKeyPressed

    /**
     * Lee el texto en el campo de texto addTextField y agrega el valor numérico al árbol
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField addTextField;
    public javax.swing.JButton backButton;
    private javax.swing.JButton removeButton;
    private javax.swing.JTextField removeTextField;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField seatchTextField;
    private javax.swing.JButton showButton;
    // End of variables declaration//GEN-END:variables
    
    /**
     * Lee el texto del campo de texto searchTextField buscar y realiza la operación de búsqueda en el árbol
     */
    private void buscar() {
        String o=seatchTextField.getText();
        try{
            if(arbol.buscar(Integer.parseInt(o)))
                JOptionPane.showMessageDialog(this, "El valor se encuentra en el árbol :D");
            else
                JOptionPane.showMessageDialog(this, "El valor no se encuentra en el árbol :(");
        }catch(NumberFormatException u){
            JOptionPane.showMessageDialog(this, "No es un numero");
        }
        seatchTextField.setText("");
    }
    
    /**
     * Lee el texto del campo de texto removeTextField buscar y realiza la operación de eliminación en el árbol
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
}
