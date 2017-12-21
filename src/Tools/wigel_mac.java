package Tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import Algorithms.Algo1;
import wifi_data.getID;


public class wigel_mac {
	
	
	public String FirstSeen;
	public String Id;
	public String MAC;
	public String SSID;
	public int Channel,RSSI;
	public double Latitude,Longitude,Altitude;
	public List<Integer> RSSIL =new ArrayList<>();
	public List<Double> LatitudeL= new ArrayList<>();
	public List<Double> LongitudeL= new ArrayList<>();
	public List<Double> AltitudeL= new ArrayList<>();

	
	public List<wigel_mac> MAC_locs= new ArrayList<>();
	
	
	
	public double wLatitude, wLongitude, wAltitude;

	
	
	public wigel_mac() throws FileNotFoundException {
		/**
		 * a class that reads wiglewifi file, and creates list of macs for algo1
		 * @author Shiran &Yonatan
		 *
		 */
		
		File folder = new File("C:\\Users\\Yoni\\Documents\\EclipseProjects\\testMatala\\src\\Data\\input\\WigleWifi");
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
		    if (file.isFile()) {
		       
		  
		try  (BufferedReader br = new BufferedReader(new FileReader(file))){

			String lineRead = ""; 
			lineRead = br.readLine();
			getID ID = new getID(lineRead);
			lineRead = "";
			while ((lineRead = br.readLine()) != null) {
				if (!lineRead.contains("Type")&&!lineRead.contains("brand")&&!lineRead.contains("GSM")) {
					wigel_mac loc = new wigel_mac(ID);
					loc.Id = ID.getId();
				String[] split = lineRead.split(",");
				loc.MAC = split[0];
				loc.SSID = split[1];
				loc.FirstSeen = split[3];
				loc.Channel = Integer.parseInt(split[4]);
				loc.RSSI = (Integer.parseInt(split[5]));
				loc.Latitude = (Double.parseDouble(split[6]));
				loc.Longitude = (Double.parseDouble(split[7]));
				loc.Altitude = (Double.parseDouble(split[8]));
				
				loc.RSSIL.add(Integer.parseInt(split[5]));
				loc.LatitudeL.add(Double.parseDouble(split[6]));
				loc.LongitudeL.add(Double.parseDouble(split[7]));
				loc.AltitudeL.add(Double.parseDouble(split[8]));
				this.MAC_locs.add(loc);
				
				
				}
				
				
			}br.close();
			
			
			}
		
		
		catch (IOException e) {
			e.printStackTrace();
		}
			
	  }
	}
		

		
		for(int i=0; i<MAC_locs.size();i++) {
			
			for(int j=0; j<MAC_locs.size();j++)
			if(MAC_locs.get(i).MAC.equals(MAC_locs.get(j).MAC)&&i!=j) {
				MAC_locs.get(i).RSSIL.add(MAC_locs.get(j).RSSI);
				MAC_locs.get(i).LatitudeL.add(MAC_locs.get(j).Latitude);
				MAC_locs.get(i).LongitudeL.add(MAC_locs.get(j).Longitude);
				MAC_locs.get(i).AltitudeL.add(MAC_locs.get(j).Altitude);
				
				MAC_locs.remove(j);
			}
		}
//for(int i=0; i<MAC_locs.size();i++) {
//	MAC_locs2.add(MAC_locs.get(i));
//	for(int j=1; j<MAC_locs.size();j++)
//		if(MAC_locs.get(i).MAC.matches(MAC_locs.get(j).MAC)) {
//			MAC_locs2.get(i).RSSIL.add(MAC_locs.get(j).RSSI);
//			MAC_locs2.get(i).LatitudeL.add(MAC_locs.get(j).Latitude);
//			MAC_locs2.get(i).LongitudeL.add(MAC_locs.get(j).Longitude);
//			MAC_locs2.get(i).AltitudeL.add(MAC_locs.get(j).Altitude);
//			
//			MAC_locs.remove(j);
//			
//		}
//}
		
		
		Algo1 find = new Algo1(MAC_locs);
		
	
}


	@Override
	public String toString() {
		return "MAC_loc [FirstSeen=" + FirstSeen + ", Id=" + Id + ", MAC=" + MAC + ", SSID=" + SSID + ", Channel="
				+ Channel + ", RSSI=" + RSSI + ", Latitude=" + Latitude + ", Longitude=" + Longitude + ", Altitude="
				+ Altitude + ", RSSIL=" + RSSIL + ", LatitudeL=" + LatitudeL + ", LongitudeL=" + LongitudeL
				+ ", AltitudeL=" + AltitudeL + ", MAC_locs=" + MAC_locs + ", wLatitude=" + wLatitude + ", wLongitude="
				+ wLongitude + ", wAltitude=" + wAltitude + "]";
	}


	public String getFirstSeen() {
		return FirstSeen;
	}


	public void setFirstSeen(String firstSeen) {
		FirstSeen = firstSeen;
	}


	public String getId() {
		return Id;
	}


	public void setId(String id) {
		Id = id;
	}


	public String getMAC() {
		return MAC;
	}


	public void setMAC(String mAC) {
		MAC = mAC;
	}


	public String getSSID() {
		return SSID;
	}


	public void setSSID(String sSID) {
		SSID = sSID;
	}


	public int getChannel() {
		return Channel;
	}


	public void setChannel(int channel) {
		Channel = channel;
	}


	
	public List<wigel_mac> getMAC_locs() {
		return MAC_locs;
	}


	public void setMAC_locs(List<wigel_mac> mAC_locs) {
		MAC_locs = mAC_locs;
	}


	public double getwLatitude() {
		return wLatitude;
	}


	public void setwLatitude(double wLatitude) {
		this.wLatitude = wLatitude;
	}


	public double getwLongitude() {
		return wLongitude;
	}


	public void setwLongitude(double wLongitude) {
		this.wLongitude = wLongitude;
	}


	public double getwAltitude() {
		return wAltitude;
	}


	public void setwAltitude(double wAltitude) {
		this.wAltitude = wAltitude;
	}


	public wigel_mac(getID firstline) {
		Id=firstline.getId();
	}
	
	
}