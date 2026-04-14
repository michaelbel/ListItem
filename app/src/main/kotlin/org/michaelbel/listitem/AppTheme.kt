@file:OptIn(ExperimentalMaterial3ExpressiveApi::class)

package org.michaelbel.listitem

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.materialPath
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
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

private var _github: ImageVector? = null
val Github: ImageVector
    get() {
        if (_github != null) {
            return _github!!
        }
        _github = ImageVector.Builder(
            name = "Github",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(12f, 2f)
                arcTo(10f, 10f, 0f, isMoreThanHalf = false, isPositiveArc = false, 2f, 12f)
                curveTo(2f, 16.42f, 4.87f, 20.17f, 8.84f, 21.5f)
                curveTo(9.34f, 21.58f, 9.5f, 21.27f, 9.5f, 21f)
                curveTo(9.5f, 20.77f, 9.5f, 20.14f, 9.5f, 19.31f)
                curveTo(6.73f, 19.91f, 6.14f, 17.97f, 6.14f, 17.97f)
                curveTo(5.68f, 16.81f, 5.03f, 16.5f, 5.03f, 16.5f)
                curveTo(4.12f, 15.88f, 5.1f, 15.9f, 5.1f, 15.9f)
                curveTo(6.1f, 15.97f, 6.63f, 16.93f, 6.63f, 16.93f)
                curveTo(7.5f, 18.45f, 8.97f, 18f, 9.54f, 17.76f)
                curveTo(9.63f, 17.11f, 9.89f, 16.67f, 10.17f, 16.42f)
                curveTo(7.95f, 16.17f, 5.62f, 15.31f, 5.62f, 11.5f)
                curveTo(5.62f, 10.39f, 6f, 9.5f, 6.65f, 8.79f)
                curveTo(6.55f, 8.54f, 6.2f, 7.5f, 6.75f, 6.15f)
                curveTo(6.75f, 6.15f, 7.59f, 5.88f, 9.5f, 7.17f)
                curveTo(10.29f, 6.95f, 11.15f, 6.84f, 12f, 6.84f)
                curveTo(12.85f, 6.84f, 13.71f, 6.95f, 14.5f, 7.17f)
                curveTo(16.41f, 5.88f, 17.25f, 6.15f, 17.25f, 6.15f)
                curveTo(17.8f, 7.5f, 17.45f, 8.54f, 17.35f, 8.79f)
                curveTo(18f, 9.5f, 18.38f, 10.39f, 18.38f, 11.5f)
                curveTo(18.38f, 15.32f, 16.04f, 16.16f, 13.81f, 16.41f)
                curveTo(14.17f, 16.72f, 14.5f, 17.33f, 14.5f, 18.26f)
                curveTo(14.5f, 19.6f, 14.5f, 20.68f, 14.5f, 21f)
                curveTo(14.5f, 21.27f, 14.66f, 21.59f, 15.17f, 21.5f)
                curveTo(19.14f, 20.16f, 22f, 16.42f, 22f, 12f)
                arcTo(10f, 10f, 0f, isMoreThanHalf = false, isPositiveArc = false, 12f, 2f)
                close()
            }
        }.build()
        return _github!!
    }

