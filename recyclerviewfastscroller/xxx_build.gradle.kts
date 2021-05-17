/**
 * build.gradle.kts 版
 *
 * 元々はこちらを利用していたが Gradle 6.7 -> Gradle 6.8-rc-1 に変更すると Make Project (Ctrl+F9) で
 * "org.gradle.api.internal.initialization.DefaultClassLoaderScope@xxx must be locked before it can be used to compute a classpath!"
 * のエラーが出るので build.gradle に戻した。
 */

plugins {
    id("com.android.library")
}

// build.gradle.kts から rootProject.ext.compileSdkVersion 等にアクセスできないので別ファイルに切り出す
apply(from = "build_android.gradle")

dependencies {
    implementation("androidx.recyclerview:recyclerview:$recyclerViewVersion")
}

// Add the below when ready to publish to maven
//apply from: 'gradle-maven-push.gradle'
//
//afterEvaluate {
//    androidJavadocs.classpath += project.android.libraryVariants.toList().first().javaCompile.classpath
//}
