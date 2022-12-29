package com.mkirilkinprojects.onboarding_presentation.gender

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import com.mkirilkinprojects.core.R
import com.mkirilkinprojects.core.domain.models.Gender
import com.mkirilkinprojects.core.util.NavigationUiEvent
import com.mkirilkinprojects.core_ui.LocalSpacing
import com.mkirilkinprojects.onboarding_presentation.components.ActionButton
import com.mkirilkinprojects.onboarding_presentation.components.SelectableButton

@Composable
fun GenderScreen(
    onNavigate: (NavigationUiEvent.Navigate) -> Unit,
    viewModel: GenderViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    LaunchedEffect(key1 = true) {
        viewModel.navigationUiEvent.collect { event ->
            when (event) {
                is NavigationUiEvent.Navigate -> onNavigate(event)
                is NavigationUiEvent.NavigateUp -> Unit
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.spaceLarge)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.whats_your_gender),
                style = MaterialTheme.typography.h3,
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            Row {
                SelectableButton(
                    text = stringResource(id = R.string.male),
                    isSelected = viewModel.selectedGender is Gender.Male,
                    color = MaterialTheme.colors.primaryVariant,
                    selectedTextColor = Color.White,
                    onClick = { viewModel.onGenderClick(gender = Gender.Male) },
                    textStyle = MaterialTheme.typography.button.copy(fontWeight = FontWeight.Normal)
                )
                SelectableButton(
                    text = stringResource(id = R.string.female),
                    isSelected = viewModel.selectedGender is Gender.Female,
                    color = MaterialTheme.colors.primaryVariant,
                    selectedTextColor = Color.White,
                    onClick = { viewModel.onGenderClick(gender = Gender.Female) },
                    textStyle = MaterialTheme.typography.button.copy(fontWeight = FontWeight.Normal)
                )
            }
        }
        ActionButton(
            text = stringResource(id = R.string.next),
            onClick = { viewModel.onNextClick() },
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }
}
