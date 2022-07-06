package servletpackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.DB;
import java.sql.*;
import com.Encryption;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String user=request.getParameter("username");
		String pwd=request.getParameter("password");
        
		try {
		Connection con=DB.con();
		PreparedStatement p1=con.prepareStatement("select * from java2db.users where user_id=(?)");
		p1.setString(1, user);
		ResultSet rs1=p1.executeQuery();

		if(rs1.next()){
			String salt=rs1.getString("salt"); //we found the saved salt for the given username
			String hashed_password=rs1.getString("hashed_password");
			String calculatedMD5=Encryption.getHashMD5(pwd,salt);
			if(hashed_password.equals(calculatedMD5)){
				System.out.println("user::"+user);
				System.out.println("success");
				response.sendRedirect("./pages/allcourses.jsp?username="+user);
			}
			else{
				response.sendRedirect("./pages/login.jsp?nologin=true");
			}
		}
		else{
			response.sendRedirect("./pages/login.jsp?nologin=true");
			}
		rs1.close();
		con.close();
		}
		catch(Exception e) {
			response.sendRedirect("./pages/default.html");
		}
	}

}
