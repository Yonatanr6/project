
package matala0;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args) {

		Path outputFile = Paths.get("C:\\Users\\shira\\eclipse-workspace\\matala0\\src\\DATE\\output\\best.csv");// path for the best wifi spots csv file
		Path outputFile3 = Paths.get("C:\\Users\\shira\\eclipse-workspace\\matala0\\src\\DATE\\output\\test.csv");// path for all the wifi spots csv file
		Path outputFile2 = Paths.get("C:\\Users\\shira\\eclipse-workspace\\matala0\\src\\DATE\\output\\test1.kml"); // path for the best wifi spots kml file
		Path folder = Paths.get("C:\\Users\\shira\\eclipse-workspace\\matala0\\src\\DATE\\input");

		List<Row> rows = new ArrayList<Row>(); //creates list of rows that contains wifi spots
		List<Row> rows2 = new ArrayList<Row>();//creates list of rows that contains wifi spots

		try {
			Files.newDirectoryStream(folder).forEach(
					file -> Reader_Writer.Rowmaker(file,rows)//reads a folder that contain csv files, and write them into the list of rows
					);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Reader_Writer.writeFile(rows , outputFile3); //creates file with all the wifi spots
		for(int i=0;i<10;i++)
			rows2.add(rows.get(i)); //fills a list with the best results
		Reader_Writer.writeFile(rows2 , outputFile); // creates file with the best wifi spots
		Reader_Writer.writeFileKML(rows2,outputFile2);// creates kml file with the best wifi spots


	}

}
