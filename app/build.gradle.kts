plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "com.example.test0319"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.test0319"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation("com.squareup.picasso:picasso:2.8");
    implementation("com.squareup.retrofit2:retrofit:(2.9.0)");
    implementation("com.squareup.retrofit2:converter-gson:2.9.0");

    testImplementation("junit:junit:4.13.2");
    testImplementation("org.mockito:mockito-core:3.12.4");

    testImplementation("com.squareup.okhttp3:mockwebserver:4.9.0");
    testImplementation("com.squareup.okhttp3:okhttp:4.9.0");

}