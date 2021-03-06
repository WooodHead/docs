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
    sgradlew task
  ```

# publish package to maven local

  ```
    gradlew publishToMavenLocal
  ```  
  
# build project without test

  ```
    gradlew build -x test
  ```

  ```
    gradle test --tests IdentityApiDocumentation
  ```


# [Gradle store on local file system](https://stackoverflow.com/questions/10834111/gradle-store-on-local-file-system )

  ```
    Linux
    ~/.gradle/caches/modules-2/files-2.1
    Window
    C:\Users\<user>\.gradle\caches\modules-2\files-2.1\
  ```
  
# fasten download from aliyun repository

  ```
     vim ~/.gradle/init.gradle
  ```

# reference

  - [gradle installation](https://gradle.org/install/ ) 
  
# issues

  - [not found in root project ](https://stackoverflow.com/questions/14093024/trying-gradle-build-task-build-not-found-in-root-project)
  - [how to test one class](https://stackoverflow.com/questions/22505533/how-to-run-only-one-test-class-on-gradle )