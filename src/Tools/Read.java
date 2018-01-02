package Tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import wifi_data.getID;
import wifi_data.location;
import wifi_data.wifiNetwork;
import wifi_data.wifiPoint;


public class Read {


	public 	List<location> locations= new ArrayList<location>();
	public List<wifiPoint> wifiPoints = new ArrayList<wifiPoint>();
	public List<wifiNetwork> wifiNetworks = new ArrayList<wifiNetwork>();
	
	
	public Read() throws IOException {
		/**
		 * a class that reads wiglewifi files, and creates a list of wifi scans
		 * Shiran &Yonatan
		 *
		 */

		
		
		File folder = new File("C:\\Users\\Yoni\\Documents\\EclipseProjects\\testMatala\\src\\Data\\input\\WigleWifi");//path of the files for reading
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
		    if (file.isFile()) {
		       
		  
		try  (BufferedReader br = new BufferedReader(new FileReader(file))){

			String lineRead = ""; 
			lineRead = br.readLine();
			getID ID = new getID(lineRead);
			lineRead = "";
			while ((lineRead = br.readLine()) != null) {

				if (!lineRead.contains("Type")&&!lineRead.contains("brand")&&!lineRead.contains("GSM")) {// Discourages points that are not wifi
					wifiPoint point = new wifiPoint(lineRead,ID);
					location loc= new location(point,ID);
					if(!locations.contains(loc)) 
					locations.add(loc);
					wifiPoints.add(point);	//adds point of wifi to a list
					
					
				}
			}br.close();
			
			
			}
		
			
		catch (IOException e) {
			e.printStackTrace();
		}
				
	  }
	}
		
		
		Comparator com= new Comparator<wifiPoint>(){
		public int compare(wifiPoint arg0, wifiPoint arg1) {
			 return arg0.FirstSeen.compareTo(arg1.FirstSeen);
		}

	};
	
	Comparator com1= new Comparator<location>(){
		
	public int compare(location arg0, location arg1) {
		
		 return arg0.FirstSeen.compareTo(arg1.FirstSeen);
	}
	};
	Comparator com2 = new Comparator<wifiPoint>(){
		public int compare(wifiPoint arg0, wifiPoint arg1) {
			 return arg1.RSSI-arg0.RSSI;
		}

	};
	wifiPoints.sort(com);
	wifiPoints.sort(com2);
	locations.sort(com1);
     
	for(int i=0;i<locations.size();i++) 
		for(int j=0;j<wifiPoints.size();j++)
			if((locations.get(i).FirstSeen).compareTo((wifiPoints.get(j).FirstSeen))==0&&
			(locations.get(i).Id).compareTo(wifiPoints.get(j).Id)==0&&locations.get(i).NumberOWN<10) {
				locations.get(i).NumberOWN++;
			}
		
