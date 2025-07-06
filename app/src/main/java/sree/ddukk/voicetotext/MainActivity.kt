package sree.ddukk.voicetotext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import sree.ddukk.voicetotext.navigation.AppNavigation
import sree.ddukk.voicetotext.ui.theme.VoicetotextTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VoicetotextTheme {
               AppNavigation()
            }
        }
    }
}

