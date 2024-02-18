pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MyModular"
include(":app")
include(":di")
include(":domain")
include(":model:entity")
include(":model:apiresponse")
include(":data")
include(":designsystem")
include(":feautures:albumFeauture")
include(":common")
