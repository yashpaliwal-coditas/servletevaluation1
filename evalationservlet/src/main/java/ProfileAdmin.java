import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
@WebServlet("/profileAdmin")
public class ProfileAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        out.println("<h1> All Details<h1>");
        try {
            Connection connection = Connectivity.connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from registeration");
            out.println("<table border='solid'>");
            while (resultSet.next()) {
                out.println("<tr>");
                out.println("<td>" + resultSet.getString(1) + "</td><td>" + resultSet.getString(3) + "</td><td>" + resultSet.getString(4) + "</td><td>" + resultSet.getInt(5) + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("<a href='edit'>edit</a>");
            out.println("<a href='delete'>delete</a>");
            out.println("<a href='add'>delete</a>");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}