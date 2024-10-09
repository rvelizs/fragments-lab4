package com.mv.proyectoavance

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mv.proyectoavance.principal_fragments.FavoritesFragment
import com.mv.proyectoavance.principal_fragments.HomeFragment
import com.mv.proyectoavance.principal_fragments.UserFragment

class PrincipalActivity : AppCompatActivity() {

    lateinit var fragmentManager: FragmentManager
    lateinit var fragmentTransaction: FragmentTransaction
    lateinit var homeFragment: HomeFragment
    lateinit var favoritesFragment: FavoritesFragment
    lateinit var userFragment: UserFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_principal)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        fragmentManager = supportFragmentManager

        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_nav_view)
        bottomNav.selectedItemId = R.id.home_menu
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home_menu -> {
                    homeFragment = HomeFragment()
                    loadFragment(homeFragment)
                    true
                }
                R.id.favorites_menu -> {
                    favoritesFragment = FavoritesFragment()
                    loadFragment(favoritesFragment)
                    true
                }
                R.id.user_menu -> {
                    userFragment = UserFragment()
                    loadFragment(userFragment)
                    true
                }
                else -> false
            }
        }

    }

    fun loadFragment(fragment: Fragment) {
        if (fragment != null) {
            fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.principal_container, fragment)
            fragmentTransaction.commit()
        }
    }
}