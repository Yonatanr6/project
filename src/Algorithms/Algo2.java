package Algorithms;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import Tools.comb_reader;
import Tools.no_gps_read;
import wifi_data.getID;



public class Algo2 {
	/**
	 * the class of algo2
	 * @author Shiran &Yonatan
	 *
	 */



	double CurrentLongitude, CurrentLatitude,  AltitudeMeters;
	int NumberOWN;
	String FirstSeen, Id;

	List<Double> weight = new ArrayList<>();
	List<Integer> diff = new ArrayList<>();
	double diff1;
	double pi,Spi;
	List<Double> wLatitude= new ArrayList<>();
	List<Double> wLongitude= new ArrayList<>();
	List<Double> wAltitude= new ArrayList<>();
	double wLatitude1,wLongitude1,wAltitude1;
	double fLongitude, fLatitude, fAltitude;
	double sLongitude, sLatitude, sAltitude;

	String path="C:\\Users\\Yoni\\git\\matala-shiran-yonatan-\\src\\Data\\output\\algo2\\algo2.csv";//output file


	double pow=2,min_dif=3,norm=10000,sig_dif=0.4,no_sig=-120,dif_no_sig=100;

	public Algo2(no_gps_read no_gps) throws Exception {

		comb_reader data = new comb_reader();
		PrintWriter writer = new PrintWriter(path);

		for(int i=0; i< no_gps.scans.size();i++) {//algo for creating a list that calcs and writes the aproxx location of the user

			List<Algo2> calcs = new ArrayList<>();

			for(int k=0;k<data.KMLpoints.size();k++) {
				Algo2 calc = new Algo2();
				calc.CurrentLatitude= data.KMLpoints.get(k).CurrentLatitude;
				calc.CurrentLongitude= data.KMLpoints.get(k).CurrentLongitude;
				calc.AltitudeMeters= data.KMLpoints.get(k).AltitudeMeters;

				for(int j=0; j< no_gps.scans.get(i).NumberOWN; j++) {

					for(int q=0;q<data.KMLpoints.get(k).NumberOWN;q++) {

						if(no_gps.scans.get(i).MACList.get(j).equals(data.KMLpoints.get(k).MACList.get(q))) {

							calc.diff1= Math.abs(no_gps.scans.get(i).RSSIList.get(j)-data.KMLpoints.get(k).RSSIList.get(q));
							calc.weight.add(norm/((Math.pow(calc.diff1, sig_dif))*(Math.pow(no_gps.scans.get(i).RSSIList.get(j), pow))));
						}
						else {
							calc.diff1= dif_no_sig;
							calc.weight.add(norm/((Math.pow(calc.diff1, sig_dif))*(Math.pow(no_gps.scans.get(i).RSSIList.get(j), pow))));

						}
					}


				}

				calcs.add(calc);
				piCalc(calcs);



			}

			for(int z=0;z<calcs.size();z++) {
				calcs.get(z).wLatitude1=(calcs.get(z).pi*calcs.get(z).CurrentLatitude);
				calcs.get(z).wLongitude1=(calcs.get(z).pi*calcs.get(z).CurrentLongitude);
				calcs.get(z).wAltitude1=(calcs.get(z).pi*calcs.get(z).AltitudeMeters);
			}
			for(int z=0;z<calcs.size();z++) {
				calcs.get(z).sLatitude+=calcs.get(z).wLatitude1;
				calcs.get(z).sLongitude+=calcs.get(z).wLongitude1;
				calcs.get(z).sAltitude+=calcs.get(z).wAltitude1;
				calcs.get(z).Spi+=calcs.get(z).pi;
			}
			for(int z=0;z<calcs.size();z++) {
				calcs.get(z).fLatitude= calcs.get(z).sLatitude/calcs.get(z).Spi;
				calcs.get(z).fLongitude= calcs.get(z).sLongitude/calcs.get(z).Spi;
				calcs.get(z).fAltitude= calcs.get(z).sAltitude/calcs.get(z).Spi;
			}
			writer.print(","+",");
			writer.print(calcs.get(i).fLatitude);
			writer.print(",");
			writer.print(calcs.get(i).fLongitude);
			writer.print(",");
			writer.print(calcs.get(i).fAltitude);
			writer.println();

		}

		writer.close();


	}

