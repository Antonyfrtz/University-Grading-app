package com;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class ProfessorDB {
	public static String getCourses(String profId) {
		  Connection con=DB.con(); 
		  try {
			  PreparedStatement p=con.prepareStatement("SELECT * FROM java2db.courses WHERE professor_id=(?)");
			  p.setString(1,profId);
			  ResultSet rs=p.executeQuery();
			  StringBuilder sb = new StringBuilder();
			  sb.append("<option style=\"display:none;\"></option>");
			  while(rs.next()) {
					String courseName = rs.getString("coursename");
					sb.append("<option>"+courseName+"</option>");
			  }
			  rs.close();
		      con.close();
			  return sb.toString();
		  }
		  catch(Exception e) {
			  return "<option>An error occured</option>";
		  }
	}
	
	
	public static String getCourseStud(String courseName) {
		Connection con=DB.con();
		try {
		      PreparedStatement p= con.prepareStatement("SELECT user_id,name,surname FROM java2db.users WHERE java2db.users.user_id IN (SELECT g.student_id FROM java2db.grades g INNER JOIN java2db.courses c ON g.course_id=c.course_id WHERE c.coursename=(?) AND g.grade is null)");
			  p.setString(1,courseName);
			  ResultSet rs=p.executeQuery();
			  StringBuilder sb = new StringBuilder();

			  while(rs.next()) {
				  String uID=rs.getString("user_id");
					  sb.append("<tr><td>"+uID+"</td> <td>"+rs.getString("name")+"</td> <td>"+rs.getString("surname")
				      +"</td> <td><input type=\"text\" class=\"fields\" id=\""+uID+"\" name=\""+uID+"\" pattern=\"[0-9]|10\" maxlength=\"2\"></td></tr>");			  
			  }

			  rs.close();
		      con.close();
			  return sb.toString();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		return "";
		}
	}
	
	
	public static String getGradesTable(String profID) {
		Connection con=DB.con();
		try {
			PreparedStatement p= con.prepareStatement("SELECT course_id,coursename FROM java2db.courses WHERE courses.professor_id=(?)");
			  p.setString(1,profID);
			  ResultSet rs=p.executeQuery();
			  ResultSet rs2;
			  StringBuilder sb = new StringBuilder();
			  while(rs.next()) {
				    int cid=rs.getInt("course_id");
				    sb.append("<table class=\"center\"><tr><td><b>"+rs.getString("coursename")+"</b></td></tr>");
				    sb.append("<tr><td>Student Id</td><td>Name<td>Surname</td><td>Grade</td></td></tr>");
				    p= con.prepareStatement ("SELECT user_id,name,surname,grade FROM java2db.grades g INNER JOIN java2db.users u ON g.student_id=u.user_id WHERE g.course_id=(?) AND g.grade is not null");
					p.setInt(1,cid);	
					rs2=p.executeQuery();

					while(rs2.next()) {
						sb.append(createHTMLRow(rs2.getString("user_id"),rs2.getString("name"),rs2.getString("surname"),rs2.getInt("grade")));
					}
					  rs2.close();
					  sb.append("</table>");
			  }
			  
			  rs.close();
		      con.close();
			  return sb.toString();
		}
		catch(Exception e) {
            e.printStackTrace();
            
            // Prints what exception has been thrown
            System.out.println(e);
            return "an error occured";
		}
		
	}
		public static String createHTMLRow(String user_id, String name, String surname , int grade) {
		StringBuilder row = new StringBuilder();
		row.append("<tr>");
		row.append("<td>" + user_id + "</td>");
		row.append("<td>" + name + "</td>");
		row.append("<td>" + surname + "</td>");
		row.append("<td>" + grade + "</td>");
		row.append("</tr>");
		return row.toString();
	}
}
