/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Proveedor;
import Modelo.ProveedorDAO;
import Modelo.Usuario;
import Vista.fmrPaginaPrincipal;
import Vista.frmInventarioProductos;
import helpers.Helpers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author mrj06
 */
public class ControllerProducto implements ActionListener{
    frmInventarioProductos vistInventarioProductos = new frmInventarioProductos();
    Proveedor proveedor = new Proveedor();
    ProveedorDAO proveedordao = new ProveedorDAO();
    Producto producto = new Producto();
    Usuario usuario = new Usuario();
    Helpers helpers = new Helpers();
    ProductoDAO productodao = new ProductoDAO();
    
    
   
    
    

    public ControllerProducto(frmInventarioProductos frm) {
        this.vistInventarioProductos = frm;
        this.vistInventarioProductos.btnBuscar.addActionListener(this);
        this.vistInventarioProductos.btnGuardar.addActionListener(this);
        this.vistInventarioProductos.btnBuscar.addActionListener(this);
        this.vistInventarioProductos.btnRefrescar.addActionListener(this);
        this.vistInventarioProductos.btnBuscarDetalle.addActionListener(this);
        this.vistInventarioProductos.btnRefrescar.addActionListener(this);
        
        
        
        
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == vistInventarioProductos.btnBuscar){
           cargarProveedorPorid();
        }
        if(e.getSource() == vistInventarioProductos.btnGuardar){
            agregarProducto();
        }
        if(e.getSource() == vistInventarioProductos.btnBuscarDetalle){
            filtrarTablaProductos(vistInventarioProductos.tbTablaDetalle, vistInventarioProductos.cboDescripcion.getSelectedItem().toString(), vistInventarioProductos.txtDescripcionDetalle.getText());
   
        }
        if(e.getSource() == vistInventarioProductos.btnBuscarDetalle){
            filtrarTablaProductos(vistInventarioProductos.tbTablaDetalle, vistInventarioProductos.cboDescripcion.getSelectedItem().toString(), "");
        
        }
        
        
    }
    
    public void cargarProveedorPorid(){
        String idProveedor = JOptionPane.showInputDialog("Ingrese un ID de proveedor");
        proveedor = proveedordao.cargarProveedorPorId( Integer.parseInt(idProveedor));
        
        if(proveedor.getNombreProveedor() == null){
            JOptionPane.showMessageDialog(vistInventarioProductos, "No se encontro ningun Proveedor, intente de nuevo");
            vistInventarioProductos.txtIdProveedor.setText("");
            vistInventarioProductos.txtNombreProveedor.setText("");
           
        }else {
            vistInventarioProductos.txtIdProveedor.setText(String.valueOf(proveedor.getIdProveedor()));
            vistInventarioProductos.txtNombreProveedor.setText(proveedor.getNombreProveedor());
        }
     
    }
    public void agregarProducto(){
        String descripcion = vistInventarioProductos.txtDescripcion.getText();
        int unidades = Integer.parseInt(vistInventarioProductos.spNumerador.getValue().toString());
        String categoria =   vistInventarioProductos.cboCategorias.getSelectedItem().toString();
        double precio = Double.parseDouble(vistInventarioProductos.txtPrecio.getText());
        boolean activo = vistInventarioProductos.chbActivo.isSelected();
        String date = vistInventarioProductos.txtFechaCaducidad.getText();
        int idProveedor = Integer.parseInt(vistInventarioProductos.txtIdProveedor.getText());
        int idUsuario = Integer.parseInt(fmrPaginaPrincipal.lblIdUsuario.getText());
        
        producto.setDescripcion(descripcion);
        producto.setUnidades(unidades);
        producto.setCategoria(categoria);
        producto.setPrecio(precio);
        
        
        
        if(activo==true){
            producto.setActivo(1);
         
        }else{
            producto.setActivo(0);
        }
        
        producto.setFechaCaducidad(date);
        proveedor.setIdProveedor(idProveedor);
        producto.setProveedor(proveedor);
        usuario.setIdUsuario(idUsuario);
        producto.setUsuario(usuario);
      //  helpers.convertDate(date);
      
      int r = productodao.agregarProducto(producto);
       if (r == 1) {
            JOptionPane.showMessageDialog(vistInventarioProductos, "Producto Registrado");

        } else {
            JOptionPane.showMessageDialog(vistInventarioProductos, "Producto no registrado");
        }

      
    }
    
    public void filtrarTablaProductos(JTable table,String criterio, String filtro){
        productodao.filtrarTablaProductos(table, criterio, filtro);
        helpers.centrarCeldas(table);
    }
    
    
}