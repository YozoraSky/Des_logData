package main;
import java.io.IOException;
import java.util.Map;


public class Search {
	public final static String ivrEsb = "esb";
	public final static String ivrLine = "line";
	public final static String ivrTandem = "tandem";
	public final static String ivrAuthBackup = "authBackup";
	public final static String ivrFax = "fax";
	public final static String ivrDb = "db";
	public final static String ivrMq = "mq";
	private String logName;
	
	public Search(String logName) {
		this.logName = logName;
	}
	
	
	public String getData(Map<String, String> map, String CallUUID, String ConnID) throws IOException {
		String data = "";
		int number = determineTheNumberOfParameters(CallUUID, ConnID);
		switch(number) {
			case 0:data = noParametersGetData(map);break;
			case 1:data = oneParametersGetData(map, CallUUID, ConnID);break;
			case 2:data = twoParametersGetData(map, CallUUID, ConnID);break;
		}
		return data;
	}
	
	private int determineTheNumberOfParameters(String CallUUID, String ConnID) {
		int hasValue = 0;
		if(CallUUID!="")
			hasValue++;
		if(ConnID!="")
			hasValue++;
		return hasValue;
	}
	
	private String noParametersGetData(Map<String, String> map) throws IOException {
		String data = "";
		if(!map.containsKey("ERROR")) {
			switch(logName) {
				case ivrEsb : data = Decrypt.esb(map);break;
				case ivrLine : data = Decrypt.general(map);break;
				case ivrTandem : data = Decrypt.general(map);break;
				case ivrAuthBackup : data = Decrypt.general(map);break;
				case ivrFax : data = Decrypt.fax(map);break;
				case ivrDb : data = Decrypt.general(map);break;
				case ivrMq : data = Decrypt.mq(map);break;
			}
			return data;
		}
		else
			return map.get("ERROR");
	}
	
	private String twoParametersGetData(Map<String, String> map, String CallUUID, String ConnID) throws IOException {
		String data = "";
		if(map.get("CallUUID").equals(CallUUID) && map.get("ConnID").equals(ConnID)) {
			if(!map.containsKey("ERROR")) {
				switch(logName) {
					case ivrEsb : data = Decrypt.esb(map);break;
					case ivrLine : data = Decrypt.general(map);break;
					case ivrTandem : data = Decrypt.general(map);break;
					case ivrAuthBackup : data = Decrypt.general(map);break;
					case ivrFax : data = Decrypt.fax(map);break;
					case ivrDb : data = Decrypt.general(map);break;
					case ivrMq : data = Decrypt.mq(map);break;
				}
				return data;
			}
			else
				return map.get("ERROR");
		}
		else
			return "";
	}
	
	private String oneParametersGetData(Map<String, String> map, String CallUUID, String ConnID) throws IOException {
		String data = "";
		if(CallUUID!="") {
			if(map.get("CallUUID").equals(CallUUID)) {
				if(!map.containsKey("ERROR")) {
					switch(logName) {
						case ivrEsb : data = Decrypt.esb(map);break;
						case ivrLine : data = Decrypt.general(map);break;
						case ivrTandem : data = Decrypt.general(map);break;
						case ivrAuthBackup : data = Decrypt.general(map);break;
						case ivrFax : data = Decrypt.fax(map);break;
						case ivrDb : data = Decrypt.general(map);break;
						case ivrMq : data = Decrypt.mq(map);break;
					}
					return data;
				}
				else
					return map.get("ERROR");
			}
			else
				return "";
		}
		else {
			if(map.get("ConnID").equals(ConnID)) {
				if(!map.containsKey("ERROR")) {
					switch(logName) {
						case ivrEsb : data = Decrypt.esb(map);break;
						case ivrLine : data = Decrypt.general(map);break;
						case ivrTandem : data = Decrypt.general(map);break;
						case ivrAuthBackup : data = Decrypt.general(map);break;
						case ivrFax : data = Decrypt.fax(map);break;
						case ivrDb : data = Decrypt.general(map);break;
						case ivrMq : data = Decrypt.mq(map);break;
					}
					return data;
				}
				else
					return map.get("ERROR");
			}
			else
				return "";
		}
	}
}
