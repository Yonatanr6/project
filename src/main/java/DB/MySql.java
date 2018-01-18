package DB;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.*;


import Tools.*;
import wifi_data.wifiNetwork;

import java.sql.*;

public class MySql {
	  private static String _url = "";
	  private static String _user = "";
	  private static String _password = "";
	  private static Connection _con = null;
	  private static ResultSet update;
     
   public static void main(String[] args) {
  
 
   }
    
   
   public static void getTable(Read data, String url, String user,String password) {
       Statement st = null;
       ResultSet rs = null;
   _url=url;
   _user=user;
   _password=password;
       try {     
           _con = DriverManager.getConnection(url+"?autoReconnect=true&useSSL=false", user, password);
           st = _con.createStatement();
           update= st.executeQuery("SELECT UPDATE_TIME FROM information_schema.tables WHERE TABLE_SCHEMA = 'oop_course_ariel' AND TABLE_NAME = 'ex4_db'");
          rs= st.executeQuery("select * from oop_course_ariel.ex4_db");
          
           while(rs.next()) {
        	   wifiNetwork wifiNet = new wifiNetwork();
        	   wifiNet.FirstSeen= rs.getString("time");
				wifiNet.Id= rs.getString("device");
				wifiNet.CurrentLatitude = rs.getDouble("lat");
				wifiNet.CurrentLongitude = rs.getDouble("lon");
				wifiNet.AltitudeMeters = rs.getDouble("alt");
				wifiNet.NumberOWN = rs.getInt("number_of_ap");

				for(int i=0;i<wifiNet.NumberOWN;i++) {
					wifiNet.MAC2.add(rs.getString(6+i*2));
					wifiNet.RSSI2.add((int) rs.getDouble(7+i*2));
					wifiNet.SSID2.add("null");
					wifiNet.Channel3.add(0);
					}	


				data.wifiNetworks.add(wifiNet);
				
          
           
           }
           data.wifiPoints.sort(data.com);
   		data.wifiPoints.sort(data.com2);
       } catch (SQLException ex) {
           Logger lgr = Logger.getLogger(MySql.class.getName());
           lgr.log(Level.SEVERE, ex.getMessage(), ex);
       } finally {
           try {
               if (rs != null) {rs.close();}
               if (st != null) { st.close(); }
               if (_con != null) { _con.close();  }
           } catch (SQLException ex) {
               
               Logger lgr = Logger.getLogger(MySql.class.getName());
               lgr.log(Level.WARNING, ex.getMessage(), ex);
           }
       }
   }
   
   public static void getTableUpdate(Read data) {
       Statement st = null;
       ResultSet rs = null;
  
       try {     
           _con = DriverManager.getConnection(_url+"?autoReconnect=true&useSSL=false", _user, _password);
           st = _con.createStatement();
           update= st.executeQuery("SELECT UPDATE_TIME FROM information_schema.tables WHERE TABLE_SCHEMA = 'oop_course_ariel' AND TABLE_NAME = 'ex4_db'");
          rs= st.executeQuery("select * from oop_course_ariel.ex4_db");
          
           while(rs.next()) {
        	   wifiNetwork wifiNet = new wifiNetwork();
        	   wifiNet.FirstSeen= rs.getString("time");
				wifiNet.Id= rs.getString("device");
				wifiNet.CurrentLatitude = rs.getDouble("lat");
				wifiNet.CurrentLongitude = rs.getDouble("lon");
				wifiNet.AltitudeMeters = rs.getDouble("alt");
				wifiNet.NumberOWN = rs.getInt("number_of_ap");

				for(int i=0;i<wifiNet.NumberOWN;i++) {
					wifiNet.MAC2.add(rs.getString(6+i*2));
					wifiNet.RSSI2.add((int) rs.getDouble(7+i*2));
					wifiNet.SSID2.add("null");
					wifiNet.Channel3.add(0);
					}	


				data.wifiNetworks.add(wifiNet);
				
          
           
           }
           data.wifiPoints.sort(data.com);
   		data.wifiPoints.sort(data.com2);
       } catch (SQLException ex) {
           Logger lgr = Logger.getLogger(MySql.class.getName());
           lgr.log(Level.SEVERE, ex.getMessage(), ex);
       } finally {
           try {
               if (rs != null) {rs.close();}
               if (st != null) { st.close(); }
               if (_con != null) { _con.close();  }
           } catch (SQLException ex) {
               
               Logger lgr = Logger.getLogger(MySql.class.getName());
               lgr.log(Level.WARNING, ex.getMessage(), ex);
           }
       }
   }
   
   
   public static boolean CheckIfUpToDate() {
		Connection c;
		try {
			c = DriverManager.getConnection(_url, _user, _password);
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery("SELECT UPDATE_TIME FROM information_schema.tables WHERE TABLE_SCHEMA = 'oop_course_ariel' AND TABLE_NAME = 'ex4_db'");
			if(r!=update) {
					return true;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
   
}
