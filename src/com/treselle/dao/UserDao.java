package com.treselle.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.treselle.bean.User;

public class UserDao {
	public static Connection getConnection(){
		Connection connection = null;
		try{
			//connecting to the mysql driver 
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","balajidev300319966");
		}
		catch(Exception e){
			System.out.println(e);
		}
		return connection;
	}
	public static int save(User u){
		int status=0;
		//handling the SqlException
		try{
			Connection con=getConnection();
			//inserting the object into the database
			PreparedStatement ps=con.prepareStatement("insert into users(name,password,email,sex,country) values(?,?,?,?,?)");
			ps.setString(1,u.getName());
			ps.setString(2,u.getPassword());
			ps.setString(3,u.getEmail());
			ps.setString(4,u.getSex());
			ps.setString(5,u.getCountry());
			status=ps.executeUpdate();
		}	
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public static int update(User u){
		int status=0;
		try{
			Connection con=getConnection();
			//updating the table users with primary key id
			PreparedStatement ps=con.prepareStatement("update users set name=?,password=?,email=?,sex=?,country=? where id=?");
			ps.setString(1,u.getName());
			ps.setString(2,u.getPassword());
			ps.setString(3,u.getEmail());
			ps.setString(4,u.getSex());
			ps.setString(5,u.getCountry());
			ps.setInt(6,u.getId());
			status=ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public static int delete(User u){
		int status=0;
		try{
			Connection con=getConnection();
			//deleting the row based on id 
			PreparedStatement ps=con.prepareStatement("delete from users where id=?");
			ps.setInt(1,u.getId());
			status=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}
	public static List<User> getAllRecords(){
		// to display all the records
		List<User> list=new ArrayList<User>();
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from users");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				User u=new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				u.setSex(rs.getString("sex"));
				u.setCountry(rs.getString("country"));
				list.add(u);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}
}
