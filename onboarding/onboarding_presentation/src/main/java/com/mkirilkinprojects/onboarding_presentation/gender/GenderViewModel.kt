package com.mkirilkinprojects.onboarding_presentation.gender

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mkirilkinprojects.core.domain.models.Gender
import com.mkirilkinprojects.core.domain.preferences.Preferences
import com.mkirilkinprojects.core.navigation.Route
import com.mkirilkinprojects.core.util.NavigationUiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GenderViewModel @Inject constructor(
    private val preferences: Preferences
) : ViewModel() {

    var selectedGender by mutableStateOf<Gender>(Gender.Male)
        private set

    private val _navigationUiEvent = Channel<NavigationUiEvent>()
    val navigationUiEvent = _navigationUiEvent.receiveAsFlow()

    fun onGenderClick(gender: Gender) {
        selectedGender = gender
    }

    fun onNextClick() {
        viewModelScope.launch {
            preferences.saveGender(selectedGender)
            _navigationUiEvent.send(NavigationUiEvent.Navigate(Route.AGE))
        }
    }
}
