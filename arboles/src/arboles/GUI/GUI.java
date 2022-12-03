package arboles.GUI;

import java.awt.event.ActionEvent;

/**
 *Menu de los árboles
 * @author Equipo 5
 */
public class GUI extends javax.swing.JFrame {

    /**
     * Constructor
     */
    public GUI() {
        initComponents();
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

        avlButton = new javax.swing.JButton();
        heapButton = new javax.swing.JButton();
        aeaButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Arbolitos :D");

        avlButton.setText("Árbol AVL");
        avlButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avlButtonActionPerformed(evt);
            }
        });

        heapButton.setText("Heap");
        heapButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                heapButtonActionPerformed(evt);
            }
        });

        aeaButton.setText("Árbol de Expresión Aritmética");
        aeaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aeaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(avlButton)
                .addGap(91, 91, 91)
                .addComponent(heapButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(aeaButton)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(avlButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(heapButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aeaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Crea y muestra un objeto de la clase ArbolAVLGUI
     * @param evt 
     */
    private void avlButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avlButtonActionPerformed
        ArbolAVLGUI o=new ArbolAVLGUI();
        this.setVisible(false);
        o.jButton5.addActionListener((ActionEvent e)->{
            this.setVisible(true);
        });
    }//GEN-LAST:event_avlButtonActionPerformed
    /**
     * Crea y muestra un objeto de la clase Heap
     * @param evt 
     */
    private void heapButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_heapButtonActionPerformed
        HeapGUI o=new HeapGUI();
        this.setVisible(false);
        o.backButton.addActionListener((ActionEvent e)->{
            this.setVisible(true);
        });
    }//GEN-LAST:event_heapButtonActionPerformed
/**
     * Crea y muestra un objeto de la clase EAGUI
     * @param evt 
     */
    private void aeaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aeaButtonActionPerformed
        EAGUI o=new EAGUI();
        this.setVisible(false);
        o.backButton.addActionListener((ActionEvent e)->{
            this.setVisible(true);
        });
    }//GEN-LAST:event_aeaButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aeaButton;
    private javax.swing.JButton avlButton;
    private javax.swing.JButton heapButton;
    // End of variables declaration//GEN-END:variables
}
