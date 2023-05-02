# Webframework
This framework was created for a Framework course at Østfold University College. The framework uses [Maven](https://maven.apache.org/) v3.8 as a build and dependency managment tool. For web communication, we have chosen to use [Java servlet](https://mvnrepository.com/artifact/javax.servlet/servlet-api) v3.1 and the [Jetty-library](https://www.eclipse.org/jetty/) to handle the request/response workflow. Java is the main language that has been used to develop the framework, but we have also used [Spring Boot](https://spring.io/) and some Javascript for developing a realtime chatroom service. 

### Background
The purpose of the framework is to develop a specially adapted platform for developing simple web applications that include the following functional areas:
* application
* Frontend
* Database
* security
* Backend

The web framework will contain functionality that simplifies development processes by automating some of the common tasks that developers face in these areas.

### Purpose
The aim of the framework is to simplify the development of webapplications by making some of the development parts easier. We want to achieve this by offering a framework that gives developers access to a number of functionalities that are relevant to the aformentioned areas. 

### Getting started
Under development we have used IntelliJ IDEA 2022.2.3 (ultimate edition) which can be downloaded from [jetbrains.com](https://www.jetbrains.com/idea/download/#section=mac). When it comes to Java SDK´s we have used jbr-17 JetBrains Runtime version 17.0.4. For the build and dependency management system we have used Maven version 3.8.1, which can be downloaded from [maven.apache.org](https://maven.apache.org/docs/3.8.1/release-notes.html). 

### Importing the project
Since we had some complications getting the whole project to work by packaging it as a Jar file, we´re showing a how-to on importing the project via zip:

1. On the main page of this repository click on **<> Code**.
2. Then click **Download ZIP**.
3. Open the zip folder in the prefered workspace.
4. Open IntelliJ and drag the projects root folder over to the IDEA.

You can now test the framework by following this [documentation](https://github.com/stian96/WebFramework/blob/main/apidoc/app/App.md).

