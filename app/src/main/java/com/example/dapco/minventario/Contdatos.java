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


    /**
    public void InsertarProducto(Producto_class Producto){
        controlDB.InsertaCliente(Producto);
    }
    */

    //Debe de servir para editar
    public void guardar(String nombre, String cantidad, String fechaVenci){
        Producto_class pro = new Producto_class();
        pro.nombre = nombre;
        pro.cantidad = cantidad;
        pro.Fecha_Vencimiento = fechaVenci;

    }

    public void borrar(){
        //elimiar entrada

    }

    public ArrayList<String> ConsultaProducto(){
        if(controlDB.CuentaFilas());
    }

}