	public void piCalc(List<Algo2> calcs) {
		/**
		 *func that calcs the similarty between each line 
		 * @author Shiran &Yonatan
		 *
		 */

		double sum =1;
		for(int i=0;i<calcs.size();i++) {
			for(int j=0;j<calcs.get(i).weight.size();j++) 
				sum*=calcs.get(i).weight.get(j);
			calcs.get(i).pi=sum;
			sum=1;
		}


	}


	public Algo2(String no_gps) throws Exception {



		List<comb_reader> scans = new ArrayList<>();

		String temp="12/05/17 11:48 AM,model=SM-G950F_device=dreamlte,?,?,?,3,IT-MNG,1c:b9:c4:15:ed:b8,1,-81, ,8c:0c:90:ae:16:83,11,-86,Ariel_University,1c:b9:c4:16:ed:3c,44,-91,,,,,,,,,,,,,,,,,,,,\r\n" ;
		String[] split = no_gps.split(",");	

		getID ID = new getID(no_gps);

		comb_reader scan = new comb_reader(ID);

		scan.FirstSeen= split[0];
		scan.Id= split[1];

		scan.NumberOWN = Integer.parseInt(split[5]);
		for(int i=0;i<scan.NumberOWN;i++) {
			scan.SSIDList.add(split[6+i*4]);
			scan.MACList.add((split[7+i*4]));
			scan.ChannelList.add(Integer.parseInt(split[8+i*4]));
			scan.RSSIList.add(Double.parseDouble(split[9+i*4]));
		}	


		scans.add(scan);


		comb_reader data = new comb_reader();

		PrintWriter writer = new PrintWriter(path);

		for(int i=0; i< scans.size();i++) {//algo for creating a list that calcs and writes the aproxx location of the user

			List<Algo2> calcs = new ArrayList<>();

			for(int k=0;k<data.KMLpoints.size();k++) {
				Algo2 calc = new Algo2();
				calc.CurrentLatitude= data.KMLpoints.get(k).CurrentLatitude;
				calc.CurrentLongitude= data.KMLpoints.get(k).CurrentLongitude;
				calc.AltitudeMeters= data.KMLpoints.get(k).AltitudeMeters;

				for(int j=0; j< scans.get(i).NumberOWN; j++) {

					for(int q=0;q<data.KMLpoints.get(k).NumberOWN;q++) {

						if(scans.get(i).MACList.get(j).equals(data.KMLpoints.get(k).MACList.get(q))) {

							calc.diff1= Math.abs(scans.get(i).RSSIList.get(j)-data.KMLpoints.get(k).RSSIList.get(q));
							calc.weight.add(norm/((Math.pow(calc.diff1, sig_dif))*(Math.pow(scans.get(i).RSSIList.get(j), pow))));
						}
						else {
							calc.diff1= dif_no_sig;
							calc.weight.add(norm/((Math.pow(calc.diff1, sig_dif))*(Math.pow(scans.get(i).RSSIList.get(j), pow))));

						}
					}


				}

				calcs.add(calc);
				piCalc(calcs);



			}

			for(int z=0;z<calcs.size();z++) {
				calcs.get(z).wLatitude1=(calcs.get(z).pi*calcs.get(z).CurrentLatitude);
				calcs.get(z).wLongitude1=(calcs.get(z).pi*calcs.get(z).CurrentLongitude);
				calcs.get(z).wAltitude1=(calcs.get(z).pi*calcs.get(z).AltitudeMeters);
			}
			for(int z=0;z<calcs.size();z++) {
				calcs.get(z).sLatitude+=calcs.get(z).wLatitude1;
				calcs.get(z).sLongitude+=calcs.get(z).wLongitude1;
				calcs.get(z).sAltitude+=calcs.get(z).wAltitude1;
				calcs.get(z).Spi+=calcs.get(z).pi;
			}
			for(int z=0;z<calcs.size();z++) {
				calcs.get(z).fLatitude= calcs.get(z).sLatitude/calcs.get(z).Spi;
				calcs.get(z).fLongitude= calcs.get(z).sLongitude/calcs.get(z).Spi;
				calcs.get(z).fAltitude= calcs.get(z).sAltitude/calcs.get(z).Spi;
			}
			writer.print(","+",");
			writer.print(calcs.get(i).fLatitude);
			writer.print(",");
			writer.print(calcs.get(i).fLongitude);
			writer.print(",");
			writer.print(calcs.get(i).fAltitude);
			writer.println();

		}

		writer.close();


	}

