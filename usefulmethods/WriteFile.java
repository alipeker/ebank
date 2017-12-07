package usefulmethods;

import java.io.IOException;
import java.io.PrintWriter;

public class WriteFile {
	public static void writefile(String filename,String word){
		try{
		    PrintWriter writer = new PrintWriter(filename, "UTF-8");
		    writer.println(word);
		    writer.close();
		} catch (IOException e) {
		   System.out.println(e);
		}
	}
}
