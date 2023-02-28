package com.example.aast_ratings.pages

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aast_ratings.ui.theme.background
import com.example.aast_ratings.R
import com.example.aast_ratings.ui.theme.bar
import com.example.aast_ratings.ui.theme.number
import com.example.aast_ratings.ui.theme.whiteText


@Composable
@Preview
fun Home_Page() {
    val image = painterResource(id = R.drawable.logo)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(background)
    ){
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth()
                .padding(20.dp)
        ){
            Image(painter = image, contentDescription = "Logo")
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(230.dp))

            Text(
//                modifier = Modifier.padding(start = 85.dp),
                text = "Rate your Lecturer",
                fontSize = 30.sp,
                style = TextStyle(
                    color = whiteText,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
//                modifier = Modifier.padding(start = 80.dp),
                text = "Rate your lectures, improve your education. Join now!",
                fontSize = 10.sp,
                style = TextStyle(
                    color = whiteText,
                )
            )
            Spacer(modifier = Modifier.height(60.dp))
            Button(
//                modifier = Modifier.padding(start = 80.dp),
                onClick = { /*TODO*/ }
            ) {
                Text(
                    text = "Get Started"
                )
            }
            Spacer(modifier = Modifier.height(40.dp))
                Box(
                    modifier = Modifier
                        .padding(30.dp)
                        .width(350.dp)
                        .height(70.dp)
                        .background(bar),

                    contentAlignment = Alignment.Center
                ){
                    Column (
                        verticalArrangement = Arrangement.SpaceBetween
                    ){

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                    )
                    {
                        Text(
                            text = "Campuses",
                            fontSize = 14.sp,
                            style = TextStyle(
                                color = whiteText,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "Colleges",
                            fontSize = 14.sp,
                            style = TextStyle(
                                color = whiteText,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "Lecturers",
                            fontSize = 14.sp,
                            style = TextStyle(
                                color = whiteText,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "Reviews",
                            fontSize = 14.sp,
                            style = TextStyle(
                                color = whiteText,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                        //numbers get from API
                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly
                        )
                        {
                            Spacer(modifier = Modifier.width(30.dp))
                            Text(
                                text = "3",
                                fontSize = 14.sp,
                                style = TextStyle(
                                    color = whiteText,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                            Spacer(modifier = Modifier.width(60.dp))
                            Text(
                                text = "8",
                                fontSize = 14.sp,
                                style = TextStyle(
                                    color = whiteText,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                            Spacer(modifier = Modifier.width(65.dp))
                            Text(
                                text = "11",
                                fontSize = 14.sp,
                                style = TextStyle(
                                    color = number,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                            Spacer(modifier = Modifier.width(45.dp))
                            Text(
                                text = "409",
                                fontSize = 14.sp,
                                style = TextStyle(
                                    color = number,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }
                    }
                }
        }
    }
}
