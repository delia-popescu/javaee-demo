package cdi.beans;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/testCDIServlet")
public class TestServlet extends HttpServlet {

    private Greeting greeting;

    @Inject
    List<String> greetings;

    @Inject
    public void setGreeting(@Named("simple") Greeting greeting){
        this.greeting = greeting;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(response);
    }

    public void processRequest(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.println("<!DOCTYPE HTML>");
        outputStream.println("<html>");
        outputStream.println("<head>");
        outputStream.println("<title>Test Servlet</title>");
        outputStream.println("</head>");
        outputStream.println("<body>");
        greeting.greet("Tudor");
        outputStream.println("<h1>Greeting!</h1>");
        outputStream.println("<h1>" + greetings + "</h1>");
        outputStream.println("<body>");
        outputStream.println("</html>");
    }
}
