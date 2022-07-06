package servletpackage;

import java.io.IOException;
import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.DB;
import java.sql.*;

/**
 * Servlet implementation class SecretaryServlet
 */
@WebServlet("/SecretaryServlet")
public class SecretaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecretaryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException {

     }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect(request.getHeader("referer"));
		//request.getRequestDispatcher("/vol3/src/main/webapp/pages/assignment.jsp").forward(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String selectedCourse=request.getParameter("courses");
		String selectedProfessor=request.getParameter("professors");
		String[] arrOfStr = selectedProfessor.split(" ");//selectedProfessor is a string that contains the combination of name and surname
		

		try {
		Connection con=DB.con();
		PreparedStatement p=con.prepareStatement("select * from java2db.users where name=(?) and surname=(?) and role='professor'");
		p.setString(1,arrOfStr[0]);
		p.setString(2,arrOfStr[1]);
		ResultSet R=p.executeQuery();

		PreparedStatement p2=con.prepareStatement("UPDATE java2db.courses SET professor_id=(?) WHERE coursename=(?)");
		p2.setString(2,selectedCourse);
		while(R.next()) {
			String prof_id=R.getString("user_id");
			p2.setString(1,prof_id);
			p2.executeUpdate();
			
		}
		R.close();
		con.close();
		response.sendRedirect("./pages/assignment.jsp?updated=true");
		}
		catch(Exception e){	
			response.sendRedirect("./pages/assignment.jsp?updated=false");
			}
	}

}