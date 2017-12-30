package Tools;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Filter {
	
	String save_id, save_from_time, save_to_time;
	double save_from_lat, save_to_lat, save_from_lon, save_to_lon, save_from_alt, save_to_alt;
	
	
public void remove_by_id(comb_reader data, String id) {
	try {
		Writer backup = new Writer(data);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	setSave_id(id);
	for(int i=0;i<data.KMLpoints.size();i++) {
		if(data.KMLpoints.get(i).Id.compareTo(id)!=0)
			data.KMLpoints.remove(i);
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
		if(data.KMLpoints.get(i).FirstSeen.compareTo(from_time)<0)
			data.KMLpoints.remove(i);
		if(data.KMLpoints.get(i).FirstSeen.compareTo(to_time)>0)
			data.KMLpoints.remove(i);
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
		if(data.KMLpoints.get(i).CurrentLatitude<from)
			data.KMLpoints.remove(i);
		if(data.KMLpoints.get(i).CurrentLatitude>to)
			data.KMLpoints.remove(i);
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
		if(data.KMLpoints.get(i).CurrentLongitude<from)
			data.KMLpoints.remove(i);
		if(data.KMLpoints.get(i).CurrentLongitude>to)
			data.KMLpoints.remove(i);
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
		if(data.KMLpoints.get(i).AltitudeMeters<from)
			data.KMLpoints.remove(i);
		if(data.KMLpoints.get(i).AltitudeMeters>to)
			data.KMLpoints.remove(i);
	}
	
}

public void save_filter() throws FileNotFoundException {
String path=("C:\\Users\\Yoni\\git\\matala-shiran-yonatan-\\output\\Filter\\Filter.txt");//output file for the comb/best file
	

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
	
}
public void setSave_id(String save_id) {
	this.save_id = save_id;
}
public void setSave_from_time(String save_from_time) {
	this.save_from_time = save_from_time;
}
public void setSave_to_time(String save_to_time) {
	this.save_to_time = save_to_time;
}
public void setSave_from_lat(double save_from_lat) {
	this.save_from_lat = save_from_lat;
}
public void setSave_to_lat(double save_to_lat) {
	this.save_to_lat = save_to_lat;
}
public void setSave_from_lon(double save_from_lon) {
	this.save_from_lon = save_from_lon;
}
public void setSave_to_lon(double save_to_lon) {
	this.save_to_lon = save_to_lon;
}
public void setSave_from_alt(double save_from_alt) {
	this.save_from_alt = save_from_alt;
}
public void setSave_to_alt(double save_to_alt) {
	this.save_to_alt = save_to_alt;
}



}
