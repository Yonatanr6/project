package wifi_data;

public class getID {

	private String id;	

	public getID(String str){	//class that gets the id of the device fromt the wiglewifi	
		int start = str.indexOf("model=");
		if(start>=0){
			start+="model=".length();
			int end = str.indexOf(",",start);
			if(end>0){
				String value= str.substring(start, end);
				id=value;
			}
		}	
	}

	public String getId() {
		return id;
	}
	
}
