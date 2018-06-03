package ejb.statefull;

import ejb.statefull.remote.Cart;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TestStatefulServlet", urlPatterns = {"/testStatefulServlet"})
public class TestStatefulServlet extends HttpServlet {

    @EJB(lookup = "java:global/training_javaee7_ear_exploded/web/CartBeanStatefull!ejb.statefull.remote.Cart")
    Cart cartBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.println("<html>");
        outputStream.println("<head>");
        outputStream.println("<title>Test Statefull Servet</title>");
        outputStream.println("</head>");
        outputStream.println("<body>");
        outputStream.println("<h1>Adding/removing cart items</h1>");
        outputStream.println("<h2>Adding cart items</h2>");
        cartBean.addItem("apple");
        cartBean.addItem("pear");
        cartBean.addItem("peach");
        cartBean.addItem("orange");
        cartBean.addItem("banana");
        outputStream.println("<h2>added</h2>");
        outputStream.println("<h2>Listing cart items</h2>");
        outputStream.println(cartBean.getItems().toString());
        outputStream.println("<h2>Removing cart items</h2>");
        cartBean.removeItem("banana");
        cartBean.removeItem("orange");
        outputStream.println("<h2>removed</h2>");
        outputStream.println("<h2>Listing cart items</h2>");
        outputStream.println(cartBean.getItems().toString());
        outputStream.println("<body>");
        outputStream.println("</html>");
    }
}
