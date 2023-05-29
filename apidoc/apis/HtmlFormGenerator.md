<h1 style="color: white">API Documentation for "HtmlFormGenerator" class</h1>

In order to be able to create a simple html page that should contain a html-form for logging 
in that consists of a username and password, you must use the package '**no.hiof.webframework.security**'
It contains the class **HtmlFormGenerator** with the methods **generateLoginForm()** 
and **generateHtmlPageWithLoginForm()**.


## Methods
#### 'public String generateLoginForm()'
Generate a login-form using HTML. The login-form contains input fields for password and username.

#### 'public String generateHtmlPageWithLoginForm()'
Generate HTML-page including the method 'generateLoginForm' to access the login-form.

## Tutorial introduction

##### Create a simple html page that will contain a html-form. The form consists of the following input fields with associated labels: Username and password.

Create a class that inherits from the HttpServlet class from the Java Servlet API.
Then use the doGet-method from the HttpServlet to handle GET-requests,
and write the code for the response using a PrintWriter-object.

```java
public class MyClass{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    { 
        HtmlFormGenerator pageLoginForm=new HtmlFormGenerator();
        String htmlPageContent=pageLoginForm.generateHtmlPageWithLoginForm();
    
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
                
        out.println(htmlPageContent);
    }
}
````