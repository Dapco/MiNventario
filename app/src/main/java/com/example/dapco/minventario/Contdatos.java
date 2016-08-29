package com.example.dapco.minventario;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by Dapco on 7/28/16.
 */
public class Contdatos {

    Context miContext;
    private SqlHelper controlDB;

    public Contdatos (Context c){
        miContext = c;
        controlDB = new SqlHelper(miContext);
    }

    public void InsertarProducto(Producto_class Producto){
        controlDB.InsertaProducto(Producto);
    }


    //Debe de servir para editar
    public void guardar(String id, String nombre, String cantidad, String fechaVenci, String Fec_In, String tipo) {
        Producto_class pro = new Producto_class();
        pro.Id = id;
        pro.nombre = nombre;
        pro.cantidad = cantidad;
        pro.Fecha_Vencimiento = fechaVenci;
        pro.Fecha_Ingreso = Fec_In;
        pro.tipo = tipo;

    }

    public void save(String nombre, String cantidad, String fechaVenci) {
        Producto_class pro = new Producto_class();
        pro.nombre = nombre;
        pro.cantidad = cantidad;
        pro.Fecha_Vencimiento = fechaVenci;
    }

    public void borrar(){
        //elimiar entrada

    }

    public ArrayList<String> ConsultaProducto(){
        if (controlDB.CuentaFilas("Producto") <= 0) {
//            guardar("0","jumex","9","11-12-16","11-12-16","comestible");
            save("jumex", "9", "11-12-16");
        }
        return controlDB.ConsultaProducto();
    }

}
