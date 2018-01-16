package Tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Tools.*;
import Algorithms.*;
import RunMatala.*;
import tests.*;
import wifi_data.*;
import gui_.*;



public class comb_reader {

	public double CurrentLongitude, CurrentLatitude,  AltitudeMeters;
	public int NumberOWN;
	public String FirstSeen, Id;

	public List<Double> RSSIList = new ArrayList<>();
	public List<Integer> ChannelList = new ArrayList<>();
	public List<String> MACList = new ArrayList<>();
	public List<String> SSIDList = new ArrayList<>();

	public List<comb_reader> KMLpoints = new ArrayList<>();
	public List<wifiNetwork> wifiNetworks= new ArrayList<>();

	public comb_reader(getID firstline) {
		/**
		 * a class that reads comb/best files and creats a list of scans 
		 * Shiran &Yonatan
		 *
		 */
		Id=firstline.getId();
	}

	public comb_reader() {

		File folder = new File("C:\\Users\\Yoni\\git\\matala-shiran-yonatan-\\Data\\input\\comb");//path of the files for reading
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			if (file.isFile()) {


				try  (BufferedReader br = new BufferedReader(new FileReader(file))){
					

					String lineRead = ""; 
					lineRead = br.readLine();
					getID ID = new getID(lineRead);
					lineRead = "";
					while ((lineRead = br.readLine()) != null) {
						if (!lineRead.contains("Type")&&!lineRead.contains("brand")&&!lineRead.contains("FirstSeen")) {
							comb_reader point = new comb_reader(ID);// fix to get the right id
							String[] split = lineRead.split(",");
							point.FirstSeen= split[0];
							
							point.Id= split[1];
							point.CurrentLatitude = Double.parseDouble(split[2]);
							point.CurrentLongitude = Double.parseDouble(split[3]);
							point.AltitudeMeters = Double.parseDouble(split[4]);
							point.NumberOWN = Integer.parseInt(split[5]);
							
							for(int i=0;i<point.NumberOWN;i++) {
								point.SSIDList.add(split[6+i*4]);
								point.MACList.add((split[7+i*4]));
								point.ChannelList.add(Integer.parseInt(split[8+i*4]));
								point.RSSIList.add(Double.parseDouble(split[9+i*4]));
							}	
						
							
							KMLpoints.add(point);
						}


					}br.close();


				}


				catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
	}

	
	
	public comb_reader(String path) {//read comb file from specific location

		File folder = new File(path);//path of the files for reading
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			if (file.isFile()) {


				try  (BufferedReader br = new BufferedReader(new FileReader(file))){
					

					String lineRead = ""; 
					lineRead = br.readLine();
					getID ID = new getID(lineRead);
					lineRead = "";
					while ((lineRead = br.readLine()) != null) {
						if (!lineRead.contains("Type")&&!lineRead.contains("brand")&&!lineRead.contains("FirstSeen")) {
							comb_reader point = new comb_reader(ID);// fix to get the right id
							String[] split = lineRead.split(",");
							point.FirstSeen= split[0];
							
							point.Id= split[1];
							point.CurrentLatitude = Double.parseDouble(split[2]);
							point.CurrentLongitude = Double.parseDouble(split[3]);
							point.AltitudeMeters = Double.parseDouble(split[4]);
							point.NumberOWN = Integer.parseInt(split[5]);
							
							for(int i=0;i<point.NumberOWN;i++) {
								point.SSIDList.add(split[6+i*4]);
								point.MACList.add((split[7+i*4]));
								point.ChannelList.add(Integer.parseInt(split[8+i*4]));
								point.RSSIList.add(Double.parseDouble(split[9+i*4]));
							}	
						
							
							KMLpoints.add(point);
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
