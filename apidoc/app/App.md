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
    * [public void addResponseToPage(String response)](#addResponse)
    * [public void addController(Controller controller)](#addController)
    * [public void run()](#run)
* [Getting started](#getting_started)
    * [creating a simple application with a title](#simple_application)
    * [creating default pages](#default_pages)
    * [creating custom pages](#custom_pages)
    * [creating a controller](#controller)
    * [adding response to page](#response)

<br>

<a id="field_section"></a>
## Fields

#### 'private static final int PORT = 8080'

The port number that the embedded Jetty server listens on.

#### 'private final Map<String, Route> routeMap = new LinkedHashMap<>()'

**'LinkedHashMap'** that maps URL endpoints to a **'Route'** object.

#### 'private final Map<String, HtmlPages> htmlPageMap = new LinkedHashMap<>()'

A **'LinkedHashMap'** that maps a HTML page title to a **'HtmlPages'** object.

#### 'private String applicationTitle'

The title of the application, this is found at route "/".

#### 'private String customPage'

A string that holds the custom HTML page.

#### 'private UserDb userDb'

A user database object that can be used to get, save and delete users.

#### 'private String response'

String that is used to deliver a response to an empty page.
   
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
#### 'public void addHtmlPage(InputStream htmlPage, String title)'

Adds a ready-made HTML page to the specified route, where all the HTML and CSS is pre-built.
   
| Parameter   | Type          | Description                                                             |
|:----------- |:--------------|:------------------------------------------------------------------------|
| 'htmlPage'  | 'InputStream' | An input stream of the HTML page. Can get this from the **HtmlFactory**.|
| 'title'     | 'String'      | Sets the title of the page.                                             |
 
<br>

<a id="addCustomHtmlPage"></a>
#### 'public void addCustomHtmlPage(String page)'

Adds a custom made HTML page to the application.
   
| Parameter   | Type          | Description                                                |
|:----------- |:--------------|:-----------------------------------------------------------|
| 'page'      | 'String'      | The HTML page as a string. Can be obtained from the build() <br> method in the **HtmlPageBuilder** class.| 

<br>

<a id="addResponse"></a>
#### 'public void addResponseToPage(String response)'

Adds a response as a **'String'** to an empty page.

| Parameter   | Type          | Description                                                |
|:----------- |:--------------|:-----------------------------------------------------------|
| 'response'  | 'String'      | Adds a response to an empty page with no html content.     | 

<br>

<a id="addController"></a>
#### 'public void addController(Controller controller)'

Adds a user-created controller to the server.

| Parameter    | Type          | Description                                   |
|:-----------  |:--------------|:----------------------------------------------|
| 'controller' | 'Controller'  | Adds a user-defined controller to the server. |

<br>
   
<a id="run"></a>
#### 'public void run()'

Starts and runs the application. The program can be run after this method is called.

<br>

<a id="getting_started"></a>
## Getting Started

<a id="simple_application"></a>
### A simple web application

Create an instance of the **'App'** object and make a call to the method **'setTitle()'**

```java
public class Main {
  public static void main(String[] args) {

    App myApp = new App();
    myApp.setTitle("Title of the application!");
    myApp.run();
    
  }
}
```

After running the program, navigate to 'http://localhost:8080/' and you should see the title in the browser.

<br>

<a id="default_pages"></a>
### Creating default pages

Before running the application, you must have called the **'addRoute()'** and **'addHtmlPage()'** methods at least once to add routes and HTML pages respectively. Setting page titles is optional.

```java
public class Main {
  public static void main(String[] args) {

    App myApp = new App();
    
    // Add routes and Http method.
    myApp.addRoute("home", HttpMethod.GET);
    myApp.addRoute("login", HttpMethod.GET);
    myApp.addRoute("logout", HttpMethod.GET);
   
    // Create an instance of the factory and create the default pages.
    HtmlFactory factory = new HtmlFactory();
    myApp.addHtmlPage(factory.createHomePage(), "Welcome to home page!");
    myApp.addHtmlPage(factory.createLoginPage(), "Login");
    myApp.addHtmlPage(factory.createLogoutPage(), "Logout");
    
    myApp.run();
  }
}
```
After running the program, navigate to the following urls to see the pages:
* http://localhost:8080/login
* http://localhost:8080/home
* http://localhost:8080/logout

<br>

<a id="custom_pages"></a>
### Creating a custom page

To create a custom page we need to use the **'HtmlPageBuilder'** class. 
After the page is built, we can call the **'addCustomHtmlPage()'** method in the **'App'** API, and
pass it the **'builder.build()'** argument.

```java
public class Main {
    public static void main(String[] args) {

        App myApp = new App();
        myApp.addRoute("custom", HttpMethod.GET);

        // Builder to create custom html pages.
        HtmlPageBuilder builder = new HtmlPageBuilder();

        // Adds a header to the page.
        builder.addHeader("Custom page");

        // Adds elements in a navbar.
        builder.addNavElements("home", "about", "contact");

        String paragraph = """
                           Contrary to popular belief, Lorem Ipsum is not simply random text. 
                           It has roots in a piece of classical Latin literature from 45 BC, 
                           making it over 2000 years old. Richard McClintock, a Latin professor 
                           at Hampden-Sydney College in Virginia, looked up one of the more obscure 
                           Latin words, consectetur, from a Lorem Ipsum passage, and going through 
                           the cites of the word in classical literature, discovered the undoubtable 
                           """;
        // Adds a main section with a header and a paragraph.
        builder.addMainSection("Main section", paragraph);

        // Adds a footer section with contact information.
        builder.addFooterSection("Home-street 5B", "46578987", "example@gmail.com");

        // Send the html page as a string to the addCustomHtmlPage method.
        myApp.addCustomHtmlPage(builder.build());
        myApp.run();
    }
}
```
We can now navigate to 'http://localhost:8080/custom' to see the results.

<br>

<a id="controller"></a>
### Add controller to the server

To add a controller to the server we first need to create a new class **'MyController'** that
extends the abstract **'Controller'** class. Then we need to define the **'handleGet'** and 
**'handlePost'** methods before we pass the controller to the **'App'** instance.

```java
public class MyController extends Controller {

    public MyController(String endpoint) {
        super(endpoint);
    }

    @Override
    protected void handleGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, HttpMethodException {
        
        // Build a simple html page with a login form that we pass
        // to the 'render()' method.
        HtmlPageBuilder builder = new HtmlPageBuilder();
        builder.addHeader("Controller test");
        builder.addForm(HttpMethod.POST, "username", "password");

        render(builder.build(), request, response);
    }

    @Override
    protected void handlePost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // Check if the response from the form matches with these values.
        if (username.equals("Jake") && password.equals("hello123"))
            response.getWriter().println("<h3>Login success!</h3>");
        else
            response.getWriter().println("<h3>User do not exists.</h3>");

    }
}
```

Then we can add the following code in the Main.java file.

```java
public class Main {
    public static void main(String[] args) {

        App app = new App();
        MyController myController = new MyController("myController");
        app.addController(myController);
        app.run();
    }
}
```
We can now navigate to 'http://localhost:8080/myController' to see the results,
and test that the **'GET'** and **'POST'** methods are working as expected.

<br>

<a id="response"></a>
### Adding response to page

To send a simple request to the server that returns a response, you can do 
the following.

```java
public class Main {
    public static void main(String[] args) {

        App app = new App();
        app.addRoute("response", HttpMethod.GET);
        app.addResponseToPage("Hello word!");
        app.run();
    }
}
```
Navigate to 'http://localhost:8080/response' to see the response.


                                                    
   
   
   
   
   
   
   
   
   
   
   
   
   
   
