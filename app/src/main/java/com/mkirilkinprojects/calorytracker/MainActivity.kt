package com.mkirilkinprojects.calorytracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mkirilkinprojects.calorytracker.navigation.navigate
import com.mkirilkinprojects.calorytracker.ui.theme.CaloryTrackerTheme
import com.mkirilkinprojects.core.navigation.Route
import com.mkirilkinprojects.onboarding_presentation.age.AgeScreen
import com.mkirilkinprojects.onboarding_presentation.gender.GenderScreen
import com.mkirilkinprojects.onboarding_presentation.height.HeightScreen
import com.mkirilkinprojects.onboarding_presentation.weight.WeightScreen
import com.mkirilkinprojects.onboarding_presentation.welcome.WelcomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaloryTrackerTheme {
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    scaffoldState = scaffoldState,
                ) { paddingValue ->
                    NavHost(
                        navController = navController,
                        startDestination = Route.WELCOME,
                        modifier = Modifier.padding(paddingValue)
                    ) {
                        composable(Route.WELCOME) {
                            WelcomeScreen(onNavigate = { navController.navigate(it) })
                        }
                        composable(Route.AGE) {
                            AgeScreen(
                                scaffoldState = scaffoldState,
                                onNavigate = { navController.navigate(it) }
                            )
                        }
                        composable(Route.GENDER) {
                            GenderScreen(onNavigate = { navController.navigate(it) })
                        }
                        composable(Route.HEIGHT) {
                            HeightScreen(
                                scaffoldState = scaffoldState,
                                onNavigate = { navController.navigate(it) }
                            )
                        }
                        composable(Route.WEIGHT) {
                            WeightScreen(
                                scaffoldState = scaffoldState,
                                onNavigate = { navController.navigate(it) }
                            )
                        }
                        composable(Route.NUTRIENT_GOAL) {

                        }
                        composable(Route.ACTIVITY) {

                        }
                        composable(Route.GOAL) {

                        }
                        composable(Route.TRACKER_OVERVIEW) {

                        }
                        composable(Route.SEARCH) {

                        }
                    }
                }
            }
        }
    }
}
