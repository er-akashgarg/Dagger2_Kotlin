package com.example.dagger2.activity

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

import com.example.dagger2.app.MyApp
import com.example.dagger2.utils.MySharedPreference
import com.example.dagger2.R

import javax.inject.Inject


/**
 * @author Akash Garg
 */


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var inUsername: EditText
    private lateinit var inNumber: EditText
    private lateinit var btnSave: Button
    private lateinit var btnGet: Button


    @set:Inject
    var mySharedPrefernce: MySharedPreference? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initComponent()

    }

    private fun initComponent() {
        (applicationContext as MyApp).myComponent.inject(this)
    }


    private fun initViews() {
        btnGet = findViewById(R.id.btnGet)
        btnSave = findViewById(R.id.btnSave)
        inUsername = findViewById(R.id.inUsername)
        inNumber = findViewById(R.id.inNumber)
        btnSave.setOnClickListener(this)
        btnGet.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {

            R.id.btnGet -> {

                inUsername.setText(mySharedPrefernce!!.getData("username"))
                inNumber.setText(mySharedPrefernce!!.getData("number"))
            }
            R.id.btnSave -> {

                mySharedPrefernce!!.putData("username", inUsername.text.toString())
                mySharedPrefernce!!.putData("number", inNumber.text.toString())
                inUsername.setText("")
                inNumber.setText("")

            }
        }
    }
}
