package com.example.recyclerviewwk5assessment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.recyclerviewwk5assessment.databinding.ActivityMainBinding
import com.example.recyclerviewwk5assessment.databinding.ActivityRecyclerBinding
import com.example.recyclerviewwk5assessment.databinding.ActivityViewProfileBinding
import com.example.recyclerviewwk5assessment.models.Profile

class ViewProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            imageView.setImageResource(intent.getStringExtra("imageView")!!.toInt())
            firstName.text = intent.getStringExtra("firstName")
            lastName.text = intent.getStringExtra("lastName")
        }

    }
}