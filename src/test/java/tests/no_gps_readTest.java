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

class no_gps_readTest {

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
	final void no_gps_read_test() {
		try {

			File folder = new File("C:\\Users\\Yoni\\git\\matala-shiran-yonatan-new\\Data\\input\\no_gps\\");
			
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
	final void no_gps_read_test1() {
		try {

			File folder = new File("C:\\Users\\shira\\git\\matala-shiran-yonatan-new\\input\\no_gps");
			
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