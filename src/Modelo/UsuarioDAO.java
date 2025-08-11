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
public class UsuarioDAO {
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con;
    Conexion conectar = new Conexion();
    
    public int agregarUsuario(Usuario user) {

        int r = 0;
        String sql = "INSERT INTO usuarios (nombre, nombreUsuario, password, tipoUsuario) VALUES (?, ?, ?, ?);";

        try {
            con = conectar.getConnection(); //Conectar a la base de datos
            ps = con.prepareStatement(sql); //Preparar el query de base de datos
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getNombreUsuario());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getTipoUsuario());
          
            r = ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.toString());

        }

        return r;
    }
    public int actualizarUsuario(Usuario user){
        
        int r = 0;
        String sql = "UPDATE usuarios SET nombre =?, nombreUsuario =?, password =?, tipoUsuario =? WHERE idUsuario =?";
        
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getNombreUsuario());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getTipoUsuario());
            ps.setInt(5, user.getIdUsuario());
            
            r = ps.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        
        
        
        
        
        
        
        
        return r;
    }
    public int eliminarUsuario(int idUsuario) {
        int r = 0;
        String sql = "DELETE FROM usuarios WHERE idUsuario =" + idUsuario;

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
        String [] headers = {"ID","Nombre", "Usuario", "PASWORD", "Tipo"};
        String [] rows = new String [5];
        
        String sql = "SELECT * FROM usuarios  WHERE nombre LIKE '%"+filtro+"%'";
        
        DefaultTableModel model = new DefaultTableModel(null, headers);
        
        try {
               con = conectar.getConnection();
               ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                rows[0] = rs.getString("idUsuario");
                rows[1] = rs.getString("nombre");
                rows[2] = rs.getString("nombreUsuario");
                rows[3] = rs.getString("password");
                rows[4] = rs.getString("tipoUsuario");
                model.addRow(rows);
           
               }
            table.setModel(model);
               
               
               
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }


 
    }
    
    public boolean login(Usuario user){
        
        
        String sql = "SELECT  idUsuario, nombreUsuario, password, tipoUsuario FROM usuarios WHERE nombreUsuario =?";
        try {
            con = conectar.getConnection(); //Conectar a la base de datos
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getNombreUsuario());
            rs = ps.executeQuery();

            if (rs.next()) {

                if (user.getPassword().equals(rs.getString("password")) && user.getTipoUsuario().equals(rs.getString("tipoUsuario"))){
                user.setIdUsuario(rs.getInt("idUsuario"));
                user.setNombreUsuario(rs.getString("nombreUsuario"));
                user.setTipoUsuario(rs.getString("tipoUsuario"));
                return true;
            }else {
                return false;
            }
        }
        return false;
             
          
        
    
    }catch (SQLException ex) {
            return false;
       
        }
    }
    

}
