plugins {
  id("com.android.library")
}

android {
  namespace = "xyz.danoz.recyclerviewfastscroller"

  compileSdk = rootProject.ext.get("compileSdkVersion") as Int
  buildToolsVersion = rootProject.ext.get("buildToolsVersion") as String

  defaultConfig {
    minSdk = rootProject.ext.get("minSdkVersion") as Int
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

  resourcePrefix = "rvfs_"
}

dependencies {
  implementation(libs.androidx.recyclerview)
}