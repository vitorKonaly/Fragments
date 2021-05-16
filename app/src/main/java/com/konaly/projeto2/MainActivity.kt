package com.konaly.projeto2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.konaly.projeto2.fragments.FavoritosFragment
import com.konaly.projeto2.fragments.HomeFragment
import com.konaly.projeto2.fragments.ProdutosFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener,BottomNavigationView.OnNavigationItemSelectedListener {



    private lateinit var buttonHome:Button
    private lateinit var buttonProdutos:Button
    private lateinit var buttonFavoritos:Button

    private lateinit var homeFragment:HomeFragment
    private lateinit var produtosFragment: ProdutosFragment
    private lateinit var favoritosFragment:FavoritosFragment

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonHome = btnHome
        buttonHome.setOnClickListener (this)

        buttonFavoritos = btnFavoritos
        buttonFavoritos.setOnClickListener(this)

        buttonProdutos = btnProdutos
        buttonProdutos.setOnClickListener (this)

        homeFragment = HomeFragment()
        produtosFragment = ProdutosFragment()
        favoritosFragment = FavoritosFragment()
        setFragment(homeFragment)

        bottomNavigationView = bottomNavigation
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
    }

    private fun setFragment(fragment:Fragment){
        val fragmentTransaction = supportFragmentManager .beginTransaction()
        fragmentTransaction.replace(R.id.frameFragments,fragment)
        fragmentTransaction.commit()
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btnHome ->{
                setFragment(homeFragment)
            }

            R.id.btnProdutos ->{
                setFragment(produtosFragment)

            }

            R.id.btnFavoritos ->{
                setFragment(favoritosFragment)

            }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menuHome ->{
                setFragment(homeFragment)
            }
            R.id.menuProdutos ->{
                setFragment(produtosFragment)
            }
            R.id.menuFavoritos ->{
                setFragment(favoritosFragment)
            }
        }

        return true
    }
}