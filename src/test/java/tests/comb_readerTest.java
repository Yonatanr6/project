package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class comb_readerTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	final void testread_File() {
				try {

					String path="C:\\Users\\shira\\git\\matala-shiran-yonatan-new\\Data\\input\\comb\\New folder";
					File f = new File(path);
					assertTrue(f.canRead());
					BufferedReader br = new BufferedReader(new FileReader(f));
					assertFalse(br.readLine() == null);
					br.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		
	

	@Test
	final void comb_reader_path() {
		String path = "C:\\Users\\shira\\git\\matala-shiran-yonatan-new\\Data\\input\\comb\\New folder";
		File folder = new File(path);//path of the files for reading
		File[] listOfFiles = folder.listFiles();
		try {

			
			assertTrue(folder.canRead());
			BufferedReader br = new BufferedReader(new FileReader(folder));
			assertFalse(br.readLine() == null);
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	final void comb_reader_no_path_() {
		String path = "C:\\Users\\shira\\git\\matala-shiran-yonatan-new\\Data\\input\\New folder";
		File folder = new File(path);//path of the files for reading
		File[] listOfFiles = folder.listFiles();
		try {

			
			assertFalse(folder.canRead());
			BufferedReader br = new BufferedReader(new FileReader(folder));
			assertFalse(br.readLine() == null);
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
