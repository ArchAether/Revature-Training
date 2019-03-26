package com.revature.JDBC;

//1. IMport Packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        // Connect to database
        String hostName = "2019trainingcode.database.windows.net"; // update me
        String dbName = "Music"; // update me
        String user = "archaether"; // update me
        String password = "BestPassword!"; // update me
        
        //2. Create a connection String
        String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
            + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
                //in String url = String.format, the jdbc:sqlserver might be different if you use a different server type

        Connection connection = null;
        try {
        	//3. Initialize Connection String
        	connection = DriverManager.getConnection(url); //Driver will analyze the type of database
        	
        	Statement statement = connection.createStatement();
        	//Create a SQL Statement
        	String sql = "insert into Music.Artist(artistName, age, activeSince, isAlive) values('Justin Beaver', 22, '2000-02-01', 1)";	//use an insert
        	statement.executeUpdate(sql);
        	//ResultSet artists = statement.executeQuery(sql);		//executeUpdate
        	
        	//while(artists.next()) {
        		//System.out.println(artists.getString("artistName")); //prints the data from the artistName column
        	//}
        	//artists.close();

        }catch(SQLException ex){	//ctrl+shift+o will import required packages
        	ex.printStackTrace();
        }
    }
}
