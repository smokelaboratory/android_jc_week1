package com.smokelaboratory.jc_challenge_week_1

import androidx.compose.ui.graphics.Color
import java.io.Serializable

val dogData = listOf(
    DogData("Charlie", Color(0xFF1A51F5), R.drawable.dog_1, R.drawable.ic_dog_1),
    DogData("Oscar", Color.Yellow, R.drawable.dog_2, R.drawable.ic_dog_2),
    DogData("Daisy", Color.Cyan, R.drawable.dog_3, R.drawable.ic_dog_3),
    DogData("Rosie", Color.Magenta, R.drawable.dog_4, R.drawable.ic_dog_6),
    DogData("Buddy", Color(0xff336699), R.drawable.dog_5, R.drawable.ic_dog_5),
    DogData("Molly", Color(0xFFF74122), R.drawable.dog_6, R.drawable.ic_dog_6)
)

data class DogData(val name: String, val color: Color, val image: Int, val logo: Int) : Serializable