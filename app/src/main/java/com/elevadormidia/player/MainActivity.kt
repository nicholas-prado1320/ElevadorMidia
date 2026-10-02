package com.elevadormidia.player

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.elevadormidia.player.ui.player.PlayerScreen
import com.elevadormidia.player.ui.theme.ElevadorMidiaTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            ElevadorMidiaTheme {
                PlayerScreen()
            }
        }
    }
}