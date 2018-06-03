package ejb.lifecycle;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/testLifecycleServlet")
public class MyLifecycleServlet extends HttpServlet {

    @EJB
    MyStatefulBean statefulBean;

    @EJB
    MyStatelessBean statelessBean;


}
