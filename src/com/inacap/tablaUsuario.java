/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.inacap;

import com.inacap.model.Usuario;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author diego
 */
public class tablaUsuario extends javax.swing.JFrame {

    /**
     * Creates new form tablaUsuario
     */

        public tablaUsuario() {
        initComponents();
        String[] columnas = {"ID", "Nombre", "Usuario","Tipo Usuario"};
        ArrayList<Usuario> listaUsuarios = Usuario.consultarUsuarios();
        String[][] datos = new String[listaUsuarios.size()][columnas.length];

        for (int i = 0; i < datos.length; i++) {
            datos[i][0] = "" + listaUsuarios.get(i).id;
            datos[i][1] = listaUsuarios.get(i).nombre;
            datos[i][2] = listaUsuarios.get(i).username;
            datos[i][3] = "" +listaUsuarios.get(i).idTipoUsuario;
        }

        DefaultTableModel tableModel = new DefaultTableModel(datos, columnas);
        tablaUsuario.setModel(tableModel);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuario = new javax.swing.JTable();
        btnAtras = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaUsuario.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        tablaUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Usuario", "Tipo Usuario"
            }
        ));
        tablaUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaUsuarioMouseClicked(evt);
                tablaUsuarioReadOnly(evt);
            }
        });
        jScrollPane1.setViewportView(tablaUsuario);
        if (tablaUsuario.getColumnModel().getColumnCount() > 0) {
            tablaUsuario.getColumnModel().getColumn(0).setHeaderValue("ID");
            tablaUsuario.getColumnModel().getColumn(1).setHeaderValue("Nombre");
            tablaUsuario.getColumnModel().getColumn(2).setHeaderValue("Usuario");
            tablaUsuario.getColumnModel().getColumn(3).setHeaderValue("Tipo Usuario");
        }

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com.inacap.icons/iconBack.png"))); // NOI18N
        btnAtras.setBorder(null);
        btnAtras.setContentAreaFilled(false);
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAtras.setMaximumSize(new java.awt.Dimension(506, 506));
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel1.setText("Elige un usuario a editar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(109, 109, 109)
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUsuarioMouseClicked

        // rowAtPoint() devuelve el número de la fila clickeada.. para llamar a rowAtPoint() tenemos
        // que pasarle por parámetro el punto específico donde se hizo click. Para esto, usamos
        // el objeto evt que viene por parámetro junto a este método MouseClicked.
        int fila = tablaUsuario.rowAtPoint(evt.getPoint());
        ArrayList<Usuario> listaUsuarios = Usuario.consultarUsuarios();
        Usuario user = listaUsuarios.get(fila);
        //JOptionPane.showMessageDialog(rootPane, p.toString());

        ActualizarUsuario actualizarFrame = new ActualizarUsuario(user);
        actualizarFrame.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_tablaUsuarioMouseClicked

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        this.setVisible(false);
        InicioAdmin form = new InicioAdmin();
        form.setVisible(true);
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void tablaUsuarioReadOnly(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUsuarioReadOnly
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaUsuarioReadOnly

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
            java.util.logging.Logger.getLogger(tablaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tablaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tablaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tablaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tablaUsuario().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAtras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tablaUsuario;
    // End of variables declaration
    /*
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaUsuario;
    // End of variables declaration//GEN-END:variables
    */
}
