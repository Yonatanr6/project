package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Algorithms.Algo1;

class Algo1Test {

	String path="C:\\Users\\shira\\eclipse-workspace\\matala0\\src\\DATE\\output\\algo1.csv";//output file
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
	final void algo1Constuctor() {
		
	}
	
	@Test
	final void testAlgo1ListOfwigel_mac() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testWriteFile() {
		List<Algo1> LocFinders1 = new ArrayList<>();
		Algo1 a = new Algo1();
		try {
			a.WriteFile(LocFinders1);
			File f = new File(path);
			assertTrue(f.exists());
			BufferedReader br = new BufferedReader(new FileReader(f));
			assertTrue(br.readLine() == null);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	final void testAlgo1() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testAlgo1WriterString() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testGetfAltitude() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testGetfLongitude() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testGetfLatitude() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testObject() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testGetClass() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testHashCode() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testEquals() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testClone() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testToString() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testNotify() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testNotifyAll() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testWaitLong() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testWaitLongInt() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testWait() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testFinalize() {
		fail("Not yet implemented"); // TODO
	}

}
