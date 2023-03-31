import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = Connectivity.connection();
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from login where email ='"+req.getParameter("email")+"' and password='"+req.getParameter("pass")+"'");

            if(resultSet.next()){
                HttpSession session = req.getSession();
                if(resultSet.getString(3).equals("admin")){
                    session.setAttribute("user","admin");
                    req.getRequestDispatcher("admin").forward(req,resp);
                }else{
                    session.setAttribute("user",req.getParameter("email"));
                    req.getRequestDispatcher("student").forward(req,resp);
                }
            }
            else{
                out.println("wrong credential");
                req.getRequestDispatcher("login.html").include(req,resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
