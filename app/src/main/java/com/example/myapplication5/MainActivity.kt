package com.example.myapplication5

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.myapplication5.databinding.ActivityMainBinding
import androidx.fragment.app.FragmentTransaction


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener {
            binding.mainActivity.openDrawer(GravityCompat.START)
        }

        binding.navigationView.setNavigationItemSelectedListener { menuItem ->
            val itemId = menuItem.itemId
            when (itemId) {
                R.id.main_screen_menu_item -> Log.d("MainActivity", "open main screen fragment")
                // TODO: Добавить всем пунктам меню id и сделать переходы по фрагментам здесь
            }

            binding.mainActivity.closeDrawer(GravityCompat.START)
            true
        }


        if (savedInstanceState == null) {
            fragmentTransaction
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .add(R.id.container, MainScreenFragment())
                .commit()
        }
    }
}