	public Algo2(String mac, String mac2, String mac3, int RSSI, int RSSI2, int RSSI3) throws Exception {
		
		int[] RSSiArr= {RSSI,RSSI2,RSSI3};
		String[] MACarr = {mac,mac2,mac3};

		

		List<comb_reader> scans = new ArrayList<>();
		
		for(int i=0;i<3;i++) {
			comb_reader scan = new comb_reader();

				scan.MACList.add(MACarr[i]);

			scan.RSSIList.add((double) RSSiArr[i]);



			scans.add(scan);
		}

		comb_reader data = new comb_reader();

		PrintWriter writer = new PrintWriter(path);

		for(int i=0; i< scans.size();i++) {//algo for creating a list that calcs and writes the aproxx location of the user

			List<Algo2> calcs = new ArrayList<>();

			for(int k=0;k<data.KMLpoints.size();k++) {
				Algo2 calc = new Algo2();
				calc.CurrentLatitude= data.KMLpoints.get(k).CurrentLatitude;
				calc.CurrentLongitude= data.KMLpoints.get(k).CurrentLongitude;
				calc.AltitudeMeters= data.KMLpoints.get(k).AltitudeMeters;

				for(int j=0; j< scans.get(i).NumberOWN; j++) {

					for(int q=0;q<data.KMLpoints.get(k).NumberOWN;q++) {

						if(scans.get(i).MACList.get(j).equals(data.KMLpoints.get(k).MACList.get(q))) {

							calc.diff1= Math.abs(scans.get(i).RSSIList.get(j)-data.KMLpoints.get(k).RSSIList.get(q));
							calc.weight.add(norm/((Math.pow(calc.diff1, sig_dif))*(Math.pow(scans.get(i).RSSIList.get(j), pow))));
						}
						else {
							calc.diff1= dif_no_sig;
							calc.weight.add(norm/((Math.pow(calc.diff1, sig_dif))*(Math.pow(scans.get(i).RSSIList.get(j), pow))));

						}
					}


				}

				calcs.add(calc);
				piCalc(calcs);



			}

			for(int z=0;z<calcs.size();z++) {
				calcs.get(z).wLatitude1=(calcs.get(z).pi*calcs.get(z).CurrentLatitude);
				calcs.get(z).wLongitude1=(calcs.get(z).pi*calcs.get(z).CurrentLongitude);
				calcs.get(z).wAltitude1=(calcs.get(z).pi*calcs.get(z).AltitudeMeters);
			}
			for(int z=0;z<calcs.size();z++) {
				calcs.get(z).sLatitude+=calcs.get(z).wLatitude1;
				calcs.get(z).sLongitude+=calcs.get(z).wLongitude1;
				calcs.get(z).sAltitude+=calcs.get(z).wAltitude1;
				calcs.get(z).Spi+=calcs.get(z).pi;
			}
			for(int z=0;z<calcs.size();z++) {
				calcs.get(z).fLatitude= calcs.get(z).sLatitude/calcs.get(z).Spi;
				calcs.get(z).fLongitude= calcs.get(z).sLongitude/calcs.get(z).Spi;
				calcs.get(z).fAltitude= calcs.get(z).sAltitude/calcs.get(z).Spi;
			}
			writer.print(","+",");
			writer.print(calcs.get(i).fLatitude);
			writer.print(",");
			writer.print(calcs.get(i).fLongitude);
			writer.print(",");
			writer.print(calcs.get(i).fAltitude);
			writer.println();

		}

		writer.close();


	}

	public Algo2() {
		super();

	}

}