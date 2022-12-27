import Google.material
import org.gradle.api.artifacts.dsl.DependencyHandler

object Google {
    private const val materialVersion = "1.4.0"
    const val material = "com.google.android.material:material:$materialVersion"
}

fun DependencyHandler.addGoogleDependency() {
    implementation(material)
}
