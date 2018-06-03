package ejb.async;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@WebServlet(urlPatterns = {"/testAsyncServlet"})
public class TestAsyncServlet extends HttpServlet {

    @EJB
    MyClassLevelAsync classLevelAsync;

    @EJB
    MyMethodLevelAsync myMethodLevelAsync;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        processRequest(response);
    }

    public void processRequest(HttpServletResponse response) throws IOException{
        response.setContentType("text/html");
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.println("<html>");
        outputStream.println("<head>");
        outputStream.println("<title>Test lifecycle Servet</title>");
        outputStream.println("</head>");
        outputStream.println("<body>");
        outputStream.println("<h2>Adding 10 + 20</h2>");
        Future<Integer> result1 = classLevelAsync.add(10, 20);
        outputStream.println("<h2>Adding 20 + 30</h2>");
        Future<Integer> result2 = myMethodLevelAsync.add(20, 30);

        while(!result1.isDone()){

        }
        try {
            outputStream.println("First result is: " + result1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        while(!result2.isDone()){

        }

        try {
            outputStream.println("Second result is: " + result2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        outputStream.println("<body>");
        outputStream.println("</html>");
    }
}
