package com.mkirilkinprojects.tracker_presentation.search.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.mkirilkinprojects.core_ui.LocalSpacing
import com.mkirilkinprojects.tracker_domain.model.TrackableFood
import com.mkirilkinprojects.tracker_presentation.R
import com.mkirilkinprojects.tracker_presentation.components.NutrientInfo
import com.mkirilkinprojects.tracker_presentation.search.TrackableFoodUiState

@Composable
fun TrackableFoodItem(
    trackableFoodsUiState: TrackableFoodUiState,
    onClick: () -> Unit,
    onAmountChange: (String) -> Unit,
    onTrack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val food = trackableFoodsUiState.food
    val spacing = LocalSpacing.current
    val context = LocalContext.current
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(5.dp))
            .padding(spacing.spaceExtraSmall)
            .shadow(
                elevation = 1.dp,
                shape = RoundedCornerShape(5.dp)
            )
            .background(MaterialTheme.colors.surface)
            .clickable { onClick() }
            .padding(end = spacing.spaceMedium)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = ImageRequest.Builder(context)
                            .data(food.imageUrl)
                            .crossfade(true)
                            .error(R.drawable.ic_burger)
                            .fallback(R.drawable.ic_burger)
                            .build()
                    ),
                    contentDescription = food.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(topStart = 5.dp))
                )
                Spacer(modifier = Modifier.width(spacing.spaceMedium))
                Column(
                    modifier = Modifier.align(Alignment.CenterVertically)
                ) {
                    Text(
                        text = food.name,
                        style = MaterialTheme.typography.body1,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.height(spacing.spaceSmall))
                    Text(
                        text = stringResource(
                            id = R.string.kcal_per_100g,
                            food.caloriesPer100g
                        ),
                        style = MaterialTheme.typography.body2
                    )
                }
            }
            Row(horizontalArrangement = Arrangement.spacedBy(spacing.spaceSmall)) {
                NutrientInfo(
                    name = stringResource(id = R.string.carbs),
                    amount = food.carbsPer100g,
                    unit = stringResource(id = R.string.grams),
                    amountTextSize = 16.sp,
                    unitTextSize = 12.sp,
                    nameTextStyle = MaterialTheme.typography.body2
                )
                NutrientInfo(
                    name = stringResource(id = R.string.protein),
                    amount = food.proteinPer100g,
                    unit = stringResource(id = R.string.grams),
                    amountTextSize = 16.sp,
                    unitTextSize = 12.sp,
                    nameTextStyle = MaterialTheme.typography.body2
                )
                NutrientInfo(
                    name = stringResource(id = R.string.fat),
                    amount = food.fatPer100g,
                    unit = stringResource(id = R.string.grams),
                    amountTextSize = 16.sp,
                    unitTextSize = 12.sp,
                    nameTextStyle = MaterialTheme.typography.body2
                )
            }
        }
        AnimatedVisibility(visible = trackableFoodsUiState.isExpanded) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(spacing.spaceMedium),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row {
                    BasicTextField(
                        value = trackableFoodsUiState.amount,
                        onValueChange = onAmountChange,
                        keyboardOptions = KeyboardOptions(
                            imeAction = if (trackableFoodsUiState.amount.isNotBlank()) {
                                ImeAction.Done
                            } else {
                                ImeAction.Default
                            },
                            keyboardType = KeyboardType.Number
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                onTrack()
                                defaultKeyboardAction(ImeAction.Done)
                            }
                        ),
                        singleLine = true,
                        modifier = Modifier
                            .border(
                                shape = RoundedCornerShape(5.dp),
                                width = 0.5.dp,
                                color = MaterialTheme.colors.onSurface
                            )
                            .alignBy(LastBaseline)
                            .padding(spacing.spaceMedium)
                            .semantics {
                                contentDescription = "Amount"
                            }
                    )
                    Spacer(modifier = Modifier.width(spacing.spaceExtraSmall))
                    Text(
                        text = stringResource(id = R.string.grams),
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.alignBy(LastBaseline)
                    )
                }
                IconButton(
                    onClick = onTrack,
                    enabled = trackableFoodsUiState.amount.isNotBlank()
                ) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = stringResource(id = R.string.track),
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun PreviewTrackableFoodItem() {
    TrackableFoodItem(
        trackableFoodsUiState = TrackableFoodUiState(
            food = TrackableFood(
                name = "asdljansdljasasdndjka",
                imageUrl = null,
                carbsPer100g = 201,
                caloriesPer100g = 200,
                proteinPer100g = 202,
                fatPer100g = 203
            )
        ),
        onClick = { /*TODO*/ },
        onAmountChange = { },
        onTrack = { /*TODO*/ })
}
