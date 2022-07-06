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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String name=request.getParameter("name");
		String surname=request.getParameter("surname");
		String role=request.getParameter("role");

		String salt=Encryption.generateSalt();
		String hashed_pwd=Encryption.getHashMD5(pwd,salt);

		try {
		Connection con=DB.con();
		PreparedStatement p1=con.prepareStatement("insert into java2db.users (user_id, hashed_password, role, name, surname, salt) values (?,?,?,?,?,?); ");
		p1.setString(1, user);
		p1.setString(2,hashed_pwd);
		p1.setString(3,role.toLowerCase());
		p1.setString(4,name);
		p1.setString(5,surname);
		p1.setString(6,salt);
		p1.executeUpdate();

		PreparedStatement p2;
		if(role.equals("Student"))	p2=con.prepareStatement("insert into java2db.students(student_id) values (?);");
		else if(role.equals("Professor")) p2=con.prepareStatement("insert into java2db.professors(professor_id) values (?);");
		else{	p2=con.prepareStatement("insert into java2db.secretaries(secretary_id) values (?);");}
		p2.setString(1,user);
		p2.executeUpdate();

		con.close();
		response.sendRedirect("./pages/allcourses.jsp?username="+user);
		}
		catch(Exception e) {
			response.sendRedirect("./pages/default.html");
		}
	}
}
