package org.knp.bingeboard.ui.screens.detail;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ExperimentalLayoutApi;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.text.font.FontWeight;
import org.knp.bingeboard.data.model.TvMazeShow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a \u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH\u0003\u001a\u0018\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bH\u0003\u001a#\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\b2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003\u00a2\u0006\u0002\b\u0010H\u0003\u001a@\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0003\u001a\u001e\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0003\u00a8\u0006\u001a"}, d2 = {"DetailScreen", "", "onBackClick", "Lkotlin/Function0;", "viewModel", "Lorg/knp/bingeboard/ui/screens/detail/DetailViewModel;", "GenreChip", "name", "", "InfoChip", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "text", "SectionCard", "title", "content", "Landroidx/compose/runtime/Composable;", "TvMazeShowDetailContent", "show", "Lorg/knp/bingeboard/data/model/TvMazeShow;", "isInWatchlist", "", "airTimeDisplay", "onToggleWatchlist", "WatchlistButton", "onClick", "app_debug"})
public final class DetailScreenKt {
    
    @androidx.compose.runtime.Composable()
    public static final void DetailScreen(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBackClick, @org.jetbrains.annotations.NotNull()
    org.knp.bingeboard.ui.screens.detail.DetailViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void WatchlistButton(boolean isInWatchlist, kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void InfoChip(androidx.compose.ui.graphics.vector.ImageVector icon, java.lang.String text) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void GenreChip(java.lang.String name) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void SectionCard(java.lang.String title, kotlin.jvm.functions.Function0<kotlin.Unit> content) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.foundation.layout.ExperimentalLayoutApi.class})
    @androidx.compose.runtime.Composable()
    private static final void TvMazeShowDetailContent(org.knp.bingeboard.data.model.TvMazeShow show, boolean isInWatchlist, java.lang.String airTimeDisplay, kotlin.jvm.functions.Function0<kotlin.Unit> onBackClick, kotlin.jvm.functions.Function0<kotlin.Unit> onToggleWatchlist) {
    }
}