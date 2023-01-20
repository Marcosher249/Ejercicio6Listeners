package com.example.ejercicio5listeners



import android.content.res.Resources
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.core.graphics.blue
import androidx.core.view.isVisible
import com.example.ejercicio5listeners.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var nombre = ""
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener(){
            mostrar()
        }
        binding.editTextTextPersonName.setOnFocusChangeListener { view, b ->
            if(b)
                binding.editTextTextPersonName.hint = ""
            else
                binding.editTextTextPersonName.hint = "Introduce tu nombre"
        }

        binding.editTextTextPersonName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(binding.editTextTextPersonName.text.toString().length > 0){
                    binding.button.text = "Finalizar"
                    compare ()}
                else
                    binding.button.text = "Comenzar"
            }
        })
    }
    private fun mostrar (){
        if (binding.button.text == "Comenzar"){
            binding.editTextTextPersonName.isVisible = true

        }
        else if (binding.button.text == "Finalizar"){
            binding.button.text = "Comenzar"
            binding.editTextTextPersonName.setText("")
            compare()
            binding.editTextTextPersonName.isVisible = false
        }

    }
    fun compare (){
        nombre = binding.editTextTextPersonName.text.toString()
        if (nombre.toLowerCase() == "wayne")
            binding.imageView.isVisible = true
        else
            binding.imageView.isVisible = false

        if (nombre.toLowerCase() == "joker"){
           binding.button.setBackgroundColor(Color.RED)
        }
    }

}


