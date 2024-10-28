

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.LocalTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/time"})
public class TimeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;  


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalTime currentTime = LocalTime.now(); 
        String time = currentTime.getHour() + ":" + String.format("%02d", currentTime.getMinute());

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(resp.getOutputStream(), "UTF-8"));

        resp.setContentType("text/plain");
        resp.setStatus(200);
        writer.write(time); 
        writer.flush();
        writer.close();
    }
}