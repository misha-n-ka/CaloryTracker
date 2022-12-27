import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.implementation(dependencyName: String) {
    add("implementation", dependencyName)
}

fun DependencyHandler.kapt(dependencyName: String) {
    add("kapt", dependencyName)
}

fun DependencyHandler.testImplementation(dependencyName: String) {
    add("testImplementation", dependencyName)
}

fun DependencyHandler.androidTestImplementation(dependencyName: String) {
    add("androidTestImplementation", dependencyName)
}

fun DependencyHandler.kaptAndroidTest(dependencyName: String) {
    add("kaptAndroidTest", dependencyName)
}

