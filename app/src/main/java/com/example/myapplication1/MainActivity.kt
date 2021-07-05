package com.example.myapplication1

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

var btn: Button? = null
var tv: TextView? = null
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn = findViewById(R.id.btn_dialog)
        tv = findViewById(R.id.txt_state)
        tv!!.text = this.lifecycle.currentState.toString()
        btn!!.setOnClickListener(View.OnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Alert dialog")
            builder.setMessage(this.lifecycle.currentState.toString())
//builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))

            builder.setPositiveButton("OK") { dialog, which ->
                tv!!.text = this.lifecycle.currentState.toString()
            }

            builder.show()
            tv!!.text = this.lifecycle.currentState.toString()
        })
        getState("onCreate")
    }

    override fun onRestart() {
        super.onRestart()
        getState("onRestart")
    }

    override fun onPause() {
        super.onPause()
        getState("onPause")
    }

    override fun onStop() {
        super.onStop()
        getState("onStop")
    }

    override fun onResume() {
        super.onResume()
        getState("onResume")
    }

    override fun onStart() {
        super.onStart()
        getState("onStart")
    }

    override fun onDestroy() {
        super.onDestroy()
        getState("onDestroy")
    }
    fun getState(msg:String){
        Log.i("state_info", msg)
        Log.i("state_info", this.lifecycle.currentState.toString())
        tv!!.text = this.lifecycle.currentState.toString()

    }
}