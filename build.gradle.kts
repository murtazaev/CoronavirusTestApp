// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath (ClasspathDependecies.androidGradlePlugin)
        classpath (ClasspathDependecies.koltinGradlePlugin)
        classpath (ClasspathDependecies.kotlinSerialization)
        classpath (ClasspathDependecies.navComponentSafeArgs)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

tasks.register("clean").configure {
    delete(rootProject.buildDir)
}