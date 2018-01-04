package RunMatala;

import java.awt.List;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Tools.*;
import Algorithms.*;
import RunMatala.*;
import tests.*;
import wifi_data.*;
import gui_.*;

public class main {
	
	//https://www.youtube.com/watch?v=fcNp2SsWOeM for the watchservice

	public static void main(String[] args) throws IOException {
		/**
		 * main
		 * @author Shiran &Yonatan
		 *
		 */
		try (WatchService service = FileSystems.getDefault().newWatchService()){
			Map<WatchKey, Path> KeyMap = new HashMap<>();
			Path path = Paths.get("Data/input");
			KeyMap.put(path.register(service,
				StandardWatchEventKinds.ENTRY_CREATE,
				StandardWatchEventKinds.ENTRY_DELETE,
				StandardWatchEventKinds.ENTRY_MODIFY
					),path);
			WatchKey watchKey;
			do {
				watchKey = service.take();
				Path eventDir = KeyMap.get(watchKey);
				for(WatchEvent<?> event : watchKey.pollEvents()) {
					WatchEvent.Kind<?> kind = event.kind();
					Path eventPath = (Path) event.context();
					System.out.println(eventDir + ":" + kind + ":"+eventPath);
				}
			} while(watchKey.reset());
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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