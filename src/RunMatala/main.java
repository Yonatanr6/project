package RunMatala;

import java.awt.List;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import Algorithms.Algo2;
import Tools.Writer;
import Tools.comb_reader;
import Tools.no_gps_read;
import Tools.wigel_mac;

public class main {

	public static void main(String[] args) throws IOException {
		
		
		
		Writer newFile =new Writer();
		
		
		
		//LocFinder Find = new LocFinder(newFile, mac);
		wigel_mac loc = new wigel_mac();
		comb_reader point = new comb_reader();
		no_gps_read read = new no_gps_read();
		try {
			Algo2 re = new Algo2(read);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	//	System.out.print(""+Find.getfAltitude()+" "+Find.getfLatitude()+" "+Find.fLongitude);
		
}
}