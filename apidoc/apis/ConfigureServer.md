<h1 style="color: white">API Documentation for "ConfigureServer" Class</h1>

'**ConfigureServer**' class is a part of the '**no.hiof.webframework.servers**' package.
This class provides method to configure a server in a structured way using a Builder pattern. 
It allows setting up a server with specific port number, server endpoint, adding controllers 
and static resources. An instance of this class can only be created through the inner Builder class, 
to ensure that the server is correctly configured before it is used. The methods in the inner class 
is chainable, which allows for a fluent interface style where method calls can be chained together.

<br>

## Table of contents
* [Fields](#field_section)
* [Methods](#method_section)
    * [public Builder setPortNumber(int portNumber)](#create)
    * [public Builder setServerEndpoint(String serverEndpoint)](#addRoute)
    * [public Builder addController(HttpServlet controller, String controllerEndpoint)](#addHtmlPage)
    * [public Builder addStaticResources(String filename, String absPathToFolder)](#addCustomHtmlPage)
    * [public ConfigureServer build()](addCustomHtmlPage2)
    * [public void startServer()](#run)
* [Tutorial introduction](#getting_started)
    * [configure a server and create a simple application](#simple_application)

<br>

<a id="field_section"></a>
## Fields

#### 'private int portNumber = 0;'

Field to hold the portNumber the server will listen on, it is zero by default.

#### 'private String serverEndpoint;'

Field to hold the endpoint of the server, it has no defaults, so this needs to be specified.

#### 'private HttpServlet controller;'

Field to hold a pre-made servlet controller that the user needs to pass to the API. 

#### 'private String controllerEndpoint;'

Field to specify the endpoint of the pre-made controller. 

#### 'private String staticResourceFilename;'

Field to hold the filename of a static resource developed by the user.

#### 'private String staticResourceFolder;'

Field to hold the absolute path to the folder of the static resource.

<br>

<a id="method_section"></a>
## Methods

<a id="create"></a>
#### 'public Builder setPortNumber(int portNumber)'

Sets the port number that the server will listen on.

| Parameter    | Type      | Description                      |
|:-------------|:----------|:---------------------------------|
| 'portNumber' | 'Integer' | The int value of the port-number |

<br>

<a id="addRoute"></a>
#### 'public Builder setServerEndpoint(String serverEndpoint)'

Sets the endpoint of the server.

| Parameter        | Type         | Description                   |
|:-----------------|:-------------|:------------------------------|
| 'serverEndpoint' | 'String'     | The endpoint value of the URL |

<br>

<a id="addHtmlPage"></a>
#### 'public Builder addController(HttpServlet controller, String controllerEndpoint)'

Adds a pre-made servlet controller to the server with associated endpoint. <br>
The pre-made controller can be created by extending the abstract 'Controller' class.

| Parameter            | Type          | Description                                                        |
|:---------------------|:--------------|:-------------------------------------------------------------------|
| 'controller'         | 'HttpServlet' | A pre-made servlet controller, which extends the Controller class. |
| 'controllerEndpoint' | 'String'      | Sets the endpoint of the pre-made controller.                      |

<br>

<a id="addCustomHtmlPage"></a>
#### 'public Builder addStaticResources(String filename, String absPathToFolder)'

Method used to add static resources to the server, e.g. html, css, and js-files.

| Parameter         | Type          | Description                                                            |
|:------------------|:--------------|:-----------------------------------------------------------------------|
| 'filename'        | 'String'      | The filename of the static resource to be added.                       | 
| 'absPathToFolder' | 'String'      | The absolute path to the folder where the static resource are located. | 

<br>

<a id="addCustomHtmlPage2"></a>
#### 'public ConfigureServer build()'

Build method in an Builder-design that gives the ConfigureServer instance the necessary configurations for the server.

<br>

<a id="run"></a>
#### 'public void startServer()'

Method used to start the server. The program can be executed after this method is called.

<br>

<a id="getting_started"></a>
## Tutorial introduction

<a id="simple_application"></a>
### Configure a server and create a simple application.

Call the static Builder method on the ConfigureServer instance to start the chained method calls.

```java
public class Main {
  public static void main(String[] args) {

    ConfigureServer server = new ConfigureServer.Builder()
            .setPortNumber(8081)
            .setServerEndpoint("/api")
            .addController(new TestController(), "/test")
            .addStaticResources("index.html", "/path/to/static/resource")
            .build();
    server.startServer();
  }
}
```

After running the program, navigate to 'http://localhost:8081/' to see the html page. <br>
To see the response of the pre-made controller, navigate to 'http://localhost/api/test'.

