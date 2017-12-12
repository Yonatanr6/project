package matala;

import java.awt.List;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) throws IOException {
		
		String path=("C:\\Users\\shira\\eclipse-workspace\\matala0\\src\\DATE\\output\\best.csv");
		
		Writer newFile =new Writer(path);
		
		String mac="6a:12:f5:f9:5e:71";
		
		//LocFinder Find = new LocFinder(newFile, mac);
		MAC_loc loc = new MAC_loc();
		
	//	System.out.print(""+Find.getfAltitude()+" "+Find.getfLatitude()+" "+Find.fLongitude);
		
}
}