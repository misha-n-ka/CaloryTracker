package com.mkirilkinprojects.calorytracker.navigation

import androidx.navigation.NavController
import com.mkirilkinprojects.core.util.NavigationUiEvent

fun NavController.navigate(event: NavigationUiEvent.Navigate) {
    this.navigate(event.route)
}
