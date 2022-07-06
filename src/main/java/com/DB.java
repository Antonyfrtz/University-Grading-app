 package com;
 
 import java.sql.Connection;
 import java.sql.ResultSet;
 import java.sql.DriverManager;
 import java.sql.Statement;

public class DB {
	final static String DB_URL="jdbc:mysql://localhost/Mysql";
	final static String USER="root";
	final static String PASS="vaso2002";
	public static Connection con() {
		Connection con;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection(DB_URL,USER,PASS);
			return con;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
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
  				String profname = rs.getString("name");
  				String profsurname = rs.getString("surname");
  				sb.append(createHTMLRow(course_id,courseName,courseYear,profname,profsurname));
			}
			rs.close();
			con.close();
			return sb.toString();
	  	}
	  	catch(Exception e) {
	  		return "Database connection problem" ;
	  		}
	}
	
	public static String createHTMLRow(int cid, String cname, int cyear
			,String pname, String psurname) {
		StringBuilder row = new StringBuilder();
		row.append("<tr>");
		row.append("<td>" + cid + "</td>");
		row.append("<td>" + cname + "</td>");
		row.append("<td>" + cyear + "</td>");
		row.append("<td>" + pname+" "+psurname+ "</td>");
		row.append("</tr>");
		return row.toString();
	}
	
}

// Code to Encrypt all passwords in DB

/*Connection con=DB.con();
Statement stmt=con.createStatement();
ResultSet rs = stmt.executeQuery("Select * from java2db.users where salt IS NULL");
PreparedStatement p2;
while(rs.next()){
	String id=rs.getString("user_id");
	String pwd=rs.getString("hashed_password");
	String salt=Encryption.generateSalt();
	String hashed_pwd=Encryption.getHashMD5(pwd,salt);
	p2=con.prepareStatement("UPDATE java2db.users SET hashed_password=?,salt=? WHERE user_id=?;");
	p2.setString(1,hashed_pwd);
	p2.setString(2,salt);
	p2.setString(3,id);
	p2.executeUpdate();
}
rs.close();
con.close();
*/