
package toto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbInteraction {
	static Connection con;
	static String url;
	static Statement st;
 public static void connect()
 
{   //chargement pilote
	 try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	 //definition url
	 url="jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";
	 //etablir connction
	 try {
		con=DriverManager.getConnection(url,"root","test123");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 //etablir statement
	 try {
		st=con.createStatement();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	 }
 public static int MAJ(String sql)
 { int nb=0;
   try {
	nb=st.executeUpdate(sql);
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
   return nb;
 }
 public static ResultSet select (String sql)
 {    ResultSet res=null;
	 try {
		res=st.executeQuery(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return res;
 }
 public static void disconnect() {
	 try {
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
 

}
