package matala0;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class test_matala {

	@Test
	
	void test() {
		

		Path outputFile = Paths.get("C:\\Users\\shira\\eclipse-workspace\\matala0\\src\\DATE\\output\\best.csv");
	
		Path outputFile3 = Paths.get("C:\\Users\\shira\\eclipse-workspace\\matala0\\src\\DATE\\output\\test.csv");
		Path outputFile2 = Paths.get("C:\\Users\\shira\\eclipse-workspace\\matala0\\src\\DATE\\output\\test1.kml"); 
		Path folder = Paths.get("C:\\Users\\shira\\eclipse-workspace\\matala0\\src\\DATE\\input");
	
		List<Row> rows = new ArrayList<Row>(); 
		List<Row> rows2 = new ArrayList<Row>();
	
		try {
			Files.newDirectoryStream(folder).forEach(
					file -> Reader_Writer.Rowmaker(file,rows)// Should print out the lines in the row class, and create 2 list of rows
					);	System.out.println("Test Pass");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Reader_Writer.writeFile(rows , outputFile3); //Should create a csv file with all the wi-fi results
		for(int i=0;i<10;i++)
			rows2.add(rows.get(i));
		Reader_Writer.writeFile(rows2 , outputFile); // Should create a csv file with the best 10 wi-fi spots
		Reader_Writer.writeFileKML(rows2,outputFile2);// Should create a kml based on the best results
		System.out.println("Test Pass");
		
	}
	
	@Test
	
	void testFail() {
		
		Path outputFile = Paths.get("C:\\Users\\shira\\eclipse-workspace\\matala0\\src\\DATE\\test-fail\\fail-output\\best.csv");
		Path outputFile3 = Paths.get("C:\\Users\\shira\\eclipse-workspace\\matala0\\src\\DATE\\test-fail\\fail-output\\test.csv");
		Path outputFile2 = Paths.get("C:\\Users\\shira\\eclipse-workspace\\matala0\\src\\DATE\\test-fail\\fail-output\\test1.kml"); 
		Path folder = Paths.get("C:\\Users\\shira\\eclipse-workspace\\matala0\\src\\DATE\\test-fail");

		List<Row> rows = new ArrayList<Row>(); 
		List<Row> rows2 = new ArrayList<Row>();

		try {
			Files.newDirectoryStream(folder).forEach(
					file -> Reader_Writer.Rowmaker(file,rows)// test will fail because of the files type in the folder
					);System.out.println("Test Fail");
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		Reader_Writer.writeFile(rows , outputFile3); //test will fail because there are no data to create the files
		for(int i=0;i<10;i++)
			rows2.add(rows.get(i));
		Reader_Writer.writeFile(rows2 , outputFile); // test will fail because there are no data to create the files
		Reader_Writer.writeFileKML(rows2,outputFile2);// test will fail because there are no data to create the files
		System.out.println("Test Fail");
	
		
	}
	}


