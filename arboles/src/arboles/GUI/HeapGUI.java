package arboles.GUI;

import arboles.Heap;
import arboles.Nodo;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *Clase para operaciones con Heaps
 * @author Equipo 5
 */
public final class HeapGUI extends javax.swing.JFrame {

    /**
     * El árbol con el que se trabaja
     */
    Heap arbol;
    
    /**
     * Crea una objeto de la clase
     */
    public HeapGUI() {
        initComponents();
        arbol=new Heap();
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
        removeButton = new javax.swing.JButton();
        showButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        addTextField = new javax.swing.JTextField();
        removeTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Heap");
        setResizable(false);

        addButton.setText("Agregar a árbol");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(showButton, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(addTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                                    .addComponent(removeTextField))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(removeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(137, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(addTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeButton)
                    .addComponent(removeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(showButton)
                .addGap(81, 81, 81)
                .addComponent(backButton)
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
    * Eventos a realizar si el boton de agregar es presionado
    * @param evt El evento ocurrido
    */
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        leer();
    }//GEN-LAST:event_addButtonActionPerformed
    /**
    * Eventos a realizar si el boton de mostrar es presionado
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
    * Eventos a realizar si el boton de eliminar es presionado
    * @param evt El evento ocurrido
    */
    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        borrar();
    }//GEN-LAST:event_removeButtonActionPerformed
    /**
    * Eventos a realizar si el boton de regresar es presionado
    * @param evt El evento ocurrido
    */
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed
    /**
    * Eventos a realizar si se escribe en el campo de texto addTextField un salto de linea
    * @param evt El evento ocurrido
    */
    private void addTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addTextFieldKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            leer();
        }
    }//GEN-LAST:event_addTextFieldKeyPressed
    /**
    * Eventos a realizar si se escribe en el campo de texto removeTextField un salto de linea
    * @param evt El evento ocurrido
    */
    private void removeTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_removeTextFieldKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            borrar();
        }
    }//GEN-LAST:event_removeTextFieldKeyPressed

    /**
     * Se obtiene el texto de addTextField y agrega el valor entero al árbol
     */
    private void leer(){
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
     * Se obtiene el texto de removeTextField y elimina el nodo con el valor del árbol
     */
    private void borrar() {
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
    private javax.swing.JButton removeButton;
    private javax.swing.JTextField removeTextField;
    private javax.swing.JButton showButton;
    // End of variables declaration//GEN-END:variables

    
}
