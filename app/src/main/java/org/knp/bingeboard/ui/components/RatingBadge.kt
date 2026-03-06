package org.knp.bingeboard.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.knp.bingeboard.ui.theme.StarYellow

@Composable
fun RatingBadge(
    rating: Double,
    modifier: Modifier = Modifier,
    starColor: Color = StarYellow,
    textColor: Color = Color.LightGray
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Star,
            contentDescription = "Rating",
            tint = starColor,
            modifier = Modifier.size(14.dp)
        )
        Text(
            text = String.format("%.1f", rating),
            style = MaterialTheme.typography.labelSmall,
            color = textColor
        )
    }
}
