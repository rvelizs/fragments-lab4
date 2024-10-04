package com.mv.proyectoavance

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.mv.proyectoavance.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private val TAG = "HomeActivity"
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        val txtMutable = binding.txtMutable

        val username = intent.getStringExtra("user")

        txtMutable.text = username ?: "Usuario desconocido"

    }
}