import Compose.activityCompose
import Compose.composeBom
import Compose.debugUiTooling
import Compose.hiltNavigationCompose
import Compose.material2
import Compose.navigation
import Compose.runtime
import Compose.ui
import Compose.uiToolingPreview
import Compose.viewModelCompose
import org.gradle.api.artifacts.dsl.DependencyHandler

object Compose {
    const val composeCompilerVersion = "1.3.2"
    const val bomVersion = "2022.12.00"
    const val composeBom = "androidx.compose:compose-bom:$bomVersion"

    //  region BOM Libs

    // Material 2
    const val material2 = "androidx.compose.material:material"

    // main UI API
    const val ui = "androidx.compose.ui:ui"

    // Android Studio Preview support
    const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
    const val debugUiTooling = "androidx.compose.ui:ui-tooling"

    const val runtime = "androidx.compose.runtime:runtime"
    // endregion

    private const val navigationVersion = "2.4.0-beta02"
    const val navigation = "androidx.navigation:navigation-compose:$navigationVersion"

    private const val hiltNavigationComposeVersion = "1.0.0-beta01"
    const val hiltNavigationCompose =
        "androidx.hilt:hilt-navigation-compose:$hiltNavigationComposeVersion"

    private const val activityComposeVersion = "1.4.0"
    const val activityCompose = "androidx.activity:activity-compose:$activityComposeVersion"

    private const val lifecycleVersion = "2.4.0"
    const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleVersion"
}

fun DependencyHandler.addComposeDependencies() {
    implementation(platform(composeBom))
    implementation(material2)
    implementation(ui)
    implementation(uiToolingPreview)
    debugImplementation(debugUiTooling)
    implementation(runtime)
    implementation(hiltNavigationCompose)
    implementation(navigation)
    implementation(viewModelCompose)
    implementation(activityCompose)
}
