package com.pkpm.smartvillage.home.struktur
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.pkpm.smartvillage.R
import com.pkpm.smartvillage.databinding.ActivityMainBinding
import com.pkpm.smartvillage.databinding.ActivityStrukturBinding

class StrukturActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStrukturBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStrukturBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()


        val phoneNumbers = arrayOf(
            "+621234567890", "+621234567891", "+621234567892",
            "+621234567893", "+621234567894", "+621234567895",
            "+621234567896", "+621234567897", "+621234567898",
            "+621234567899", "+621234567800", "+621234567801",
            "+621234567802"
        )

        val buttons = arrayOf(
            binding.wa1, binding.wa2, binding.wa3, binding.wa4, binding.wa5,
            binding.wa6, binding.wa7, binding.wa8, binding.wa9, binding.wa10,
            binding.wa11, binding.wa12
        )

        for (i in buttons.indices) {
            buttons[i].setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse("https://wa.me/${phoneNumbers[i]}")
                }
                startActivity(intent)
            }
        }
    }
}