		for(int i=0;i<locations.size();i++) {
			wifiNetwork wifiNet = new wifiNetwork();
			wifiNet.FirstSeen= locations.get(i).FirstSeen;
			wifiNet.Id= locations.get(i).Id;
			wifiNet.CurrentLatitude= locations.get(i).Lat;
			wifiNet.CurrentLongitude= locations.get(i).Lon;
			wifiNet.AltitudeMeters= locations.get(i).Alt;
			wifiNet.NumberOWN= locations.get(i).NumberOWN;
			for(int j=0;j<wifiPoints.size();j++) 
				if((locations.get(i).FirstSeen).compareTo((wifiPoints.get(j).FirstSeen))==0&&(locations.get(i).Id).compareTo(wifiPoints.get(j).Id)==0) {
				wifiNet.Channel3.add((wifiPoints.get(j).Channel));
				wifiNet.RSSI2.add((wifiPoints.get(j).RSSI));
				wifiNet.MAC2.add((wifiPoints.get(j).MAC));
				wifiNet.SSID2.add((wifiPoints.get(j).SSID));
				}	
			wifiNetworks.add(wifiNet);
		}
	
	}
	
	public Read(String path) throws IOException {
		/**
		 * a class that reads wiglewifi files, and creates a list of wifi scans
		 * Shiran &Yonatan
		 *
		 */

		
		
		File folder = new File("C:\\Users\\Yoni\\Documents\\EclipseProjects\\testMatala\\src\\Data\\input\\WigleWifi");//path of the files for reading
		File folder1 = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
		    if (file.isFile()) {
		       
		  
		try  (BufferedReader br = new BufferedReader(new FileReader(file))){

			String lineRead = ""; 
			lineRead = br.readLine();
			getID ID = new getID(lineRead);
			lineRead = "";
			while ((lineRead = br.readLine()) != null) {

				if (!lineRead.contains("Type")&&!lineRead.contains("brand")&&!lineRead.contains("GSM")) {// Discourages points that are not wifi
					wifiPoint point = new wifiPoint(lineRead,ID);
					location loc= new location(point,ID);
					if(!locations.contains(loc)) 
					locations.add(loc);
					wifiPoints.add(point);	//adds point of wifi to a list
					
					
				}
			}br.close();
			
			
			}
		
			
		catch (IOException e) {
			e.printStackTrace();
		}
				
	  }
	}
		
		
		Comparator com= new Comparator<wifiPoint>(){
		public int compare(wifiPoint arg0, wifiPoint arg1) {
			 return arg0.FirstSeen.compareTo(arg1.FirstSeen);
		}

	};
	
	Comparator com1= new Comparator<location>(){
		
	public int compare(location arg0, location arg1) {
		
		 return arg0.FirstSeen.compareTo(arg1.FirstSeen);
	}
	};
	Comparator com2 = new Comparator<wifiPoint>(){
		public int compare(wifiPoint arg0, wifiPoint arg1) {
			 return arg1.RSSI-arg0.RSSI;
		}

	};
	wifiPoints.sort(com);
	wifiPoints.sort(com2);
	locations.sort(com1);
     
	for(int i=0;i<locations.size();i++) 
		for(int j=0;j<wifiPoints.size();j++)
			if((locations.get(i).FirstSeen).compareTo((wifiPoints.get(j).FirstSeen))==0&&
			(locations.get(i).Id).compareTo(wifiPoints.get(j).Id)==0&&locations.get(i).NumberOWN<10) {
				locations.get(i).NumberOWN++;
			}
		
		for(int i=0;i<locations.size();i++) {
			wifiNetwork wifiNet = new wifiNetwork();
			wifiNet.FirstSeen= locations.get(i).FirstSeen;
			wifiNet.Id= locations.get(i).Id;
			wifiNet.CurrentLatitude= locations.get(i).Lat;
			wifiNet.CurrentLongitude= locations.get(i).Lon;
			wifiNet.AltitudeMeters= locations.get(i).Alt;
			wifiNet.NumberOWN= locations.get(i).NumberOWN;
			for(int j=0;j<wifiPoints.size();j++) 
				if((locations.get(i).FirstSeen).compareTo((wifiPoints.get(j).FirstSeen))==0&&(locations.get(i).Id).compareTo(wifiPoints.get(j).Id)==0) {
				wifiNet.Channel3.add((wifiPoints.get(j).Channel));
				wifiNet.RSSI2.add((wifiPoints.get(j).RSSI));
				wifiNet.MAC2.add((wifiPoints.get(j).MAC));
				wifiNet.SSID2.add((wifiPoints.get(j).SSID));
				}	
			wifiNetworks.add(wifiNet);
		}
	
	}
	public List<location> getlocations() {
			
			return locations;
		}
	
	public List<wifiNetwork> getWifiNetwork() {
		
		return wifiNetworks;
	}

	
public List<wifiPoint> getwifiPoints() {
		
		return wifiPoints;
	}


}
