package com.mv.proyectoavance

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mv.proyectoavance.fragments.Login
import com.mv.proyectoavance.fragments.olvido_pass_correo

class InitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_init)

        if (savedInstanceState == null) {
            //val loginFragment = Login()
            val olvido_passCorreo = olvido_pass_correo()

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, olvido_passCorreo)
                .commit()
        }
    }
}