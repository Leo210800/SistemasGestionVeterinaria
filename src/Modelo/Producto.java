/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.Date;
/**
 *
 * @author mrj06
 */
public class Producto {
    
    private int idProducto;
    private String descripcion;
    private int unidades;
    private String categoria;
    private double precio;
    private int activo;
    private String fechaCaducidad;
    private Proveedor proveedor;
    private Usuario usuario;

    public Producto(int idProducto, String descripcion, int unidades, String categoria, double precio, int activo, String fechaCaducidad, Proveedor proveedor, Usuario usuario) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.unidades = unidades;
        this.categoria = categoria;
        this.precio = precio;
        this.activo = activo;
        this.fechaCaducidad = fechaCaducidad;
        this.proveedor = proveedor;
        this.usuario = usuario;
    }

    public Producto() {
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getUnidades() {
        return unidades;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public int getActivo() {
        return activo;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
    
    
    
}
