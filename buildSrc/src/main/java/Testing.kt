import Testing.composeUiTest
import Testing.coroutines
import Testing.hiltTesting
import Testing.junit4
import Testing.junitAndroidExt
import Testing.mockWebServer
import Testing.mockk
import Testing.mockkAndroid
import Testing.testRunner
import Testing.truth
import Testing.turbine
import org.gradle.api.artifacts.dsl.DependencyHandler

object Testing {
    private const val junitVersion = "4.13.2"
    const val junit4 = "junit:junit:$junitVersion"

    private const val junitAndroidExtVersion = "1.1.3"
    const val junitAndroidExt = "androidx.test.ext:junit:$junitAndroidExtVersion"

    private const val coroutinesTestVersion = "1.5.1"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesTestVersion"

    private const val truthVersion = "1.1.3"
    const val truth = "com.google.truth:truth:$truthVersion"

    private const val mockkVersion = "1.10.0"
    const val mockk = "io.mockk:mockk:$mockkVersion"
    const val mockkAndroid = "io.mockk:mockk-android:$mockkVersion"

    private const val turbineVersion = "0.7.0"
    const val turbine = "app.cash.turbine:turbine:$turbineVersion"

    private const val mockWebServerVersion = "4.9.3"
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:$mockWebServerVersion"

    const val composeUiTest = "androidx.compose.ui:ui-test-junit4:${Compose.composeVersion}"

    const val hiltTesting = "com.google.dagger:hilt-android-testing:${DaggerHilt.version}"

    private const val testRunnerVersion = "1.4.0"
    const val testRunner = "androidx.test:runner:$testRunnerVersion"
}

fun DependencyHandler.addTestingDependencies() {
    testImplementation(junit4)
    testImplementation(junitAndroidExt)
    testImplementation(truth)
    testImplementation(coroutines)
    testImplementation(turbine)
    testImplementation(composeUiTest)
    testImplementation(mockk)
    testImplementation(mockWebServer)
}

fun DependencyHandler.addAndroidTestingDependencies() {
    androidTestImplementation(junit4)
    androidTestImplementation(junitAndroidExt)
    androidTestImplementation(truth)
    androidTestImplementation(coroutines)
    androidTestImplementation(turbine)
    androidTestImplementation(composeUiTest)
    androidTestImplementation(mockkAndroid)
    androidTestImplementation(mockWebServer)
    androidTestImplementation(hiltTesting)
    androidTestImplementation(testRunner)
    kaptAndroidTest(DaggerHilt.hiltCompiler)
}
