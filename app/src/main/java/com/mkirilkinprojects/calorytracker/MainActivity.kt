package com.mkirilkinprojects.calorytracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mkirilkinprojects.calorytracker.navigation.navigate
import com.mkirilkinprojects.calorytracker.ui.theme.CaloryTrackerTheme
import com.mkirilkinprojects.core.domain.preferences.Preferences
import com.mkirilkinprojects.core.navigation.Route
import com.mkirilkinprojects.onboarding_presentation.activity.ActivityScreen
import com.mkirilkinprojects.onboarding_presentation.age.AgeScreen
import com.mkirilkinprojects.onboarding_presentation.gender.GenderScreen
import com.mkirilkinprojects.onboarding_presentation.goal.GoalScreen
import com.mkirilkinprojects.onboarding_presentation.height.HeightScreen
import com.mkirilkinprojects.onboarding_presentation.nutrient_goal.NutrientGoalScreen
import com.mkirilkinprojects.onboarding_presentation.weight.WeightScreen
import com.mkirilkinprojects.onboarding_presentation.welcome.WelcomeScreen
import com.mkirilkinprojects.tracker_presentation.search.SearchScreen
import com.mkirilkinprojects.tracker_presentation.tracker_overview.TrackerOverViewScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val shouldShowOnboarding = preferences.loadShouldShowOnboarding()
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
                        startDestination = if (shouldShowOnboarding) {
                            Route.WELCOME
                        } else {
                            Route.TRACKER_OVERVIEW
                        },
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
                            NutrientGoalScreen(
                                scaffoldState = scaffoldState,
                                onNavigate = { navController.navigate(it) }
                            )
                        }
                        composable(Route.ACTIVITY) {
                            ActivityScreen(onNavigate = { navController.navigate(it) })
                        }
                        composable(Route.GOAL) {
                            GoalScreen(onNavigate = { navController.navigate(it) })
                        }
                        composable(Route.TRACKER_OVERVIEW) {
                            TrackerOverViewScreen(onNavigate = { navController.navigate(it) })
                        }
                        composable(
                            route = Route.SEARCH + "/{mealName}/{dayOfMonth}/{month}/{year}",
                            arguments = listOf(
                                navArgument("mealName") {
                                    type = NavType.StringType
                                },
                                navArgument("dayOfMonth") {
                                    type = NavType.IntType
                                },
                                navArgument("month") {
                                    type = NavType.IntType
                                },
                                navArgument("year") {
                                    type = NavType.IntType
                                },
                            )
                        ) {
                            val mealName = it.arguments?.getString("mealName")!!
                            val dayOfMonth = it.arguments?.getInt("dayOfMonth")!!
                            val month = it.arguments?.getInt("month")!!
                            val year = it.arguments?.getInt("year")!!
                            SearchScreen(
                                scaffoldState = scaffoldState,
                                mealName = mealName,
                                dayOfMonth = dayOfMonth,
                                month = month,
                                year = year,
                                onNavigateUp = {
                                    navController.navigateUp()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
