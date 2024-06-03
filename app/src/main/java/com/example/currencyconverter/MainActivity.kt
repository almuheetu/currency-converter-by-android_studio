package com.example.currencyconverter

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val showResultTv = findViewById<TextView>(R.id.tv_show_result)
        val ustToBdtButton = findViewById<Button>(R.id.btn_test)
        val bdtToUsdButton = findViewById<Button>(R.id.bt_test)
        val editText = findViewById<EditText>(R.id.et_test)
        val euroToBdtButton = findViewById<Button>(R.id.second_btn)
        val bdtToEuroButton = findViewById<Button>(R.id.second_btn_two)

        ustToBdtButton.setOnClickListener {
            if (editText.text.toString().isBlank() && !checkIsValidInput(editText.text.toString().toInt())) {
                Toast.makeText(applicationContext, "Convert is not possible", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            showResultTv.text = (editText.text.toString().toInt() * 117.32).toString()
        }

        bdtToUsdButton.setOnClickListener {
            if (!checkIsValidInput(editText.text.toString().toInt())) {
                Toast.makeText(applicationContext, "Convert is not possible", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            showResultTv.text = (editText.text.toString().toInt() * 0.0085).toString()

        }

        euroToBdtButton.setOnClickListener {
            if (!checkIsValidInput(editText.text.toString().toInt())) {
                Toast.makeText(applicationContext, "Convert is not possible", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            showResultTv.text = (editText.text.toString().toInt() * 127.4182).toString()

        }

        bdtToEuroButton.setOnClickListener {
            Log.d("Log404","The value of")

            if (!checkIsValidInput(editText.text.toString().toInt())) {
                Toast.makeText(applicationContext, "Convert is not possible", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            showResultTv.text = (editText.text.toString().toInt() * 0.0079).toString()

        }


    }


    private fun checkIsValidInput(currencyValue: Int): Boolean {
        Log.d("Log404","The value of $currencyValue")

        return currencyValue > 10
    }

    fun EditViewOneOnClick(view: View) {}


//    fun EditViewOneOnClick(view: View) {
//        Toast.makeText(applicationContext, "below amount of 10", Toast.LENGTH_SHORT).show()
//    }
}