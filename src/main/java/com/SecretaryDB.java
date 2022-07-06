package com;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SecretaryDB {
	public static String getCourses() {
		  Connection con=DB.con(); 
		  try {
			  Statement stmt = con.createStatement();
			  ResultSet rs = stmt.executeQuery("SELECT * FROM java2db.courses");
			  StringBuilder sb = new StringBuilder();
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
	
	public static String getProfessors() {
	  	Connection con=DB.con(); 
	  	try {
		  	Statement stmt = con.createStatement();
		  	ResultSet rs = stmt.executeQuery("SELECT * FROM java2db.professors INNER JOIN java2db.users ON professors.professor_id=users.user_id");;
		  	StringBuilder sb = new StringBuilder();
			while(rs.next()) {
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				sb.append("<option>"+name+" "+surname+"</option>");
			}
			rs.close();
			con.close();
			return sb.toString();
	  	}
	  	catch(Exception e) {
	  		return "<option>An error occured</option>";
	  	}
	}
	public static String coursesProfTable() {
	  	Connection con=DB.con(); 
	  	try {
	  		Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM java2db.courses INNER JOIN java2db.users ON courses.professor_id=users.user_id ORDER BY courseyear,course_id");
		  	StringBuilder sb = new StringBuilder();
			while(rs.next()) {
				int course_id = rs.getInt("course_id");
				String courseName = rs.getString("coursename");
				int courseYear = rs.getInt("courseyear");
				int courseSemester = rs.getInt("semester");
				String profname = rs.getString("name");
				String profsurname = rs.getString("surname");
				sb.append(createHTMLRow(course_id,courseName,courseYear,courseSemester,profname,profsurname));
			}
			rs.close();
			con.close();
			return sb.toString();
	  	}
	  	catch(Exception e) {
	  		return "Database connection problem" ;
	  		}
	}
	
	public static String createHTMLRow(int cid, String cname, int cyear, int csemester
			,String pname, String psurname) {
		StringBuilder row = new StringBuilder();
		row.append("<tr>");
		row.append("<td>" + cid + "</td>");
		row.append("<td>" + cname + "</td>");
		row.append("<td>" + cyear + "</td>");
		row.append("<td>" + csemester + "</td>");
		row.append("<td>" + pname+" "+psurname+ "</td>");
		row.append("</tr>");
		return row.toString();
	}
}
