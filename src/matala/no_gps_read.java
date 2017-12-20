package matala;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class no_gps_read {

	double CurrentLongitude, CurrentLatitude,  AltitudeMeters;
	int NumberOWN;
	String FirstSeen, Id;

	List<Double> RSSIList = new ArrayList<>();
	List<Integer> ChannelList = new ArrayList<>();
	List<String> MACList = new ArrayList<>();
	List<String> SSIDList = new ArrayList<>();

	List<KMLpoint> scans = new ArrayList<>();

	public no_gps_read(getID firstline) {
		Id=firstline.getId();
	}

	public no_gps_read() {

		File folder = new File("C:\\Users\\Yoni\\Downloads\\Ex2.2\\Ex2\\data\\TS1\\New folder");
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
							KMLpoint scan = new KMLpoint(ID);
							String[] split = lineRead.split(",");
							scan.FirstSeen= split[0];
							scan.Id= split[1];
							//scan.CurrentLatitude = Double.parseDouble(split[2]);
							//scan.CurrentLongitude = Double.parseDouble(split[3]);
							//scan.AltitudeMeters = Double.parseDouble(split[4]);
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
