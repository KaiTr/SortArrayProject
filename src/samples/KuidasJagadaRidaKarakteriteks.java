package samples;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class KuidasJagadaRidaKarakteriteks {
	
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			String sCurrentLine;
//			String loplik = "Vastus: ";
			String rida = "Rida ";
			String koolon = " : ";
			char otsitavMark = 0;
//			int TaisArv = 0;
//			int TeineArv = 6;
//			int Vastus = 0;
			int reanumber = 0;
			int otsitavRida = 2;
			int otsitavaMargiNumber = 5;			
			br = new BufferedReader(new FileReader("C:/esimene/input.txt"));

			while ((sCurrentLine = br.readLine()) != null) {
				reanumber = reanumber + 1;
				System.out.print(rida + reanumber + koolon);
				for(int i = 0; i < sCurrentLine.length(); i++) {
					 System.out.print(sCurrentLine.charAt(i) + " " );				    
				    if(reanumber == otsitavRida && i == otsitavaMargiNumber){
						otsitavMark = sCurrentLine.charAt(i);
						}  
					}				
				System.out.println();				
//				for(int i = 0; i < sCurrentLine.length(); i++) {
//				    System.out.println(sCurrentLine.charAt(i));
//				}				
				/*TaisArv = Integer.parseInt(sCurrentLine);
				Vastus = TaisArv + TeineArv;				
				System.out.println(sCurrentLine);
				System.out.println(loplik+ Vastus);
				System.out.print(loplik);
				System.out.print(Vastus);*/								
				}
			System.out.println(otsitavMark);			
			} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
