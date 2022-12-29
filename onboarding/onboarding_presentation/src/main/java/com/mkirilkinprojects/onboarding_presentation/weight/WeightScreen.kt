package com.mkirilkinprojects.onboarding_presentation.weight

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.mkirilkinprojects.core.R
import com.mkirilkinprojects.core.util.UiEvent
import com.mkirilkinprojects.core_ui.LocalSpacing
import com.mkirilkinprojects.onboarding_presentation.age.AgeViewModel
import com.mkirilkinprojects.onboarding_presentation.components.ActionButton
import com.mkirilkinprojects.onboarding_presentation.components.UnitTextField
import com.mkirilkinprojects.onboarding_presentation.height.HeightViewModel

@Composable
fun WeightScreen(
    scaffoldState: ScaffoldState,
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: WeightViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Navigate -> onNavigate(event)
                is UiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message.asString(context)
                    )
                }
                is UiEvent.NavigateUp -> Unit
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
                text = stringResource(id = R.string.whats_your_weight),
                style = MaterialTheme.typography.h3,
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            UnitTextField(
                value = viewModel.weight,
                onValueChange = { viewModel.onWeightEnter(it) },
                unit = stringResource(R.string.kg)
            )
        }
        ActionButton(
            text = stringResource(id = R.string.next),
            onClick = { viewModel.onNextClick() },
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }
}
