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

import Tools.*;
import Algorithms.*;
import tests.*;
import wifi_data.*;
import gui_.*;
import main.*;


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
	final void testWriteFile() {
		List<Algo1> LocFinders1 = new ArrayList<>();
		Algo1 a = new Algo1();
		try {
			a.WriteFile(LocFinders1);
			File f = new File(path);
			assertTrue(f.exists());
			BufferedReader br = new BufferedReader(new FileReader(f));
			assertTrue(br.readLine() == null);
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	final void testWriteFile_empty() throws FileNotFoundException {
		List<Algo1> LocFinders2 = new ArrayList<>();//empty list 
	//	Algo1 a = new Algo1();
		try {
			
			File f = new File(path);
			assertTrue(f.exists());
			BufferedReader br = new BufferedReader(new FileReader(f));
			assertTrue(br.readLine() == null);
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Test
	final void Algo1_one_mac() {//null
		List<Algo1> LocFinders2 = new ArrayList<>(1);
		Algo1 FindMe = new Algo1();
		
		assertEquals(FindMe.mac_find, null);
		FindMe.mac_find="mac";
		assertEquals(FindMe.mac_find,"mac");
		
		
				
	}

	@Test
	final void Algo1_one_mac_not_null() {
		List<Algo1> LocFinders2 = new ArrayList<>();
		Algo1 FindMe = new Algo1();
		FindMe.mac_find="mac";
		assertEquals(FindMe.mac_find,"mac");
		
		
	}

	

}
