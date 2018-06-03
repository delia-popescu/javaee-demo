package ejb.messageDrivenBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/testMDBServlet")
public class TestMDBServlet extends HttpServlet {

    @EJB
    private MessageClient messageClient;

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
        outputStream.println("<h1>Sending messages...</h1>");
        messageClient.sendMessages();
        outputStream.println("<h1>Messages sent</h1>");
        outputStream.println("<body>");
        outputStream.println("</html>");
    }

}