private var _telegram: ImageVector? = null
val Telegram: ImageVector
    get() {
        if (_telegram != null) {
            return _telegram!!
        }

        _telegram = ImageVector.Builder(
            name = "tg",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = SolidColor(Color(0xFFFFFFFF)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(1.64987f, 10.6099f)
                curveTo(8.09231f, 7.78741f, 12.3883f, 5.92667f, 14.5378f, 5.02765f)
                curveTo(20.675f, 2.46077f, 21.9503f, 2.01488f, 22.7815f, 2.00016f)
                curveTo(22.9643f, 1.99692f, 23.3731f, 2.04248f, 23.6379f, 2.25852f)
                curveTo(23.8614f, 2.44094f, 23.9229f, 2.68737f, 23.9524f, 2.86033f)
                curveTo(23.9818f, 3.03328f, 24.0185f, 3.42728f, 23.9893f, 3.73514f)
                curveTo(23.6568f, 7.249f, 22.2177f, 15.7762f, 21.4856f, 19.7118f)
                curveTo(21.1758f, 21.3771f, 20.5658f, 21.9354f, 19.9753f, 21.9901f)
                curveTo(18.6919f, 22.1088f, 17.7174f, 21.1372f, 16.4744f, 20.3179f)
                curveTo(14.5294f, 19.0358f, 13.4305f, 18.2377f, 11.5425f, 16.9867f)
                curveTo(9.36064f, 15.5408f, 10.7751f, 14.7462f, 12.0185f, 13.4475f)
                curveTo(12.344f, 13.1076f, 17.9985f, 7.93584f, 18.1079f, 7.46668f)
                curveTo(18.1216f, 7.40801f, 18.1343f, 7.18929f, 18.0051f, 7.0738f)
                curveTo(17.8759f, 6.95831f, 17.6851f, 6.9978f, 17.5475f, 7.02921f)
                curveTo(17.3524f, 7.07373f, 14.2452f, 9.1389f, 8.22584f, 13.2247f)
                curveTo(7.34386f, 13.8337f, 6.545f, 14.1304f, 5.82924f, 14.1149f)
                curveTo(5.04018f, 14.0977f, 3.52233f, 13.6663f, 2.39397f, 13.2974f)
                curveTo(1.00999f, 12.8451f, -0.0899676f, 12.6059f, 0.00581422f, 11.8376f)
                curveTo(0.0557033f, 11.4374f, 0.603723f, 11.0282f, 1.64987f, 10.6099f)
                close()
            }
        }.build()

        return _telegram!!
    }

private var _formatPaint: ImageVector? = null
val FormatPaint: ImageVector
    get() {
        if (_formatPaint != null) {
            return _formatPaint!!
        }
        _formatPaint = materialIcon(name = "Outlined.FormatPaint") {
            materialPath {
                moveTo(18.0f, 4.0f)
                lineTo(18.0f, 3.0f)
                curveToRelative(0.0f, -0.55f, -0.45f, -1.0f, -1.0f, -1.0f)
                lineTo(5.0f, 2.0f)
                curveToRelative(-0.55f, 0.0f, -1.0f, 0.45f, -1.0f, 1.0f)
                verticalLineToRelative(4.0f)
                curveToRelative(0.0f, 0.55f, 0.45f, 1.0f, 1.0f, 1.0f)
                horizontalLineToRelative(12.0f)
                curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f)
                lineTo(18.0f, 6.0f)
                horizontalLineToRelative(1.0f)
                verticalLineToRelative(4.0f)
                lineTo(9.0f, 10.0f)
                verticalLineToRelative(11.0f)
                curveToRelative(0.0f, 0.55f, 0.45f, 1.0f, 1.0f, 1.0f)
                horizontalLineToRelative(2.0f)
                curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f)
                verticalLineToRelative(-9.0f)
                horizontalLineToRelative(8.0f)
                lineTo(21.0f, 4.0f)
                horizontalLineToRelative(-3.0f)
                close()
                moveTo(16.0f, 6.0f)
                lineTo(6.0f, 6.0f)
                lineTo(6.0f, 4.0f)
                horizontalLineToRelative(10.0f)
                verticalLineToRelative(2.0f)
                close()
            }
        }
        return _formatPaint!!
    }

private var _formatAlignCenter: ImageVector? = null
val FormatAlignCenter: ImageVector
    get() {
        if (_formatAlignCenter != null) {
            return _formatAlignCenter!!
        }
        _formatAlignCenter = materialIcon(name = "Outlined.FormatAlignCenter") {
            materialPath {
                moveTo(7.0f, 15.0f)
                verticalLineToRelative(2.0f)
                horizontalLineToRelative(10.0f)
                verticalLineToRelative(-2.0f)
                lineTo(7.0f, 15.0f)
                close()
                moveTo(3.0f, 21.0f)
                horizontalLineToRelative(18.0f)
                verticalLineToRelative(-2.0f)
                lineTo(3.0f, 19.0f)
                verticalLineToRelative(2.0f)
                close()
                moveTo(3.0f, 13.0f)
                horizontalLineToRelative(18.0f)
                verticalLineToRelative(-2.0f)
                lineTo(3.0f, 11.0f)
                verticalLineToRelative(2.0f)
                close()
                moveTo(7.0f, 7.0f)
                verticalLineToRelative(2.0f)
                horizontalLineToRelative(10.0f)
                lineTo(17.0f, 7.0f)
                lineTo(7.0f, 7.0f)
                close()
                moveTo(3.0f, 3.0f)
                verticalLineToRelative(2.0f)
                horizontalLineToRelative(18.0f)
                lineTo(21.0f, 3.0f)
                lineTo(3.0f, 3.0f)
                close()
            }
        }
        return _formatAlignCenter!!
    }

