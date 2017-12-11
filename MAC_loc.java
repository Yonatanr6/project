package testMatala;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MAC_loc {
	
	String FirstSeen, Id, MAC, SSID;
	int Channel;
	List<Integer> RSSI =new ArrayList<>();
	List<Double> Latitude= new ArrayList<>();
	List<Double> Longitude= new ArrayList<>();
	List<Double> Altitude= new ArrayList<>();
	
	List<MAC_loc> MAC_locs= new ArrayList<>();
	
	double wLatitude, wLongitude, wAltitude;

	
	public MAC_loc() {
		
		File folder = new File("C:\\Users\\Yoni\\Documents\\EclipseProjects\\testMatala\\src\\Data\\input");
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
		    if (file.isFile()) {
		       
		  
		try  (BufferedReader br = new BufferedReader(new FileReader(file))){

			String lineRead = ""; 
			lineRead = br.readLine();
			lineRead = "";
			while ((lineRead = br.readLine()) != null) {
				if (!lineRead.contains("Type")&&!lineRead.contains("brand")&&!lineRead.contains("GSM")) {
				String[] split = lineRead.split(",");
				MAC = split[0];
				SSID = split[1];
				FirstSeen = split[3];
				Channel = Integer.parseInt(split[4]);
				RSSI.add(Integer.parseInt(split[5]));
				Latitude.add(Double.parseDouble(split[6]));
				Longitude.add(Double.parseDouble(split[7]));
				Altitude.add(Double.parseDouble(split[8]));
				

				}
			}br.close();
			
			
			}
		
			
		catch (IOException e) {
			e.printStackTrace();
		}
				
	  }
	}
}
}