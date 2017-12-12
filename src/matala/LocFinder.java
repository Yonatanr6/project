package matala;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
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

	List<LocFinder> LocFinders = new ArrayList<>();
	int  count=0;
	double fLongitude, fLatitude, fAltitude;
	double sLongitude, sLatitude, sAltitude, sRSSI;

	String FirstSeen, Id, MAC, SSID;
	
	String path="C:\\Users\\shira\\eclipse-workspace\\matala0\\src\\DATE\\output\\MAC_loc.csv";
	
	public LocFinder(List<MAC_loc> MAC_locs) throws FileNotFoundException {
		for(int j=0;j<MAC_locs.size();j++) {
			LocFinder FindMe = new LocFinder();
			FindMe.FirstSeen = MAC_locs.get(j).FirstSeen;
			FindMe.Id = MAC_locs.get(j).Id;
			FindMe.MAC = MAC_locs.get(j).MAC;
			FindMe.SSID = MAC_locs.get(j).SSID;

			for(int i=0;i<MAC_locs.get(j).RSSIL.size();i++) {
				FindMe.wRSSI.add( (1/ (double)(MAC_locs.get(j).RSSIL.get(i)* (double)MAC_locs.get(j).RSSIL.get(i))));
			}
			for(int i=0;i<MAC_locs.get(j).LongitudeL.size();i++) {
				FindMe.wLongitude.add((MAC_locs.get(j).LongitudeL.get(i)*FindMe.wRSSI.get(i)));
			}
			for(int i=0;i<MAC_locs.get(j).LatitudeL.size();i++) {
				FindMe.wLatitude.add((MAC_locs.get(j).LatitudeL.get(i)*FindMe.wRSSI.get(i)));
			}
			for(int i=0;i<MAC_locs.get(j).AltitudeL.size();i++) {
				FindMe.wAltitude.add((MAC_locs.get(j).AltitudeL.get(i)*FindMe.wRSSI.get(i)));
			}
			LocFinders.add(FindMe);
		}
		
		for(int j=0; j<LocFinders.size();j++) {
			
			for(int i=0;i<LocFinders.get(j).wRSSI.size();i++) 
				LocFinders.get(j).sRSSI+=LocFinders.get(j).wRSSI.get(i);
			
			for(int i=0;i<LocFinders.get(j).wLongitude.size();i++) 
				LocFinders.get(j).sLongitude+=LocFinders.get(j).wLongitude.get(i);
			
			for(int i=0;i<LocFinders.get(j).wLatitude.size();i++) 
				LocFinders.get(j).sLatitude+=LocFinders.get(j).wLatitude.get(i);
			
			for(int i=0;i<LocFinders.get(j).wAltitude.size();i++) 
				LocFinders.get(j).sAltitude+=LocFinders.get(j).wAltitude.get(i);
			
		}
			for(int i=0;i<LocFinders.size();i++) {
				
				LocFinders.get(i).fLongitude = LocFinders.get(i).sLongitude/LocFinders.get(i).sRSSI;
				LocFinders.get(i).fLatitude = LocFinders.get(i).sLatitude/LocFinders.get(i).sRSSI;
				LocFinders.get(i).fAltitude = LocFinders.get(i).sAltitude/LocFinders.get(i).sRSSI;

			}
		
		WriteFile(LocFinders);
	}

	public void WriteFile(List<LocFinder> LocFinders) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(path);
		for(int i=0;i<LocFinders.size();i++) {
			writer.print(LocFinders.get(i).FirstSeen);
			writer.print(",");
			writer.print(LocFinders.get(i).Id);
			writer.print(",");
			writer.print(LocFinders.get(i).MAC);
			writer.print(",");
			writer.print(LocFinders.get(i).SSID);
			writer.print(",");
		
		writer.print(LocFinders.get(i).fAltitude);
		writer.print(",");
		writer.print(LocFinders.get(i).fLatitude);
		writer.print(",");
		writer.print(LocFinders.get(i).fLongitude);
		
		writer.println();
		}
		writer.close();
	}
	
	
	public LocFinder() {

	}

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