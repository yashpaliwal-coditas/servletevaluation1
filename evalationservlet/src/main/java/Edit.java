import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@WebServlet("/edit")
public class Edit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = Connectivity.connection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("update registeration set city='agra' where email = 'aartiii'");
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.getRequestDispatcher("profileAdmin").forward(req,resp);

    }
}
