import kotlin.experimental.ExperimentalNativeApi

@OptIn(ExperimentalNativeApi::class)
@CName(externName = "greeting")
fun greeting(greeting: String): String {
    return "$greeting Kotlin/Native!"
}