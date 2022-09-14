package com.xhateya.idn.barvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edtWidth: EditText
    private lateinit var edtLength: EditText
    private lateinit var edtHeight: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    companion object{
        private const val STATE_RESULT="state_result"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        edtWidth= findViewById(R.id.edt_width)
        edtLength= findViewById(R.id.edt_length)
        edtHeight= findViewById(R.id.edt_height)
        btnCalculate= findViewById(R.id.btn_calculate)
        tvResult= findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener(this)

        if(savedInstanceState != null){
            val result = savedInstanceState.getString(STATE_RESULT)
            tvResult.text= result
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvResult.text.toString())
    }

    override fun onClick(p0: View) {
        if (p0.id == R.id.btn_calculate){
            val inputLength = edtLength.text.toString().trim()
            val inputWidth = edtWidth.text.toString().trim()
            val inputHeight = edtHeight.text.toString().trim()
            
            var isEmptyFields= false

            if(inputLength.isEmpty()) {
                isEmptyFields=true
                edtLength.error="Tidak boleh kosong"
            }

            if(inputWidth.isEmpty()){
                isEmptyFields= true
                edtWidth.error= "Tidak boleh kosong"
            }
            if(inputHeight.isEmpty()){
                isEmptyFields= true
                edtHeight.error= "Tidak boleh kosong"
            }

            if(!isEmptyFields){
                val volume= inputLength.toDouble()*inputWidth.toDouble()*inputHeight.toDouble()
                tvResult.text = volume.toString()
            }

        }
    }
}


