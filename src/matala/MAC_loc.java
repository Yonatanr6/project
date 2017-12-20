package matala;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MAC_loc {
	
	String FirstSeen, Id, MAC, SSID;
	int Channel,RSSI;
	double Latitude,Longitude,Altitude;
	List<Integer> RSSIL =new ArrayList<>();
	List<Double> LatitudeL= new ArrayList<>();
	List<Double> LongitudeL= new ArrayList<>();
	List<Double> AltitudeL= new ArrayList<>();

	
	List<MAC_loc> MAC_locs= new ArrayList<>();
	
	double wLatitude, wLongitude, wAltitude;

	
	
	public MAC_loc() throws FileNotFoundException {
		
		File folder = new File("C:\\Users\\Yoni\\Documents\\EclipseProjects\\testMatala\\src\\Data\\input");
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
					MAC_loc loc = new MAC_loc(ID);
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
			
			for(int j=1; j<MAC_locs.size()-1;j++)
			if(MAC_locs.get(i).MAC.equals(MAC_locs.get(j).MAC)) {
				MAC_locs.get(i).RSSIL.add(MAC_locs.get(j).RSSI);
				MAC_locs.get(i).LatitudeL.add(MAC_locs.get(j).Latitude);
				MAC_locs.get(i).LongitudeL.add(MAC_locs.get(j).Longitude);
				MAC_locs.get(i).AltitudeL.add(MAC_locs.get(j).Altitude);
				
				MAC_locs.remove(j);
			}
		}
		
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


	
	public List<MAC_loc> getMAC_locs() {
		return MAC_locs;
	}


	public void setMAC_locs(List<MAC_loc> mAC_locs) {
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


	public MAC_loc(getID firstline) {
		Id=firstline.getId();
	}
	
	
}