plugins {
    id("com.android.library")
}

// build.gradle.kts から rootProject.ext.compileSdkVersion 等にアクセスできないので別ファイルに切り出す
apply(from = "build_android.gradle")

dependencies {
    implementation(Dep.Library.androidx_recyclerview)
}

// Add the below when ready to publish to maven
//apply from: 'gradle-maven-push.gradle'
//
//afterEvaluate {
//    androidJavadocs.classpath += project.android.libraryVariants.toList().first().javaCompile.classpath
//}
