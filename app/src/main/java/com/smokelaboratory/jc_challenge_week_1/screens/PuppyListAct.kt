package com.smokelaboratory.jc_challenge_week_1.screens

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.smokelaboratory.jc_challenge_week_1.ui.theme.JC_challenge_week_1Theme

class PuppyListAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JC_challenge_week_1Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    PuppyListScreen()
                }
            }
        }
    }
}