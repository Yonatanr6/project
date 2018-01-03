package RunMatala;

import java.awt.List;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Algorithms.Algo2;
import Tools.Writer;
import Tools.WriterToKml;
import Tools.comb_reader;
import Tools.no_gps_read;
import Tools.wigel_mac;
import Tools.Filter;
import Tools.Read;
public class main {
	

	public static void main(String[] args) throws IOException {
		/**
		 * main
		 * @author Shiran &Yonatan
		 *
		 */
		try (WatchService service = FileSystems.getDefault().newWatchService()){
			Map<WatchKey, Path> KeyMap = new HashMap<>();
		}
		String path=("C:\\Users\\Yoni\\git\\matala-shiran-yonatan-\\Data\\output\\Filter\\after_filter.csv");
		
		Read data=new Read();
		Writer newFile =new Writer(data);
		
		WriterToKml newkml = new WriterToKml(data);
		
		String a="model=SM-G950F_device=dreamlte";
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
		

		
}
}