package jaxws.client;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import java.io.IOException;

@WebServlet(urlPatterns = "/testWSClient")
public class TestServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation =
            "http://localhost:8080/training_javaee7Web/Hello?WSDL")
    private HelloService service;

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
        outputStream.println(service.getHelloPort().sayHello("Delia"));
        outputStream.println("<body>");
        outputStream.println("</html>");
    }


}
