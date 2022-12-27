import Retrofit.moshiConverter
import Retrofit.okHttp
import Retrofit.okHttpLoggingInterceptor
import Retrofit.retrofit
import org.gradle.api.artifacts.dsl.DependencyHandler

object Retrofit {
    private const val version = "2.9.0"
    const val retrofit = "com.squareup.retrofit2:retrofit:$version"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:$version"

    private const val okHttpVersion = "5.0.0-alpha.2"
    const val okHttp = "com.squareup.okhttp3:okhttp:$okHttpVersion"
    const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$okHttpVersion"
}

fun DependencyHandler.addRetrofitDependencies() {
    implementation(okHttp)
    implementation(retrofit)
    implementation(okHttpLoggingInterceptor)
    implementation(moshiConverter)
}