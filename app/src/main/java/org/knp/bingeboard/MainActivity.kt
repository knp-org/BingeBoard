package org.knp.bingeboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dagger.hilt.android.AndroidEntryPoint
import org.knp.bingeboard.data.repository.ThemeMode
import org.knp.bingeboard.data.repository.UserPreferencesRepository
import org.knp.bingeboard.navigation.BingeBoardNavGraph
import org.knp.bingeboard.ui.theme.BingeBoardTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var preferencesRepository: UserPreferencesRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Enable edge-to-edge display
        WindowCompat.setDecorFitsSystemWindows(window, false)
        
        setContent {
            val themeMode by preferencesRepository.themeMode.collectAsStateWithLifecycle(initialValue = ThemeMode.SYSTEM_DEFAULT)
            
            BingeBoardTheme(themeMode = themeMode) {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    BingeBoardNavGraph()
                }
            }
        }
    }
}
