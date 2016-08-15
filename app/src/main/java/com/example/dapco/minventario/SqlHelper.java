package com.example.dapco.minventario;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
                    "telefono TEXT," +
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
        values.put("Nombre", producto.nombre);
        values.put("Cantidad",producto.cantidad);
        values.put("Fecha Inicio",producto.Fecha_Ingreso);
        values.put("Fecha vencimiento", producto.Fecha_Vencimiento);

        db = this.getReadableDatabase();
        long ProductoID = db.insert("Productos", null, values);
        db.close();

        return (int) ProductoID;
    }


}
