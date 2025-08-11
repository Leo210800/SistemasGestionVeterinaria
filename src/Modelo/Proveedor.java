/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author mrj06
 */
public class Proveedor {
    private int idProveedor;
    private String nombreProveedor;
    private String direccion;
    private String nombreEmpresa;
    private String telefono;
    private String email;

    public Proveedor(int idProveedor, String nombreProveedor, String direccion, String nombreEmpresa, String telefono, String email) {
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
        this.direccion = direccion;
        this.nombreEmpresa = nombreEmpresa;
        this.telefono = telefono;
        this.email = email;
    }

    public Proveedor() {
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
    
    
    
    
}
