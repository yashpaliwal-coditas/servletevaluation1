import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/hello")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = Connectivity.connection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select email,password from registeration where email ='"+req.getParameter("email")+"' and password='"+req.getParameter("pass")+"'");
            if(resultSet.next()){

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
