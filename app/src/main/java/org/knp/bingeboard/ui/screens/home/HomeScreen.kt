package org.knp.bingeboard.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Tv
import androidx.compose.material.icons.outlined.BookmarkAdd
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.ui.input.nestedscroll.nestedScroll
import org.knp.bingeboard.data.model.WatchlistDisplayItem
import org.knp.bingeboard.ui.components.AppHeader
import org.knp.bingeboard.ui.components.glassSurface
import org.knp.bingeboard.ui.theme.GradientPurple
import org.knp.bingeboard.ui.theme.LiquidGradientBrush
import org.knp.bingeboard.ui.theme.LocalThemeIsDark
import org.knp.bingeboard.ui.theme.Primary
import org.knp.bingeboard.ui.theme.StarYellow
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onShowClick: (Int, String) -> Unit = { _, _ -> },
    onSearchClick: () -> Unit = {}
) {
    // Reload watchlist every time this screen is shown
    LaunchedEffect(Unit) {
        viewModel.loadWatchlist()
    }
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val isDark = LocalThemeIsDark.current

    var isRefreshing by remember { mutableStateOf(false) }

    if (isRefreshing) {
        LaunchedEffect(true) {
            viewModel.syncWatchlist()
            isRefreshing = false
        }
    }

    val backgroundModifier = if (isDark) {
        Modifier.background(LiquidGradientBrush)
    } else {
        Modifier.background(MaterialTheme.colorScheme.background)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .then(backgroundModifier)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
        ) {
            AppHeader(onSearchClick = onSearchClick)
            Spacer(modifier = Modifier.height(8.dp))

            when {
                uiState.isLoading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(color = Primary)
                    }
                }
                uiState.watchlistItems.isEmpty() -> {
                    // Empty watchlist state
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.BookmarkAdd,
                                contentDescription = null,
                                modifier = Modifier.size(72.dp),
                                tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.3f)
                            )
                            Text(
                                text = "Your watchlist is empty",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Text(
                                text = "Search for shows and tap \"Add to List\"",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f)
                            )
                        }
                    }
                }
                else -> {
                    PullToRefreshBox(
                        isRefreshing = isRefreshing,
                        onRefresh = { isRefreshing = true },
                        modifier = Modifier.fillMaxSize()
                    ) {
                        LazyColumn(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.spacedBy(12.dp),
                            contentPadding = androidx.compose.foundation.layout.PaddingValues(
                                start = 16.dp, end = 16.dp, top = 4.dp, bottom = 100.dp
                            )
                        ) {
                            items(
                                items = uiState.watchlistItems,
                                key = { item -> "${item.source}_${item.mediaType}_${item.mediaId}" }
                            ) { item ->
                                WatchlistCard(
                                    item = item,
                                    onClick = {
                                        onShowClick(item.mediaId, item.source)
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

// ── Watchlist Card ──────────────────────────────────────────────

@Composable
private fun WatchlistCard(
    item: WatchlistDisplayItem,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .glassSurface(
                shape = RoundedCornerShape(16.dp),
                elevation = 4.dp
            )
            .clickable { onClick() }
            .padding(12.dp),
        horizontalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Poster
        AsyncImage(
            model = item.posterUrl,
            contentDescription = item.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(width = 80.dp, height = 115.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0xFF1A2133))
        )

        // Info column
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            // Title
            Text(
                text = item.name,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            // Type badge + rating
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Media type badge
                Row(
                    modifier = Modifier
                        .background(
                            Primary.copy(alpha = 0.1f),
                            RoundedCornerShape(4.dp)
                        )
                        .padding(horizontal = 6.dp, vertical = 2.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(3.dp)
                ) {
                    Icon(
                        imageVector = if (item.mediaType == "tv") Icons.Filled.Tv else Icons.Filled.Movie,
                        contentDescription = null,
                        tint = Primary,
                        modifier = Modifier.size(12.dp)
                    )
                    Text(
                        text = if (item.mediaType == "tv") "TV" else "Movie",
                        style = MaterialTheme.typography.labelSmall,
                        color = Primary,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                // Rating
                if (item.voteAverage > 0) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(3.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Star,
                            contentDescription = null,
                            tint = StarYellow,
                            modifier = Modifier.size(13.dp)
                        )
                        Text(
                            text = String.format("%.1f", item.voteAverage),
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }

            // Genres
            if (item.genres.isNotEmpty()) {
                Text(
                    text = item.genres,
                    style = MaterialTheme.typography.bodySmall,
                    color = GradientPurple,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            // Next episode details
            item.nextEpisodeLabel?.let { label ->
                Text(
                    text = "Next: $label",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            // Air date with relative label
            item.sortDate?.let { dateStr ->
                val relativeLabel = getRelativeDateLabel(dateStr)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.CalendarMonth,
                        contentDescription = null,
                        tint = Primary,
                        modifier = Modifier.size(13.dp)
                    )
                    Text(
                        text = if (relativeLabel != null) "$dateStr ($relativeLabel)" else dateStr,
                        style = MaterialTheme.typography.labelSmall,
                        color = if (relativeLabel == "Today") Color(0xFF22C55E)
                        else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            // Air time or Countdown
            val isToday = item.sortDate?.let { getRelativeDateLabel(it) } == "Today"
            if (isToday && item.airTimestamp != null) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Schedule,
                        contentDescription = null,
                        tint = Color(0xFF22C55E),
                        modifier = Modifier.size(13.dp)
                    )
                    CountdownTimer(targetTimestamp = item.airTimestamp)
                }
            } else if (item.airTimeDisplay != null) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Schedule,
                        contentDescription = null,
                        tint = GradientPurple,
                        modifier = Modifier.size(13.dp)
                    )
                    Text(
                        text = item.airTimeDisplay,
                        style = MaterialTheme.typography.labelSmall,
                        color = GradientPurple,
                        fontWeight = FontWeight.Medium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}

// ── Countdown Timer ─────────────────────────────────────────────

@Composable
fun CountdownTimer(targetTimestamp: Long) {
    var currentTime by remember { mutableLongStateOf(System.currentTimeMillis()) }

    LaunchedEffect(targetTimestamp) {
        while (true) {
            currentTime = System.currentTimeMillis()
            delay(1000L)
        }
    }

    val diff = targetTimestamp - currentTime
    val text = if (diff > 0) {
        val seconds = (diff / 1000) % 60
        val minutes = (diff / (1000 * 60)) % 60
        val hours = (diff / (1000 * 60 * 60))
        if (hours > 0) {
            "Airs in ${hours}h ${minutes}m"
        } else {
            "Airs in ${minutes}m ${seconds}s"
        }
    } else {
        "Aired today"
    }

    Text(
        text = text,
        style = MaterialTheme.typography.labelSmall,
        color = if (diff > 0) Color(0xFF22C55E) else MaterialTheme.colorScheme.onSurfaceVariant,
        fontWeight = FontWeight.Medium,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

// ── Helper ──────────────────────────────────────────────────────

private fun getRelativeDateLabel(dateStr: String): String? {
    return try {
        val date = LocalDate.parse(dateStr, DateTimeFormatter.ISO_LOCAL_DATE)
        val today = LocalDate.now()
        val days = ChronoUnit.DAYS.between(today, date)
        when {
            days == 0L -> "Today"
            days == 1L -> "Tomorrow"
            days == -1L -> "Yesterday"
            days in 2..7 -> "In $days days"
            days in -7..-2 -> "${-days} days ago"
            else -> null
        }
    } catch (e: Exception) {
        null
    }
}
