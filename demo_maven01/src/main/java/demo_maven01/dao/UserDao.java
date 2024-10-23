package demo_maven01.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import demo_maven01.dto.User;

public class UserDao 
{
	public void createTable()throws Exception
	{
		Connection connection= connectionStep();
		Statement statement=connection.createStatement();
		statement.execute("create table if not exists userDetails(id int primary key not null, name varchar(25) null,email varchar(25) unique null,pwd varchar(25) null)"); 
	}
	public Connection connectionStep() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/userDb?createDatabaseIfNotExist=true&user=root&password=root");
	}
	public boolean userLogin(String mail,String password) throws Exception
	{
		Connection connection=connectionStep();
		PreparedStatement ps=connection.prepareStatement("select email,pwd from userDetails");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			if(mail.equals(rs.getString(1)) && password.equals(rs.getString(2)))
			{
				return true;
			}
		}
		return false;
	}
	public int saveUser(User user) throws Exception
	{
		Connection connection=connectionStep();
		PreparedStatement ps=connection.prepareStatement("insert into UserDetails values(?,?,?,?)");
		ps.setInt(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getEmail());
		ps.setString(4, user.getPwd());
		return ps.executeUpdate();
	}
}
