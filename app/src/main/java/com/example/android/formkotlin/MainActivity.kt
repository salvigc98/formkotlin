package com.example.android.formkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = lblName.editText?.text
        val surname = lblSurname.editText?.text
        val email = lblEmail.editText?.text
        val phoneNumber = lblPhoneNumber.editText?.text
        val password = lblPassword.editText?.text
        val termsCheck = termsCheck

        var isNameValid: Boolean
        var isSurnameValid: Boolean
        var isEmailValid: Boolean
        var isPhoneNumberValid: Boolean
        var isPasswordValid: Boolean

        fun isEmailValid(email: String): Boolean {
            return  android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }

        fun isPhoneNumberValid(phoneNumber: String): Boolean {
            return  android.util.Patterns.PHONE.matcher(phoneNumber).matches()
        }

        fun isPasswordValid(password: String) : Boolean {
                val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$"
                val passwordMatcher = Regex(passwordPattern)

                return passwordMatcher.find(password) != null
        }

        formButton.setOnClickListener {

            if (name.toString().length === 0) {
                isNameValid= false
                lblName.error = "Debe de introducir un nombre"
            } else {
                isNameValid = true
                lblName.error = null
            }

            if (surname.toString().length === 0) {
                isSurnameValid = false
                lblSurname.error = "Debe de introducir un apellido"
            } else {
                isSurnameValid = true
                lblSurname.error = null
            }

            if (!isPhoneNumberValid(phoneNumber = phoneNumber.toString())) {
                isPhoneNumberValid = false
                lblPhoneNumber.error = "Debe añadir un telefono valido"
            } else {
                isPhoneNumberValid = true
                lblPhoneNumber.error = null
            }

            if (!isEmailValid(email = email.toString())) {
                isEmailValid = false
                lblEmail.error = "Debe de introducir un email valido"
            } else {
                isEmailValid = true
                lblEmail.error = null
            }

            if (!isPasswordValid(password = password.toString())) {
                isPasswordValid = false
                lblPassword.error = "La contraseña debe contener un numero, una minuscula, una mayuscula, un caracter especial y al menos 8 caracteres"
            } else {
                isPasswordValid = true
                lblPassword.error = null
            }


            if (
                isNameValid &&
                isSurnameValid &&
                isPhoneNumberValid &&
                isEmailValid &&
                isPasswordValid
            ) {
                if (termsCheck.isChecked) {
                    val user = User(
                        name = name.toString(),
                        surname = surname.toString(),
                        email = email.toString(),
                        phoneNumber = phoneNumber.toString().toInt(),
                        password = password.toString()
                    )
                    Toast.makeText(
                        this,
                        "usuario creado con exito",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    Snackbar.make(
                        it, // Parent view
                        "Debe aceptar los terminos", // Message to show
                        Snackbar.LENGTH_SHORT // How long to display the message.
                    ).show()
                }
            }
        }
    }
}
