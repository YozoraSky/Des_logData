package main;

import java.util.Map;
import java.util.Properties;

import des.DES;
import resources.LoadProperties;

public class Decrypt {
	private static Properties props = new LoadProperties().load();
	
	public static String esb(Map<String, String> map) {
		String data = "";
		try {
			String decryptData = DES._DecryptByDES(map.get("EData"), props.getProperty("key"));
			StringBuffer sb = new StringBuffer(decryptData);
//			FormatXML.asXML(sb);
			data = map.get("Data").replace(map.get("EData"), "\n"+sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public static String mq(Map<String, String> map) {
		String data = "";
		try {
			String decryptInput = DES._DecryptByDES(map.get("EInput"), props.getProperty("key"));
			String decryptMsg = DES._DecryptByDES(map.get("Emsg"),props.getProperty("key"));
			data = map.get("Data").replace(map.get("EInput"), decryptInput)
								  .replace(map.get("Emsg"), decryptMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public static String fax(Map<String, String> map) {
		String data = "";
		try {
			String decryptInput = DES._DecryptByDES(map.get("EInput"), props.getProperty("key"));
			data = map.get("Data").replace(map.get("EInput"), decryptInput);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public static String db_or_line_or_socket_or_authBackup(Map<String, String> map) {
		String data = "";
		try {
			if(map.containsKey("EInput") && !map.containsKey("EOutput")) {
				String decryptInput = DES._DecryptByDES(map.get("EInput"), props.getProperty("key"));
				data = map.get("Data").replace(map.get("EInput"), decryptInput);
			}
			else if(!map.containsKey("EInput") && map.containsKey("EOutput")) {
				String decrypOutput = DES._DecryptByDES(map.get("EOutput"),props.getProperty("key"));
				data = map.get("Data").replace(map.get("EOutput"), decrypOutput);
			}
			else if(map.containsKey("EInput") && map.containsKey("EOutput")) {
				String decryptInput = DES._DecryptByDES(map.get("EInput"), props.getProperty("key"));
				String decrypOutput = DES._DecryptByDES(map.get("EOutput"),props.getProperty("key"));
				data = map.get("Data").replace(map.get("EInput"), decryptInput)
									  .replace(map.get("EOutput"), decrypOutput);
			}
			else
				data = map.get("Data");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}
