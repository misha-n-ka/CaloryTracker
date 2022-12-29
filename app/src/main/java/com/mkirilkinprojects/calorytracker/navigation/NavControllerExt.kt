package com.mkirilkinprojects.calorytracker.navigation

import androidx.navigation.NavController
import com.mkirilkinprojects.core.util.UiEvent

fun NavController.navigate(event: UiEvent.Navigate) {
    this.navigate(event.route)
}
