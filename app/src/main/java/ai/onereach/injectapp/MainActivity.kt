package ai.onereach.injectapp

import ai.onereach.coretools.utils.OneReachFlavor
import ai.onereach.injectapp.ui.theme.SampleAppTheme
import ai.onereach.launch.OneReachSdk.handleNewPushToken
import ai.onereach.launch.OneReachSdk.handlePushMessageReceived
import ai.onereach.launch.OneReachSdk.initOneReachAppsSdk
import ai.onereach.launch.OneReachSdk.launchApp
import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.WorkerThread
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class SampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initOneReachAppsSdk("ai.onereach.injectapp")
    }
}

class SampleMessagingService : FirebaseMessagingService() {

    @WorkerThread
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        handleNewPushToken(token)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        handlePushMessageReceived(remoteMessage)
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val appId = "put_your_appId_here"
                    val environment = "put_your_environment_here"
                    MainScreen {
                        launchApp(
                            url = "https://$environment.onereach.ai/$appId",
                            theme = OneReachFlavor.AppTheme.SYSTEM,
                            name = "Sample"
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun MainScreen(onClick: () -> Unit = {}) {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Button(
            modifier = Modifier,
            onClick = onClick,
        ) {
            Text(text = "Open OneReach")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SampleAppTheme {
        MainScreen()
    }
}