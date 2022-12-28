package com.mkirilkinprojects.core.util

sealed class NavigationUiEvent {
    data class Navigate(val route: String) : NavigationUiEvent()
    object NavigateUp : NavigationUiEvent()
}
