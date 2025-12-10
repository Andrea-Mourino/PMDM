import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val dbHelper = DBHelper(this)
        val db = dbHelper.writableDatabase

        // Insertar datos de ejemplo
        insertScore(db, 80, "2024-11-22")
        insertScore(db, 300, "2025-02-14")

        // Consultar y mostrar en Logcat
        showScores(db)

        db.close()

        setContent {
            Text("BD SQLite Prueba", modifier = Modifier)
        }
    }

    // Función para insertar un registro
    private fun insertScore(db: SQLiteDatabase, score: Int, date: String) {
        val values = ContentValues().apply {
            put("valor", score)
            put("fecha_registro", date)
        }
        val rowId = db.insert("marcadores", null, values)
        Log.d("SQLiteTest", "Insertado registro ID: $rowId")
    }

    // Función para consultar todos los registros y mostrarlos
    private fun showScores(db: SQLiteDatabase) {
        val cursor: Cursor = db.rawQuery("SELECT * FROM marcadores ORDER BY fecha_registro DESC", null)

        Log.d("SQLiteTest", "===== MOSTRANDO MARCADORES =====")
        cursor.use { c ->
            while (c.moveToNext()) {
                val id = c.getInt(0)
                val score = c.getInt(1)
                val date = c.getString(2)
                Log.d("SQLiteTest", "ID=$id  |  Puntuación=$score  |  Fecha=$date")
            }
        }
    }
}

// =========================
//      BASE DE DATOS
// =========================

class DBHelper(context: Context) :
    SQLiteOpenHelper(context, "miBaseDatos.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "CREATE TABLE marcadores (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "valor INTEGER NOT NULL," +
                    "fecha_registro TEXT)"
        )
        Log.d("SQLiteTest", "Tabla creada correctamente")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS marcadores")
        onCreate(db)
    }
}
