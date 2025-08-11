/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.Date;
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
public class ProductoDAO {
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con;
    Conexion conectar = new Conexion();
    
    public int agregarProducto(Producto product){
        int r = 0;
        String sql = "INSERT INTO productos(descripcion, unidades, categoria, precio,activo,fechaCaducidad,idProveedor,idUsuario) VALUES (?,?,?,?,?,?,?,?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, product.getDescripcion());
            ps.setInt(2, product.getUnidades());
            ps.setString(3,product.getCategoria());
            ps.setDouble(5, product.getPrecio());
            ps.setInt(5, product.getActivo());
            ps.setString(6, product.getFechaCaducidad());
            ps.setInt(7, product.getProveedor().getIdProveedor());
            ps.setInt(8, product.getUsuario().getIdUsuario());
            r = ps.executeUpdate();
            
       } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        
        
        
        return r;
        
    }
    public void filtrarTablaProductos(JTable table, String criterio, String filtro) {
        String[] headers = {"ID PRODUCTO", "DESCRIPCION", "UNIDADES", "CATEGORIA", "PRECIO", "ACTIVO", "FECHA CADUCIDAD", "ID PROVEEDOR", "NOMBRE PROVEEDOR", "USUARIO"};
        String[] rows = new String[10];

        String sql = "SELECT productos.idProducto, productos.descripcion, productos.unidades, productos.precio,productos.activo, productos.categoria, productos.fechaCaducidad, "
                + "proveedores.idProveedor, proveedores.nombreProveedor, usuarios.nombreUsuario "
                + "FROM ((productos "
                + "INNER JOIN proveedores ON productos.idProveedor = proveedores.idProveedor) "
                + "INNER JOIN usuarios ON productos.idUsuario = usuarios.idUsuario)WHERE " + criterio + "  LIKE '%" + filtro + "%'";

        DefaultTableModel mode1 = new DefaultTableModel(null, headers);

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                rows[0] = rs.getString("idProducto");
                rows[1] = rs.getString("descripcion");
                rows[2] = rs.getString("unidades");
                rows[3] = rs.getString("categoria");
                rows[4] = rs.getString("precio");
                rows[5] = rs.getString("activo");
                rows[6] = rs.getString("fechaCaducidad");
                rows[7] = rs.getString("idProveedor");
                rows[8] = rs.getString("nombreProveedor");
                rows[9] = rs.getString("nombreUsuario");

                mode1.addRow(rows);

            }
            table.setModel(mode1);

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }




















    }
}
