import org.gradle.api.artifacts.dsl.DependencyHandler

object Versions {
    const val core = "1.7.0"
    const val compose = "1.1.1"
    const val navigation = "2.4.1"
    const val kotlin = "1.6.10"
    const val fragment = "1.4.1"
    const val appcompat = "1.4.1"
}

object Dependencies{
    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
}

fun DependencyHandler.application() {
    implementation (Dependencies.core)
    implementation (Dependencies.composeUi)
}

/*fun DependencyHandler.unitTesting() {

}*/

fun DependencyHandler.implementation(depName: Any) {
    add("implementation", depName)
}

private fun DependencyHandler.kapt(depName: String) {
    add("kapt", depName)
}
