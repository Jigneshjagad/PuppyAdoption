package com.example.androiddevchallenge.data

data class Puppy(
    val id: Int,
    val name: String,
    val breed: String,
    val gender: Gender,
    val image: Int,
    val contactNumber: String,
    val age: Int,
    val weight: Float,
    val location: String,
    val description: String,
)

enum class Gender {
    Male,
    Female
}