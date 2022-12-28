import Coil.coilCompose
import org.gradle.api.artifacts.dsl.DependencyHandler

object Coil {
    private const val version = "2.2.2"
    const val coilCompose = "io.coil-kt:coil-compose:$version"
}

fun DependencyHandler.addCoilDependency() {
    implementation(coilCompose)
}
