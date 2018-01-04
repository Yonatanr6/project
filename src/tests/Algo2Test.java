package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
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

class Algo2Test {
	List<Algo2> calcs = new ArrayList<>();
	List<Double> weight = new ArrayList<>();
	List<Integer> diff = new ArrayList<>();
	double diff1;
	double pi,Spi;
	List<Double> wLatitude= new ArrayList<>();
	List<Double> wLongitude= new ArrayList<>();
	List<Double> wAltitude= new ArrayList<>();



	@Test
	final void pic_calctest() {
		Algo2 sum = null ;
		for(int i=0;i<calcs.size();i++) {
			for(int j=0;j<calcs.get(i).weight.size();j++) 
				calcs.set(i,sum);
				//sum*=calcs.get(i).weight.get(j);
			assertEquals(sum,1);
			
		}
	}
}
