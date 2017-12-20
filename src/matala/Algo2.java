package matala;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Algo2 {

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
	
	String path="C:\\Users\\Yoni\\Documents\\EclipseProjects\\testMatala\\src\\Data\\output\\_no_gps_ts1.csv";
	

	double pow=2,min_dif=3,norm=10000,sig_dif=0.4,no_sig=-120,dif_no_sig=100;

	public Algo2(no_gps_read no_gps) throws Exception {
		
		KMLpoint data = new KMLpoint();
		PrintWriter writer = new PrintWriter(path);

		for(int i=0; i< no_gps.scans.size();i++) {
			
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
				
				//calcs.sort(compare1);

			}
//			for(int z=0;z<calcs.size();z++) {
//				calcs.get(z).wLatitude.add(calcs.get(z).pi*calcs.get(z).CurrentLatitude);
//				calcs.get(z).wLongitude.add(calcs.get(z).pi*calcs.get(z).CurrentLongitude);
//				calcs.get(z).wAltitude.add(calcs.get(z).pi*calcs.get(z).AltitudeMeters);
//			}
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
		double sum =1;
		for(int i=0;i<calcs.size();i++) {
			for(int j=0;j<calcs.get(i).weight.size();j++) 
				sum*=calcs.get(i).weight.get(j);
			calcs.get(i).pi=sum;
			sum=1;
		}
		
		
	}
//	Comparator<Algo2> compare1= new Comparator<Algo2>(){
//		public double compare(Algo2 arg0, Algo2 arg1) {
//			 return arg0.pi-arg1.pi;
//		}
//
//	};

	public Algo2() {
		super();
		
	}
	
}