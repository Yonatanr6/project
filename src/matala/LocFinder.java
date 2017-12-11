package matala;


import java.util.ArrayList;
import java.util.List;

public class LocFinder {
	
	List<Integer> RSSI= new ArrayList<>();
	List<Double> Latitude= new ArrayList<>();
	List<Double> Longitude= new ArrayList<>();
	List<Double> Altitude= new ArrayList<>();
	
	List<Double> wRSSI= new ArrayList<>();
	List<Double> wLatitude= new ArrayList<>();
	List<Double> wLongitude= new ArrayList<>();
	List<Double> wAltitude= new ArrayList<>();
	
	int  count=0;
	double fLongitude, fLatitude, fAltitude;
	double sLongitude, sLatitude, sAltitude, sRSSI;
	
	public LocFinder(Writer newFile, String mac) {

		for(int i=0;i<newFile.data.wifiNetworks.size();i++) 
			for(int j=0;j<newFile.data.wifiNetworks.get(i).MAC2.size();j++)
     		if(mac.equals(newFile.data.wifiNetworks.get(i).MAC2.get(j))==true) {
     			count++;
     			RSSI.add(newFile.data.wifiNetworks.get(i).RSSI2.get(j));
     			Latitude.add(newFile.data.wifiNetworks.get(i).CurrentLatitude);
     			Longitude.add(newFile.data.wifiNetworks.get(i).CurrentLongitude);
     			Altitude.add(newFile.data.wifiNetworks.get(i).AltitudeMeters);
     		}
		
		
		for(int i=0;i<count;i++) {
			wRSSI.add( (1/ (double)(RSSI.get(i)* (double)RSSI.get(i))));
		}
		for(int i=0;i<count;i++) {
			wLongitude.add((Longitude.get(i)*wRSSI.get(i)));
		}
		for(int i=0;i<count;i++) {
			wLatitude.add((Latitude.get(i)*wRSSI.get(i)));
		}
		for(int i=0;i<count;i++) {
			wAltitude.add((Altitude.get(i)*wRSSI.get(i)));
		}
		
		
		for(int i=0;i<count;i++) {
			sRSSI+=wRSSI.get(i);
		}
		for(int i=0;i<count;i++) {
			sLongitude+=wLongitude.get(i);
		}
		for(int i=0;i<count;i++) {
			sLatitude+=wLatitude.get(i);
		}
		for(int i=0;i<count;i++) {
			sAltitude+=wAltitude.get(i);
		}
		
		fLongitude=sLongitude/sRSSI;
		fLatitude=sLatitude/sRSSI;
		fAltitude=sAltitude/sRSSI;
		

}

	public double getfAltitude() {
		return fAltitude;
	}

	public double getfLongitude() {
		return fLongitude;
	}

	public double getfLatitude() {
		return fLatitude;
	}

	
	
}