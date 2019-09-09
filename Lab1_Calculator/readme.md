# Lab1

## Name: Xiaoting Jin	SJSU ID: 013842192

### <u>Part 1</u>

Environment Setup Screenshots

### <u>Part 2</u>

Android application of calculator with use of Activity, Text-view, Buttons

* Source Code Package
* APK

### <u>Part 3</u>

1. What is difference between Gradle and Maven? Why is Gradle used extensively in
   Android project developments?

   A: The major difference between Gradle and Maven are: flexibility, performance, user experience and dependency management. (<https://gradle.org/maven-vs-gradle/>)

   - Flexibility: Gradle is more modeled in a way that is extensible in the most fundamental ways. Maven provides a very rigid model while Gradle's model allows to be used for native development with C/C++ and can be expanded to cover any ecosystem.

   - Performance: Gradle's build performance is faster than Maven for most scenario.

   - User Experience: Maven's longer tenure means it has better support through IDEs for many users, however, Gradle is also improving quickly, such as developed Kotlin-based DSL and Gradle has more powerful command-line operations, also, Gradle provides an interactive web-based UI for checking logs, debugging and optimizing builds.

   - Dependency Management: Both are able to cache dependencies locally and download them in parallel. Maven allows users to override a dependency, but only by verion. Gradle allows users to declare API and implementaion dependencies to prevent unwanted libraries from leaking into the class paths of consumers.

     **Why Gradle? **(<https://stackoverflow.com/questions/16754643/what-is-gradle-in-android-studio>)

     Some features made us to choose Gradle:

   - Domain Specific Language (DSL) to describe and manipulate the build logic
   - Build files are Groovy based and allow mixing of declarative elements through the DSL and using code to manipulate the DSL elements to provide custom logic.
   - Built-in dependency management through Maven and/or Ivy.
   - Very flexible. Allows using best practices but doesn’t force its own way of doing things.
   - Plugins can expose their own DSL and their own API for build files to use.
   - Good Tooling API allowing IDE integration

   

2. What is project structure in Android Studio? List down the folder structure created
   for your application.

   A: The most important project files are the following (<https://developer.android.com/studio/projects#ProjectStructure>)

   

3. What is “adb” and where is it located? What is the importance of “adb”?

   A: "adb" means Android Debug Bridge, it is a versatile command-line tool that let us communicate with a device. The adb command facilitates a variety of device actions, such as installing and debugging apps, and it provides access to a Unix shell that you can use to run a variety of commands on a device. It is very powerful and allows us to directly operate from the system level through shell commands on handheld devices. (<https://developer.android.com/studio/command-line/adb>)

4. Use “Android Monitor” for your application and attach screenshots of your application graphs from Android Monitor, in report.

   A: 

