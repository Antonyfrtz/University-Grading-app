package com;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDB {
	
		  
	public  static String getCourseGrade(String studID) {
		Connection con=DB.con();
		try {
			
			 PreparedStatement p=con.prepareStatement("SELECT c.course_id,c.coursename,c.courseyear,c.semester,g.grade  FROM java2db.courses c INNER JOIN java2db.grades g ON g.course_id = c.course_id where g.student_id =(?)");
			  p.setString(1,studID);
			  ResultSet rs=p.executeQuery();
			  StringBuilder sb = new StringBuilder();
			  
			  while(rs.next()) {
				  
				    sb.append("<table class=\"center\">");
				    sb.append("<tr><th>Course Code</th><th> Course name</th><th>Year</th><th>Semester</th><th>Grade</th></tr>");
				    sb.append(createHTMLRow(rs.getInt("course_id"),rs.getString("coursename"),rs.getInt("courseyear"),rs.getInt("semester"),rs.getInt("grade")));
					sb.append("</table>");
			  		}
			  
			rs.close();
			con.close();
			return sb.toString();
		}
			  
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
			return "an error occured";
		}
	}
	
	
	
	public  static String getSemesterGrade(String studID) {
		Connection con=DB.con();
		try {
			//we select all the courses in which the student is enrolled and we order them by year
			 PreparedStatement p=con.prepareStatement("SELECT c.course_id,c.coursename,c.courseyear,c.semester,g.grade  FROM java2db.courses c INNER JOIN java2db.grades g ON g.course_id = c.course_id where g.student_id =(?) ORDER BY c.semester");
			 p.setString(1,studID);
			 ResultSet rs=p.executeQuery();
			 StringBuilder sb = new StringBuilder();
			 int currentsem=0; //a var for keeping track of current semester (in order to know when semester has changed) 
			 int sum=0; //total sum of grades per semester
			 int counter=0; //total number of enrolled courses per semester
			 float avg;
			 while(rs.next()) {
				 
				 	if(currentsem==0) { //we make the table for the first semester that student has been graded
				 		currentsem=rs.getInt("semester"); 
				 		sb.append("<br><h3 style=\"margin-left:370px;\">Semester:"+currentsem+"</h3>");
				 		sb.append("<table class=\"center\" style=\"margin-top:0px;\">");
				 		sb.append("<tr><th>Course Code</th><th> Course name</th><th>Year</th><th>Semester</th><th>Grade</th></tr>");
				 	}
				 	else if(currentsem!=rs.getInt("semester") & currentsem!=0) { 
				    	sb.append("</table>"); //finish with the table of previous semester
				    	
				    	avg=(float)sum/counter;//before changing the value of currentsem variable with the current sem we calculate the average grade
				    	sb.append("<h3 style=\"margin-left:400px;\">Average grade for semester "+currentsem+" is "+avg+"</h3>");
				    	
				    	currentsem=rs.getInt("semester");//start all over again creating a new table
				    	sum=0;
				    	counter=0;
				 		sb.append("<br><h3 style=\"margin-left:370px;\">Semester:"+currentsem+"</h3>");
				 		sb.append("<table class=\"center\" style=\"margin-top:0px;\">");
					    sb.append("<tr><th>Course Code</th><th> Course name</th><th>Year</th><th>Semester</th><th>Grade</th></tr>");
				    }
				    sb.append(createHTMLRow(rs.getInt("course_id"),rs.getString("coursename"),rs.getInt("courseyear"),rs.getInt("semester"),rs.getInt("grade")));			  		
				    sum+=rs.getInt("grade");
				    counter+=1;
				    
			 }
			 sb.append("</table>"); //finish with the last table
			 //calculate the avg for the last table
			 avg=(float)sum/counter;//before changing the value of currentsem variable with the current sem we calculate the average grade
		    	sb.append("<h3 style=\"margin-left:400px;\">Average grade for semester "+currentsem+" is "+avg+"</h3>");
			rs.close();
			con.close();
			
			return sb.toString();
		}
			  
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
			return "an error occured";
		}
	}
	
	public static String getTotalGrade(String studID){
		Connection con=DB.con();
		try{
			PreparedStatement p=con.prepareStatement("SELECT c.course_id,c.coursename,c.courseyear,c.semester,g.grade  FROM java2db.courses c INNER JOIN java2db.grades g ON g.course_id = c.course_id where g.student_id =(?) ORDER BY c.courseyear");
			 p.setString(1,studID);
			 ResultSet rs=p.executeQuery();
			 StringBuilder sb = new StringBuilder();
			 int currentyear=0;
			 int sum=0;
			 int counter=0;
			 float avg;
			 while(rs.next()) {
				 if(currentyear==0) {
				 		currentyear=rs.getInt("courseyear");
				 		sb.append("<br><h3 style=\"margin-left:370px;\">Year:"+currentyear+"</h3>");
				 		sb.append("<table class=\"center\" style=\"margin-top:0px;\">");
				 		sb.append("<tr><th>Course Code</th><th> Course name</th><th>Year</th><th>Semester</th><th>Grade</th></tr>");
				 	}
				 	else if(currentyear!=rs.getInt("courseyear") & currentyear!=0) {
						sb.append("</table>");
				    	avg=(float)sum/counter;//before changing the value of currentyear variable with the current year we calculate the average grade
				        sb.append("<h3 style=\"margin-left:400px;\">Average grade for year "+currentyear+" is "+avg+"</h3>");
						
				    	currentyear=rs.getInt("courseyear");
				    	sum=0;
				    	counter=0;
				 		sb.append("<br><h3 style=\"margin-left:370px;\">Year:"+currentyear+"</h3>");
				 		sb.append("<table class=\"center\" style=\"margin-top:0px;\">");
					    sb.append("<tr><th>Course Code</th><th> Course name</th><th>Year</th><th>Semester</th><th>Grade</th></tr>");
				    }
				    sb.append(createHTMLRow(rs.getInt("course_id"),rs.getString("coursename"),rs.getInt("courseyear"),rs.getInt("semester"),rs.getInt("grade")));	
				    sum+=rs.getInt("grade");
				    counter+=1;
			}
	    sb.append("</table>");
	    avg=(float)sum/counter;
        sb.append("<h3 style=\"margin-left:400px;\">Average grade for year "+currentyear+" is "+avg+"</h3>");
		rs.close();
		con.close();
		return sb.toString();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
			return "an error occured";
		}
	}
	
	public static String createHTMLRow(int course_id,String coursename, int courseyear,int semester ,  int grade) {
		StringBuilder row = new StringBuilder();
		row.append("<tr>");
		row.append("<td>" + course_id + "</td>");
		row.append("<td>" + coursename + "</td>");
		row.append("<td>" + courseyear + "</td>");
		row.append("<td>" + semester + "</td>");
	    if (grade==0) {row.append("<td>-</td>");}
	    else {row.append("<td>" + grade + "</td>");}
		row.append("</tr>");
		return row.toString();
	}
	
}
