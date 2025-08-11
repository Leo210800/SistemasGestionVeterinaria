/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.ControllerProducto;
import Controlador.ControllerProveedor;
import Controlador.ControllerUsuario;

/**
 *
 * @author mrj06
 */
public class fmrPaginaPrincipal extends javax.swing.JFrame {

    private ControllerProveedor con2;

    public fmrPaginaPrincipal(String idUsuario,String nombreUsuario,String tipoUsuario) {
        initComponents();
        setTitle("Sistema de  Inventeario");
        setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        lblIdUsuario.setText(idUsuario);
        lblNombreUsuario.setText(nombreUsuario);
        lblTipoUsuario.setText(tipoUsuario);
    }

   


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        lblNombreUsuario = new javax.swing.JLabel();
        lblIdUsuario = new javax.swing.JLabel();
        lblTipoUsuario = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuFile = new javax.swing.JMenu();
        btnExit = new javax.swing.JMenuItem();
        menuCatalogoDatos = new javax.swing.JMenu();
        btnUsuarios = new javax.swing.JMenuItem();
        btnProvedores = new javax.swing.JMenuItem();
        menuProcesos = new javax.swing.JMenu();
        btnProductos = new javax.swing.JMenuItem();
        menuReportes = new javax.swing.JMenu();
        btnProductosFecha = new javax.swing.JMenuItem();
        menuAyuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNombreUsuario.setForeground(new java.awt.Color(204, 204, 255));
        lblNombreUsuario.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblIdUsuario.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblTipoUsuario.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        desktopPane.setLayer(lblNombreUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(lblIdUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(lblTipoUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopPaneLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTipoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(lblIdUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
                .addGap(0, 489, Short.MAX_VALUE))
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopPaneLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(214, 214, 214))
        );

        MenuFile.setText("File");

        btnExit.setText("Exit");
        MenuFile.add(btnExit);

        jMenuBar1.add(MenuFile);

        menuCatalogoDatos.setText("Catalogo de Datos");

        btnUsuarios.setText("Usuarios");
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });
        menuCatalogoDatos.add(btnUsuarios);

        btnProvedores.setText("Provedores");
        btnProvedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProvedoresActionPerformed(evt);
            }
        });
        menuCatalogoDatos.add(btnProvedores);

        jMenuBar1.add(menuCatalogoDatos);

        menuProcesos.setText("Procesos");

        btnProductos.setText("Inventario de Productos");
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });
        menuProcesos.add(btnProductos);

        jMenuBar1.add(menuProcesos);

        menuReportes.setText("Reportes");

        btnProductosFecha.setText("Productos por fecha de caducidad");
        menuReportes.add(btnProductosFecha);

        jMenuBar1.add(menuReportes);

        menuAyuda.setText("Help");
        jMenuBar1.add(menuAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktopPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktopPane)
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        // TODO add your handling code here:
        frmUsuarios obj = new frmUsuarios();
        ControllerUsuario con = new ControllerUsuario(obj);
       

        
       
        desktopPane.add(obj);
        obj.toFront();
        obj.setVisible(true);
        con.iniciarFormulario();
        
  
      
        
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnProvedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProvedoresActionPerformed
        // TODO add your handling code here: frmProvedores obj2 = new frmProvedores();
        frmProvedores obj2 = new frmProvedores();
        ControllerProveedor con2 = new ControllerProveedor(obj2);
        desktopPane.add(obj2);
        obj2.toFront();
        obj2.setVisible(true);
        con2.iniciarFormulario();
        
      

    }//GEN-LAST:event_btnProvedoresActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        // TODO add your handling code here:
        
        frmInventarioProductos obj3 = new frmInventarioProductos();
        ControllerProducto con3 = new ControllerProducto(obj3);
        desktopPane.add(obj3);
        obj3.toFront();
        obj3.setVisible(true);
        
        
    }//GEN-LAST:event_btnProductosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
       
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
       
            public void run() {
                new fmrPaginaPrincipal( lblIdUsuario.getText(), lblNombreUsuario.getText(), lblTipoUsuario.getText()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuFile;
    private javax.swing.JMenuItem btnExit;
    private javax.swing.JMenuItem btnProductos;
    private javax.swing.JMenuItem btnProductosFecha;
    private javax.swing.JMenuItem btnProvedores;
    private javax.swing.JMenuItem btnUsuarios;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuBar jMenuBar1;
    public static javax.swing.JLabel lblIdUsuario;
    public static javax.swing.JLabel lblNombreUsuario;
    public static javax.swing.JLabel lblTipoUsuario;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JMenu menuCatalogoDatos;
    private javax.swing.JMenu menuProcesos;
    private javax.swing.JMenu menuReportes;
    // End of variables declaration//GEN-END:variables
}
