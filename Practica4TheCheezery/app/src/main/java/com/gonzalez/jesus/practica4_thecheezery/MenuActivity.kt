package com.gonzalez.jesus.practica4_thecheezery


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var intent = Intent(this, ProductoActivity::class.java)

        btn_cold_drinks.setOnClickListener{
            intent.putExtra("type", "coldDrinks")
            startActivity(intent)
        }

        btn_hot_drinks.setOnClickListener{
            intent.putExtra("type", "hotDrinks")
            startActivity(intent)
        }
        btn_salties.setOnClickListener{
            intent.putExtra("type", "salties")
            startActivity(intent)
        }

        btn_sweets.setOnClickListener{
            intent.putExtra("type", "sweets")
            startActivity(intent)
        }
    }
}