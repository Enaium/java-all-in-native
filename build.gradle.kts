plugins {
    id("java")
    application
}

group = "cn.enaium"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
}

java {
    sourceCompatibility = JavaVersion.VERSION_23
    targetCompatibility = JavaVersion.VERSION_23
}

tasks.compileJava {
    options.compilerArgs = listOf("--enable-preview")
}

application {
    mainClass = "Main"
}

registerTask("cpp", "natives/cpp/build/Release")
registerTask("rust", "natives/rust/target/release")
registerTask("csharp", "natives/csharp/bin/Release")
registerTask("go", "natives/go/build")
registerTask("kotlin", "natives/kotlin/build/bin/native/releaseShared")
registerTask("zig", "natives/zig/zig-out/bin")

fun registerTask(name: String, native: String) {
    tasks.register<JavaExec>(name) {
        group = "application"
        mainClass = application.mainClass
        classpath = sourceSets.main.get().runtimeClasspath
        jvmArgs = listOf(
            "--enable-preview",
            "--enable-native-access=ALL-UNNAMED",
            "-Djava.library.path=$native"
        )
    }
}