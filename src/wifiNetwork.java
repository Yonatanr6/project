


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class wifiNetwork {

	
	double CurrentLongitude, CurrentLatitude,  AltitudeMeters;
	int RSSI, Channel,NumberOWN;
	String  SSID, MAC, FirstSeen, Id;
	
	
	List<Integer> RSSI2= new ArrayList<>();
	List<Integer> Channel3= new ArrayList<>();
	List<String> SSID2= new ArrayList<>();
	List<String> MAC2= new ArrayList<>();
	List<wifiNetwork> wifiNetworks= new ArrayList<>();


	@Override
	public String toString() {
		return FirstSeen +","+ Id +","+ CurrentLatitude +","+ CurrentLongitude +","+ AltitudeMeters
				+","+ NumberOWN +","+ SSID2.toString() +","+ MAC2.toString() + ","+ Channel3.toString() + ","+ RSSI2.toString()
				;
	}


	public void setChannel3(int channel3) {
		Channel3.add( channel3);
	}
	
	
	public double getCurrentLongitude() {
		return CurrentLongitude;
	}




	public void setCurrentLongitude(double currentLongitude) {
		CurrentLongitude = currentLongitude;
	}




	public double getCurrentLatitude() {
		return CurrentLatitude;
	}




	public void setCurrentLatitude(double currentLatitude) {
		CurrentLatitude = currentLatitude;
	}




	public double getAltitudeMeters() {
		return AltitudeMeters;
	}




	public void setAltitudeMeters(double altitudeMeters) {
		AltitudeMeters = altitudeMeters;
	}




	public int getRSSI() {
		return RSSI;
	}




	public void setRSSI(int rSSI) {
		RSSI = rSSI;
	}




	public int getChannel() {
		return Channel;
	}




	public void setChannel(int channel) {
		Channel = channel;
	}




	public int getNumberOWN() {
		return NumberOWN;
	}




	public void setNumberOWN(int numberOWN) {
		NumberOWN = numberOWN;
	}




	public String getSSID() {
		return SSID;
	}




	public void setSSID(String sSID) {
		SSID = sSID;
	}




	public String getMAC() {
		return MAC;
	}




	public void setMAC(String mAC) {
		MAC = mAC;
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

	public wifiNetwork(List<location> locations, List<wifiPoint> wifiPoints ) {
		
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
	
	public List<wifiNetwork> getWifiNetwork() {
		return wifiNetworks;
	}
	
	public wifiNetwork(String id2, String firstSeen2, double lon, double lat, double alt, int rssi2, int channel2,
			String ssid2, String mac2, int numberOWN2) {
		
		CurrentLongitude = lon;
		CurrentLatitude = lat;
		AltitudeMeters = alt;
		RSSI = rssi2;
		Channel = channel2;
		SSID = ssid2;
		MAC = mac2;
		FirstSeen = firstSeen2;
		Id = id2;
		NumberOWN = numberOWN2;
	}


	public wifiNetwork() {
		// TODO Auto-generated constructor stub
	}
		

}
