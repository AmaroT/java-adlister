import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Bonus3", urlPatterns = "/order-summary")
public class Bonus3 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String product = req.getParameter("Product");
        String numberOf = req.getParameter("Quantity");

        out.println("<h1>The name of the product is " + product +
                "\n The number of the product is "  + numberOf + "</h1>");
    }
}
