<h1 style="color: white">API Documentation for "App" Class</h1>

'**App**' class is a part of the '**no.hiof.webframework.application**' package and represents 
the core of the application. It is responsible for managing the web server, handling HTTP requests
and integrationg a Spring Boot chatroom application. It utilizes the Singleton pattern to ensure that 
only one instance of the class exists at any given time. The class maintains a collection of routes 
and associated HTTP methods and providing methods for adding pre-built or custom HTML pages and responses 
to specific routes. It also allows for adding a custom controller for handling dynamic content and provides 
access to a user database if needed. To use the '**App**' class, call create() method to obtain an instance, 
then use the various add methods to define routes and content, and finally call the run() method to start 
the server and listen for incoming requests. The chatroom functionality is facilitated through the Spring Boot 
framework, ensuring seamless integration and efficient real-time communication between users.

<br>

## Table of contents
* [Fields](#field_section)
* [Methods](#method_section) 
    * [public static App create()](#create)  
    * [public void addRoute(String endpoint, HttpMethod httpMethod)](#addRoute)
    * [public void addHtmlPage(InputStream htmlPage)](#addHtmlPage)
    * [public void addCustomHtmlPage(String page)](#addCustomHtmlPage)
    * [public void addCustomHtmlPage(String page, UserDb userDb)](addCustomHtmlPage2)
    * [public void addResponseToPage(String response)](#addResponse)
    * [public void addController(Controller controller)](#addController)
    * [public void addChatroom(Chatroom room)](#addChatroom)
    * [public void run()](#run)
* [Tutorial introduction](#getting_started)
    * [creating a simple application with a title](#simple_application)
    * [creating default pages](#default_pages)
    * [creating custom pages](#custom_pages)
    * [creating a controller](#controller)
    * [adding response to page](#response)
    * [creating a chatroom application](#chatroomt)

<br>

<a id="field_section"></a>
## Fields

#### 'private static App instance = null'

The use of the Singleton pattern, ensuring that only one instance of the 'App' class exists at any given time.

#### 'private final Map<String, Route> routeMap = new LinkedHashMap<>()'

**'LinkedHashMap'** that maps URL endpoints to a **'Route'** object.

#### 'private final Map<String, HtmlPages> htmlPageMap = new LinkedHashMap<>()'

A **'LinkedHashMap'** that maps a HTML page title to a **'HtmlPages'** object.

#### 'private String applicationTitle'

The title of the application, this is found at route "/".

#### 'private String customPage'

A string that holds the custom HTML page.

#### 'private Chatroom chatroom'

Reference variable to a 'Chatroom' application instance.

#### 'private Controller controller'

Reference variable to a 'servlet' controller instance.

#### 'private UserDb userDb'

A user database object that can be used to get, save and delete users.

#### 'private String response'

String that is used to deliver a response to an empty page.
   
#### 'private int pageCounter = 0'

A counter used to keep track of the number of HTML pages that have been added to the **htmlPageMap**.

<br>

<a id="method_section"></a>
## Methods

<a id="create"></a>
#### 'public static App create()'

Returns one instace of the application using Singleton pattern.

<br>
   
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

<a id="addCustomHtmlPage2"></a>
#### 'public void addCustomHtmlPage(String page, UserDb userDb)'

Override previous method to also add a user database.
   
| Parameter   | Type          | Description                                                |
|:----------- |:--------------|:-----------------------------------------------------------|
| 'page'      | 'String'      | The HTML page as a string. Can be obtained from the build() <br> method in the **HtmlPageBuilder** class.| 
| 'userDb'    | 'UserDb'      | A user database instance. Can get this from the 'UserDb' class                                           |

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

<a id="addChatroom"></a>
#### 'public void addChatroom(Chatroom room)'

Adds a Spring Boot based chatroom application to the **'App'** application.

| Parameter    | Type          | Description                                              |
|:-----------  |:--------------|:---------------------------------------------------------|
| 'room'       | 'Chatroom'    | Adds a Spring Boot chatroom application to the App class |

<br>
   
<a id="run"></a>
#### 'public void run()'

Starts and runs the application. If an chatroom instance is provided it will also start and
run this on a separate **'Thread'**.

<br>

<a id="getting_started"></a>
## Tutorial introduction

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

<br>

<a id="chatroomt"></a>
### Creating a chatroom application

To create a chatroom application you can specify some of the
chatroom properties, but all of them are optional, therefore the
default values will be used if none of them are provided.

```java
public class Main {
   public static void main(String[] args) {
      
      App app = App.create();

      Chatroom.setChatMethod(ChatMethod.PRIVATE);
      Chatroom.addMessageTimeStamp(true);

      Chatroom.addDeleteMessagesButton(Options.YES);
      Chatroom.setTitle("Welcome to private chat!");

      app.addChatRoom(Chatroom.create());
      app.run();
   }
}

```

Navigate to 'http://localhost:8081/' to start chatting.
   


                                                   
   
   
   
   
   
   
   
   
   
   
   
   
