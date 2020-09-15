import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserForm", urlPatterns = "/order-form")
public class UserForm extends HttpServlet{
    protected void doPOST(HttpServletRequest req, HttpServletResponse res) throws IOException{
        res.setContentType("text/html");
        res.setHeader("content-type","text/html");
        PrintWriter out = res.getWriter();

        out.println("<form action = \"order-summary\" method= \"POST \"> " +
                "Product:<input type=text name=\"Product\"/><br/><br/> \n" +
                "Quantity:<input type=text name=\"Quantity\"/><br/><br/> \n" +
                "<input type=\"submit\" value=\"submit\"/> \n" +
                "\n" +
                "</form>");

    }
}
