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

        fun onCheckboxClicked(view: View) {
            var checked = view as CheckBox
            if (CBC == checked) {
                message(CBC.text.toString() + if (CBC.isChecked) " Anda memilih Hobi Coding " else " Anda batal memilih Hobi Coding ")
            }
            if (CBR == checked) {
                message(CBR.text.toString() + if (CBR.isChecked) " Anda memilih Hobi Reading " else " Anda batal memilih Hobi Reading ")
            }

            if (CBT == checked) {
                message(CBT.text.toString() + if (CBT.isChecked) "Anda memilih Hobi Traveling" else " Anda batal memilih Hobi Traveling ")
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
