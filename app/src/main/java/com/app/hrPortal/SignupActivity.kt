package com.app.hrPortal

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SignupActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)

        val designationSpinner = findViewById<Spinner>(R.id.designationSpinner)
        val signupButton = findViewById<Button>(R.id.signupButton)
        val toggleSignupPasswordVisibility = findViewById<ImageView>(R.id.toggleSignupPasswordVisibility)


        val passwordSignupEditText = findViewById<EditText>(R.id.passwordSignupEditText)



//        error
        val deginationErrorId = findViewById<TextView>(R.id.deginationErrorId)
        ArrayAdapter.createFromResource(
            this,
            R.array.designation_options,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            designationSpinner.adapter = adapter
        }

        signupButton.setOnClickListener() {
            val selectedDesignation = designationSpinner.selectedItem.toString()
            if (selectedDesignation == "--Select--") {
                deginationErrorId.visibility = View.VISIBLE
            }
        }
        var isPasswordVisible = false
        toggleSignupPasswordVisibility.setOnClickListener(){
            println("password")
            isPasswordVisible = !isPasswordVisible

            if (isPasswordVisible) {
                // Show password
                passwordSignupEditText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            } else {
                // Hide password
                passwordSignupEditText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }

            // Move cursor to the end of the text
            passwordSignupEditText.setSelection(passwordSignupEditText.text.length)
        }

// To get selected value
        designationSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedDesignation = parent?.getItemAtPosition(position) as String
                // Use the selected designation
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle no selection
            }


        }
    }
}