private var _splitscreen: ImageVector? = null
val Splitscreen: ImageVector
    get() {
        if (_splitscreen != null) {
            return _splitscreen!!
        }
        _splitscreen = materialIcon(name = "Outlined.Splitscreen") {
            materialPath {
                moveTo(18.0f, 4.0f)
                verticalLineToRelative(5.0f)
                horizontalLineTo(6.0f)
                verticalLineTo(4.0f)
                horizontalLineTo(18.0f)
                moveTo(18.0f, 2.0f)
                horizontalLineTo(6.0f)
                curveTo(4.9f, 2.0f, 4.0f, 2.9f, 4.0f, 4.0f)
                verticalLineToRelative(5.0f)
                curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f)
                horizontalLineToRelative(12.0f)
                curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f)
                verticalLineTo(4.0f)
                curveTo(20.0f, 2.9f, 19.1f, 2.0f, 18.0f, 2.0f)
                close()
                moveTo(18.0f, 15.0f)
                verticalLineToRelative(5.0f)
                horizontalLineTo(6.0f)
                verticalLineToRelative(-5.0f)
                horizontalLineTo(18.0f)
                moveTo(18.0f, 13.0f)
                horizontalLineTo(6.0f)
                curveToRelative(-1.1f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f)
                verticalLineToRelative(5.0f)
                curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f)
                horizontalLineToRelative(12.0f)
                curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f)
                verticalLineToRelative(-5.0f)
                curveTo(20.0f, 13.9f, 19.1f, 13.0f, 18.0f, 13.0f)
                close()
            }
        }
        return _splitscreen!!
    }

private var _verticalAlignTop: ImageVector? = null
val VerticalAlignTop: ImageVector
    get() {
        if (_verticalAlignTop != null) {
            return _verticalAlignTop!!
        }
        _verticalAlignTop = materialIcon(name = "Outlined.VerticalAlignTop") {
            materialPath {
                moveTo(8.0f, 11.0f)
                horizontalLineToRelative(3.0f)
                verticalLineToRelative(10.0f)
                horizontalLineToRelative(2.0f)
                verticalLineTo(11.0f)
                horizontalLineToRelative(3.0f)
                lineToRelative(-4.0f, -4.0f)
                lineToRelative(-4.0f, 4.0f)
                close()
                moveTo(4.0f, 3.0f)
                verticalLineToRelative(2.0f)
                horizontalLineToRelative(16.0f)
                verticalLineTo(3.0f)
                horizontalLineTo(4.0f)
                close()
            }
        }
        return _verticalAlignTop!!
    }

private var _verticalAlignCenter: ImageVector? = null
val VerticalAlignCenter: ImageVector
    get() {
        if (_verticalAlignCenter != null) {
            return _verticalAlignCenter!!
        }
        _verticalAlignCenter = materialIcon(name = "Outlined.VerticalAlignCenter") {
            materialPath {
                moveTo(8.0f, 19.0f)
                horizontalLineToRelative(3.0f)
                verticalLineToRelative(4.0f)
                horizontalLineToRelative(2.0f)
                verticalLineToRelative(-4.0f)
                horizontalLineToRelative(3.0f)
                lineToRelative(-4.0f, -4.0f)
                lineToRelative(-4.0f, 4.0f)
                close()
                moveTo(16.0f, 5.0f)
                horizontalLineToRelative(-3.0f)
                lineTo(13.0f, 1.0f)
                horizontalLineToRelative(-2.0f)
                verticalLineToRelative(4.0f)
                lineTo(8.0f, 5.0f)
                lineToRelative(4.0f, 4.0f)
                lineToRelative(4.0f, -4.0f)
                close()
                moveTo(4.0f, 11.0f)
                verticalLineToRelative(2.0f)
                horizontalLineToRelative(16.0f)
                verticalLineToRelative(-2.0f)
                lineTo(4.0f, 11.0f)
                close()
            }
        }
        return _verticalAlignCenter!!
    }

