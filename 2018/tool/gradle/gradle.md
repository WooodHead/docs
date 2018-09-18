# gradle overview

# gradle installation

    ```
    $ mkdir /opt/gradle
    $ unzip -d /opt/gradle gradle-4.10.1-bin.zip
    $ ls /opt/gradle/gradle-4.10.1
    
    echo 'export GRADLE_HOME=/opt/gradle/gradle-2.14' | sudo tee -a /etc/profile
    ```
    
# view gradle tasks

  ```
    ./gradlew task
  ```

# gradle installation jar into local maven repository

  ```
    gradlew install
  ```

# [Gradle store on local file system](https://stackoverflow.com/questions/10834111/gradle-store-on-local-file-system )

  ```
    Linux
    ~/.gradle/caches/modules-2/files-2.1
    Window
    C:\Users\<user>\.gradle\caches\modules-2\files-2.1\
  ```

# reference

  - [gradle installation](https://gradle.org/install/ ) 