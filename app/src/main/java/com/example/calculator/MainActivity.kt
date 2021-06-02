package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.calculator.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var isNewOp=true
    var oldNumber=""
    var op="+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberEvent(view: View) {
        if(isNewOp)
            editText.setText("")
        isNewOp=false

       var butClick=editText.text.toString()
        var butSelect=view as Button
        when(butSelect.id){
            but1.id -> { butClick+="1"}
            but2.id -> { butClick+="2"}
            but3.id -> { butClick+="3"}
            but4.id -> { butClick+="4"}
            but5.id -> { butClick+="5"}
            but6.id -> { butClick+="6"}
            but7.id -> { butClick+="7"}
            but8.id -> { butClick+="8"}
            but9.id -> { butClick+="9"}
            but0.id -> { butClick+="0"}
            butDot.id->{ butClick+="."}
            butplusMinus.id->{ butClick+="-$butClick"}

        }
        editText.setText(butClick)
    }

    fun operatorEvent(view: View) {
        isNewOp=true
        oldNumber=editText.text.toString()
        var butselect=view as Button
        when(butselect.id){
            butMultiply.id->{op="*"}
            butPlus.id->{op="+"}
            btnminus.id->{op="-"}
            butDivide.id->{op="/"}

        }
    }

    fun equalEvent(view: View) {
        var newNumber=editText.text.toString()
        var result=0.0
        when(op){
            "+"->{result=oldNumber.toDouble()+newNumber.toDouble()}
            "*"->{result=oldNumber.toDouble()*newNumber.toDouble()}
            "-"->{result=oldNumber.toDouble()-newNumber.toDouble()}
            "/"->{result=oldNumber.toDouble()/newNumber.toDouble()}
        }
        editText.setText(result.toString())
    }

    fun acEvent(view: View) {
        editText.setText(0)
        isNewOp=true
    }

    fun perEvent(view: View) {
        var number=editText.text.toString().toDouble()/100
        editText.setText(number.toString())
        isNewOp=true
    }
}