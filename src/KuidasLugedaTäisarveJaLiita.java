import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class KuidasLugedaT�isarveJaLiita {

	public static void main(String[] args) {

		BufferedReader br = null;

		try {

			String sCurrentLine;
			String l�plik = "Vastus: ";
			int TaisArv = 0;
			int TeineArv = 6;
			int Vastus = 0;

			br = new BufferedReader(new FileReader("C:/esimene/input.txt"));

			while ((sCurrentLine = br.readLine()) != null) {
			TaisArv = Integer.parseInt(sCurrentLine);
			Vastus = TaisArv + TeineArv;
				
				System.out.println(sCurrentLine);
				System.out.println(l�plik + Vastus);
				System.out.print(l�plik);
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
						
						
						