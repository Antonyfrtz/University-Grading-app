package servletpackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DB;
import java.sql.*;

/**
 * Servlet implementation class ProfessorGradingServlet
 */
@WebServlet("/ProfessorGradingServlet")
public class ProfessorGradingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfessorGradingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String courseName=request.getParameter("courseInput");
		Connection con=DB.con();
		try {
			  //FIND COURSE ID
			  int cID=0;
			  PreparedStatement p1=con.prepareStatement("SELECT course_id FROM java2db.courses WHERE coursename=(?)");
		      p1.setString(1,courseName);
			  ResultSet rs1=p1.executeQuery();
			  while(rs1.next()) {
				  cID=rs1.getInt("course_id");
				  }
			  PreparedStatement p= con.prepareStatement("SELECT user_id,name,surname FROM java2db.users WHERE java2db.users.user_id IN (SELECT g.student_id FROM java2db.grades g INNER JOIN java2db.courses c ON g.course_id=c.course_id WHERE c.coursename=(?))");
		      p.setString(1,courseName);
			  ResultSet rs=p.executeQuery();
			  StringBuilder sb = new StringBuilder();

			  while(rs.next()) {
				    String sID=rs.getString("user_id");
				    System.out.println(sID);
				    int grade=Integer.parseInt(request.getParameter(sID));
				    System.out.println(grade);
				    PreparedStatement p3=con.prepareStatement("UPDATE java2db.grades SET grade=(?) WHERE course_id=(?) AND student_id=(?); ");
					p3.setInt(1, grade);
				    p3.setInt(2, cID);
					p3.setString(3, sID);
					p3.executeUpdate();
			  }

			  rs.close();
		      con.close();
		      //request.setAttribute("postback", sampleValue);
			  response.sendRedirect("./pages/Professor/grading.jsp?postback=true");
		}
		catch(Exception e) {
			
		}
	}

}
