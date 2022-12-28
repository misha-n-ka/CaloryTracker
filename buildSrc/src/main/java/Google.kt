import Google.material
import org.gradle.api.artifacts.dsl.DependencyHandler

object Google {
    private const val materialVersion = "1.8.0-beta01"
    const val material = "com.google.android.material:material:$materialVersion"
}

fun DependencyHandler.addGoogleDependency() {
    implementation(material)
}
