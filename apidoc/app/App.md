<h1 style="color: white">API Documentation for "App" Class</h1>

'**App**' class is a part of the '**no.hiof.webframework.Application**' package and represents 
the core application. It creates and initializes an embedded Jetty server and sets up a 
context handler with a map of routes and HTML pages.

<br>

## Table of contents
* [Fields](#field_section)
* [Methods](method_section) 
    * [public void addRoute(String endpoint, HttpMethod httpMethod)](#)
    * [public void addHtmlPage(InputStream htmlPage)](#)
    * [public void addCustomHtmlPage(String page)](#)
    * [public void run()](#)

<br>

<a id="field_section"></a>
## Fields

1. #### 'private static final int PORT = 8080'

   The port number that the embedded Jetty server listens on.

2. #### 'private final Map<String, Route> routeMap = new LinkedHashMap<>()'

   **'LinkedHashMap'** that maps URL endpoints to a **'Route'** object.

3. #### 'private final Map<String, HtmlPages> htmlPageMap = new LinkedHashMap<>()'

   A **'LinkedHashMap'** that maps a HTML page title to a **'HtmlPages'** object.

4. #### 'private String applicationTitle, loginPageTitle, homePageTitle, logoutPageTitle'

   The title of the application, login page, home page, and logout page respectively.

5. #### 'private String customPage'
   A string that holds the custom HTML page.
   
6. #### 'private int titleCounter = 0'
   A counter used to keep track of the number of HTML pages that have been added to the **htmlPageMap**.

<br>

<a id="method_section"></a>
## Methods

1. #### 'public void addRoute(String endpoint, HttpMethod httpMethod)'
   Adds a new route to the application.
   
   | Parameter   | Type         | Description                                          |
   |:----------- |:-------------|:-----------------------------------------------------|
   | 'endpoint'  | 'String'     | The URI value of the URL                             |
   | 'httpMethod'| 'HttpMethod' | The HTTP method to be used (e.g. GET, POST, PUT etc.)|
   
   <br>
   
2. #### 'public void addHtmlPage(InputStream htmlPage)'
   Adds a ready-made HTML page to the specified route, where all the HTML and CSS is pre-built.
   
   | Parameter   | Type          | Description                                                             |
   |:----------- |:--------------|:------------------------------------------------------------------------|
   | 'htmlPage'  | 'InputStream' | An input stream of the HTML page. Can get this from the **HtmlFactory**.|
   
3. #### 'public void addCustomHtmlPage(String page)'
   Adds a custom made HTML page to the application.
   
   | Parameter   | Type          | Description                                                |
   |:----------- |:--------------|:-----------------------------------------------------------|
   | 'page'      | 'String'      | The HTML page as a string. Can be obtained from the build() <br> method in the **HtmlPageBuilder** class.| 
   
4. #### 'public void run()'
   Starts and runs the application. The program can be run after this method is called.

<br>
   
## Important
Note: Before running the application, you must have called the **'addRoute()'** and **'addHtmlPage()'** methods at least once to add routes and HTML pages respectively.

```Java
public static void main(String[] args) {

    App myApp = new App();
    myApp.addRoute("/home", HttpMethod.GET);
    
    HtmlFactory factory = new HtmlFactory();
    myApp.addHtmlPage(factory.createHomePage());

    myApp.run();
}
```
                                                    
   
   
   
   
   
   
   
   
   
   
   
   
   
   
