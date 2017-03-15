package Dao;

import Beans.*;

import Dao.DbConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import java.sql.*;


public class DbConnectionSubscription {
	
	public void setInDb(SubscriptionOrderBean myClass) throws Exception{
		
		Connection con = DbConnection.getConnection();
		System.out.println("in dao");
		
		String uuid,baseUrl,firstName,accountIdentifier;
		
		uuid = myClass.getCreator().getUuid();
		baseUrl = myClass.getMarketplace().getBaseUrl();
		accountIdentifier = null;
		firstName = myClass.getCreator().getFirstName();
		
		String query = "Insert into Subscription values(?,?,?,?)";
		
		PreparedStatement pstmt = (PreparedStatement)con.prepareStatement(query);
		pstmt.setString(1, uuid);
		pstmt.setString(2, baseUrl);
		pstmt.setString(3, firstName);
		pstmt.setString(4,accountIdentifier);
		
		int resultset  = pstmt.executeUpdate();
	}
	
	public void getFromDb(SubscriptionOrderBean myClass) throws Exception{
		Connection con = DbConnection.getConnection();
		System.out.println("in dao");
		
		String uuid,baseUrl,firstName,accountIdentifier;
		
		uuid = myClass.getCreator().getUuid();
		baseUrl = myClass.getMarketplace().getBaseUrl();
		accountIdentifier = null;
		firstName = myClass.getCreator().getFirstName();
		
		String query = "Delete from Subscription where uuid = ?";
		
		PreparedStatement prepareStatement = null;
			
			prepareStatement.setString(1, uuid); 
		
	       int resultSet = prepareStatement.executeUpdate();
	      
	       System.out.println("User removed Successfully");
	}
}
