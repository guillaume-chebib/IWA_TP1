import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns="/MyServletAsync",asyncSupported =true)
public class MyServletAsync extends HttpServlet {

    public MyServletAsync(){

    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final AsyncContext ctx = request.startAsync();
        ctx.start(() -> {
            try {
                ctx.getResponse().getWriter().print("<h1>" + "Hello World" + "</h1>");

            } catch (IOException e) {
                log("Une erreur est survenue");
            }
            ctx.complete();
        });
    }

    public void destroy() {
        // do nothing.
    }
}
