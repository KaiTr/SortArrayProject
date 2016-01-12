package samples;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


public class KuidasKirjutadaFaili {
	public static void main(String[] args) {
	
	PrintWriter writer;
	try {
		writer = new PrintWriter("C:/esimene/output.txt", "UTF-8");
		
		writer.println("Tere Kai");
		writer.println();
		writer.println("Tere Anni");
		writer.close();
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


	}
}
