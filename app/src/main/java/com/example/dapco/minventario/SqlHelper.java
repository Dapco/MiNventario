package com.example.dapco.minventario;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Dapco on 7/15/16.
 */
public class SqlHelper extends SQLiteOpenHelper{

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "MiInventario.db";

    private static final String CREA_TABLA_PRODUCTO =
            "CREATE TABLE IF NOT EXISTS Producto (" +
                    "id INTEGER PRIMARY KEY NOT NULL ," +
                    "nombre TEXT," +
                    "cantidad TEXT," +
                    "fecha ingreso TEXT," +
                    "fecha Vencimiento TEXT," +
                    "tipo TEXT, " +
                    "UNIQUE(id))";

    SQLiteDatabase db;


    public SqlHelper (Context context, String name,
                      SQLiteDatabase.CursorFactory factory, int version){

            super(context, DB_NAME, factory, DB_VERSION);
    }

    public SqlHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREA_TABLA_PRODUCTO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXIST Producto");
        onCreate(db);
    }

    public int CuentaFilas(String tabla){
        int elementos = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        db = this.getReadableDatabase();
        String selectQuery = "SELECT Count(id) as Cantidad FROM " + tabla;
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                elementos = cursor.getInt(cursor.getColumnIndex("Cantidad"));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return elementos;
    }

    public int InsertaProducto (Producto_class producto){
        ContentValues values = new ContentValues();//Objeto ContentValues, permite almacenar columnas
        values.put("Id", producto.Id);
        values.put("Nombre", producto.nombre);
        values.put("Cantidad",producto.cantidad);
        values.put("Fecha Inicio",producto.Fecha_Ingreso);
        values.put("Fecha vencimiento", producto.Fecha_Vencimiento);

        db = this.getReadableDatabase();
        long ProductoID = db.insert("Productos", null, values);
        db.close();

        return (int) ProductoID;
    }

    /*
        //actualizar
        public int actualizar(Producto_class producto) {
            db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("Id", producto.Id);
            values.put("Nombre", producto.nombre);
            values.put("Cantidad",producto.cantidad);
            values.put("Fecha Inicio",producto.Fecha_Ingreso);
            values.put("Fecha vencimiento", producto.Fecha_Vencimiento);

    // updating row
            return db.update(producto, values, KEY_ID + " = ?",
                    new String[]{String.valueOf(producto.getId())});
        }
    */
    //borrado
    public void borrar(Producto_class producto) {
        db = this.getWritableDatabase();
        db.delete("Productos", producto + " = ?",
                new String[]{String.valueOf(producto.getId())});
        db.close();
    }

    //
    public ArrayList<String> ConsultaProducto() {
        String Id = "";
        String Nombre = "";
        String cantidad = "";
        String Fecha_Ingreso = "";
        String fecha_Vencimiento = "";
        String tipo = "";

        ArrayList<String> ListaProducto = new ArrayList<String>();
        db = this.getReadableDatabase();
        Cursor elCursor = db.rawQuery("SELECT * FROM Producto", null);
        while (elCursor.moveToNext()) {
            Id = elCursor.getString(elCursor.getColumnIndex("nombre"));
            Nombre = elCursor.getString(elCursor.getColumnIndex("nombre"));
            cantidad = elCursor.getColumnName(elCursor.getColumnIndex("cantidad"));
            Fecha_Ingreso = elCursor.getColumnName(elCursor.getColumnIndex("Fecha_Ingreso"));
            fecha_Vencimiento = elCursor.getColumnName(elCursor.getColumnIndex("fecha_Vencimiento"));
            tipo = elCursor.getColumnName(elCursor.getColumnIndex("tipo"));

        }//Fin while
        elCursor.close();
        db.close();
        return ListaProducto;
    }

}
