import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Counting the views", urlPatterns = "/count")
public class CountServlet extends HttpServlet {
    private int count;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        boolean resetCount = request.getParameter("reset") != null;
        if(resetCount){
            count = 0;
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Total Count" + (count++));
    }

}
