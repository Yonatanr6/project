package Tools;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import wifi_data.getID;


public class no_gps_read {
	
	public double CurrentLongitude, CurrentLatitude,  AltitudeMeters;
	public int NumberOWN;
	public String FirstSeen, Id;

	public List<Double> RSSIList = new ArrayList<>();
	public List<Integer> ChannelList = new ArrayList<>();
	public List<String> MACList = new ArrayList<>();
	public List<String> SSIDList = new ArrayList<>();

	public List<comb_reader> scans = new ArrayList<>();

	public no_gps_read(getID firstline) {
		/**
		 * a class that reads no gps file, and creates a list for algo2 
		 *  Shiran &Yonatan
		 *
		 */

		Id=firstline.getId();
	}

	public no_gps_read() {

		File folder = new File("C:\\Users\\Yoni\\Documents\\EclipseProjects\\testMatala\\src\\Data\\input\\no_gps");//path for the files for reading
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
							comb_reader scan = new comb_reader(ID);
							String[] split = lineRead.split(",");
							scan.FirstSeen= split[0];
							scan.Id= split[1];
							
							scan.NumberOWN = Integer.parseInt(split[5]);
							for(int i=0;i<scan.NumberOWN;i++) {
								scan.SSIDList.add(split[6+i*4]);
								scan.MACList.add((split[7+i*4]));
								scan.ChannelList.add(Integer.parseInt(split[8+i*4]));
								scan.RSSIList.add(Double.parseDouble(split[9+i*4]));
							}	
						
							
							scans.add(scan);
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
