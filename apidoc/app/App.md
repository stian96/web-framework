<h1 style="color: white">API Documentation for "App" Class</h1>

'**App**' class is a part of the '**no.hiof.webframework.Application**' package and represents 
the core application. It creates and initializes an embedded Jetty server and sets up a 
context handler with a map of routes and HTML pages.

<br>

## Table of contents
* [Fields](#field_section)
* [Methods](#method_section) 
    * [public void addRoute(String endpoint, HttpMethod httpMethod)](#addRoute)
    * [public void addHtmlPage(InputStream htmlPage)](#addHtmlPage)
    * [public void addCustomHtmlPage(String page)](#addCustomHtmlPage)
    * [public void run()](#run)
* [Getting started](#getting_started)

<br>

<a id="field_section"></a>
## Fields

#### 'private static final int PORT = 8080'

The port number that the embedded Jetty server listens on.

#### 'private final Map<String, Route> routeMap = new LinkedHashMap<>()'

**'LinkedHashMap'** that maps URL endpoints to a **'Route'** object.

#### 'private final Map<String, HtmlPages> htmlPageMap = new LinkedHashMap<>()'

A **'LinkedHashMap'** that maps a HTML page title to a **'HtmlPages'** object.

#### 'private String applicationTitle, loginPageTitle, homePageTitle, logoutPageTitle'

The title of the application, login page, home page, and logout page respectively.

#### 'private String customPage'

A string that holds the custom HTML page.
   
#### 'private int titleCounter = 0'

A counter used to keep track of the number of HTML pages that have been added to the **htmlPageMap**.

<br>

<a id="method_section"></a>
## Methods
   
<a id="addRoute"></a>
#### 'public void addRoute(String endpoint, HttpMethod httpMethod)'

Adds a new route to the application.
   
| Parameter   | Type         | Description                                          |
|:----------- |:-------------|:-----------------------------------------------------|
| 'endpoint'  | 'String'     | The URI value of the URL                             |
| 'httpMethod'| 'HttpMethod' | The HTTP method to be used (e.g. GET, POST, PUT etc.)|
   
<br>
   
<a id="addHtmlPage"></a>
#### 'public void addHtmlPage(InputStream htmlPage)'

Adds a ready-made HTML page to the specified route, where all the HTML and CSS is pre-built.
   
| Parameter   | Type          | Description                                                             |
|:----------- |:--------------|:------------------------------------------------------------------------|
| 'htmlPage'  | 'InputStream' | An input stream of the HTML page. Can get this from the **HtmlFactory**.|
 
<br>

<a id="addCustomHtmlPage"></a>
#### 'public void addCustomHtmlPage(String page)'

Adds a custom made HTML page to the application.
   
| Parameter   | Type          | Description                                                |
|:----------- |:--------------|:-----------------------------------------------------------|
| 'page'      | 'String'      | The HTML page as a string. Can be obtained from the build() <br> method in the **HtmlPageBuilder** class.| 

<br>
   
<a id="run"></a>
#### 'public void run()'

Starts and runs the application. The program can be run after this method is called.

<br>

<a id="getting_started"></a>
## Getting Started

Note: Before running the application, you must have called the **'addRoute()'** and **'addHtmlPage()'** methods at least once to add routes and HTML pages respectively.

```java
public class Main {
  public static void main(String[] args) {

    App myApp = new App();
    myApp.addRoute("home", HttpMethod.GET);

    HtmlFactory factory = new HtmlFactory();
    myApp.addHtmlPage(factory.createHomePage());

    myApp.run();
  }
}
```
                                                    
   
   
   
   
   
   
   
   
   
   
   
   
   
   
