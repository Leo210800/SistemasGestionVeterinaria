/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mrj06
 */
public class ProveedorDAO {
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con;
    Conexion conectar = new Conexion();
    
    
    
     public int agregarProveedor(Proveedor proveedor) {

        int r = 0;
        String sql = "INSERT INTO proveedores (nombreProveedor, direccion, nombreEmpresa, telefono, email) VALUES (?, ?, ?, ?, ?);";

        try {
            con = conectar.getConnection(); //Conectar a la base de datos
            ps = con.prepareStatement(sql); //Preparar el query de base de datos
            ps.setString(1, proveedor.getNombreProveedor());
            ps.setString(2, proveedor.getDireccion());
            ps.setString(3, proveedor.getNombreEmpresa());
            ps.setString(4, proveedor.getTelefono());
            ps.setString(5, proveedor.getEmail());
                    
                    
          
            r = ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.toString());

        }

        return r;
        
        
        
        
     }
      public int actualizarProveedor(Proveedor proveedor){
        
        int r = 0;
        String sql = "UPDATE usuarios SET nombreProveedor =?, direccion =?, nombreEmpresa =?, telefono =?, email =? WHERE idProveedor =?";
        
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, proveedor.getNombreProveedor());
            ps.setString(2, proveedor.getDireccion());
            ps.setString(3, proveedor.getNombreEmpresa());
            ps.setString(4, proveedor.getTelefono());
            ps.setString(5, proveedor.getEmail());
            ps.setInt(5, proveedor.getIdProveedor());
            
            
            r = ps.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        
        
        
        return r;
    }
      
      public int eliminarProveedor(int idProveedor) {
        int r = 0;
        String sql = "DELETE FROM usuarios WHERE idProveedor =" + idProveedor;

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

        return r;

    }
      
       public void filtrarTablaPorNombre(JTable table, String filtro){
        String [] headers = {"ID","NombreProveedor","Direccion","Nombre Empresa","Telefono","Email"};
        String [] rows = new String [6];
        
        String sql = "SELECT * FROM proveedores  WHERE nombreProveedor LIKE '%"+filtro+"%'";
        
        DefaultTableModel model = new DefaultTableModel(null, headers);
        
        try {
               con = conectar.getConnection();
               ps = con.prepareStatement(sql);
               rs = ps.executeQuery();

            while (rs.next()) {
                rows[0] = rs.getString("idProveedor");
                rows[1] = rs.getString("nombreProveedor");
                rows[2] = rs.getString("direccion");
                rows[3] = rs.getString("nombreEmpresa");
                rows[4] = rs.getString("telefono");
                rows[5] = rs.getString("email");
                model.addRow(rows);
           
               }
            table.setModel(model);
               
               
               
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }


 
    }
       
       public Proveedor cargarProveedorPorId(int idProveedor){
           Proveedor p = new Proveedor();
           
           String sql = "SELECT idProveedor, nombreProveedor FROM proveedores WHERE idProveedor = "+idProveedor;
           
           try {
               con = conectar.getConnection();
               ps = con.prepareStatement(sql);
               rs = ps.executeQuery();
               
               while (rs.next()){
                   
                   p.setIdProveedor(rs.getInt("idProveedor"));
                   p.setNombreProveedor(rs.getString("nombreProveedor"));
                   
               }
           } catch (SQLException ex) {
                  System.err.println(ex.toString());
           }
           
           
           
           
           
           
           
           
           return p;
           
       }
    
    
    
    
    
    
    
}
