# Onereach.ai Android SDK documentation
Welcome to the Onereach.ai Android SDK documentation. Here, you'll discover valuable information about utilizing the Android SDK effectively.
# Table of Contents
1. [Onereach.ai Android SDK documentation](#onereachai-android-sdk-documentation)
    - [Setup](#setup)
        - [Changes in your project](#changes-in-your-project)
        - [If you intend to use Firebase Messaging functionality](#if-you-intend-to-use-firebase-messaging-functionality)
        - [If you don't want to use Firebase Messaging functionality](#if-you-dont-want-to-use-firebase-messaging-functionality)
    - [SDK Usage](#sdk-usage)
        - [Enable the SDK in your Application class](#enable-the-sdk-in-your-application-class)
        - [Launch the Onereach App from your activity](#launch-the-onereach-app-from-your-activity)
        - [Firebase Push Messaging](#firebase-push-messaging)
## Setup
#### Changes in your project:
1. Root build.gradle.kts:
```
plugins {
    // Other plugins...
    id("com.google.firebase.crashlytics") version "2.9.9" apply false
    id("com.google.firebase.appdistribution") version "4.0.1" apply false
    id("androidx.navigation.safeargs") version "2.5.0" apply false
}
```
2. Module build.gradle.kts:
```
plugins {
    // Other plugins...
    id("com.google.firebase.crashlytics")
    id("com.google.firebase.appdistribution")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    // Other configurations...
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // Other dependencies...
    implementation("ai.onereach.app:android-sdk:1.0.0")
}
```
#### If you intend to use Firebase Messaging functionality, follow these additional steps:
1. Add to root build.gradle.kts:
```
id("com.google.gms.google-services")
```
2. Add to module build.gradle.kts:
```
id("com.google.gms.google-services") version "4.4.0" apply false
```

3. Generate from firebase `google-services.json` and put it in you app directory

#### If you don't want to use Firebase Messaging functionality, add the following code to your `AndroidManifest.xml`:
```
<application
...
        <provider android:authorities="${applicationId}.firebaseinitprovider"
            android:name="com.google.firebase.provider.FirebaseInitProvider"
            android:exported="false"
            tools:node="remove"/>
</application>
```

## SDK Usage
#### Enable the SDK in your Application class.
Ensure to pass your app's package name to the `initOneReachAppsSdk` function.
(All SDK API functions are extension functions and can only be called within a limited context)
```
class SampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initOneReachAppsSkd("ai.onereach.injectapp")
    }
}
```
#### Launch the Onereach App from your activity.
`url` is the URL to your Onereach IDW.
`theme` defaults to SYSTEM but can be overridden to DARK or LIGHT.
`name` is the application name used in some SDK screens.
```
launchApp(
    url = "https://{enviroment}.onereach.ai/{appId}}",
    theme = OneReachFlavor.AppTheme.SYSTEM,
    name = "Sample"
)
```

#### Firebase Push Messaging
If you enable Firebase Messaging, special Onereach push messages will be handled automatically. However, if you want to handle your own push messages, you need to override FirebaseMessagingService and pass the token and push messages to the SDK manually.

1. Add the following to your `AndroidManifest.xml:`
```
<application>
...
        <service
            android:name="ai.onereach.injectapp.SampleMessagingService"
            android:exported="false">
            <intent-filter>
                <action android:name="com.google.firebase.MESSAGING_EVENT" />
            </intent-filter>
        </service>
</application>
```
2. Create a successor of FirebaseMessagingService
   Ensure to call the two SDK functions described above for proper handling of push notifications.
```
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
```