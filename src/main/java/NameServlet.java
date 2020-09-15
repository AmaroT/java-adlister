import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet(name = "NameServlet", urlPatterns = "/name")

// Create a servlet that returns your first and last name in a heading element to the user if navigating to ```/name```.

public class NameServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (name != null) {
            try {
                out.print("<h1>Hello " + name + "!</h1>");
            } catch (Exception e) {
                response.resetBuffer();
                out.println("<h1>Hello, World!</h1>");
            }
        } else {
            out.println("<h1>Hello, World!</h1>");
        }
    }
}
