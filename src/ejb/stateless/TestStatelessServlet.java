package ejb.stateless;

import ejb.stateless.remote.Hello;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ejb.stateless.TestStatelessServlet", urlPatterns = {"/testStatelessServlet"})
public class TestStatelessServlet extends HttpServlet {

    @EJB
    Hello statelessSessionBean;

    @EJB
    AccountSessionBean accountSessionBean;

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
        outputStream.println(statelessSessionBean.hello());
        outputStream.println("<br/>");
        outputStream.println(accountSessionBean.deposit(5.0f));
        outputStream.println("<br/>");
        outputStream.println(accountSessionBean.deposit(2.0f));
        outputStream.println("<br/>");
        outputStream.println(accountSessionBean.withdraw(3.0f));
        outputStream.println("<br/>");
        outputStream.println("Account balance is: " + accountSessionBean.getAmount());
        outputStream.println("<body>");
        outputStream.println("</html>");
    }
}
