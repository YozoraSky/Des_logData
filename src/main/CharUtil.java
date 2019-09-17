package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

public class CharUtil {
	public static void dump(Reader src, Writer dest) throws IOException{
		try(BufferedReader bsrc = new BufferedReader(src);
			PrintWriter pdest = new PrintWriter(dest)){
			char[] data = new char[1024];
			int length = -1;
			while((length = bsrc.read(data)) != -1) {
				pdest.write(data,0,length);
			}
		}
	}
}
