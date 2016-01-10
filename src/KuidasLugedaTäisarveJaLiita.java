import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class KuidasLugedaTäisarveJaLiita {

	public static void main(String[] args) {

		BufferedReader br = null;

		try {

			String sCurrentLine;
			String lõplik = "Vastus: ";
			int TaisArv = 0;
			int TeineArv = 6;
			int Vastus = 0;

			br = new BufferedReader(new FileReader("C:/esimene/input.txt"));

			while ((sCurrentLine = br.readLine()) != null) {
			TaisArv = Integer.parseInt(sCurrentLine);
			Vastus = TaisArv + TeineArv;
				
				System.out.println(sCurrentLine);
				System.out.println(lõplik + Vastus);
				System.out.print(lõplik);
				System.out.print(Vastus);
								
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}
}
						
						
						