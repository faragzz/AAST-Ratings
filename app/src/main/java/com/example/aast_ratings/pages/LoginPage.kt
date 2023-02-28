package com.example.aast_ratings.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aast_ratings.ui.theme.background
import com.example.aast_ratings.ui.theme.whiteText
import com.example.aast_ratings.R
import com.example.aast_ratings.ui.theme.primaryColor

@Composable
fun Login_Page() {
    var image = painterResource(id = R.drawable.logo)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(background),
        contentAlignment = Alignment.TopCenter
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(20.dp),
            contentAlignment = Alignment.TopCenter
        ){
            Image( painter = image,contentDescription ="Logo")
        }

        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier =  Modifier.height(250.dp))
            var values by remember { mutableStateOf("") }
            OutlinedTextField(
                value = values,
                onValueChange = {
                    values = it },
                label = { Text("Enter Username") },
                maxLines = 1,
                textStyle = TextStyle(color = Color.White, fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .padding(20.dp)
                    .background(background),
                shape = RoundedCornerShape(7.dp),
            )
            Spacer(modifier =  Modifier.height(10.dp))
            var value by remember { mutableStateOf("") }
            var passwordvisability by remember { mutableStateOf(false) }
            OutlinedTextField(
                value = value,
                onValueChange = {value=it},
                trailingIcon = {
                    IconButton(
                        onClick = {
                            passwordvisability=!passwordvisability
                        }
                    ) {
                        Icon(painter = painterResource (R.drawable.baseline_remove_red_eye_24), contentDescription ="eye" , tint = if(passwordvisability) primaryColor else Color.Gray)
                    }
                },
                label = { Text("Enter Password") },
                maxLines = 1,
                textStyle = TextStyle(color = Color.White, fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .padding(20.dp)
                    .background(background),
                shape = RoundedCornerShape(7.dp),
                visualTransformation = if(passwordvisability) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)

            )
            Spacer(modifier =  Modifier.height(90.dp))
            Button(
                onClick = {
//                    Toast.makeText(con,"Helloz", Toast.LENGTH_LONG).show()
//                    navController.navigate("Home_Page"){
//                        popUpTo = navController.graph.startDestinationId
//                        launchSingleTop = true
                    },
                modifier = Modifier.padding(start=85.dp)
            ) {
                Text(
                    text = "Sign in",
                    fontSize = 30.sp,
                    style = TextStyle(color = whiteText, fontWeight = FontWeight.Bold),
                )
            }


        }
    }
}
@Composable
fun text(content :String) {
    Text(
        text = content,
        color = whiteText,
        style = TextStyle(fontWeight = FontWeight.Bold),
        fontSize = 30.sp
    )
}
