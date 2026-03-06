# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.kts.

# Moshi
-keepclassmembers class * {
    @com.squareup.moshi.Json <fields>;
}
-keep class org.knp.bingeboard.data.model.** { *; }

# Retrofit
-keepattributes Signature
-keepattributes *Annotation*
