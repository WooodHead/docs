# Gradle Commands

```bash
#!/bin/bash

# version
gradle -v

# you can easily upgrade by running the wrapper task, specifying the desired Gradle version
./gradlew wrapper --gradle-version=5.1 --distribution-type=bin

# Note that it is not necessary for Gradle to be installed to use the Gradle wrapper. The next invocation of gradlew or gradlew.bat will download and cache the specified version of Gradle
./gradlew tasks
```