package com.example.snackbar

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var editTextET: EditText
    private lateinit var textViewTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        editTextET = findViewById(R.id.editTextTV)
        textViewTV = findViewById(R.id.textViewTV)

    }

    fun onClick(view: View) {
        textViewTV.text = editTextET.text
    }

    fun onClickErase(view: View) {
        Snackbar
            .make(view, "Подтвердите удаление", Snackbar.LENGTH_LONG)
            .setAction("Удалить") {
                textViewTV.text = ""
                Snackbar.make(view, "Данные удалены", Snackbar.LENGTH_LONG).show()
            }.show()
    }
}