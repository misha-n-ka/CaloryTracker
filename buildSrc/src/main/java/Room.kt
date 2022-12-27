import Room.roomCompiler
import Room.roomKtx
import Room.roomRuntime
import org.gradle.api.artifacts.dsl.DependencyHandler

object Room {
    private const val version = "2.4.0"
    const val roomRuntime = "androidx.room:room-runtime:$version"
    const val roomCompiler = "androidx.room:room-compiler:$version"
    const val roomKtx = "androidx.room:room-ktx:$version"
}

fun DependencyHandler.addRoomDependencies() {
    kapt(roomCompiler)
    implementation(roomKtx)
    implementation(roomRuntime)
}
