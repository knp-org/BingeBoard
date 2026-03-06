package org.knp.bingeboard.navigation;

import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.navigation.NavType;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lorg/knp/bingeboard/navigation/Destinations;", "", "()V", "DETAIL", "", "HOME", "SEARCH", "SETTINGS", "TV", "detailRoute", "mediaType", "mediaId", "", "source", "app_debug"})
public final class Destinations {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String HOME = "home";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TV = "tv";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SETTINGS = "settings";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SEARCH = "search";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DETAIL = "detail/{mediaType}/{mediaId}?source={source}";
    @org.jetbrains.annotations.NotNull()
    public static final org.knp.bingeboard.navigation.Destinations INSTANCE = null;
    
    private Destinations() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String detailRoute(@org.jetbrains.annotations.NotNull()
    java.lang.String mediaType, int mediaId, @org.jetbrains.annotations.NotNull()
    java.lang.String source) {
        return null;
    }
}