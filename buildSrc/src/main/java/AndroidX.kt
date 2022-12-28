import AndroidX.appCompat
import AndroidX.coreKtx
import org.gradle.api.artifacts.dsl.DependencyHandler

object AndroidX {
    private const val coreKtxVersion = "1.9.0"
    const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"

    private const val appCompatVersion = "1.5.1"
    const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"
}

fun DependencyHandler.addAndroidXDependencies() {
    implementation(coreKtx)
    implementation(appCompat)
}
