package com.ipl;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class TeamPlayerDetails {
	
	public static void main(String[] args) throws SQLException, IOException {
		try {
		Connection mycon = null;
		Statement mystat = null;
		ResultSet myrs = null;
		
		
		mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/ipl_details", "root", "Sai971999*");
		
		System.out.println("\n Connection to the Database is Successful \n");
		
		mystat = mycon.createStatement();
		
		 FileInputStream file = new FileInputStream("D:\\PlayersList.txt");
         DataInputStream in = new DataInputStream(file);
         BufferedReader br = new BufferedReader(new InputStreamReader(in));
         String str;
         ArrayList list = new ArrayList();
         while ((str = br.readLine()) != null) {
             list.add(str);
         }
         Iterator it;
         for(it = list.iterator(); it.hasNext();) {
        	 
        	 String st = it.next().toString();
        	 String[] split = st.split("\t");
        	 String teamid = "", teamname = "", playername = "", playerscore = "";
        	 for(int i=0; i<split.length; i++) {
        		 
        		 teamid = split[0];
        		 teamname = split[1];
        		 playername = split[2];
        		 
        	 }
        	 Scanner key = new Scanner(System.in);
             System.out.println("Enter the score of " + playername);
             playerscore = key.nextLine();
        	 
        	 Statement mystmt = mycon.createStatement();
        	 
        	 String create = "insert into player_table(teamid, teamname, playername, playerscore) values('" + teamid + "','" + teamname + "','" + playername +"'," + playerscore +")";
        	 
        	 mystmt.executeUpdate(create);
        
        	 myrs = mystmt.executeQuery("select * from player_table");
			
    	 	while(myrs.next()) {
    			String Teamid = myrs.getString("teamid");
    			String TeamName = myrs.getString("teamname");
    			String PlayerName = myrs.getString("playername");
 			    String PlayerScore = myrs.getString("playerscore");
        	 	}
         }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
			
	}
	}
        
         
         
         
        		 
        
         
		
         
	
	

	
