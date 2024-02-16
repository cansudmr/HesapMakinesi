package com.example.hesapmakinesi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.hesapmakinesi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun btnSayiTik(view: View){

        if(yeniOperator){
            binding.sayiGoster.setText("")
        }
        yeniOperator = false
        var seciliButon = view as Button
        var x = binding.sayiGoster.text.toString()
        var deger = seciliButon.text.toString()
        if(seciliButon.text == "+/-"){
            x = "-"+x
        }else{
            x += deger
        }


        binding.sayiGoster.setText(x)

    }

    var operator = "*"
    var eskiSayi = ""
    var yeniOperator = true

    fun btnOnTik(view :View){
        var secilenButton = view as Button
        when(secilenButton.id){
            binding.buttonBolme.id ->{
                operator = "/"
            }

            binding.buttonCarpma.id ->{
                operator = "x"
            }

            binding.buttonCikarma.id ->{
                operator = "-"
            }

            binding.buttonToplama.id ->{
                operator = "+"
            }


        }
        eskiSayi = binding.sayiGoster.text.toString()
        yeniOperator = true
    }

    fun btnEsittirTik(view:View){
        var yeniSayi = binding.sayiGoster.text.toString()
        var sonuc : Double? = null

        when(operator){
            "/"->{
                sonuc = eskiSayi.toDouble() / yeniSayi.toDouble()
            }
            "x"->{
                sonuc = eskiSayi.toDouble() * yeniSayi.toDouble()
            }
            "-"->{
                sonuc = eskiSayi.toDouble() - yeniSayi.toDouble()
            }
            "+"->{
                sonuc = eskiSayi.toDouble() + yeniSayi.toDouble()
            }
        }

        binding.sayiGoster.setText(sonuc.toString())
        yeniOperator = true
    }

    fun btnSilTik(view:View){
        binding.sayiGoster.setText("0")
        yeniOperator = true
    }

    fun btnYuzdeTik(view: View){
        var sayi : Double = binding.sayiGoster.text.toString().toDouble()/100
        binding.sayiGoster.setText(sayi.toString())
        yeniOperator = true
    }
}