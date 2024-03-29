// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id ("com.google.dagger.hilt.android") version "2.44" apply false
}

buildscript {

    extra.apply{
        set("hilt_version", "2.44")
        set("retrofit_version","2.9.0")
        set("moshi_version","1.8.0")
        set("room_version","2.5.0")
    }
    repositories {
        google()
        mavenCentral()
    }
}