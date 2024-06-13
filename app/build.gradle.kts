plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.isanghoony.composeexample"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.isanghoony.composeexample"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    // Java 및 Kotlin 컴파일 옵션 설정
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17 // Java 소스 호환성 설정
        targetCompatibility = JavaVersion.VERSION_17 // Java 타겟 호환성 설정
    }
    kotlinOptions {
        jvmTarget = "17" // Kotlin이 생성하는 JVM 바이트 코드의 타겟 버전 설정
    }

    buildFeatures {
        compose = true // Jetpack Compose 사용 설정
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3" // 사용할 Jetpack Compose Kotlin 컴파일러 확장 버전 설정
    }

    packaging {
        resources {
            // 배포 시 제외할 리소스 설정
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.1")
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    implementation("androidx.navigation:navigation-compose:2.7.7")
}