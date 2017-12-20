package wifi_data;



public class wifi {
	
	int RSSI, Channel;
	String AuthMode, SSID, MAC, type;
	double AccuracyMeters;
	

public wifi(wifiPoint line) {
	this.RSSI= line.RSSI;
	this.Channel = line.Channel;
	this.AuthMode = line.AuthMode;
	this.SSID = line.SSID;
	this.MAC = line.MAC;
	this.type = line.type;
	this.AccuracyMeters = line.AccuracyMeters;
	
}


@Override
public String toString() {
	return "wifi [RSSI=" + RSSI + ", Channel=" + Channel + ", AuthMode=" + AuthMode + ", SSID=" + SSID + ", MAC=" + MAC
			+ ", type=" + type + ", AccuracyMeters=" + AccuracyMeters + "]";
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


public String getAuthMode() {
	return AuthMode;
}


public void setAuthMode(String authMode) {
	AuthMode = authMode;
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


public String getType() {
	return type;
}


public void setType(String type) {
	this.type = type;
}


public double getAccuracyMeters() {
	return AccuracyMeters;
}


public void setAccuracyMeters(double accuracyMeters) {
	AccuracyMeters = accuracyMeters;
}
	
}
