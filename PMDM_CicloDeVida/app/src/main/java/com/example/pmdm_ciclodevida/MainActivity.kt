package com.example.pmdm_ciclodevida.ui.theme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.pmdm_ciclodevida.R

class MainActivity : AppCompatActivity() {

    // Tag para Logcat
    private val TAG = "ActivityLifecycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate llamado")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart llamado")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume llamado")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause llamado")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop llamado")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart llamado")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy llamado")
    }
}
