package wifi_data;

public class location {

	public double Lat;
	public double Lon;
	public double Alt;
	public String Id; 
	public String FirstSeen;
	public int NumberOWN=0;
	public location(wifiPoint line, getID firstline)
	{
		this.Id=firstline.getId();
		this.Lat=line.CurrentLatitude;
		this.Lon=line.CurrentLongitude;
		this.Alt=line.AltitudeMeters;
		this.FirstSeen=line.FirstSeen;
	}
	
	public int getNumberOWN() {
		return NumberOWN;
	}

	public void setNumberOWN(int numberOWN) {
		NumberOWN = numberOWN;
	}

	public String getId() {
		return Id;
	}

	public double getLat() {
		return Lat;
	}
	public void setLat(double lat) {
		Lat = lat;
	}
	
	public double getLon() {
		return Lon;
	}
	public void setLon(double lon) {
		Lon = lon;
	}
	public double getAlt() {
		return Alt;
	}
	public void setAlt(double alt) {
		Alt = alt;
	}
	public String getID() {
		return Id;
	}
	public void setID(String Id) {
		Id =Id ;
	}
	public String getTime() {
		return FirstSeen;
	}
	public void setTime() {
		FirstSeen = FirstSeen;
	}
	@Override
	public String toString() {
		return "" + FirstSeen + "," + Id  + "," + Lat + "," + Lon + "," + Alt + "";
	}

	@Override
	 public boolean equals(Object object)
	    {
	        boolean sameSame = false;

	        if (object != null && object instanceof location&&this.FirstSeen.equals( ((location) object).FirstSeen)&&
	        		this.Lat ==  ((location) object).Lat&&this.Lon ==  ((location) object).Lon&& this.Alt ==  ((location) object).Alt)
	        {
	        	sameSame = true;
	        }

	        return sameSame;
	    }

	
}
