package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Tools.*;
import Algorithms.*;
import RunMatala.*;
import tests.*;
import wifi_data.*;
import gui_.*;

class ReadTest {
	public 	List<location> locations= new ArrayList<location>();
	public List<wifiPoint> wifiPoints = new ArrayList<wifiPoint>(3);
	public List<wifiNetwork> wifiNetworks = new ArrayList<wifiNetwork>();
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
	final void make_wifiNetworks_test0() {
		Comparator com= new Comparator<wifiPoint>(){
			public int compare(wifiPoint arg0, wifiPoint arg1) {
				assertEquals(arg0,arg1);
				return 1;
			}

		};

	}
	@Test
	final void make_wifiNetworks_test1() {
		Comparator com1= new Comparator<location>(){

			public int compare(location arg0, location arg1) {
				assertEquals(arg0,arg1);
				return 1;
			}

		};
	}
}

