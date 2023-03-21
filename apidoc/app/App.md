<h1 style="color: white">API Documentation for "App" Class</h1>

'**App**' class is a part of the '**no.hiof.webframework.Application**' package and represents 
the core application. It creates and initializes an embedded Jetty server and sets up a 
context handler with a map of routes and HTML pages.

<h2 style="color: white">Table of contents</h2>
<ul>
<li><a href="#field_section" style="color: white;">Fields</a></li>
<li>
    <a href="#" style="color: white;">Methods</a>
    <ul>
        <li><a href="#" style="color: white">public void addRoute(String endpoint, HttpMethod httpMethod)</a></li>
        <li><a href="#" style="color: white">public void addHtmlPage(InputStream htmlPage)</a></li>
        <li><a href="#" style="color: white">public void addCustomHtmlPage(String page)</a></li>
        <li><a href="#" style="color: white">public void run()</a></li>
    </ul>
</li>
</ul>

<h2 id="field_section" style="color: white">Fields</h2>

<font size="3" color="white">'private static final int PORT = 8080'</font>

The port number that the embedded Jetty server listens on.

<font size="3" color="white">'private final Map<String, Route> routeMap = new LinkedHashMap<>()'</font>

A <font color="white">'LinkedHashMap'</font> that maps URL endpoints to a <font color="white">'Route'</font> object.

<font size="3" color="white">'private final Map<String, HtmlPages> htmlPageMap = new LinkedHashMap<>()'</font>

A <font color="white">'LinkedHashMap'</font> that maps a HTML page title to a <font color="white">'HtmlPages</font> object.</font>

<font size="3" color="white">
'private String applicationTitle, loginPageTitle, homePageTitle, logoutPageTitle'
</font>

The title of the application, login page, home page, and logout page respectively.