private var _verticalAlignBottom: ImageVector? = null
val VerticalAlignBottom: ImageVector
    get() {
        if (_verticalAlignBottom != null) {
            return _verticalAlignBottom!!
        }
        _verticalAlignBottom = materialIcon(name = "Outlined.VerticalAlignBottom") {
            materialPath {
                moveTo(16.0f, 13.0f)
                horizontalLineToRelative(-3.0f)
                verticalLineTo(3.0f)
                horizontalLineToRelative(-2.0f)
                verticalLineToRelative(10.0f)
                horizontalLineTo(8.0f)
                lineToRelative(4.0f, 4.0f)
                lineToRelative(4.0f, -4.0f)
                close()
                moveTo(4.0f, 19.0f)
                verticalLineToRelative(2.0f)
                horizontalLineToRelative(16.0f)
                verticalLineToRelative(-2.0f)
                horizontalLineTo(4.0f)
                close()
            }
        }
        return _verticalAlignBottom!!
    }

private var _palette: ImageVector? = null
val Palette: ImageVector
    get() {
        if (_palette != null) {
            return _palette!!
        }
        _palette = materialIcon(name = "Outlined.Palette") {
            materialPath {
                moveTo(12.0f, 22.0f)
                curveTo(6.49f, 22.0f, 2.0f, 17.51f, 2.0f, 12.0f)
                reflectiveCurveTo(6.49f, 2.0f, 12.0f, 2.0f)
                reflectiveCurveToRelative(10.0f, 4.04f, 10.0f, 9.0f)
                curveToRelative(0.0f, 3.31f, -2.69f, 6.0f, -6.0f, 6.0f)
                horizontalLineToRelative(-1.77f)
                curveToRelative(-0.28f, 0.0f, -0.5f, 0.22f, -0.5f, 0.5f)
                curveToRelative(0.0f, 0.12f, 0.05f, 0.23f, 0.13f, 0.33f)
                curveToRelative(0.41f, 0.47f, 0.64f, 1.06f, 0.64f, 1.67f)
                curveTo(14.5f, 20.88f, 13.38f, 22.0f, 12.0f, 22.0f)
                close()
                moveTo(12.0f, 4.0f)
                curveToRelative(-4.41f, 0.0f, -8.0f, 3.59f, -8.0f, 8.0f)
                reflectiveCurveToRelative(3.59f, 8.0f, 8.0f, 8.0f)
                curveToRelative(0.28f, 0.0f, 0.5f, -0.22f, 0.5f, -0.5f)
                curveToRelative(0.0f, -0.16f, -0.08f, -0.28f, -0.14f, -0.35f)
                curveToRelative(-0.41f, -0.46f, -0.63f, -1.05f, -0.63f, -1.65f)
                curveToRelative(0.0f, -1.38f, 1.12f, -2.5f, 2.5f, -2.5f)
                horizontalLineTo(16.0f)
                curveToRelative(2.21f, 0.0f, 4.0f, -1.79f, 4.0f, -4.0f)
                curveTo(20.0f, 7.14f, 16.41f, 4.0f, 12.0f, 4.0f)
                close()
            }
            materialPath {
                moveTo(6.5f, 11.5f)
                moveToRelative(-1.5f, 0.0f)
                arcToRelative(1.5f, 1.5f, 0.0f, true, true, 3.0f, 0.0f)
                arcToRelative(1.5f, 1.5f, 0.0f, true, true, -3.0f, 0.0f)
            }
            materialPath {
                moveTo(9.5f, 7.5f)
                moveToRelative(-1.5f, 0.0f)
                arcToRelative(1.5f, 1.5f, 0.0f, true, true, 3.0f, 0.0f)
                arcToRelative(1.5f, 1.5f, 0.0f, true, true, -3.0f, 0.0f)
            }
            materialPath {
                moveTo(14.5f, 7.5f)
                moveToRelative(-1.5f, 0.0f)
                arcToRelative(1.5f, 1.5f, 0.0f, true, true, 3.0f, 0.0f)
                arcToRelative(1.5f, 1.5f, 0.0f, true, true, -3.0f, 0.0f)
            }
            materialPath {
                moveTo(17.5f, 11.5f)
                moveToRelative(-1.5f, 0.0f)
                arcToRelative(1.5f, 1.5f, 0.0f, true, true, 3.0f, 0.0f)
                arcToRelative(1.5f, 1.5f, 0.0f, true, true, -3.0f, 0.0f)
            }
        }
        return _palette!!
    }

