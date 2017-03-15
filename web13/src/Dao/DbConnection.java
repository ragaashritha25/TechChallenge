package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {


public static Connection getConnection() throws SQLException,ClassNotFoundException {
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=null;
    con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/TechChallenge","root","password");

    System.out.println("Connected to Database ");
     return con;

	}
}

