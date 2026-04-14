@file:OptIn(ExperimentalMaterial3ExpressiveApi::class)

package org.michaelbel.listitem

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle

private val GreenLightColorScheme = lightColorScheme(
    primary = Color(0xFF386A20),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFB5F09A),
    onPrimaryContainer = Color(0xFF042100),
    secondary = Color(0xFF54624D),
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFFD7E8CD),
    onSecondaryContainer = Color(0xFF121F0E),
    tertiary = Color(0xFF386666),
    onTertiary = Color(0xFFFFFFFF),
    tertiaryContainer = Color(0xFFBBECEB),
    onTertiaryContainer = Color(0xFF002020),
    background = Color(0xFFF2F9F2),
    onBackground = Color(0xFF181D17),
    surface = Color(0xFFF2F9F2),
    onSurface = Color(0xFF181D17),
    surfaceVariant = Color(0xFFDEE4D8),
    onSurfaceVariant = Color(0xFF424940),
    outline = Color(0xFF727A6E),
    outlineVariant = Color(0xFFC2C9BD),
    inverseSurface = Color(0xFF2D322C),
    inverseOnSurface = Color(0xFFEFF1E9),
    inversePrimary = Color(0xFF9DD67E),
    surfaceTint = Color(0xFF386A20),
    surfaceBright = Color(0xFFF7FAF1),
    surfaceDim = Color(0xFFD8DAD2),
    surfaceContainer = Color(0xFFECF0E7),
    surfaceContainerHigh = Color(0xFFE7EAE1),
    surfaceContainerHighest = Color(0xFFE1E4DC),
    surfaceContainerLow = Color(0xFFF2F5EC),
    surfaceContainerLowest = Color(0xFFFFFFFF),
    primaryFixed = Color(0xFFB5F09A),
    primaryFixedDim = Color(0xFF9DD67E),
    onPrimaryFixed = Color(0xFF042100),
    onPrimaryFixedVariant = Color(0xFF1F5106),
    secondaryFixed = Color(0xFFD7E8CD),
    secondaryFixedDim = Color(0xFFBBCBB2),
    onSecondaryFixed = Color(0xFF121F0E),
    onSecondaryFixedVariant = Color(0xFF3C4A37),
    tertiaryFixed = Color(0xFFBBECEB),
    tertiaryFixedDim = Color(0xFFA0CFCF),
    onTertiaryFixed = Color(0xFF002020),
    onTertiaryFixedVariant = Color(0xFF1E4E4E)
)

private val GreenDarkColorScheme = darkColorScheme(
    primary = Color(0xFF9DD67E),
    onPrimary = Color(0xFF0A3900),
    primaryContainer = Color(0xFF1F5106),
    onPrimaryContainer = Color(0xFFB5F09A),
    secondary = Color(0xFFBBCBB2),
    onSecondary = Color(0xFF263420),
    secondaryContainer = Color(0xFF3C4A37),
    onSecondaryContainer = Color(0xFFD7E8CD),
    tertiary = Color(0xFFA0CFCF),
    onTertiary = Color(0xFF003737),
    tertiaryContainer = Color(0xFF1E4E4E),
    onTertiaryContainer = Color(0xFFBBECEB),
    background = Color(0xFF0F1A0E),
    onBackground = Color(0xFFDEE4D8),
    surface = Color(0xFF0F1A0E),
    onSurface = Color(0xFFDEE4D8),
    surfaceVariant = Color(0xFF424940),
    onSurfaceVariant = Color(0xFFC2C9BD),
    outline = Color(0xFF8C9388),
    outlineVariant = Color(0xFF424940),
    inverseSurface = Color(0xFFDEE4D8),
    inverseOnSurface = Color(0xFF2D322C),
    inversePrimary = Color(0xFF386A20),
    surfaceTint = Color(0xFF9DD67E),
    surfaceBright = Color(0xFF353B33),
    surfaceDim = Color(0xFF0F1A0E),
    surfaceContainer = Color(0xFF1C2119),
    surfaceContainerHigh = Color(0xFF262B24),
    surfaceContainerHighest = Color(0xFF31362E),
    surfaceContainerLow = Color(0xFF181D17),
    surfaceContainerLowest = Color(0xFF0A0F09),
    primaryFixed = Color(0xFFB5F09A),
    primaryFixedDim = Color(0xFF9DD67E),
    onPrimaryFixed = Color(0xFF042100),
    onPrimaryFixedVariant = Color(0xFF1F5106),
    secondaryFixed = Color(0xFFD7E8CD),
    secondaryFixedDim = Color(0xFFBBCBB2),
    onSecondaryFixed = Color(0xFF121F0E),
    onSecondaryFixedVariant = Color(0xFF3C4A37),
    tertiaryFixed = Color(0xFFBBECEB),
    tertiaryFixedDim = Color(0xFFA0CFCF),
    onTertiaryFixed = Color(0xFF002020),
    onTertiaryFixedVariant = Color(0xFF1E4E4E)
)

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    val dynamicColors by AppSettings.dynamicColorsFlow.collectAsStateWithLifecycle()

    val context = LocalContext.current
    val darkTheme = isSystemInDarkTheme()

    val colorScheme = when {
        dynamicColors && darkTheme -> dynamicDarkColorScheme(context)
        dynamicColors -> dynamicLightColorScheme(context)
        darkTheme -> GreenDarkColorScheme
        else -> GreenLightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}

val topListItemShape: RoundedCornerShape
    @Composable get() = RoundedCornerShape(
        topStart = MaterialTheme.shapes.largeIncreased.topStart,
        topEnd = MaterialTheme.shapes.largeIncreased.topEnd,
        bottomStart = MaterialTheme.shapes.extraSmall.bottomStart,
        bottomEnd = MaterialTheme.shapes.extraSmall.bottomStart
    )

val topLargeIncreasedListItemShape: RoundedCornerShape
    @Composable get() = RoundedCornerShape(
        topStart = MaterialTheme.shapes.largeIncreased.topStart,
        topEnd = MaterialTheme.shapes.largeIncreased.topEnd,
        bottomStart = CornerSize(0.dp),
        bottomEnd = CornerSize(0.dp)
    )

val middleExtraSmallListItemShape: RoundedCornerShape
    @Composable get() = RoundedCornerShape(
        topStart = MaterialTheme.shapes.extraSmall.topStart,
        topEnd = MaterialTheme.shapes.extraSmall.topEnd,
        bottomStart = MaterialTheme.shapes.extraSmall.bottomStart,
        bottomEnd = MaterialTheme.shapes.extraSmall.bottomEnd
    )

val middleLargeIncreasedListItemShape: RoundedCornerShape
    @Composable get() = RoundedCornerShape(
        topStart = MaterialTheme.shapes.largeIncreased.topStart,
        topEnd = MaterialTheme.shapes.largeIncreased.topEnd,
        bottomStart = MaterialTheme.shapes.largeIncreased.bottomStart,
        bottomEnd = MaterialTheme.shapes.largeIncreased.bottomEnd
    )

val bottomListItemShape: RoundedCornerShape
    @Composable get() = RoundedCornerShape(
        topStart = MaterialTheme.shapes.extraSmall.topStart,
        topEnd = MaterialTheme.shapes.extraSmall.topEnd,
        bottomStart = MaterialTheme.shapes.largeIncreased.bottomStart,
        bottomEnd = MaterialTheme.shapes.largeIncreased.bottomEnd
    )
