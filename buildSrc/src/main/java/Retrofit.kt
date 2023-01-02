import Retrofit.moshiConverter
import Retrofit.okHttp
import Retrofit.okHttpLoggingInterceptor
import Retrofit.retrofit
import org.gradle.api.artifacts.dsl.DependencyHandler

object Retrofit {
    private const val version = "2.9.0"
    const val retrofit = "com.squareup.retrofit2:retrofit:$version"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:$version"

    const val okHttpVersion = "4.10.0"
    const val okHttp = "com.squareup.okhttp3:okhttp:$okHttpVersion"
    const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$okHttpVersion"
}

fun DependencyHandler.addRetrofitDependencies() {
    api(okHttp)
    api(retrofit)
    api(okHttpLoggingInterceptor)
    api(moshiConverter)
}
