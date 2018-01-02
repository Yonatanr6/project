package RunMatala;

import java.awt.List;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import Algorithms.Algo2;
import KML.kml_writer;
import Tools.Writer;
import Tools.comb_reader;
import Tools.no_gps_read;
import Tools.wigel_mac;
import Tools.Filter;
public class main {
	

	public static void main(String[] args) throws IOException {
		/**
		 * main
		 * @author Shiran &Yonatan
		 *
		 */
		String path=("C:\\Users\\Yoni\\git\\matala-shiran-yonatan-\\src\\Data\\output\\Filter\\after_filter.csv");
		
		Writer newFile =new Writer();
		kml_writer newkml = new kml_writer();
		String a="model=SM-G950F_device=dreamlte";
		
		//LocFinder Find = new LocFinder(newFile, mac);
		wigel_mac loc = new wigel_mac();
		comb_reader point = new comb_reader();
		Tools.Filter.remove_by_id(point,a);
		Tools.Filter.save_filter();
		Writer writeComb= new Writer(point,path);
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