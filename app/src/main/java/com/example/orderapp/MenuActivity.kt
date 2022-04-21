package com.example.orderapp

import com.bumptech.glide.Glide
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.isVisible



class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val radioButton1 = findViewById<RadioButton>(R.id.radioButton1)
        val radioButton2 = findViewById<RadioButton>(R.id.radioButton2)
        val radioButton3 = findViewById<RadioButton>(R.id.radioButton3)
        val radioButton4 = findViewById<RadioButton>(R.id.radioButton4)
        val radioButton5 = findViewById<RadioButton>(R.id.radioButton5)
        val radioButton6 = findViewById<RadioButton>(R.id.radioButton6)

        val hesapla = findViewById<Button>(R.id.hesapla)
        val ucret = findViewById<TextView>(R.id.ucret)
        val ad_soyad = findViewById<TextView>(R.id.textViewPersonName)
        val email = findViewById<TextView>(R.id.textViewPersonEmail)
        val imageView = findViewById<ImageView>(R.id.imageView)

        var toplam_ucret = 0
        var isChecked = true

        ucret.isVisible = false

        ad_soyad.text = "Hoşgeldin "+ intent.getStringExtra("Ad") + " " + intent.getStringExtra("Soyad")
        email.text = intent.getStringExtra("Email")

        val icon = "https://cdn-icons-png.flaticon.com/512/747/747376.png"
        if (icon !== null) {
            Glide.with(this).load(icon).into(imageView)
        }

        hesapla.setOnClickListener {
            isChecked = true
            if(!radioButton1.isChecked && !radioButton2.isChecked && !radioButton3.isChecked){
                Toast.makeText(baseContext, "Hamburger Menüden Seçim Yapmalısınız", Toast.LENGTH_SHORT).show()
                isChecked = false
            }
            if(!radioButton4.isChecked && !radioButton5.isChecked && !radioButton6.isChecked){
                Toast.makeText(baseContext, "Hamburgerden Seçim Yapmalısınız", Toast.LENGTH_SHORT).show()
                isChecked = false
            }

            if(isChecked) {
                if (radioButton1.isChecked) {
                    toplam_ucret += 10
                } else if (radioButton2.isChecked) {
                    toplam_ucret += 20
                } else {
                    toplam_ucret += 30
                }

                if (radioButton4.isChecked) {
                    toplam_ucret += 40
                } else if (radioButton5.isChecked) {
                    toplam_ucret += 50
                } else {
                    toplam_ucret += 60
                }

                ucret.isVisible = true
                ucret.text = "Ödemeniz gereken ücret " + toplam_ucret.toString() + "TL"
                toplam_ucret = 0
            }
        }

    }
}