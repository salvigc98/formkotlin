package com.example.android.formkotlin

class User(name: String, surname: String, email: String, phoneNumber: Int, password: String) {

    private val name: String = name
    private val surname: String = surname
    private val email: String = email
    private val phoneNumber: Int = phoneNumber
    private val password: String = password

    override fun toString(): String {
        return "User(name='$name', surname='$surname', email='$email', phoneNumber=$phoneNumber, password='$password')"
    }
}