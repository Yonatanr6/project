package Tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Filter {
	
	static String save_id,load_id;
	static Date save_from_time;
	static Date load_from_time;
	static Date save_to_time;
	static Date load_to_time;
	static double save_from_lat,load_from_lat, save_to_lat,load_to_lat, save_from_lon,load_from_lon;
	static double save_to_lon,load_to_lon, save_from_alt,load_from_alt, save_to_alt,load_to_alt;
	static DateFormat format = new SimpleDateFormat("dd-MM-yy hh:mm");
	

public static void remove_by_id(Read data, String id) {//filter fo wiglewifi
	try {
		Writer backup = new Writer(data);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	setSave_id(id);
	for(int i=0;i<data.wifiNetworks.size();i++) {
		if(data.wifiNetworks.get(i).Id.contains(id)) {
			data.wifiNetworks.remove(i);
		    i--;
		}
	}
	
	
}
public static void leave_by_id(Read data, String id) {//filter fo wiglewifi
	try {
		Writer backup = new Writer(data);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	setSave_id(id);
	for(int i=0;i<data.wifiNetworks.size();i++) {
		if(!data.wifiNetworks.get(i).Id.contains(id)) {
			data.wifiNetworks.remove(i);
		    i--;
		}
	}
	
	
}

	


public static void remove_by_time(Read data, Date from_time, Date to_time) throws ParseException {
	
	try {
		Writer backup = new Writer(data);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	setSave_from_time(from_time);
	setSave_to_time(to_time);
	for(int i=0;i<data.wifiNetworks.size();i++) {
		int FT =format.parse(data.wifiNetworks.get(i).FirstSeen).compareTo(from_time);
		int TT = format.parse(data.wifiNetworks.get(i).FirstSeen).compareTo(to_time);
		if(FT>=0&&TT<=0) {
			
		data.wifiNetworks.remove(i);
			i--;
		}	
	}
	
}
public static void leave_by_time(Read data, Date from_time, Date to_time) throws ParseException {
	try {
		Writer backup = new Writer(data);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	setSave_from_time(from_time);
	setSave_to_time(to_time);
	for(int i=0;i<data.wifiNetworks.size();i++) {
		int FT =format.parse(data.wifiNetworks.get(i).FirstSeen).compareTo(from_time);
		int TT = format.parse(data.wifiNetworks.get(i).FirstSeen).compareTo(to_time);			
		if(FT>0&&TT>0) {
		data.wifiNetworks.remove(i);
		
			i--;
		}
		
	}	
}


public static void remove_by_lat(Read data, double from, double to) {
	try {
		Writer backup = new Writer(data);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	setSave_from_lat(from);
	setSave_to_lat(to);
	for(int i=0;i<data.wifiNetworks.size();i++) {
		if(data.wifiNetworks.get(i).CurrentLatitude>from&&data.wifiNetworks.get(i).CurrentLatitude<to) {
			System.out.println("delete");
			data.wifiNetworks.remove(i);
			i--;
		}
	}
	
}
public static void leave_by_lat(Read data, double from, double to) {
	try {
		Writer backup = new Writer(data);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	setSave_from_lat(from);
	setSave_to_lat(to);
	for(int i=0;i<data.wifiNetworks.size();i++) {
		if(data.wifiNetworks.get(i).CurrentLatitude<from||data.wifiNetworks.get(i).CurrentLatitude>to) {
			data.wifiNetworks.remove(i);
			i--;
		}
	}
	
}
public static void remove_by_lon(Read data, double from, double to) {
	try {
		Writer backup = new Writer(data);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	setSave_from_lon(from);
	setSave_to_lon(to);
	for(int i=0;i<data.wifiNetworks.size();i++) {
		if(data.wifiNetworks.get(i).CurrentLongitude>from&&data.wifiNetworks.get(i).CurrentLongitude<to) {
			data.wifiNetworks.remove(i);
			i--;
		}
	}
	
}
public static void leave_by_lon(Read data, double from, double to) {
	try {
		Writer backup = new Writer(data);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	setSave_from_lon(from);
	setSave_to_lon(to);
	for(int i=0;i<data.wifiNetworks.size();i++) {
		if(data.wifiNetworks.get(i).CurrentLongitude<from||data.wifiNetworks.get(i).CurrentLongitude>to) {
			data.wifiNetworks.remove(i);
			i--;
		}
	}
	
}
public static void remove_by_alt(Read data, double from, double to) {
	try {
		Writer backup = new Writer(data);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	setSave_from_alt(from);
	setSave_to_alt(to);
	for(int i=0;i<data.wifiNetworks.size();i++) {
		if(data.wifiNetworks.get(i).AltitudeMeters>from&&data.wifiNetworks.get(i).AltitudeMeters<to) {
			data.wifiNetworks.remove(i);
			i--;
		}
	}
	
}
public static void leave_by_alt(Read data, double from, double to) {
	try {
		Writer backup = new Writer(data);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	setSave_from_alt(from);
	setSave_to_alt(to);
	for(int i=0;i<data.wifiNetworks.size();i++) {
		if(data.wifiNetworks.get(i).AltitudeMeters>from||data.wifiNetworks.get(i).AltitudeMeters<to) {
			data.wifiNetworks.remove(i);
			i--;
		}
	}
	
}

public static void save_filter() throws FileNotFoundException {
String path=("C:\\Users\\Yoni\\git\\matala-shiran-yonatan-\\Data\\output\\Filter\\Filter.txt");//output file for the comb/best file


	PrintWriter writer = new PrintWriter(path);
	
	
	writer.println(save_id);
	writer.println(save_from_time);
	writer.println(save_to_time);
	writer.println(save_from_lat);
	writer.println(save_to_lat);
	writer.println(save_from_lon);
	writer.println(save_to_lon);
	writer.println(save_from_alt);
	writer.println(save_to_alt);
	writer.close();
	
}


public static String getSave_id() {
	return save_id;
}
public static String getLoad_id() {
	return load_id;
}
public static Date getSave_from_time() {
	return save_from_time;
}
public static Date getLoad_from_time() {
	return load_from_time;
}
public static Date getSave_to_time() {
	return save_to_time;
}
public static Date getLoad_to_time() {
	return load_to_time;
}
public static double getSave_from_lat() {
	return save_from_lat;
}
public static double getLoad_from_lat() {
	return load_from_lat;
}
public static double getSave_to_lat() {
	return save_to_lat;
}
public static double getLoad_to_lat() {
	return load_to_lat;
}
public static double getSave_from_lon() {
	return save_from_lon;
}
public static double getLoad_from_lon() {
	return load_from_lon;
}
public static double getSave_to_lon() {
	return save_to_lon;
}
public static double getLoad_to_lon() {
	return load_to_lon;
}
public static double getSave_from_alt() {
	return save_from_alt;
}
public static double getLoad_from_alt() {
	return load_from_alt;
}
public static double getSave_to_alt() {
	return save_to_alt;
}
public static double getLoad_to_alt() {
	return load_to_alt;
}
public static void load_filter() throws IOException, ParseException {
	File newfile = new File("C:\\Users\\Yoni\\git\\matala-shiran-yonatan-\\Data\\output\\Filter\\Filter.txt");
	BufferedReader br = new BufferedReader(new FileReader(newfile));
	String[] filterRead= new String[9];
	for(int i=0; i<9;i++) {
		try {
			filterRead[i] = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	save_id= filterRead[0];
	if(!filterRead[1].equals("null")) {
	load_from_time=format.parse(filterRead[1]);
	load_to_time =format.parse(filterRead[2]);
	}
	load_from_lat = Double.parseDouble(filterRead[3]);
	load_to_lat =Double.parseDouble(filterRead[4]);
	load_from_lon = Double.parseDouble(filterRead[5]);
	load_to_lon = Double.parseDouble(filterRead[6]);
	load_from_alt = Double.parseDouble(filterRead[7]);
	load_to_alt = Double.parseDouble(filterRead[8]);
    
	br.close();
}

public static void and_filter() {
	
}

public static void setSave_id(String save_id1) {
	save_id = save_id1;
}
public static void setSave_from_time(Date save_from_time1) {
	save_from_time = save_from_time1;
}
public static void setSave_to_time(Date save_to_time1) {
	save_to_time = save_to_time1;
}
public static void setSave_from_lat(double save_from_lat1) {
	save_from_lat = save_from_lat1;
}
public static void setSave_to_lat(double save_to_lat1) {
	save_to_lat = save_to_lat1;
}
public static void setSave_from_lon(double save_from_lon1) {
	save_from_lon = save_from_lon1;
}
public static void setSave_to_lon(double save_to_lon1) {
	save_to_lon = save_to_lon1;
}
public static void setSave_from_alt(double save_from_alt1) {
	save_from_alt = save_from_alt1;
}
public static void setSave_to_alt(double save_to_alt1) {
	save_to_alt = save_to_alt1;
}



}
