package org.knp.bingeboard.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.knp.bingeboard.ui.theme.GlassDarkBg
import org.knp.bingeboard.ui.theme.GlassDarkBorder
import org.knp.bingeboard.ui.theme.GlassLightBg
import org.knp.bingeboard.ui.theme.GlassLightBorder
import org.knp.bingeboard.ui.theme.LocalThemeIsDark

/**
 * Glass panel modifier — semi-transparent surface with border and shadow.
 * Mimics the CSS `.glass-panel` effect from the design.
 */
@Composable
fun Modifier.glassSurface(
    shape: Shape = RoundedCornerShape(16.dp),
    elevation: Dp = 8.dp
): Modifier {
    val isDark = LocalThemeIsDark.current
    val bgColor = if (isDark) GlassDarkBg else GlassLightBg
    val borderColor = if (isDark) GlassDarkBorder else GlassLightBorder
    val shadowColor = if (isDark) Color.Black.copy(alpha = 0.3f) else Color.Black.copy(alpha = 0.08f)

    return this
        .shadow(
            elevation = elevation,
            shape = shape,
            ambientColor = shadowColor,
            spotColor = shadowColor,
            clip = false
        )
        .clip(shape)
        .background(bgColor, shape)
        .border(width = 1.dp, color = borderColor, shape = shape)
}

/**
 * Glass pill modifier — gradient glass surface for the bottom nav and buttons.
 * Mimics the CSS `.glass-pill` effect from the design.
 */
@Composable
fun Modifier.glassPill(
    shape: Shape = RoundedCornerShape(50),
    elevation: Dp = 8.dp
): Modifier {
    val isDark = LocalThemeIsDark.current
    val borderColor = if (isDark) Color.White.copy(alpha = 0.15f) else Color.Black.copy(alpha = 0.06f)
    val shadowColor = if (isDark) Color.Black.copy(alpha = 0.3f) else Color.Black.copy(alpha = 0.08f)
    val gradientBrush = if (isDark) {
        Brush.linearGradient(
            colors = listOf(Color.White.copy(alpha = 0.1f), Color.White.copy(alpha = 0f))
        )
    } else {
        Brush.linearGradient(
            colors = listOf(Color.White.copy(alpha = 0.85f), Color.White.copy(alpha = 0.6f))
        )
    }

    return this
        .shadow(
            elevation = elevation,
            shape = shape,
            ambientColor = shadowColor,
            spotColor = shadowColor,
            clip = false
        )
        .clip(shape)
        .background(gradientBrush, shape)
        .border(width = 1.dp, color = borderColor, shape = shape)
}
