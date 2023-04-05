import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Connection connection = Connectivity.connection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("insert into registeration values(?,?,?,?,?)");
			preparedStatement.setString(1,request.getParameter("email"));
			preparedStatement.setString(2,request.getParameter("pass"));
			preparedStatement.setString(3,request.getParameter("name"));
			preparedStatement.setString(4,request.getParameter("city"));
			preparedStatement.setInt(5,Integer.parseInt(request.getParameter("phoneno")));
			request.getRequestDispatcher("login.html").forward(request,response);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
