package org.knp.bingeboard.ui.screens.settings

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.Language
import androidx.compose.material.icons.outlined.LightMode
import androidx.compose.material.icons.outlined.Public
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material.icons.outlined.SettingsBrightness
import androidx.compose.material.icons.outlined.VpnKey
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.knp.bingeboard.data.model.LocaleOption
import org.knp.bingeboard.data.repository.ThemeMode
import org.knp.bingeboard.ui.components.AppHeader
import org.knp.bingeboard.ui.components.glassSurface
import org.knp.bingeboard.ui.theme.LiquidGradientBrush
import org.knp.bingeboard.ui.theme.LocalThemeIsDark
import org.knp.bingeboard.ui.theme.Primary

// ── Settings Screen ─────────────────────────────────────────────

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel = hiltViewModel()
) {
    val themeMode by viewModel.themeMode.collectAsStateWithLifecycle()
    val region by viewModel.region.collectAsStateWithLifecycle()
    val language by viewModel.language.collectAsStateWithLifecycle()
    val timezone by viewModel.timezone.collectAsStateWithLifecycle()
    val tvdbApiKey by viewModel.tvdbApiKey.collectAsStateWithLifecycle()
    val useTvdb by viewModel.useTvdb.collectAsStateWithLifecycle()

    // Locale options loaded from JSON assets
    val regionOptions = viewModel.localeOptionsProvider.regions
    val languageOptions = viewModel.localeOptionsProvider.languages
    val timezoneOptions = viewModel.localeOptionsProvider.timezones

    val isDark = LocalThemeIsDark.current
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
                .verticalScroll(rememberScrollState())
                .statusBarsPadding()
        ) {
            AppHeader(title = "Settings", showActions = false)

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                // ── Region & Locale Section ───────────────────────────
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .glassSurface(elevation = 4.dp)
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = "Region & Locale",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Controls which region's popular, airing today, and upcoming content is shown.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    SettingsDropdown(
                        label = "Region",
                        icon = Icons.Outlined.Public,
                        selectedValue = region,
                        options = regionOptions,
                        onOptionSelected = { viewModel.updateRegion(it) }
                    )

                    SettingsDropdown(
                        label = "Language",
                        icon = Icons.Outlined.Language,
                        selectedValue = language,
                        options = languageOptions,
                        onOptionSelected = { viewModel.updateLanguage(it) }
                    )

                    SettingsDropdown(
                        label = "Timezone",
                        icon = Icons.Outlined.Schedule,
                        selectedValue = timezone,
                        options = timezoneOptions,
                        onOptionSelected = { viewModel.updateTimezone(it) }
                    )
                }

                // ── API Integration Section ────────────────────────────
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .glassSurface(elevation = 4.dp)
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = "API Integrations",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Customize the data sources used to fetch TV shows.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Use TVDB API",
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.Medium
                            )
                            Text(
                                text = "If enabled, TVDB will be used instead of TVMaze for searches and TV show details.",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        Switch(
                            checked = useTvdb,
                            onCheckedChange = { viewModel.updateUseTvdb(it) },
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = Color.White,
                                checkedTrackColor = Primary,
                                uncheckedThumbColor = MaterialTheme.colorScheme.outline,
                                uncheckedTrackColor = MaterialTheme.colorScheme.surfaceVariant
                            )
                        )
                    }

                    if (useTvdb) {
                        OutlinedTextField(
                            value = tvdbApiKey,
                            onValueChange = { viewModel.updateTvdbApiKey(it) },
                            label = { Text("TVDB API Key v4") },
                            placeholder = { Text("Enter your TVDB API Key") },
                            modifier = Modifier.fillMaxWidth(),
                            singleLine = true,
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Outlined.VpnKey,
                                    contentDescription = null,
                                    tint = Primary
                                )
                            },
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Primary,
                                focusedLabelColor = Primary,
                                unfocusedBorderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.5f)
                            )
                        )
                    }
                }

                // ── Theme Section ──────────────────────────────────────
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .glassSurface(elevation = 4.dp)
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = "Appearance",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    ThemeOptionCard(
                        title = "System Default",
                        icon = Icons.Outlined.SettingsBrightness,
                        isSelected = themeMode == ThemeMode.SYSTEM_DEFAULT,
                        onClick = { viewModel.updateThemeMode(ThemeMode.SYSTEM_DEFAULT) }
                    )

                    ThemeOptionCard(
                        title = "Light Mode",
                        icon = Icons.Outlined.LightMode,
                        isSelected = themeMode == ThemeMode.LIGHT,
                        onClick = { viewModel.updateThemeMode(ThemeMode.LIGHT) }
                    )

                    ThemeOptionCard(
                        title = "Dark Mode",
                        icon = Icons.Outlined.DarkMode,
                        isSelected = themeMode == ThemeMode.DARK,
                        onClick = { viewModel.updateThemeMode(ThemeMode.DARK) }
                    )
                }

                // Bottom spacing for nav bar
                Spacer(modifier = Modifier.height(80.dp))
            }
        }
    }
}

// ── Reusable Dropdown Component (reads from LocaleOption) ───────

@Composable
private fun SettingsDropdown(
    label: String,
    icon: ImageVector,
    selectedValue: String,
    options: List<LocaleOption>,
    onOptionSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val displayName = options.find { it.code == selectedValue }?.name ?: selectedValue

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f))
                .clickable { expanded = true }
                .padding(horizontal = 16.dp, vertical = 14.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = Primary,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = label,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = displayName,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "Expand",
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = option.name)
                            if (option.code == selectedValue) {
                                Icon(
                                    imageVector = Icons.Filled.Check,
                                    contentDescription = "Selected",
                                    tint = Primary,
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        }
                    },
                    onClick = {
                        onOptionSelected(option.code)
                        expanded = false
                    }
                )
            }
        }
    }
}

// ── Theme Option Card ───────────────────────────────────────────

@Composable
private fun ThemeOptionCard(
    title: String,
    icon: ImageVector,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val bgColor = if (isSelected) Primary.copy(alpha = 0.15f) else Color.Transparent

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(bgColor)
            .clickable { onClick() }
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
        }

        if (isSelected) {
            Icon(
                imageVector = Icons.Filled.Check,
                contentDescription = "Selected",
                tint = Primary,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}
