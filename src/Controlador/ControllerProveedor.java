/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Proveedor;
import Modelo.ProveedorDAO;
import Vista.frmProvedores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author mrj06
 */
public final class ControllerProveedor  implements  ActionListener{
    ProveedorDAO provedordao = new ProveedorDAO();
    Proveedor proveedor = new Proveedor();
    frmProvedores vistaProveedor = new frmProvedores();

    public ControllerProveedor(frmProvedores frm) {
        this.vistaProveedor = frm;
        this.vistaProveedor.btnGuardar.addActionListener(this);
        this.vistaProveedor.btnEditar.addActionListener(this);
        this.vistaProveedor.btnEliminar.addActionListener(this);
        this.vistaProveedor.btnCancelar.addActionListener(this);
        this.vistaProveedor.btnRefrescar.addActionListener(this);
        this.vistaProveedor.btnBuscar.addActionListener(this);
        
        
        
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaProveedor.btnGuardar) {
            if (vistaProveedor.txtNombre.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaProveedor, "Error debe ingresar un nombre");

            } else if (vistaProveedor.txtDireccion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaProveedor, "Error debe ingresar una direccion");

            } else if (vistaProveedor.txtEmpresa.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaProveedor, "Error debe ingresar un nombre de Empresa");

            } else if (vistaProveedor.txtTelefono.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaProveedor, "Error debe ingresar un numero telefonico");

            } else if (vistaProveedor.txtEmail.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaProveedor, "Error debe ingresar un email");

            } else {

                agregarProveedor();
            }

        }
        if (e.getSource() == vistaProveedor.btnEditar) {
            if (vistaProveedor.txtId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaProveedor, "Error debe ingresar un ID");
            } else if (vistaProveedor.txtNombre.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaProveedor, "Error debe ingresar un nombre");

            } else if (vistaProveedor.txtDireccion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaProveedor, "Error debe ingresar una direccion");

            } else if (vistaProveedor.txtEmpresa.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaProveedor, "Error debe ingresar un nombre de Empresa");

            } else if (vistaProveedor.txtTelefono.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaProveedor, "Error debe ingresar un numero telefonico");

            } else if (vistaProveedor.txtEmail.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaProveedor, "Error debe ingresar un email");

            } else {

                actualizarProveedor();
            }

        }
        if (e.getSource() == vistaProveedor.btnEliminar) {
            if (vistaProveedor.txtId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaProveedor, "Error debe ingresar un ID");

            } else {
                eliminarProveedor();
            }
        }
        if (e.getSource() == vistaProveedor.btnBuscar) {
            filtrarTablaPorNombre(vistaProveedor.tbDatosProvedor, vistaProveedor.txtBuscador.getText());
        }
        if (e.getSource() == vistaProveedor.btnRefrescar) {
            filtrarTablaPorNombre(vistaProveedor.tbDatosProvedor, "");

        }

        if (e.getSource() == vistaProveedor.btnCancelar) {
            limpiarCampos();

        }

    }
    public void agregarProveedor() {

        String nombreProveedor = vistaProveedor.txtNombre.getText();
        String direccion = vistaProveedor.txtDireccion.getText();
        String nombreEmpresa = vistaProveedor.txtEmpresa.getText();
        String telefono = vistaProveedor.txtTelefono.getText();
        String email = vistaProveedor.txtEmail.getText();

        proveedor.setNombreProveedor(nombreProveedor);
        proveedor.setDireccion(direccion);
        proveedor.setNombreEmpresa(nombreEmpresa);
        proveedor.setTelefono(telefono);
        proveedor.setEmail(email);

        int r = provedordao.agregarProveedor(proveedor);

        if (r == 1) {
            JOptionPane.showMessageDialog(vistaProveedor, "Proveedor Registrado");

        } else {
            JOptionPane.showMessageDialog(vistaProveedor, "Proveedor no registrado");
        }

    }
    
    public void actualizarProveedor(){
        int idProveedor = Integer.parseInt(vistaProveedor.txtId.getText());
        String nombre = vistaProveedor.txtNombre.getText();
        String nombreEmpresa = vistaProveedor.txtEmpresa.getText();
        String direccion = vistaProveedor.txtDireccion.getText();
        String telefono = vistaProveedor.txtTelefono.getText();
        String email = vistaProveedor.txtEmail.getText();
        
        
        proveedor.setIdProveedor(idProveedor);
        proveedor.setNombreProveedor(nombre);
        proveedor.setNombreEmpresa(nombreEmpresa);
        proveedor.setDireccion(direccion);
        proveedor.setTelefono(telefono);
        proveedor.setEmail(email);
     
        
        
        
        int r = provedordao.actualizarProveedor(proveedor);
        
        if (r==1){
            JOptionPane.showMessageDialog(vistaProveedor, "Actualizado");
                filtrarTablaPorNombre(vistaProveedor.tbDatosProvedor, "");
                limpiarCampos();
        }else {
              JOptionPane.showMessageDialog(vistaProveedor, "Usuario no Actualizado");
        }
        
    }
    
    public void eliminarProveedor(){
        int idProveedor = Integer.parseInt(vistaProveedor.txtId.getText());
        
        int r = provedordao.eliminarProveedor(idProveedor);
        
        if (r==1){
            JOptionPane.showMessageDialog(vistaProveedor, "Usuario Elimnado");
                filtrarTablaPorNombre(vistaProveedor.tbDatosProvedor, "");
                 limpiarCampos();
        }else {
              JOptionPane.showMessageDialog(vistaProveedor, "Usuario no Eliminado");
        }
          
          
        
    }
    
    public void filtrarTablaPorNombre (JTable table, String filtro){
    
        provedordao.filtrarTablaPorNombre(table, filtro);

    

}
    
     public void limpiarCampos(){
        vistaProveedor.txtId.setText("");
        vistaProveedor.txtNombre.setText("");
        vistaProveedor.txtDireccion.setText("");
        vistaProveedor.txtEmpresa.setText("");
        vistaProveedor.txtTelefono.setText("");
        vistaProveedor.txtEmail.setText("");
    }
     
     public void iniciarFormulario() {
        filtrarTablaPorNombre(vistaProveedor.tbDatosProvedor, "");
        limpiarCampos();
    }
    
    
    
    
    
}