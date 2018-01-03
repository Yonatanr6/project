package Tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Filter {
	
	static String save_id,load_id;
	static String save_from_time, load_from_time;
	static String save_to_time,load_to_time;
	static double save_from_lat,load_from_lat, save_to_lat,load_to_lat, save_from_lon,load_from_lon;
	static double save_to_lon,load_to_lon, save_from_alt,load_from_alt, save_to_alt,load_to_alt;
	
	
public static void remove_by_id(comb_reader data, String id) {
	try {
		Writer backup = new Writer(data);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	setSave_id(id);
	for(int i=0;i<data.KMLpoints.size();i++) {
		if(!data.KMLpoints.get(i).Id.equals(id)) {
			data.KMLpoints.remove(i);
		    i--;
		}
	}
	
	
}
public void remove_by_time(comb_reader data, String from_time, String to_time) {
	try {
		Writer backup = new Writer(data);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	setSave_from_time(from_time);
	setSave_to_time(to_time);
	for(int i=0;i<data.KMLpoints.size();i++) {
		if(data.KMLpoints.get(i).FirstSeen.compareTo(from_time)<0) {
			data.KMLpoints.remove(i);
			i--;
		}
		if(data.KMLpoints.get(i).FirstSeen.compareTo(to_time)>0) {
			data.KMLpoints.remove(i);
			i--;
		}
	}	
}

public void remove_by_lat(comb_reader data, double from, double to) {
	try {
		Writer backup = new Writer(data);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	setSave_from_lat(from);
	setSave_to_lat(to);
	for(int i=0;i<data.KMLpoints.size();i++) {
		if(data.KMLpoints.get(i).CurrentLatitude<from) {
			data.KMLpoints.remove(i);
			i--;
		}
		if(data.KMLpoints.get(i).CurrentLatitude>to) {
			data.KMLpoints.remove(i);
			i--;
		}
	}
	
}
public void remove_by_lon(comb_reader data, double from, double to) {
	try {
		Writer backup = new Writer(data);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	setSave_from_lon(from);
	setSave_to_lon(to);
	for(int i=0;i<data.KMLpoints.size();i++) {
		if(data.KMLpoints.get(i).CurrentLongitude<from) {
			data.KMLpoints.remove(i);
			i--;
		}
		if(data.KMLpoints.get(i).CurrentLongitude>to) {
			data.KMLpoints.remove(i);
			i--;
		}
	}
	
}
public void remove_by_alt(comb_reader data, double from, double to) {
	try {
		Writer backup = new Writer(data);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	setSave_from_alt(from);
	setSave_to_alt(to);
	for(int i=0;i<data.KMLpoints.size();i++) {
		if(data.KMLpoints.get(i).AltitudeMeters<from) {
			data.KMLpoints.remove(i);
			i--;
		}
		if(data.KMLpoints.get(i).AltitudeMeters>to) {
			data.KMLpoints.remove(i);
			i--;
		}
	}
	
}

public static void save_filter() throws FileNotFoundException {
String path=("C:\\Users\\Yoni\\git\\matala-shiran-yonatan-\\src\\Data\\output\\Filter\\Filter.txt");//output file for the comb/best file


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

public static void load_filter() throws FileNotFoundException {
	File newfile = new File("C:\\Users\\Yoni\\git\\matala-shiran-yonatan-\\src\\Data\\output\\Filter\\Filter.txt");
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
	load_id= filterRead[0];
	load_from_time= filterRead[1];
	load_to_time =filterRead[2];
	load_from_lat = Double.parseDouble(filterRead[3]);
	load_to_lat =Double.parseDouble(filterRead[4]);
	load_from_lon = Double.parseDouble(filterRead[5]);
	load_to_lon = Double.parseDouble(filterRead[6]);
    load_from_alt = Double.parseDouble(filterRead[7]);
    load_to_alt = Double.parseDouble(filterRead[8]);
}

public static void and_filter() {
	
}

public static void setSave_id(String save_id1) {
	save_id = save_id1;
}
public void setSave_from_time(String save_from_time1) {
	save_from_time = save_from_time1;
}
public void setSave_to_time(String save_to_time1) {
	save_to_time = save_to_time1;
}
public void setSave_from_lat(double save_from_lat1) {
	save_from_lat = save_from_lat1;
}
public void setSave_to_lat(double save_to_lat1) {
	save_to_lat = save_to_lat1;
}
public void setSave_from_lon(double save_from_lon1) {
	save_from_lon = save_from_lon1;
}
public void setSave_to_lon(double save_to_lon1) {
	save_to_lon = save_to_lon1;
}
public void setSave_from_alt(double save_from_alt1) {
	save_from_alt = save_from_alt1;
}
public void setSave_to_alt(double save_to_alt1) {
	save_to_alt = save_to_alt1;
}



}
