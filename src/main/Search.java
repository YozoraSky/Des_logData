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
	
	
	public String getData(Map<String, String> map, String CallUUID, String ConnID, String GvpSessionID) throws IOException {
		String data = "";
		int number = determineTheNumberOfParameters(CallUUID, ConnID, GvpSessionID);
		switch(number) {
			case 1:data = oneParametersGetData(map, CallUUID, ConnID, GvpSessionID);break;
			case 2:data = twoParametersGetData(map, CallUUID, ConnID, GvpSessionID);break;
			case 3:data = threeParametersGetData(map, CallUUID, ConnID, GvpSessionID);break;
		}
		return data;
	}
	
	private int determineTheNumberOfParameters(String CallUUID, String ConnID, String GvpSessionID) {
		int hasValue = 0;
		if(CallUUID!="")
			hasValue++;
		if(ConnID!="")
			hasValue++;
		if(GvpSessionID!="")
			hasValue++;
		return hasValue;
	}
	
	private String threeParametersGetData(Map<String, String> map, String CallUUID, String ConnID, String GvpSessionID) throws IOException {
		String data = "";
		if(map.get("CallUUID").equals(CallUUID) && map.get("ConnID").equals(ConnID) && map.get("GvpSessionID").equals(GvpSessionID)) {
			if(!map.containsKey("ERROR")) {
				switch(logName) {
					case ivrEsb : data = Decrypt.esb(map);break;
					case ivrLine : data = Decrypt.db_or_line_or_socket_or_authBackup(map);break;
					case ivrTandem : data = Decrypt.db_or_line_or_socket_or_authBackup(map);break;
					case ivrAuthBackup : data = Decrypt.db_or_line_or_socket_or_authBackup(map);break;
					case ivrFax : data = Decrypt.fax(map);break;
					case ivrDb : data = Decrypt.db_or_line_or_socket_or_authBackup(map);break;
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
	
	private String twoParametersGetData(Map<String, String> map, String CallUUID, String ConnID, String GvpSessionID) throws IOException {
		String data = "";
		if(CallUUID=="") {
			if(map.get("ConnID").equals(ConnID) && map.get("GvpSessionID").equals(GvpSessionID)) {
				if(!map.containsKey("ERROR")) {
					switch(logName) {
						case ivrEsb : data = Decrypt.esb(map);break;
						case ivrLine : data = Decrypt.db_or_line_or_socket_or_authBackup(map);break;
						case ivrTandem : data = Decrypt.db_or_line_or_socket_or_authBackup(map);break;
						case ivrAuthBackup : data = Decrypt.db_or_line_or_socket_or_authBackup(map);break;
						case ivrFax : data = Decrypt.fax(map);break;
						case ivrDb : data = Decrypt.db_or_line_or_socket_or_authBackup(map);break;
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
		else if(ConnID=="") {
			if(map.get("CallUUID").equals(CallUUID) && map.get("GvpSessionID").equals(GvpSessionID)) {
				if(!map.containsKey("ERROR")) {
					switch(logName) {
						case ivrEsb : data = Decrypt.esb(map);break;
						case ivrLine : data = Decrypt.db_or_line_or_socket_or_authBackup(map);break;
						case ivrTandem : data = Decrypt.db_or_line_or_socket_or_authBackup(map);break;
						case ivrAuthBackup : data = Decrypt.db_or_line_or_socket_or_authBackup(map);break;
						case ivrFax : data = Decrypt.fax(map);break;
						case ivrDb : data = Decrypt.db_or_line_or_socket_or_authBackup(map);break;
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
			if(map.get("CallUUID").equals(CallUUID) && map.get("ConnID").equals(ConnID)) {
				if(!map.containsKey("ERROR")) {
					switch(logName) {
						case ivrEsb : data = Decrypt.esb(map);break;
						case ivrLine : data = Decrypt.db_or_line_or_socket_or_authBackup(map);break;
						case ivrTandem : data = Decrypt.db_or_line_or_socket_or_authBackup(map);break;
						case ivrAuthBackup : data = Decrypt.db_or_line_or_socket_or_authBackup(map);break;
						case ivrFax : data = Decrypt.fax(map);break;
						case ivrDb : data = Decrypt.db_or_line_or_socket_or_authBackup(map);break;
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
	
	private String oneParametersGetData(Map<String, String> map, String CallUUID, String ConnID, String GvpSessionID) throws IOException {
		String data = "";
		if(CallUUID!="") {
			if(map.get("CallUUID").equals(CallUUID)) {
				if(!map.containsKey("ERROR")) {
					switch(logName) {
						case ivrEsb : data = Decrypt.esb(map);break;
						case ivrLine : data = Decrypt.db_or_line_or_socket_or_authBackup(map);break;
						case ivrTandem : data = Decrypt.db_or_line_or_socket_or_authBackup(map);break;
						case ivrAuthBackup : data = Decrypt.db_or_line_or_socket_or_authBackup(map);break;
						case ivrFax : data = Decrypt.fax(map);break;
						case ivrDb : data = Decrypt.db_or_line_or_socket_or_authBackup(map);break;
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
		else if(ConnID!="") {
			if(map.get("ConnID").equals(ConnID)) {
				if(!map.containsKey("ERROR")) {
					switch(logName) {
						case ivrEsb : data = Decrypt.esb(map);break;
						case ivrLine : data = Decrypt.db_or_line_or_socket_or_authBackup(map);break;
						case ivrTandem : data = Decrypt.db_or_line_or_socket_or_authBackup(map);break;
						case ivrAuthBackup : data = Decrypt.db_or_line_or_socket_or_authBackup(map);break;
						case ivrFax : data = Decrypt.fax(map);break;
						case ivrDb : data = Decrypt.db_or_line_or_socket_or_authBackup(map);break;
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
			if(map.get("GvpSessionID").equals(GvpSessionID)) {
				if(!map.containsKey("ERROR")) {
					switch(logName) {
						case ivrEsb : data = Decrypt.esb(map);break;
						case ivrLine : data = Decrypt.db_or_line_or_socket_or_authBackup(map);break;
						case ivrTandem : data = Decrypt.db_or_line_or_socket_or_authBackup(map);break;
						case ivrAuthBackup : data = Decrypt.db_or_line_or_socket_or_authBackup(map);break;
						case ivrFax : data = Decrypt.fax(map);break;
						case ivrDb : data = Decrypt.db_or_line_or_socket_or_authBackup(map);break;
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
