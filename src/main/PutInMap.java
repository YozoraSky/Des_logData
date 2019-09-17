package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PutInMap {
//	把context字串資料以#$$%%%%$$#做區隔，放入MAP裡面，方便之後查詢
	private final static String SeparatorSymbol = "#$$%%%%$$#";
	private final static String ERROR = "---ERROR---";
	
	public static List<Map<String,String>> esb(String context) {
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		int from = 0;
		int to = 0;
		String data;
		String encryptData;
		String dataLength;
		String callUU;
		String conn;
		String getGvpSession;
		while(context.indexOf(SeparatorSymbol, from)!=-1) {
			to = context.indexOf(SeparatorSymbol, from) + 10;
			Map<String,String> map = new HashMap<String,String>();
			data = context.substring(from, to);
			
			if(data.indexOf(ERROR) != -1) {
				map = error(data);
				list.add(map);
			}
			else {
				dataLength = data.substring(data.indexOf("data length")+14,data.indexOf("#", data.indexOf("data length")));
				encryptData = data.substring(data.indexOf("========= : ")+12, data.indexOf("========= : ")+12+Integer.parseInt(dataLength));
				callUU = data.substring(data.indexOf("CallUUID")+11,data.indexOf("#", data.indexOf("CallUUID")));
				conn = data.substring(data.indexOf("ConnID")+9,data.indexOf("#", data.indexOf("ConnID")));
				getGvpSession = data.substring(data.indexOf("GvpSessionID")+15,data.indexOf("#", data.indexOf("GvpSessionID")));
				map.put("Data", data);
				map.put("EData", encryptData);
				map.put("CallUUID", callUU);
				map.put("ConnID", conn);
				map.put("GvpSessionID", getGvpSession);
				list.add(map);
			}
			from = to;
		}
		return list;
	}
	
	public static List<Map<String,String>> db_or_line_or_socket_or_authBackup(String context) {
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		int from = 0;
		int to = 0;
		String data;
		String callUU;
		String conn;
		String getGvpSession;
		while(context.indexOf(SeparatorSymbol, from)!=-1) {
			to = context.indexOf(SeparatorSymbol, from) + 10;
			Map<String,String> map = new HashMap<String,String>();
			data = context.substring(from, to);
			
//			判斷data是否為完整的資料，若否!則不存入map中
//			if(data.indexOf("========= : ")!=-1) {
			if(data.indexOf(ERROR) != -1) {
				map = error(data);
				list.add(map);
			}
			else {
				callUU = data.substring(data.indexOf("CallUUID")+11,data.indexOf("#", data.indexOf("CallUUID")));
				conn = data.substring(data.indexOf("ConnID")+9,data.indexOf("#", data.indexOf("ConnID")));
				getGvpSession = data.substring(data.indexOf("GvpSessionID")+15,data.indexOf("#", data.indexOf("GvpSessionID")));
				map.put("Data", data);
				map.put("CallUUID", callUU);
				map.put("ConnID", conn);
				map.put("GvpSessionID", getGvpSession);
				if(data.indexOf("input : ")!=-1) {
					String encryptInput = data.substring(data.indexOf("input : ")+8, data.indexOf("#",data.indexOf("input : ")));
					map.put("EInput", encryptInput);
				}
				if(data.indexOf("output : ")!=-1) {
					String encryptOutput = data.substring(data.indexOf("output : ")+9, data.indexOf("#",data.indexOf("output : ")));
					map.put("EOutput", encryptOutput);
				}
				list.add(map);
			}
			from = to;
		}
		return list;
	}
	
	public static List<Map<String,String>> fax(String context){
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		int from = 0;
		int to = 0;
		String data;
		String encryptInput;
		String callUU;
		String conn;
		String getGvpSession;
		while(context.indexOf(SeparatorSymbol, from)!=-1) {
			to = context.indexOf(SeparatorSymbol, from) + 10;
			Map<String,String> map = new HashMap<String,String>();
			data = context.substring(from, to);
			
//			判斷data是否為完整的資料，若否!則不存入map中
//			if(data.indexOf("========= : ")!=-1) {
			if(data.indexOf(ERROR) != -1) {
				map = error(data);
				list.add(map);
			}
			else {
				callUU = data.substring(data.indexOf("CallUUID")+11,data.indexOf("#", data.indexOf("CallUUID")));
				conn = data.substring(data.indexOf("ConnID")+9,data.indexOf("#", data.indexOf("ConnID")));
				getGvpSession = data.substring(data.indexOf("GvpSessionID")+15,data.indexOf("#", data.indexOf("GvpSessionID")));
				encryptInput = data.substring(data.indexOf("input : ")+8, data.indexOf("#",data.indexOf("input : ")));
				map.put("Data", data);
				map.put("EInput", encryptInput);
				map.put("CallUUID", callUU);
				map.put("ConnID", conn);
				map.put("GvpSessionID", getGvpSession);
				list.add(map);
			}
			from = to;
		}
		return list;
	}
	
	public static List<Map<String,String>> mq(String context){
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		int from = 0;
		int to = 0;
		String data;
		String encryptInput;
		String encryptMsg;
		String callUU;
		String conn;
		String getGvpSession;
		while(context.indexOf(SeparatorSymbol, from)!=-1) {
			to = context.indexOf(SeparatorSymbol, from) + 10;
			Map<String,String> map = new HashMap<String,String>();
			data = context.substring(from, to);
			
//			判斷data是否為完整的資料，若否!則不存入map中
//			if(data.indexOf("========= : ")!=-1) {
			if(data.indexOf(ERROR) != -1) {
				map = error(data);
				list.add(map);
			}
			else {
				encryptInput = data.substring(data.indexOf("========= : ")+12, data.indexOf("#",data.indexOf("========= : ")));
				encryptMsg = data.substring(data.indexOf("msg_Enc")+10, data.indexOf("#",data.indexOf("msg_Enc")));
				callUU = data.substring(data.indexOf("CallUUID")+11,data.indexOf("#", data.indexOf("CallUUID")));
				conn = data.substring(data.indexOf("ConnID")+9,data.indexOf("#", data.indexOf("ConnID")));
				getGvpSession = data.substring(data.indexOf("GvpSessionID")+15,data.indexOf("#", data.indexOf("GvpSessionID")));
				map.put("Data", data);
				map.put("EInput", encryptInput);
				map.put("Emsg", encryptMsg);
				map.put("CallUUID", callUU);
				map.put("ConnID", conn);
				map.put("GvpSessionID", getGvpSession);
				list.add(map);
			}
			from = to;
		}
		return list;
	}
	
	private static Map<String,String> error(String data){
		Map<String,String> map = new HashMap<String,String>();
		String callUU = data.substring(data.indexOf("CallUUID")+11,data.indexOf("#", data.indexOf("CallUUID")));
		String conn = data.substring(data.indexOf("ConnID")+9,data.indexOf("#", data.indexOf("ConnID")));
		String getGvpSession = data.substring(data.indexOf("GvpSessionID")+15,data.indexOf("#", data.indexOf("GvpSessionID")));
		map.put("ERROR", data);
		map.put("CallUUID", callUU);
		map.put("ConnID", conn);
		map.put("GvpSessionID", getGvpSession);
		return map;
	}
}
