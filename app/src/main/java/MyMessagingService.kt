import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyMessagingService : FirebaseMessagingService() {
    override fun onNewToken(token: String) {

    }

    override fun onMessageReceived(message: RemoteMessage) {

    }
}