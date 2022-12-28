import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object Modules {
    const val app = ":app"

    const val core = ":core"
    const val coreUi = ":core-ui"

    const val onboardingDomain = ":onboarding:onboarding_domain"
    const val onboardingPresentation = ":onboarding:onboarding_presentation"

    const val trackerData = ":tracker:tracker_data"
    const val trackerDomain = ":tracker:tracker_domain"
    const val trackerPresentation = ":tracker:tracker_presentation"
}

fun DependencyHandler.addModulesDependencies() {
    implementation(project(Modules.core))
    implementation(project(Modules.coreUi))
    implementation(project(Modules.onboardingPresentation))
    implementation(project(Modules.onboardingDomain))
    implementation(project(Modules.trackerPresentation))
    implementation(project(Modules.trackerDomain))
    implementation(project(Modules.trackerData))
}
