package com.example.orderapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonClick = findViewById<Button>(R.id.button)
        val checkbox = findViewById<CheckBox>(R.id.checkBox)
        val email = findViewById<EditText>(R.id.editTextEmail)
        val sifre = findViewById<EditText>(R.id.editTextSifre)
        val ad = findViewById<EditText>(R.id.editTextAd)
        val soyad = findViewById<EditText>(R.id.editTextSoyad)

        fun isEmailValid(email: String): Boolean = Pattern.compile(
                "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                        "\\@yalova.edu.tr"
            ).matcher(email).matches()

        buttonClick.setOnClickListener {
            if(!email.text.isNullOrBlank()){
                if(isEmailValid(email.text.toString())){
                    if(!sifre.text.isNullOrBlank()){
                        if(sifre.text.length >= 8){
                            if(checkbox.isChecked){
                                val ad_p = ad.text.toString()
                                val soyad_p = soyad.text.toString()
                                val email_p = email.text.toString()
                                val intent = Intent(this, MenuActivity::class.java).apply {
                                    putExtra("Ad", ad_p)
                                    putExtra("Soyad", soyad_p)
                                    putExtra("Email", email_p)
                                }
                                startActivity(intent)
                            }else{
                                Toast.makeText(baseContext, "KVKK metnini onaylamalısınız!", Toast.LENGTH_SHORT).show()
                            }
                        }else{
                            Toast.makeText(baseContext, "Şifre en az 8 karakter olmalı!", Toast.LENGTH_SHORT).show()
                        }
                    }else{
                        Toast.makeText(baseContext, "Şifre boş olamaz!", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(baseContext, "Email doğru formatta olmalı!", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(baseContext, "Email boş olamaz!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}