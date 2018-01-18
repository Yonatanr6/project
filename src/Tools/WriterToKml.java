package Tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Tools.*;
import Algorithms.*;
import tests.*;
import wifi_data.*;
import gui_.*;
import main.*;



public class WriterToKml {
	
	
	public WriterToKml(Read data) throws IOException {
		/**
		 *  a class that creates kml file, the class is not completed due to project restart and lack of time
		 * @author Shiran &Yonatan
		 *
		 */
		
		 File file = new File("C:\\Users\\Yoni\\git\\matala-shiran-yonatan-\\Data\\output\\KML\\kmalMap.kml");
	      
	      file.createNewFile();
	      
	      PrintWriter writer = new PrintWriter(file); 
		 writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
				"<kml xmlns=\"http://www.opengis.net/kml/2.2\"><Document><Style id=\"red\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href></Icon></IconStyle></Style><Style id=\"yellow\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href></Icon></IconStyle></Style><Style id=\"green\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href></Icon></IconStyle></Style><Folder><name>Wifi Networks</name>");
		
		 for(int i=0;i<data.wifiNetworks.size();i++) {
			 for(int j=0;j<data.wifiNetworks.get(i).NumberOWN;j++) {
			 writer.println("<Placemark>");
				writer.println("<name>"+"<![CDATA["+data.wifiNetworks.get(i).SSID2.get(j)+"]]>"+"</name>");
				writer.println("<description>"+"<![CDATA[MAC: "+"<b>"+data.wifiNetworks.get(i).MAC2.get(j)+"</b>"+"<br/>"
						+"RSSI:"+"<b>"+data.wifiNetworks.get(i).RSSI2.get(j)+"</b>"+"<br/>"+
						"Channel:"+"<b>"+data.wifiNetworks.get(i).Channel3.get(j)+"</b>"+"<br/>"+
						"First seen:"+"<b>"+data.wifiNetworks.get(i).FirstSeen+"</b>"+"<br/>"+				
						"]]>"+"</description>");
				writer.println("<Point>"+"<coordinates>"+data.wifiNetworks.get(i).CurrentLongitude+","+data.wifiNetworks.get(i).CurrentLatitude+"</coordinates>"+"</Point>");
				writer.println("</Placemark>");
			}
		 }
		
			writer.println("</Folder>"+"</Document>"+"</kml>");
			
			writer.close();

	
		 
		 
	}		
}
