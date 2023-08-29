plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlinx-serialization")
    id("io.gitlab.arturbosch.detekt")
    id("kotlin-kapt")
    id("de.mannodermaus.android-junit5")
    id("kotlin-android")
    id("kotlin-parcelize")
}

android {
    namespace = "pro.midev.mec"
    compileSdk = libs.versions.compileSdk.get().toInt()

//    signingConfigs {
//        create("release") {
//            storeFile = file("../key.jks")
//            storePassword = "313211707"
//            keyAlias = "key0"
//            keyPassword = "313211707"
//        }
//    }

    defaultConfig {
        testInstrumentationRunnerArguments += mapOf()
        applicationId = "pro.midev.mec"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = 18
        versionName = "0.1.9"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testInstrumentationRunnerArguments["runnerBuilder"] = "de.mannodermaus.junit5.AndroidJUnit5Builder"
        vectorDrawables {
            useSupportLibrary = true
        }
        //signingConfig = signingConfigs.getByName("release") // todo спросить
    }

    buildTypes {
        val debug by getting {
            isDebuggable = true
            isMinifyEnabled = false
            versionNameSuffix = "-debug"

            buildConfigField("String", "SERVER_URL", "\"\thttps://mobile.moscow-export.com/api/1.0/\"")
            buildConfigField("String", "MEC_URL", "\"\thttps://mec.htmlup.ru/api/\"")
        }
        val release by getting {
            // TODO: Enable minify
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")

            buildConfigField("String", "SERVER_URL", "\"\thttps://mobile.moscow-export.com/api/1.0/\"")
            buildConfigField("String", "MEC_URL", "\"\thttps://mec.htmlup.ru/api/\"")
        }
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true

        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.androidxComposeCompiler.get()
    }
    packagingOptions {
        resources.excludes.add("META-INF/*")
    }
    kapt {
        //correctErrorTypes = true
    }
}

dependencies {
    implementation("androidx.core:core-ktx:+")
    // region Android
    coreLibraryDesugaring(libs.androidDesugaring)
    // endregion

    // region Core
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.lifecycle.runtime)
    implementation(libs.androidx.lifecycle.viewModelCompose)
    // endregion

    // region Compose
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.material)

    debugImplementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.compose.ui.tooling.preview)

    // region UI
    implementation(libs.shimmer)
    // endregion

    // region Coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)
    // endregion

    // region Network
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)

    implementation(libs.retrofit.core)
    implementation(libs.retrofit.conventer.gson)

    implementation(libs.gson)
    // endregion

    // region Koin
    implementation(libs.koin)
    implementation(libs.koin.compose)
    // endregion

    // region Coil
    implementation(libs.coil)
    implementation(libs.coil.compose)
    implementation(libs.coil.svg)
    // endregion

    // region Navigation
    implementation(libs.bundles.voyager)
    // endregion

    // region Utils
    implementation(libs.timber)
    implementation(libs.kotlinx.collections.immutable)
    implementation(libs.kotlinx.datetime)
    // endregion

    // region local storage
    implementation(libs.mmkv)
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    kapt(libs.room.compiler)
    testImplementation(libs.room.testing)
    // endregion

    // region unit-tests
    testImplementation(libs.bundles.test.android)
    testImplementation(libs.bundles.test.unit)
    testRuntimeOnly(libs.test.mannodermaus.runner)
    testRuntimeOnly(libs.test.junit.vintage)

    androidTestRuntimeOnly(libs.test.mannodermaus.runner)
    androidTestRuntimeOnly(libs.test.junit.vintage)
    androidTestImplementation(libs.bundles.test.android)
    androidTestImplementation(libs.bundles.test.unit)
    // endregion

    // region biometrics
    implementation(libs.biometric)
    // endregion

}

detekt {
    toolVersion = libs.versions.detekt.get()
    source = files(projectDir)
    config = files("${projectDir.parent}/config/detekt/detekt.yml")
    parallel = true
    reports {
        txt.required.set(false)
        xml.required.set(false)
        sarif.required.set(false)
        html.required.set(true)
        html.outputLocation.set(file("app/build/reports/detekt.html"))
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
