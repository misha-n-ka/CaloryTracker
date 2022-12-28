import DaggerHilt.hiltAndroid
import DaggerHilt.hiltCompiler
import org.gradle.api.artifacts.dsl.DependencyHandler

object DaggerHilt {
    const val version = "2.44.2"
    const val hiltAndroid = "com.google.dagger:hilt-android:$version"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:$version"
}

fun DependencyHandler.addDaggerHiltDependencies() {
    implementation(hiltAndroid)
    kapt(hiltCompiler)
}
