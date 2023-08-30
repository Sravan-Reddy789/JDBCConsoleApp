package com.taashee.training.dao;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class UserDAO 
{
	public void getAllUsers()
	{
		try(
			Connection con= ConnectionFactory.getConnection();	//try vth resources
			Statement statement = con.createStatement()){
			ResultSet rs= statement.executeQuery("SELECT * from users");
			while(rs.next())
			{
				System.out.printf("%s lives in %s\n",rs.getString("name"),rs.getString("city"));
			}
			con.close();
			statement.close();
		}
		catch(SQLException throwables)
		{
			throwables.printStackTrace();
		}
	}
	public void addUser(String name,String city)
	{
		String insertQuery="INSERT INTO users (name,city) VALUES (?,?)";
		try(Connection con=ConnectionFactory.getConnection();
				PreparedStatement statement = con.prepareStatement(insertQuery))
		{
			statement.setString(1, name);
			statement.setString(2, city);
			int rowInserted=statement.executeUpdate();
			if(rowInserted>0) System.out.printf("Successfully inserted User %s",name);	
		}
		catch(SQLException throwables)
		{
			throwables.printStackTrace();
		}	
	}
	public void deleteUser(String user)
	{
		String deleteQuery="DELETE from users WHERE name=?";
		try(Connection con=ConnectionFactory.getConnection();
				PreparedStatement statement = con.prepareStatement(deleteQuery))
		{
			statement.setString(1, user);
			int updateInserted=statement.executeUpdate();
			if(updateInserted>0) System.out.printf("Successfully user deleted %s",user);

		}
		catch(SQLException throwables)
		{
			throwables.printStackTrace();
		}
	}
	public void UpdateUser(int id,String name,String city)
	{
		String updateQuery="UPDATE users SET city=? , name= ? WHERE id=?";
		try(Connection con=ConnectionFactory.getConnection();
				PreparedStatement statement = con.prepareStatement(updateQuery))
		{
			statement.setString(1, city);
			statement.setString(2, name);
			statement.setInt(3, id);
			int updateInserted=statement.executeUpdate();
			if(updateInserted>0) System.out.printf("Successfully user updated %s",name);

		}
		catch(SQLException throwables)
		{
			throwables.printStackTrace();
		}
	}
	public void getUserByName(String name)
	{
		String getUserByNameQuery="SELECT * from users WHERE name= ?";
		try(Connection con=ConnectionFactory.getConnection();
				PreparedStatement statement=con.prepareStatement(getUserByNameQuery))
		{
			statement.setString(1,name);
			ResultSet rs= statement.executeQuery();
			while(rs.next())
			{
				System.out.printf("%s lives in %s\n",rs.getString("name"),rs.getString("city"));
			}
		}
		catch(SQLException throwables)
		{
			throwables.printStackTrace();
		}
	}
	public void SearchUser(String name,String city)
	{
		String searchQuery="SELECT * FROM users WHERE name LIKE ? AND city LIKE ?";
		try(Connection con=ConnectionFactory.getConnection();
				PreparedStatement statement = con.prepareStatement(searchQuery))
		{
			statement.setString(1, "%"+name+"%");
			statement.setString(2, "%"+city+"%");
			ResultSet rs=statement.executeQuery();
			while(rs.next())
			{
				System.out.printf("%s lives in %s\n",rs.getString("name"),rs.getString("city"));
			}
			
		}
		catch(SQLException throwables)
		{
			throwables.printStackTrace();
		}
		
		
	}

}
