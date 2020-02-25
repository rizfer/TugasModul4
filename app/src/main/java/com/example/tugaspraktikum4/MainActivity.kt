package com.example.tugaspraktikum4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val Btnadd      = findViewById<ImageButton>(R.id.imgButtonAdd)
        val Btncancel   = findViewById<ImageButton>(R.id.imgButtonCancel)
        val nama        = findViewById<EditText>(R.id.editNama)
        val RG          = findViewById<RadioGroup>(R.id.rg)
        val CBC         = findViewById<CheckBox>(R.id.cbCoding)
        val CBR         = findViewById<CheckBox>(R.id.cbReading)
        val CBT         = findViewById<CheckBox>(R.id.cbTraveling)

        RG.setOnCheckedChangeListener() { group, checkedId ->
            val radio: RadioButton = findViewById(checkedId)
            Toast.makeText(applicationContext," Gender : ${radio.text} telah dipilih", Toast.LENGTH_SHORT).show()
        }
        Btnadd.setOnClickListener{
            var id: Int = RG.checkedRadioButtonId
            if (id!=-1){
                val radio:RadioButton = findViewById(id)
                Toast.makeText(this@MainActivity,"Nama: ${nama.text}, gender: ${radio.text} telah berhasil disimpan", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this@MainActivity,"Gender belum dipilih, Silahkan pilih gender...", Toast.LENGTH_SHORT).show()
            }
        }

        CBC.setOnCheckedChangeListener {buttonView, isChecked ->
            if(CBC.isChecked){
                var str:String= " Anda memilih Hobi " + CBC.text
                message(str)
            }
            else {
                var str: String = " Anda batal memilih Hobi " + CBC.text
                message(str)
            }
        }
        CBR.setOnCheckedChangeListener {buttonView, isChecked ->
            if(CBR.isChecked){
                var str:String= " Anda memilih Hobi " + CBR.text
                message(str)
            }
            else {
                var str: String = " Anda batal memilih Hobi " + CBR.text
                message(str)
            }
        }
        CBT.setOnCheckedChangeListener {buttonView, isChecked ->
            if(CBT.isChecked){
                var str:String= " Anda memilih Hobi " + CBT.text
                message(str)
            }
            else {
                var str: String = " Anda batal memilih Hobi " + CBT.text
                message(str)
            }
        }


        Btncancel.setOnClickListener {
            editNama.text.clear()
            RG.clearCheck()
            cbCoding.clearFocus()
            cbReading.clearFocus()
            cbTraveling.clearFocus()
        }
    }

    fun message(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_LONG).show()
    }
}
