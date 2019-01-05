# Gradle Issue

* [without manifest](https://discuss.gradle.org/t/manifest-with-classpath-in-jar-task-for-subprojects/7030/4)

```bulid.gradle
jar.doFirst{
    manifest {
        attributes("Manifest-Version"
        : "1.0",
                "Created-By"
                : vendor,
                "Specification-Title"
                : appName,
                "Specification-Version"
                : version,
                "Specification-Vendor"
                : vendor,
                "Implementation-Title"
                : appName,
                "Implementation-Version" : version,
                "Implementation-Vendor"
                : vendor,
                "Main-Class"
                : "com.bamboo.demand.portal.migration.MigrationMain",
                "Class-Path"
                : configurations.compile.collect { it.getName() }.join(' ')
        )
    }
}

```