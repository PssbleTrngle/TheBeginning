plugins {
    id("com.possible-triangle.neoforge")
}

neoforge {
    dataGen {
        splitSourceSet()
    }
}

repositories {
    maven {
        url = uri("https://maven.blamejared.com/")
        content {
            includeGroup("mezz.jei")
        }
    }

    maven {
        url = uri("https://maven.gegy.dev/releases")
        content {
            includeGroupAndSubgroups("com.tterrag")
        }
    }
}

dependencies {
    modApi(libs.registrate)

    modCompileOnly(libs.jei.common.api)
    modCompileOnly(libs.jei.api)
    modRuntimeOnly(libs.jei)
}

upload.maven {
    nexus()
}

enableSpotless()
