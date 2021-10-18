package com.ipl;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class output {

	public static void main(String[] args) {
		try {
			Connection mycon = null;
			Statement mystat = null;
			ResultSet myrs = null;
			
			
			mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/ipl_details", "root", "Sai971999*");
			
			System.out.println("\n Connection to the Database is Successful \n");
			
			mystat = mycon.createStatement();
			
			FileOutputStream file = new FileOutputStream("D:\\IPL_List.txt");
	        DataOutputStream out = new DataOutputStream(file);
	        
	        
	        	myrs = mystat.executeQuery("SELECT * FROM player_table ORDER BY teamid ASC, playerscore ASC");
	        	
	        	while(myrs.next()) {
	        		String teamid = myrs.getString("teamid");
	        		String teamname = myrs.getString("teamname");
	        		String playername = myrs.getString("playername");
	        		String playerscore = myrs.getString("playerscore");
	        		
	        		String done = "\n" + teamid + " " + teamname + " " + playername + " " + playerscore;
	        		out.writeBytes(done);
	        					
	        	}
	        	System.out.println("The requested output is writen the IPL_List.txt file");

	} catch(Exception e) {
		e.printStackTrace();
	}

}
}
