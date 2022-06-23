package JDBC_CONNECTION;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {

	public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException
	{
	
	

	try{ Class.forName("com.mysql.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Registration","root","Prism@98");
	//print menu
	System.out.println("connected");
	Scanner scan = new Scanner(System.in);
	SQLCommands SQL = new SQLCommands();
	int command;
	String input;
	boolean keepGoing = true;
	while (keepGoing == true)
	{
	printmenu();
	input = scan.nextLine();
	command = Integer.parseInt(input);

	switch(command)
	{
	case 1: SQL.add_course(conn, scan); break;
	case 2: SQL.show_courses(conn); break;
	case 0:
	System.out.println("The Session has been ended, Thank you!");
	keepGoing = false;
	conn.close(); //close database connection
	break;
	}
	}
	}
	catch (SQLException ex)
	{
	System.out.println("An error occurred when connecting to the database server.");
	ex.printStackTrace();
	}
	}
	public static void printmenu()
	{
	System.out.println();
	System.out.println("*********************************************************************");
	System.out.println("");
	System.out.println("*** ***");
	System.out.println("");
	System.out.println("*** Welcome to Online Registration System ***");
	System.out.println("");
	System.out.println("*** ***");
	System.out.println("");
	System.out.println("*********************************************************************");
	System.out.println("1. Add a course");
	System.out.println("2. Show all course");
	System.out.println("0.Quit.\n");
	System.out.println();

	System.out.println("Please choose an option");
	}
	}

	


