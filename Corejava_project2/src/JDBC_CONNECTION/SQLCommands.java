package JDBC_CONNECTION;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SQLCommands {
	public void add_course(Connection conn, Scanner keyboard) throws SQLException, IOException
	{
	Statement st = conn.createStatement();
	System.out.println("Add a course");
	System.out.println("Please input course code: ");
	String courseCode = keyboard.nextLine().toUpperCase().trim();
	System.out.println("Please input course title: ");
	String courseTitle = keyboard.nextLine().trim();
	String query = "select code from Course Where code = '" + courseCode + "'";
	ResultSet rs = st.executeQuery(query);
	if (rs.next())
	{
	System.out.println("Course already exists");
	return;
	}
	query = "Insert into Course (code, title) values ('" + courseCode + "', '" + courseTitle + "')";
	try
	{
	st.executeUpdate(query);
	}
	catch (SQLException e)
	{
	System.out.println("Message: " + e.getMessage());

	}
	rs.close();
	st.close();
	System.out.println("A new course is added.");
	}

	public void show_courses(Connection conn) throws SQLException, IOException
	{

	try
	(
	Statement st = conn.createStatement();

	)
	{
	String query = "select * from Course;";
	ResultSet rs = st.executeQuery(query);
	while (rs.next())
	{
	String code = rs.getString("code");
	String title = rs.getString("title");
	System.out.println("Code: " + code + "\tTitle: " + title);
	}
	rs.close();
	st.close();
	}
	catch (SQLException e)
	{
	System.out.println("Message: " + e.getMessage());

	}
	}

	}

