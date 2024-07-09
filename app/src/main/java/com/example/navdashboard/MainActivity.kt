package com.example.navdashboard

import android.os.Bundle
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val frameLayout : FrameLayout
        val bottomNavigationView : BottomNavigationView

        var fragmentBmi = BmiFragment()
        var fragmentCalculator = CalculatorFragment()
        var fragmentTicTacToe = TicTacToeFragment()
        var fragmentImageView = ImageViewFragment()

        bottomNavigationView=findViewById(R.id.bottomNavigationView)

        replace(fragmentBmi)

        bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId)
            {
                R.id.fragmentBmi -> replace(fragmentBmi)
                R.id.fragmentCalculator -> replace(fragmentCalculator)
                R.id.fragmentTicTacToe -> replace(fragmentTicTacToe)
                R.id.fragmentImageView -> replace(fragmentImageView)
            }
            true
        }

        bottomNavigationView.itemIconTintList = null

    }

    fun replace(fragment: Fragment)
    {
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout,fragment).commit()
    }

}