package com.nikhil.rockpaper

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nikhil.rockpaper.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var userscore1=0
    var compscore1=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val images = mapOf(
            0 to R.drawable.rock,
            1 to R.drawable.paper,
            2 to R.drawable.scissors
        )
        binding.img1.setOnClickListener { game(2, images) }
        binding.img2.setOnClickListener { game(0, images) }
        binding.img3.setOnClickListener { game(1, images) }
    }
        fun game(uschoice:Int,images:Map<Int,Int>)
        {
            binding.userchoice.setImageResource(images[uschoice]!!)
            val randchoice=Random.nextInt(0,3)
            binding.compchoice.setImageResource(images[randchoice]!!)
            binding.userscore.text="0"


            when {
                uschoice == randchoice -> {
                    userscore1++
                    compscore1++
                }
                (uschoice == 0 && randchoice == 2) ||
                         (uschoice == 1 && randchoice == 0) ||
                        (uschoice == 2 && randchoice == 1) -> {
                            userscore1++
                        }
                else -> {
                    compscore1++
                }
            }
            binding.userscore.text = userscore1.toString()
            binding.scorecomp.text = compscore1.toString()
        }
}
