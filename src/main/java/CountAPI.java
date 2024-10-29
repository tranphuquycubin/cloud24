
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Admin
 */
@WebServlet(urlPatterns = {"/count_roles"})
public class CountAPI extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(resp.getOutputStream(), "UTF-8"));

        try {
            Connection con = Configuration.getDBConnection();

            PreparedStatement st = con.prepareStatement("SELECT COUNT(ID) as count FROM Role");
            ResultSet rs = st.executeQuery();

            int count = 0;

            if (rs.next()) {
                count = rs.getInt("count");

            }

            resp.setContentType("text/plain");
            resp.setStatus(200);
            writer.write(Integer.toString(count));
            writer.flush();
            writer.close();
        } catch (Exception ex) {
            //Logger.getLogger(CountAPI.class.getName()).log(Level.SEVERE, null, ex);
            resp.setContentType("text/plain");
            resp.setStatus(500);
            writer.write(ex.toString());
            writer.flush();
            writer.close();
        }
    }
}
