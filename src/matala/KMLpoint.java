package matala;

public class KMLpoint {
	
	double CurrentLongitude, CurrentLatitude,  AltitudeMeters;
	int NumberOWN;
	int RSSI, RSSI2, RSSI3, RSSI4, RSSI5, RSSI6, RSSI7, RSSI8, RSSI9, RSSI10;
	int Channel, Channel2, Channel3, Channel4, Channel5, Channel6, Channel7, Channel8, Channel9, Channel10;
	String  SSID, SSID2, SSID3, SSID4, SSID5, SSID6, SSID7, SSID8, SSID9, SSID10;
	String MAC, MAC2, MAC3, MAC4, MAC5, MAC6, MAC7, MAC8, MAC9, MAC10;
	String FirstSeen, Id;
	
	public KMLpoint(String line) {
		
		String[] split = line.split(",");
		FirstSeen = split[0];
		Id = split[1];
		CurrentLatitude =Double.parseDouble(split[2]);
		CurrentLongitude = Double.parseDouble(split[3]);
		AltitudeMeters = Double.parseDouble(split[4]);
		NumberOWN = Integer.parseInt(split[5]);
		SSID = split[6];
		MAC = split[7];
		Channel = Integer.parseInt(split[8]);
		RSSI = Integer.parseInt(split[9]);
		
		SSID2 = split[11];
		MAC2 = split[12];
		Channel2 = Integer.parseInt(split[13]);
		RSSI2 = Integer.parseInt(split[14]);
		
		SSID3 = split[16];
		MAC3 = split[17];
		Channel3 = Integer.parseInt(split[18]);
		RSSI3 = Integer.parseInt(split[19]);
		
		SSID4 = split[21];
		MAC4 = split[22];
		Channel4 = Integer.parseInt(split[23]);
		RSSI4 = Integer.parseInt(split[24]);
		
		SSID5 = split[26];
		MAC5 = split[27];
		Channel5 = Integer.parseInt(split[28]);
		RSSI5 = Integer.parseInt(split[29]);
		
		SSID6 = split[31];
		MAC6 = split[32];
		Channel6 = Integer.parseInt(split[33]);
		RSSI6 = Integer.parseInt(split[34]);
		
		SSID7 = split[36];
		MAC7 = split[37];
		Channel7 = Integer.parseInt(split[38]);
		RSSI7 = Integer.parseInt(split[39]);
		
		SSID8 = split[41];
		MAC8 = split[42];
		Channel8 = Integer.parseInt(split[43]);
		RSSI8 = Integer.parseInt(split[44]);
		
		SSID9 = split[46];
		MAC9 = split[47];
		Channel9 = Integer.parseInt(split[48]);
		RSSI9 = Integer.parseInt(split[49]);
		
		SSID10 = split[51];
		MAC10 = split[52];
		Channel10 = Integer.parseInt(split[53]);
		RSSI10 = Integer.parseInt(split[54]);
		
	}

	
	public void KMLConvert() {
		
		
		
	}
}
