package com.example.aast_ratings

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.BadgedBox
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.aast_ratings.APIState.StateViewModel
import com.example.aast_ratings.BottomNav.BottomNavItem
import com.example.aast_ratings.pages.Home_Page
import com.example.aast_ratings.pages.Login_Page
import com.example.aast_ratings.pages.Search_Page
import com.example.aast_ratings.ui.theme.AASTRatingsTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AASTRatingsTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(
                            item =listOf(
                                BottomNavItem(
                                    name = "Login",
                                    route = "login",
                                    icon = Icons.Default.Person
                                ),
                                BottomNavItem(
                                    name = "Home",
                                    route = "home",
                                    icon = Icons.Default.Home
                                ),
                                BottomNavItem(
                                    name = "Search",
                                    route = "search",
                                    icon = Icons.Default.Search
                                ),
                            ) ,
                            navController = navController ,
                            onItemClick ={
                                navController.navigate(it.route)
                            }
                        )
                    }
                ){
                    Navigation(navController = navController)
                }
            }
        }
    }
}

//@Composable
//fun screens(){
//    Home_Page()
//    Login_Page()
//    Search_Page()
//}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home" ){
        composable("home"){
            Home_Page()
        }
        composable("search"){
            Search_Page()
        }
        composable("login"){
            Login_Page()
        }
    }
}

@Composable
fun BottomNavigationBar(
    item: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick:(BottomNavItem) ->Unit
) {
    val backStackEntery = navController.currentBackStackEntryAsState()
    BottomNavigation (
        modifier = modifier,
        backgroundColor = Color.DarkGray,
        elevation = 5.dp
    ){
        item.forEach{item->
            val selected = item.route == backStackEntery.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = {onItemClick(item)},
                selectedContentColor = Color.DarkGray,
                unselectedContentColor = Color.Gray,
                icon = {
                    Column(
                        horizontalAlignment = CenterHorizontally
                    ) {
                        if(item.badgeCount > 0){
                            BadgedBox(
                                badge = {
                                    Text(text = item.badgeCount.toString())
                                }
                            ){
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription  = item.name
                                )
                            }
                        }else{
                            Icon(
                                imageVector = item.icon,
                                contentDescription  = item.name
                            )
                        }
                        if(selected){
                            Text(
                                text = item.name,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp
                            )
                        }
                    }
                }
            )
        }
    }

}