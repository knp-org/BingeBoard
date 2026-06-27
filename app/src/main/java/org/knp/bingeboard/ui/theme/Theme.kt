package org.knp.bingeboard.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = AccentWhite,
    onPrimary = Color.Black,
    background = DarkBackground,
    onBackground = DarkOnBackground,
    surface = DarkSurface,
    onSurface = DarkOnSurface,
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = DarkOnSurfaceVariant,
    outline = GlassDarkBorder,
    outlineVariant = GlassDarkBorder
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF1A1A1A),
    onPrimary = Color.White,
    background = LightBackground,
    onBackground = LightOnBackground,
    surface = LightSurface,
    onSurface = LightOnSurface,
    surfaceVariant = LightSurfaceVariant,
    onSurfaceVariant = LightOnSurfaceVariant,
    outline = GlassLightBorder,
    outlineVariant = GlassLightBorder
)

val LocalThemeIsDark = compositionLocalOf { false }

@Composable
fun BingeBoardTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    themeMode: org.knp.bingeboard.data.repository.ThemeMode = org.knp.bingeboard.data.repository.ThemeMode.SYSTEM_DEFAULT,
    content: @Composable () -> Unit
) {
    val isAppInDarkTheme = when (themeMode) {
        org.knp.bingeboard.data.repository.ThemeMode.LIGHT -> false
        org.knp.bingeboard.data.repository.ThemeMode.DARK -> true
        org.knp.bingeboard.data.repository.ThemeMode.SYSTEM_DEFAULT -> darkTheme
    }

    val colorScheme = if (isAppInDarkTheme) DarkColorScheme else LightColorScheme

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            @Suppress("DEPRECATION")
            window.statusBarColor = Color.Transparent.toArgb()
            @Suppress("DEPRECATION")
            window.navigationBarColor = Color.Transparent.toArgb()
            WindowCompat.getInsetsController(window, view).apply {
                isAppearanceLightStatusBars = !isAppInDarkTheme
                isAppearanceLightNavigationBars = !isAppInDarkTheme
            }
        }
    }

    CompositionLocalProvider(LocalThemeIsDark provides isAppInDarkTheme) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = BingeBoardTypography,
            content = content
        )
    }
}
