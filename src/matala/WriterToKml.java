package matala;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WriterToKml {
	
	public WriterToKml(String path) throws IOException {
		
		List<KMLpoint> KMLpoints =new ArrayList<>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String lineRead = ""; 
			lineRead = br.readLine();
			
			while ((lineRead = br.readLine()) != null) {
				KMLpoint point =new KMLpoint();
				KMLpoints.add(point);
			
			}
			
			
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}

}
