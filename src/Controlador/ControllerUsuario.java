/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author mrj06
 */
import Modelo.Usuario;
import Modelo.UsuarioDAO;
import Vista.frmUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author mrj06
 */
public  class ControllerUsuario implements ActionListener{
    
    UsuarioDAO usuariodao = new UsuarioDAO();
    Usuario usuario = new Usuario();
    frmUsuarios vistaUsuario = new frmUsuarios();

    public ControllerUsuario(frmUsuarios frm) {
        this.vistaUsuario = frm;
        this.vistaUsuario.btnGuardar.addActionListener(this);
        this.vistaUsuario.btnEditar.addActionListener(this);
        this.vistaUsuario.btnEliminar.addActionListener(this);
        this.vistaUsuario.btnBuscar.addActionListener(this);
        this.vistaUsuario.btnRefrescar.addActionListener(this);
        this.vistaUsuario.btnCancelar.addActionListener(this);
        
    }
     @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vistaUsuario.btnGuardar) {
            if (vistaUsuario.txtNombre.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaUsuario, "Error debe ingresar un nombre");

            } else if (vistaUsuario.txtNombreUser.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaUsuario, "Error debe ingresar un nombre de Usuario");

            } else if (vistaUsuario.txtContrasena.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaUsuario, "Error debe ingresar una Contrasenna");

            } else if (!vistaUsuario.txtContrasena.getText().equals(vistaUsuario.txtConfirmar.getText())) {
                JOptionPane.showMessageDialog(vistaUsuario, "Error Contrasena no coincide");

            } else {
                agregarUsuario();
            }

            //agregarUsuario();
        }
       
         if (e.getSource() == vistaUsuario.btnEditar) {

             if (vistaUsuario.txtId.getText().isEmpty()) {
                 JOptionPane.showMessageDialog(vistaUsuario, "Error debe ingresar un ID");

             } else if (vistaUsuario.txtNombre.getText().isEmpty()) {
                 JOptionPane.showMessageDialog(vistaUsuario, "Error debe ingresar un nombre");

             } else if (vistaUsuario.txtNombreUser.getText().isEmpty()) {
                 JOptionPane.showMessageDialog(vistaUsuario, "Error debe ingresar un nombre de Usuario");

             } else if (vistaUsuario.txtContrasena.getText().isEmpty()) {
                 JOptionPane.showMessageDialog(vistaUsuario, "Error debe ingresar una Contrasenna");

             } else if (!vistaUsuario.txtContrasena.getText().equals(vistaUsuario.txtConfirmar.getText())) {
                 JOptionPane.showMessageDialog(vistaUsuario, "Error Contrasena no coincide");

             } else {
                 actualizarUsuario();
             }

         }
         if (e.getSource() == vistaUsuario.btnEliminar) {
             if (vistaUsuario.txtId.getText().isEmpty()) {
                 JOptionPane.showMessageDialog(vistaUsuario, "Error debe ingresar un ID");

             } else {
                 eliminarUsuario();
             }
         }
           if (e.getSource() == vistaUsuario.btnBuscar){
               filtrarTablaPorNombre(vistaUsuario.tbDetalles, vistaUsuario.txtBuscador.getText());
           }
           if (e.getSource() == vistaUsuario.btnRefrescar){
               filtrarTablaPorNombre(vistaUsuario.tbDetalles, "");
               
           }
           
         if (e.getSource() == vistaUsuario.btnCancelar) {
             limpiarCampos();
         
         }
    }

    public void agregarUsuario() {

        String nombre = vistaUsuario.txtNombre.getText();
        String nombreUsuario = vistaUsuario.txtNombreUser.getText();
        String password = vistaUsuario.txtContrasena.getText();
        String tipoUsuario = vistaUsuario.cboTipoUsuarios.getSelectedItem().toString();

        usuario.setNombre(nombre);
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setPassword(password);
        usuario.setTipoUsuario(tipoUsuario);

        int r = usuariodao.agregarUsuario(usuario);

        if (r == 1) {
            JOptionPane.showMessageDialog(vistaUsuario, "Usuario Registrado");
                filtrarTablaPorNombre(vistaUsuario.tbDetalles, "");
                 limpiarCampos();

        } else {
            JOptionPane.showMessageDialog(vistaUsuario, "Usuario no registrado");
        }

       
        
        
        
        
    }
    
    public void actualizarUsuario(){
        int idUsuario = Integer.parseInt(vistaUsuario.txtId.getText());
        String nombre = vistaUsuario.txtNombre.getText();
        String nombreUsuario = vistaUsuario.txtNombreUser.getText();
        String password = vistaUsuario.txtContrasena.getText();
        String tipoUsuario = vistaUsuario.cboTipoUsuarios.getSelectedItem().toString();
        
        
        usuario.setIdUsuario(idUsuario);
        usuario.setNombre(nombre);
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setPassword(password);
        usuario.setTipoUsuario(tipoUsuario);
        
        
        
        int r = usuariodao.actualizarUsuario(usuario);
        
        if (r==1){
            JOptionPane.showMessageDialog(vistaUsuario, "Actualizado");
                filtrarTablaPorNombre(vistaUsuario.tbDetalles, "");
                 limpiarCampos();
        }else {
              JOptionPane.showMessageDialog(vistaUsuario, "Usuario no Actualizado");
        }
        
    }
    
    public void eliminarUsuario(){
        int idUsuario = Integer.parseInt(vistaUsuario.txtId.getText());
        
        int r = usuariodao.eliminarUsuario(idUsuario);
        
        if (r==1){
            JOptionPane.showMessageDialog(vistaUsuario, "Usuario Elimnado");
                filtrarTablaPorNombre(vistaUsuario.tbDetalles, "");
                 limpiarCampos();
                 
        }else {
              JOptionPane.showMessageDialog(vistaUsuario, "Usuario no Eliminado");
        }
          
          
        
    }
    
    public void filtrarTablaPorNombre (JTable table, String filtro){
        usuariodao.filtrarTablaPorNombre(table, filtro);
    }
    public void limpiarCampos(){
        vistaUsuario.txtId.setText("");
        vistaUsuario.txtNombre.setText("");
        vistaUsuario.txtNombreUser.setText("");
        vistaUsuario.txtContrasena.setText("");
        vistaUsuario.txtConfirmar.setText("");
   
    }
    
    public void iniciarFormulario() {
        filtrarTablaPorNombre(vistaUsuario.tbDetalles, "");
        limpiarCampos();
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
      
}
    
    