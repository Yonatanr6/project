package Algorithms;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import Tools.Read;
import Tools.Writer;
import Tools.wigel_mac;

//the class of algo1
 
 
 

public class Algo1 {
	
	public List<Integer> RSSI= new ArrayList<>();
	public List<Double> Latitude= new ArrayList<>();
	public List<Double> Longitude= new ArrayList<>();
	public List<Double> Altitude= new ArrayList<>();

	public List<Double> wRSSI= new ArrayList<>();
	public List<Double> wLatitude= new ArrayList<>();
	public List<Double> wLongitude= new ArrayList<>();
	public List<Double> wAltitude= new ArrayList<>();

	public List<Algo1> LocFinders = new ArrayList<>();
	public int  count=0;
	public double fLongitude, fLatitude, fAltitude;
	public double sLongitude, sLatitude, sAltitude, sRSSI;

	public String FirstSeen, Id, MAC, SSID;
	
	String path="C:\\Users\\Yoni\\git\\matala-shiran-yonatan-\\src\\Data\\output\\algo1\\algo1.csv";//output file
	
	
	public Algo1(List<wigel_mac> MAC_locs) throws FileNotFoundException {
		
		/**
		 * the main algo that clacs the approx location of the mac, wich gets list of macs
		 * @author Shiran &Yonatan
		 *
		 */
		for(int j=0;j<MAC_locs.size();j++) {
			Algo1 FindMe = new Algo1();
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

	public void WriteFile(List<Algo1> LocFinders) throws FileNotFoundException {//writer for the algo
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
	
	
	public Algo1() {

	}

	public Algo1(Read newFile, String mac) {//Secondary algo with different input

		for(int i=0;i<newFile.wifiNetworks.size();i++) 
			for(int j=0;j<newFile.wifiNetworks.get(i).MAC2.size();j++)
				if(mac.equals(newFile.wifiNetworks.get(i).MAC2.get(j))==true) {
					count++;
					RSSI.add(newFile.wifiNetworks.get(i).RSSI2.get(j));
					Latitude.add(newFile.wifiNetworks.get(i).CurrentLatitude);
					Longitude.add(newFile.wifiNetworks.get(i).CurrentLongitude);
					Altitude.add(newFile.wifiNetworks.get(i).AltitudeMeters);
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