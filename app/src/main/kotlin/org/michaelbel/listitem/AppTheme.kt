@file:OptIn(ExperimentalMaterial3ExpressiveApi::class)

package org.michaelbel.listitem

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

private val BlueLightColorScheme = lightColorScheme(
    primary = Color(0xFF1558A8),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFBDD8FF),
    onPrimaryContainer = Color(0xFF001A3D),
    secondary = Color(0xFF3A5F99),
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFFBDD4FF),
    onSecondaryContainer = Color(0xFF001A3D),
    tertiary = Color(0xFF0B6E9E),
    onTertiary = Color(0xFFFFFFFF),
    tertiaryContainer = Color(0xFFB8E4FF),
    onTertiaryContainer = Color(0xFF001E30),
    background = Color(0xFFE8F0FF),
    onBackground = Color(0xFF101826),
    surface = Color(0xFFE8F0FF),
    onSurface = Color(0xFF101826),
    surfaceVariant = Color(0xFFCDD8F5),
    onSurfaceVariant = Color(0xFF2A3550),
    outline = Color(0xFF5E6E92),
    outlineVariant = Color(0xFFADBCD8),
    inverseSurface = Color(0xFF1E2A40),
    inverseOnSurface = Color(0xFFE8F0FF),
    inversePrimary = Color(0xFF9ECAFF),
    surfaceTint = Color(0xFF1558A8),
    surfaceBright = Color(0xFFF0F5FF),
    surfaceDim = Color(0xFFC8D5EE),
    surfaceContainer = Color(0xFFD8E4F8),
    surfaceContainerHigh = Color(0xFFD0DCF5),
    surfaceContainerHighest = Color(0xFFC8D4F0),
    surfaceContainerLow = Color(0xFFE0EAFF),
    surfaceContainerLowest = Color(0xFFEEF4FF),
    primaryFixed = Color(0xFFBDD8FF),
    primaryFixedDim = Color(0xFF8EC0FF),
    onPrimaryFixed = Color(0xFF001A3D),
    onPrimaryFixedVariant = Color(0xFF003A80),
    secondaryFixed = Color(0xFFBDD4FF),
    secondaryFixedDim = Color(0xFF8BB5F5),
    onSecondaryFixed = Color(0xFF001A3D),
    onSecondaryFixedVariant = Color(0xFF1E3F75),
    tertiaryFixed = Color(0xFFB8E4FF),
    tertiaryFixedDim = Color(0xFF7ECEF5),
    onTertiaryFixed = Color(0xFF001E30),
    onTertiaryFixedVariant = Color(0xFF004C70)
)

private val BlueDarkColorScheme = darkColorScheme(
    primary = Color(0xFF8EC0FF),
    onPrimary = Color(0xFF002A60),
    primaryContainer = Color(0xFF003A80),
    onPrimaryContainer = Color(0xFFBDD8FF),
    secondary = Color(0xFF8BB5F5),
    onSecondary = Color(0xFF0D2550),
    secondaryContainer = Color(0xFF1E3F75),
    onSecondaryContainer = Color(0xFFBDD4FF),
    tertiary = Color(0xFF7ECEF5),
    onTertiary = Color(0xFF003550),
    tertiaryContainer = Color(0xFF004C70),
    onTertiaryContainer = Color(0xFFB8E4FF),
    background = Color(0xFF091524),
    onBackground = Color(0xFFD0DFFF),
    surface = Color(0xFF091524),
    onSurface = Color(0xFFD0DFFF),
    surfaceVariant = Color(0xFF1E2E48),
    onSurfaceVariant = Color(0xFFADC4E8),
    outline = Color(0xFF5E80B0),
    outlineVariant = Color(0xFF1E2E48),
    inverseSurface = Color(0xFFD0DFFF),
    inverseOnSurface = Color(0xFF1E2A40),
    inversePrimary = Color(0xFF1558A8),
    surfaceTint = Color(0xFF8EC0FF),
    surfaceBright = Color(0xFF1A2A40),
    surfaceDim = Color(0xFF091524),
    surfaceContainer = Color(0xFF101E30),
    surfaceContainerHigh = Color(0xFF182638),
    surfaceContainerHighest = Color(0xFF203040),
    surfaceContainerLow = Color(0xFF0E1A2A),
    surfaceContainerLowest = Color(0xFF05101C),
    primaryFixed = Color(0xFFBDD8FF),
    primaryFixedDim = Color(0xFF8EC0FF),
    onPrimaryFixed = Color(0xFF001A3D),
    onPrimaryFixedVariant = Color(0xFF003A80),
    secondaryFixed = Color(0xFFBDD4FF),
    secondaryFixedDim = Color(0xFF8BB5F5),
    onSecondaryFixed = Color(0xFF001A3D),
    onSecondaryFixedVariant = Color(0xFF1E3F75),
    tertiaryFixed = Color(0xFFB8E4FF),
    tertiaryFixedDim = Color(0xFF7ECEF5),
    onTertiaryFixed = Color(0xFF001E30),
    onTertiaryFixedVariant = Color(0xFF004C70)
)

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = if (isSystemInDarkTheme()) BlueDarkColorScheme else BlueLightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}

@Composable
fun SectionLabel(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.labelMedium,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 20.dp, bottom = 4.dp)
    )
}