private var _menuOpen: ImageVector? = null
val MenuOpen: ImageVector
    get() {
        if (_menuOpen != null) {
            return _menuOpen!!
        }
        _menuOpen = materialIcon(name = "AutoMirrored.Filled.MenuOpen", autoMirror = true) {
            materialPath {
                moveTo(3.0f, 18.0f)
                horizontalLineToRelative(13.0f)
                verticalLineToRelative(-2.0f)
                lineTo(3.0f, 16.0f)
                verticalLineToRelative(2.0f)
                close()
                moveTo(3.0f, 13.0f)
                horizontalLineToRelative(10.0f)
                verticalLineToRelative(-2.0f)
                lineTo(3.0f, 11.0f)
                verticalLineToRelative(2.0f)
                close()
                moveTo(3.0f, 6.0f)
                verticalLineToRelative(2.0f)
                horizontalLineToRelative(13.0f)
                lineTo(16.0f, 6.0f)
                lineTo(3.0f, 6.0f)
                close()
                moveTo(21.0f, 15.59f)
                lineTo(17.42f, 12.0f)
                lineTo(21.0f, 8.41f)
                lineTo(19.59f, 7.0f)
                lineToRelative(-5.0f, 5.0f)
                lineToRelative(5.0f, 5.0f)
                lineTo(21.0f, 15.59f)
                close()
            }
        }
        return _menuOpen!!
    }

private var _formatAlignLeft: ImageVector? = null
val FormatAlignLeft: ImageVector
    get() {
        if (_formatAlignLeft != null) {
            return _formatAlignLeft!!
        }
        _formatAlignLeft = materialIcon(name = "AutoMirrored.Outlined.FormatAlignLeft", autoMirror = true) {
            materialPath {
                moveTo(15.0f, 15.0f)
                lineTo(3.0f, 15.0f)
                verticalLineToRelative(2.0f)
                horizontalLineToRelative(12.0f)
                verticalLineToRelative(-2.0f)
                close()
                moveTo(15.0f, 7.0f)
                lineTo(3.0f, 7.0f)
                verticalLineToRelative(2.0f)
                horizontalLineToRelative(12.0f)
                lineTo(15.0f, 7.0f)
                close()
                moveTo(3.0f, 13.0f)
                horizontalLineToRelative(18.0f)
                verticalLineToRelative(-2.0f)
                lineTo(3.0f, 11.0f)
                verticalLineToRelative(2.0f)
                close()
                moveTo(3.0f, 21.0f)
                horizontalLineToRelative(18.0f)
                verticalLineToRelative(-2.0f)
                lineTo(3.0f, 19.0f)
                verticalLineToRelative(2.0f)
                close()
                moveTo(3.0f, 3.0f)
                verticalLineToRelative(2.0f)
                horizontalLineToRelative(18.0f)
                lineTo(21.0f, 3.0f)
                lineTo(3.0f, 3.0f)
                close()
            }
        }
        return _formatAlignLeft!!
    }

private var _formatAlignRight: ImageVector? = null
val FormatAlignRight: ImageVector
    get() {
        if (_formatAlignRight != null) {
            return _formatAlignRight!!
        }
        _formatAlignRight = materialIcon(name = "AutoMirrored.Outlined.FormatAlignRight", autoMirror = true) {
            materialPath {
                moveTo(3.0f, 21.0f)
                horizontalLineToRelative(18.0f)
                verticalLineToRelative(-2.0f)
                lineTo(3.0f, 19.0f)
                verticalLineToRelative(2.0f)
                close()
                moveTo(9.0f, 17.0f)
                horizontalLineToRelative(12.0f)
                verticalLineToRelative(-2.0f)
                lineTo(9.0f, 15.0f)
                verticalLineToRelative(2.0f)
                close()
                moveTo(3.0f, 13.0f)
                horizontalLineToRelative(18.0f)
                verticalLineToRelative(-2.0f)
                lineTo(3.0f, 11.0f)
                verticalLineToRelative(2.0f)
                close()
                moveTo(9.0f, 9.0f)
                horizontalLineToRelative(12.0f)
                lineTo(21.0f, 7.0f)
                lineTo(9.0f, 7.0f)
                verticalLineToRelative(2.0f)
                close()
                moveTo(3.0f, 3.0f)
                verticalLineToRelative(2.0f)
                horizontalLineToRelative(18.0f)
                lineTo(21.0f, 3.0f)
                lineTo(3.0f, 3.0f)
                close()
            }
        }
        return _formatAlignRight!!
    }
