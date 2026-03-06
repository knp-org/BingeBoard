package org.knp.bingeboard.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.knp.bingeboard.R
import org.knp.bingeboard.ui.theme.GradientBlue
import org.knp.bingeboard.ui.theme.GradientPurple
import org.knp.bingeboard.ui.theme.Primary

/**
 * Reusable app header with a gradient title and optional action icons.
 *
 * @param title The title text displayed in gradient style.
 * @param showActions When true, displays search and notification action icons.
 */
@OptIn(ExperimentalTextApi::class)
@Composable
fun AppHeader(
    title: String = "BingeBoard",
    showActions: Boolean = true,
    onSearchClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(top = 12.dp, bottom = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // App Logo and Gradient title
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "App Logo",
                    modifier = Modifier
                        .size(44.dp)
                        .padding(end = 6.dp)
                )
                Text(
                    text = title,
                    style = TextStyle(
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        brush = Brush.horizontalGradient(
                            colors = listOf(GradientBlue, GradientPurple)
                        )
                    )
                )
            }

            if (showActions) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Search button
                    IconButton(
                        onClick = onSearchClick,
                        modifier = Modifier
                            .size(44.dp)
                            .glassPill(shape = CircleShape, elevation = 4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Search,
                            contentDescription = "Search",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }

                    // Notification button
                    Box {
                        IconButton(
                            onClick = { /* TODO: Notifications */ },
                            modifier = Modifier
                                .size(44.dp)
                                .glassPill(shape = CircleShape, elevation = 4.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Notifications,
                                contentDescription = "Notifications",
                                tint = MaterialTheme.colorScheme.onSurface
                            )
                        }
                        // Blue notification dot
                        Box(
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .offset(x = (-4).dp, y = 4.dp)
                                .size(8.dp)
                                .clip(CircleShape)
                                .background(Primary)
                        )
                    }
                }
            }
        }
    }
}
