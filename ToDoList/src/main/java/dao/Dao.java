package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;


import dto.User;

public class Dao {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/userdatabase?user=root&password=root");
	}
	
	public static int saveUser(User user) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("insert into user values(?,?,?,?,?,?)");
		pst.setInt(1, user.getUserid());
		pst.setString(2, user.getUsername());
		pst.setString(3, user.getUseremail());
		pst.setLong(4, user.getUsercontact());
		pst.setString(5, user.getUserpassword());
		
		pst.setBlob(6, new SerialBlob(user.getUserimage()));
		return pst.executeUpdate();
		
	}
	
	public User findByEmail(String email) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("select * from user where useremail = ?");
		pst.setString(1, email);
		ResultSet rs = pst.executeQuery();
		
		if(rs.next()) {
		Blob imageblob = rs.getBlob(6);
		byte[] image = imageblob.getBytes(1, (int) imageblob.length());
		
		User user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5),image);
		return user;
		}
		else {
			return null;
		}
	}
	 
}
