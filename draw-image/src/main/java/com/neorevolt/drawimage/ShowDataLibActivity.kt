package com.neorevolt.drawimage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neorevolt.drawimage.databinding.ActivityShowDataLibBinding

class ShowDataLibActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShowDataLibBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowDataLibBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detail = intent.getStringExtra(EXTRA_DETAIL)

        binding.apply {
            tvDetail.text = detail
        }
    }

    companion object{
        const val EXTRA_DETAIL = "extra_detail"
    }
}