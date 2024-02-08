plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
//    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
    id("com.google.firebase.appdistribution")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "ai.onereach.injectapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "ai.onereach.injectapp"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(files("libs/domain-core.jar"))
    implementation(files("libs/domain-bot.jar"))
    api(files("libs/domain-bot-core.jar"))
    implementation(files("libs/domain-idw.jar"))
    implementation(files("libs/domain-sip-calls.jar"))
    implementation(files("libs/domain-notifications-core.jar"))
    implementation(files("libs/domain-notifications.jar"))
    implementation(files("libs/domain-onboarding.jar"))
    implementation(files("libs/domain-settings.jar"))
    implementation(files("libs/domain-webview-bridge.jar"))
    implementation(files("libs/data-core-single-defaul-release.aar"))
    implementation(files("libs/data-bot-single-defaul-release.aar"))
    implementation(files("libs/data-notifications-single-defaul-release.aar"))
    implementation(files("libs/data-sip-calls-single-defaul-release.aar"))
    implementation(files("libs/data-settings-single-defaul-release.aar"))
    implementation(files("libs/data-onboarding-single-defaul-release.aar"))
    implementation(files("libs/data-webview-bridge-single-defaul-release.aar"))
    implementation(files("libs/core-platform-ui-single-defaul-release.aar"))
    implementation(files("libs/core-resources-single-defaul-release.aar"))
    implementation(files("libs/core-platform-tools-single-defaul-release.aar"))
    implementation(files("libs/feature-launch-single-defaul-release.aar"))
    implementation(files("libs/feature-sip-calls-single-defaul-release.aar"))
    implementation(files("libs/feature-notifications-single-defaul-release.aar"))
    implementation(files("libs/feature-notifications-common-single-defaul-release.aar"))
    implementation(files("libs/feature-bot-single-defaul-release.aar"))
    implementation(files("libs/feature-bot-list-single-defaul-release.aar"))
    implementation(files("libs/feature-bot-common-single-defaul-release.aar"))
    implementation(files("libs/feature-messages-history-single-defaul-release.aar"))
    implementation(files("libs/feature-qa-panel-single-defaul-release.aar"))
    implementation(files("libs/feature-webview-bridge-single-defaul-release.aar"))
    implementation(files("libs/feature-compose-single-defaul-release.aar"))
    implementation(files("libs/feature-settings-single-defaul-release.aar"))
    implementation(files("libs/feature-app-info-single-defaul-release.aar"))
    implementation(files("libs/feature-onboarding-single-defaul-release.aar"))
    implementation(files("libs/feature-permissions-single-defaul-release.aar"))
    implementation(files("libs/feature-app-link-single-defaul-release.aar"))
    implementation(files("libs/feature-qr-scanner-single-defaul-release.aar"))
    implementation(files("libs/feature-bot-call-single-defaul-release.aar"))
    implementation(files("libs/feature-bot-web-single-defaul-release.aar"))
    implementation(files("libs/feature-idw-single-defaul-release.aar"))
    implementation(files("libs/onereach-web-app-handler.jar"))

    implementation("androidx.activity:activity-compose:1.8.2")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // Kotlin
    val coroutinesVer = "1.7.3"

    // Android X / Jetpack
    val appCompatVer = "1.6.1"
    val fragmentKtxVer = "1.6.1"
    val activityKtxVer = "1.7.2"
    val coreKtxVer = "1.10.1"
    val lifecycleVer = "2.6.1"
    val workManagerVer = "2.8.1"
    val cameraXVer = "1.3.0-alpha06"
    val appStartupVer = "1.1.1"
    val dataStoreVer = "1.0.0"
    val webkit = "1.7.0"
    val broadcastManagerVer = "1.1.0"
    val mediaVer = "1.6.0"
    val material3Ver = "1.1.1"
    val coilVer = "2.5.0"
    val accompanistVer = "0.32.0"
    val splashscreenVer = "1.0.1"

    // Compose
    val composeBomVer = "2023.10.01"
    val constraintComposeVer = "1.0.1"

    // Google Play + Firebase Services
    val firebaseBomVer = "32.7.0"
    val playServicesLocationVer = "21.0.1"
    val playServicesMapsVer = "18.1.0"
    val barcodeScanningVer = "17.2.0"

    // Dependency injection
    val koinVer = "3.4.3"
    val koinComposeVer = "3.4.6"

    // Network
    val retrofitVer = "2.9.0"
    val okHttpVer = "4.11.0"

    // Data persistence
    val gsonVer = "2.10.1"
    val roomVer = "2.6.0"

    // Development dependencies
    val timberVer = "5.0.1"
    val leakCanaryVer = "2.12"
    val threeTenABPVer = "1.4.6"
    val chuckerVer = "3.5.2"
    val stethoVer = "1.6.0"

    val navigationComponentVer = "2.5.3"

    // Dependencies
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.9.20")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVer")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVer")
    implementation("androidx.appcompat:appcompat:$appCompatVer")
    implementation("androidx.lifecycle:lifecycle-common-java8:$lifecycleVer")
    implementation("androidx.lifecycle:lifecycle-process:$lifecycleVer")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVer")
    implementation("androidx.navigation:navigation-fragment-ktx:$navigationComponentVer")
    implementation("androidx.navigation:navigation-ui-ktx:$navigationComponentVer")
    implementation("androidx.core:core-ktx:$coreKtxVer")
    implementation("androidx.fragment:fragment-ktx:$fragmentKtxVer")
    implementation("androidx.activity:activity-ktx:$activityKtxVer")
    implementation("androidx.work:work-runtime-ktx:$workManagerVer")
    implementation("androidx.camera:camera-lifecycle:$cameraXVer")
    implementation("androidx.camera:camera-view:$cameraXVer")
    implementation("androidx.camera:camera-camera2:$cameraXVer")
    implementation("androidx.startup:startup-runtime:$appStartupVer")
    implementation("androidx.datastore:datastore-preferences:$dataStoreVer")
    implementation("androidx.webkit:webkit:$webkit")
    implementation("androidx.localbroadcastmanager:localbroadcastmanager:$broadcastManagerVer")
    implementation("androidx.media:media:$mediaVer")
    implementation("androidx.core:core-splashscreen:$splashscreenVer")
    implementation("androidx.compose.material3:material3:$material3Ver")
    implementation("androidx.compose.material3:material3-window-size-class:$material3Ver")
    implementation("androidx.navigation:navigation-compose:$navigationComponentVer")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleVer")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:$lifecycleVer")
    implementation("androidx.constraintlayout:constraintlayout-compose:$constraintComposeVer")
    implementation("androidx.compose:compose-bom:$composeBomVer")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.compose.ui:ui-util")
    implementation("com.google.accompanist:accompanist-permissions:$accompanistVer")
    implementation("com.google.accompanist:accompanist-swiperefresh:$accompanistVer")
    implementation("com.google.accompanist:accompanist-placeholder-material:$accompanistVer")
    implementation("io.coil-kt:coil-compose:$coilVer")
    implementation("io.coil-kt:coil-svg:$coilVer")
    implementation(platform("com.google.firebase:firebase-bom:$firebaseBomVer"))
    implementation("com.google.firebase:firebase-messaging-ktx")
    implementation("com.google.firebase:firebase-crashlytics-ktx")
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.firebase:firebase-dynamic-links-ktx")
    implementation("androidx.room:room-runtime:$roomVer")
    implementation("androidx.room:room-ktx:$roomVer")
    kapt("androidx.room:room-compiler:$roomVer")
    implementation("com.google.mlkit:barcode-scanning:$barcodeScanningVer")
    implementation("com.google.android.gms:play-services-location:$playServicesLocationVer")
    implementation("com.google.android.gms:play-services-maps:$playServicesMapsVer")
    implementation("io.insert-koin:koin-core:$koinVer")
    implementation("io.insert-koin:koin-android:$koinVer")
    implementation("io.insert-koin:koin-androidx-compose:$koinComposeVer")
    implementation("io.insert-koin:koin-androidx-navigation:$koinVer")
    implementation("com.squareup.retrofit2:retrofit:$retrofitVer")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVer")
    implementation("com.squareup.okhttp3:okhttp:$okHttpVer")
    implementation("com.squareup.okhttp3:logging-interceptor:$okHttpVer")
    api("com.google.code.gson:gson:$gsonVer")
    api("com.jakewharton.timber:timber:$timberVer")
    implementation("com.squareup.leakcanary:leakcanary-android:$leakCanaryVer")
    api("com.jakewharton.threetenabp:threetenabp:$threeTenABPVer")
    debugImplementation("com.github.chuckerteam.chucker:library:$chuckerVer")
    releaseImplementation("com.github.chuckerteam.chucker:library-no-op:$chuckerVer")

    implementation("com.facebook.stetho:stetho:$stethoVer")
    implementation("com.facebook.stetho:stetho-okhttp3:$stethoVer")

}