 package com;
 
 import java.sql.Connection;
 import java.sql.DriverManager;


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