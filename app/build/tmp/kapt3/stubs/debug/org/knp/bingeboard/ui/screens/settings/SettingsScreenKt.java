package org.knp.bingeboard.ui.screens.settings;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.ExperimentalMaterial3Api;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.text.font.FontWeight;
import org.knp.bingeboard.data.model.LocaleOption;
import org.knp.bingeboard.data.repository.ThemeMode;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aB\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000bH\u0003\u001a\u0012\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u001a.\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014H\u0003\u00a8\u0006\u0015"}, d2 = {"SettingsDropdown", "", "label", "", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "selectedValue", "options", "", "Lorg/knp/bingeboard/data/model/LocaleOption;", "onOptionSelected", "Lkotlin/Function1;", "SettingsScreen", "viewModel", "Lorg/knp/bingeboard/ui/screens/settings/SettingsViewModel;", "ThemeOptionCard", "title", "isSelected", "", "onClick", "Lkotlin/Function0;", "app_debug"})
public final class SettingsScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void SettingsScreen(@org.jetbrains.annotations.NotNull()
    org.knp.bingeboard.ui.screens.settings.SettingsViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void SettingsDropdown(java.lang.String label, androidx.compose.ui.graphics.vector.ImageVector icon, java.lang.String selectedValue, java.util.List<org.knp.bingeboard.data.model.LocaleOption> options, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onOptionSelected) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ThemeOptionCard(java.lang.String title, androidx.compose.ui.graphics.vector.ImageVector icon, boolean isSelected, kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
}