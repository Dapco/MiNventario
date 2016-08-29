package com.example.dapco.minventario;

/**
 * Created by Dapco on 7/21/16.
 */
public class Producto_class {

    public String Id;
    public String nombre;
    public String cantidad;
    public String Fecha_Ingreso;
    public String Fecha_Vencimiento;
    public String tipo;

    public Producto_class(){}

    public Producto_class(String Id, String nombre, String cantidad, String fecha_Ingreso, String fecha_Vencimiento) {

        this.setId(Id);
        this.setNombre(nombre);
        this.setCantidad(cantidad);
        this.setFecha_Ingreso(fecha_Ingreso);
        this.setFecha_Vencimiento(fecha_Vencimiento);
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha_Ingreso() {
        return Fecha_Ingreso;
    }

    public void setFecha_Ingreso(String fecha_Ingreso) {
        Fecha_Ingreso = fecha_Ingreso;
    }

    public String getFecha_Vencimiento() {
        return Fecha_Vencimiento;
    }

    public void setFecha_Vencimiento(String fecha_Vencimiento) {
        Fecha_Vencimiento = fecha_Vencimiento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


}
