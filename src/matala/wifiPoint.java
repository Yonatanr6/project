package matala;



public class wifiPoint {
	

	@Override
	public String toString() {
		return  Id +","+ FirstSeen + "," + AuthMode + "," + SSID + "," + Channel + "," + RSSI + "," + CurrentLatitude
				+ "," + CurrentLongitude + "," + AltitudeMeters + "," + AccuracyMeters + "," + type+ "," +MAC ;
	}


	public double getCurrentLongitude() {
		return CurrentLongitude;
	}


	public double getCurrentLatitude() {
		return CurrentLatitude;
	}


	public double getAccuracyMeters() {
		return AccuracyMeters;
	}


	public int getRSSI() {
		return RSSI;
	}


	public int getChannel() {
		return Channel;
	}


	public double getAltitudeMeters() {
		return AltitudeMeters;
	}


	public String getAuthMode() {
		return AuthMode;
	}


	public String getSSID() {
		return SSID;
	}


	public String getMAC() {
		return MAC;
	}


	public String getType() {
		return type;
	}


	public String getFirstSeen() {
		return FirstSeen;
	}


	double CurrentLongitude, CurrentLatitude, AccuracyMeters, AltitudeMeters;
	int RSSI, Channel;
	String AuthMode, SSID, MAC, type, FirstSeen,Id;
   

	public wifiPoint(String Id,double currentLongitude, double currentLatitude, double accuracyMeters, int rSSI, int channel,
			double altitudeMeters, String authMode, String sSID, String mAC, String type, String firstSeen) {
		super();
		
		MAC = mAC;
		SSID = sSID;
		AuthMode = authMode;
		FirstSeen = firstSeen;
		Channel = channel;
		RSSI = rSSI;
		CurrentLatitude = currentLatitude;
		CurrentLongitude = currentLongitude;
		AltitudeMeters = altitudeMeters;
		AccuracyMeters = accuracyMeters;
		this.type = type;

	}


	public wifiPoint(String line, getID firstline) {
		String[] split = line.split(",");
		MAC = split[0];
		SSID = split[1];
		AuthMode = split[2];
		FirstSeen = split[3];
		Channel = Integer.parseInt(split[4]);
		RSSI = Integer.parseInt(split[5]);
		CurrentLatitude = Double.parseDouble(split[6]);
		CurrentLongitude = Double.parseDouble(split[7]);
		AltitudeMeters = Double.parseDouble(split[8]);
		AccuracyMeters = Double.parseDouble(split[9]);
		type = split[10];
		Id=firstline.getId();

	}


	

}
