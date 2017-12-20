package matala;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KMLpoint {

	double CurrentLongitude, CurrentLatitude,  AltitudeMeters;
	int NumberOWN;
	String FirstSeen, Id;

	List<Double> RSSIList = new ArrayList<>();
	List<Integer> ChannelList = new ArrayList<>();
	List<String> MACList = new ArrayList<>();
	List<String> SSIDList = new ArrayList<>();

	List<KMLpoint> KMLpoints = new ArrayList<>();

	public KMLpoint(getID firstline) {
		Id=firstline.getId();
	}

	public KMLpoint() {

		File folder = new File("C:\\Users\\Yoni\\Downloads\\Ex2.2\\Ex2\\data\\BM1\\comb\\New folder");
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
							KMLpoint point = new KMLpoint(ID);// fix to get the right id
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
