
package matala0;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Reader_Writer {

	public static void Rowmaker(Path file, List rows) {// method that fills list with wifi spots

		File f=new File(file.toString());// creates a path for the buffer reader

		try  (BufferedReader br = new BufferedReader(new FileReader(f))){

			String line = ""; 
			while ((line = br.readLine()) != null) {

				if (!line.contains("Type")&&!line.contains("brand")&&!line.contains("GSM")) {// Discourages points that are not wifi
					Row row = new Row(line);
					System.out.println(row);
					rows.add(row);	//adds point of wifi to a list

				}

			}
			Comparator com= new Comparator<Row>(){//a comparator for best signal

				public int compare(Row arg0, Row arg1) {
					return arg0.RSSI-arg1.RSSI;
				}

			};
			rows.sort(com);// sort the wifi spots by signal 

		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}

	static void writeFile(List<Row> rows, Path theFile) {// method that creates a csv file 
		try {
			PrintWriter writer = new PrintWriter(Files.newBufferedWriter(theFile));
			writer.println("MAC"+",SSID"+",AuthMode"+",FirstSeen"+",Channel"+",RSSI"+",CurrentLantitude"+",CurrentLongitude"+",AltitudeMeters"+",AccurarcyMeters"+",Type");//header for the file
			for(int i=0;i<rows.size();i++) {
				writer.println(rows.get(i));//creates the file from the list of rows

			}writer.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	static void writeFileKML(List<Row> rows, Path theFile) //method that creates a kml file
	{
		try {
			PrintWriter writer = new PrintWriter(Files.newBufferedWriter(theFile));
			writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
					"<kml xmlns=\"http://www.opengis.net/kml/2.2\"><Document><Style id=\"red\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href></Icon></IconStyle></Style><Style id=\"yellow\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href></Icon></IconStyle></Style><Style id=\"green\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href></Icon></IconStyle></Style><Folder><name>Wifi Networks</name>"); //header for the file
			Scanner scAns = new Scanner(System.in);
			System.out.println("Do you want to filter the results? 0-no 1-by date 2-by location");
			int ans=scAns.nextInt();
			//scAns.close();

			switch(ans) {//sorting switch
			case 0: //defualt file
				for(int i=0;i<rows.size();i++) {//kml encoding
					writer.println("<Placemark>");
					writer.println("<name>"+"<![CDATA["+rows.get(i).SSID+"]]>"+"</name>");
					writer.println("<description>"+"<![CDATA[MAC: "+"<b>"+rows.get(i).MAC+"</b>"+"<br/>"
							+"AuthMode:"+"<b>"+rows.get(i).AuthMode+"</b>"+"<br/>"+
							"RSSI:"+"<b>"+rows.get(i).RSSI+"</b>"+"<br/>"+
							"Channel:"+"<b>"+rows.get(i).Channel+"</b>"+"<br/>"+
							"First seen:"+"<b>"+rows.get(i).FirstSeen+"</b>"+"<br/>"+				
							"]]>"+"</description>");
					writer.println("<Point>"+"<coordinates>"+rows.get(i).CurrentLongitude+","+rows.get(i).CurrentLatitude+"</coordinates>"+"</Point>");
					writer.println("</Placemark>");
				}

				writer.println("</Folder>"+"</Document>"+"</kml>");

				writer.close();
				break;

			case 1: //sort by date

				System.out.println("From which date, use the format: dd/mm/year  hour:min:sec ");



				String date1 = scAns.next();
				scAns.close();

				for(int i=0;i<rows.size();i++) {
					if(date1.compareTo(rows.get(i).FirstSeen)<1) {
						writer.println("<Placemark>");
						writer.println("<name>"+"<![CDATA["+rows.get(i).SSID+"]]>"+"</name>");
						writer.println("<description>"+"<![CDATA[MAC: "+"<b>"+rows.get(i).MAC+"</b>"+"<br/>"
								+"AuthMode:"+"<b>"+rows.get(i).AuthMode+"</b>"+"<br/>"+
								"RSSI:"+"<b>"+rows.get(i).RSSI+"</b>"+"<br/>"+
								"Channel:"+"<b>"+rows.get(i).Channel+"</b>"+"<br/>"+
								"First seen:"+"<b>"+rows.get(i).FirstSeen+"</b>"+"<br/>"+				
								"]]>"+"</description>");
						writer.println("<Point>"+"<coordinates>"+rows.get(i).CurrentLongitude+","+rows.get(i).CurrentLatitude+"</coordinates>"+"</Point>");
						writer.println("</Placemark>");
					}
				}
				writer.println("</Folder>"+"</Document>"+"</kml>");

				writer.close();
				break;

			case 2: //sort by area

				System.out.println("Insert Range for lantitude(from-to): ");
				double Lan1= scAns.nextInt();
				double Lan2= scAns.nextInt();

				System.out.println("Insert Range for longtitude(from-to): ");
				double Lon1= scAns.nextInt();
				double Lon2= scAns.nextInt();

				scAns.close();
				for(int i=0;i<rows.size();i++) {
					if(Lan1<=rows.get(i).CurrentLatitude && Lan2>=rows.get(i).CurrentLatitude && Lon1<=rows.get(i).CurrentLongitude && Lon2>=rows.get(i).CurrentLongitude) {
						writer.println("<Placemark>");
						writer.println("<name>"+"<![CDATA["+rows.get(i).SSID+"]]>"+"</name>");
						writer.println("<description>"+"<![CDATA[MAC: "+"<b>"+rows.get(i).MAC+"</b>"+"<br/>"
								+"AuthMode:"+"<b>"+rows.get(i).AuthMode+"</b>"+"<br/>"+
								"RSSI:"+"<b>"+rows.get(i).RSSI+"</b>"+"<br/>"+
								"Channel:"+"<b>"+rows.get(i).Channel+"</b>"+"<br/>"+
								"First seen:"+"<b>"+rows.get(i).FirstSeen+"</b>"+"<br/>"+				
								"]]>"+"</description>");
						writer.println("<Point>"+"<coordinates>"+rows.get(i).CurrentLongitude+","+rows.get(i).CurrentLatitude+"</coordinates>"+"</Point>");
						writer.println("</Placemark>");
					}
				}
				writer.println("</Folder>"+"</Document>"+"</kml>");

				writer.close();
				break;
			default:
				System.out.println("bye bye");
				break;


			}
			scAns.close();
		}


		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
