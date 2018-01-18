package main;

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

import Tools.Writer;
import Tools.WriterToKml;
import Tools.comb_reader;
import Tools.no_gps_read;
import Tools.wigel_mac;
import WatchSer.watchservice;
import Tools.Filter;
import Tools.Read;

import Tools.*;
import Algorithms.*;
import tests.*;
import wifi_data.*;
import gui_.*;
import main.*;


public class main {
	
	

	public static void main(String[] args) throws Exception {
		/**
		 * main
		 * @author Shiran &Yonatan
		 *
		 */
	
		
		watchservice watchMe = new watchservice();
		
		Thread thread = new Thread(watchMe);
		thread.start();
		
		String path=("C:\\Users\\Yoni\\git\\matala-shiran-yonatan-\\Data\\output\\Filter\\after_filter.csv");
		
		Read data=new Read();
		
		
		WriterToKml newkml = new WriterToKml(data);
		Writer temp =new Writer(data);
		String a="Lenovo PB2-690Y";
    	wigel_mac loc = new wigel_mac();
		comb_reader point = new comb_reader("C:\\Users\\Yoni\\git\\matala-shiran-yonatan-\\Data\\output\\Filter\\backup");
		Tools.Filter.remove_by_id(data,a);
		Writer newFile =new Writer(data);
		Tools.Filter.save_filter();
		Tools.Filter.load_filter();
		//Writer writeComb= new Writer(point,path);
		no_gps_read read = new no_gps_read();
		Algo1 find = new Algo1(loc.MAC_locs);
		try {
			Algo2 re = new Algo2(point,read);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
}
}