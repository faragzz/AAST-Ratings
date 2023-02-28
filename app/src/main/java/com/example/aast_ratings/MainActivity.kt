package com.example.aast_ratings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.aast_ratings.pages.Home_Page
import com.example.aast_ratings.pages.Login_Page
import com.example.aast_ratings.ui.theme.AASTRatingsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AASTRatingsTheme {
                screens()

            }
        }
    }
}

@Composable
fun screens(){
    Home_Page()
//    Login_Page()
}
