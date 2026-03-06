package org.knp.bingeboard.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Tv
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Tv
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import org.knp.bingeboard.ui.theme.LocalThemeIsDark
import org.knp.bingeboard.ui.theme.Primary

data class BottomNavItem(
    val label: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)

val bottomNavItems = listOf(
    BottomNavItem("Home", Icons.Filled.Home, Icons.Outlined.Home),
    BottomNavItem("TV", Icons.Filled.Tv, Icons.Outlined.Tv),
    BottomNavItem("Settings", Icons.Filled.Settings, Icons.Outlined.Settings)
)

/**
 * Floating glass bottom navigation bar.
 * Matches the CSS `.glass-pill` design with a glow effect on the selected item.
 */
@Composable
fun GlassBottomNav(
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .navigationBarsPadding()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = {} // Consume clicks in the padding around the pill
            ),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .glassPill(
                    shape = RoundedCornerShape(50),
                    elevation = 12.dp
                )
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val isDark = LocalThemeIsDark.current

            bottomNavItems.forEachIndexed { index, item ->
                val isSelected = index == selectedIndex
                
                val selectedColor = if (isDark) Color.White else Primary
                val unselectedColor = if (isDark) Color(0xFF94A3B8) else Color(0xFF64748B)

                val iconColor by animateColorAsState(
                    targetValue = if (isSelected) selectedColor else unselectedColor,
                    label = "navIconColor"
                )

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .weight(1f) // Distribute width evenly
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null
                        ) { onItemSelected(index) }
                        .padding(vertical = 14.dp) // Extend vertical touch target
                ) {
                    // Glow behind selected icon
                    if (isSelected) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .offset(y = (-2).dp)
                                .blur(12.dp)
                                .background(
                                    color = Primary.copy(alpha = 0.3f),
                                    shape = CircleShape
                                )
                        )
                    }

                    Icon(
                        imageVector = if (isSelected) item.selectedIcon else item.unselectedIcon,
                        contentDescription = item.label,
                        tint = iconColor,
                        modifier = Modifier.size(28.dp)
                    )

                    // Active dot indicator
                    if (isSelected) {
                        Box(
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .offset(y = 12.dp)
                                .size(4.dp)
                                .clip(CircleShape)
                                .background(selectedColor)
                        )
                    }
                }
            }
        }
    }
}
