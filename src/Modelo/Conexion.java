/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;
import com.mysql.jdbc.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;

public class Conexion {

    private static final String DATABASE = "inventariodb";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DATABASE + "?user=" + USER + "&password=" + PASSWORD + "&useSSL=false";
    private Connection con;

    public Conexion() {
        con = null;
        try {
            Class.forName(DRIVER);
            con = (Connection) DriverManager.getConnection(URL);
            if (con != null) {
                System.out.println("Conexion a la BD establecida correctamente");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println(ex);
        }
    }
    
    /**
     * Retorna la conexión a la BD
     * @return 
     */
    public Connection getConnection() {
        return con;
    }

    /**
     * Permite desconectar la BD
     */
    public void desconectar() {
        try {
            con.close();
            System.exit(0);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}