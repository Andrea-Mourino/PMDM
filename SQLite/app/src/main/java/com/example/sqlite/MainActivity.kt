package com.ejemplo.sqlitebasico

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dbHelper = MyDBHelper(this)
        val db = dbHelper.writableDatabase

        // ---- INSERTAR ----
        db.execSQL("INSERT INTO scores (score, date) VALUES (10, '2024-01-01')")
        db.execSQL("INSERT INTO scores (score, date) VALUES (20, '2024-02-02')")
        Log.d("DB", "Insertadas dos filas")

        // ---- LEER ----
        var cursor = db.rawQuery("SELECT * FROM scores", null)
        Log.d("DB", "Listado inicial:")
        while (cursor.moveToNext()) {
            val id = cursor.getInt(0)
            val score = cursor.getInt(1)
            val date = cursor.getString(2)
            Log.d("DB", "Fila: id=$id - score=$score - fecha=$date")
        }
        cursor.close()

        // ---- ACTUALIZAR ----
        db.execSQL("UPDATE scores SET score=99 WHERE id=1")
        Log.d("DB", "Fila id=1 actualizada")

        // ---- LEER DESPUÉS DE UPDATE ----
        cursor = db.rawQuery("SELECT * FROM scores", null)
        Log.d("DB", "Listado después de actualizar:")
        while (cursor.moveToNext()) {
            val id = cursor.getInt(0)
            val score = cursor.getInt(1)
            val date = cursor.getString(2)
            Log.d("DB", "Fila: id=$id - score=$score - fecha=$date")
        }
        cursor.close()

        // ---- BORRAR ----
        db.execSQL("DELETE FROM scores WHERE id=2")
        Log.d("DB", "Fila id=2 eliminada")

        // ---- LEER DESPUÉS DE DELETE ----
        cursor = db.rawQuery("SELECT * FROM scores", null)
        Log.d("DB", "Listado final:")
        while (cursor.moveToNext()) {
            val id = cursor.getInt(0)
            val score = cursor.getInt(1)
            val date = cursor.getString(2)
            Log.d("DB", "Fila: id=$id - score=$score - fecha=$date")
        }
        cursor.close()

        db.close()

        // ---- UI mínima ----
        setContent {
            Text("SQLite básico con ComponentActivity")
        }
    }
}
