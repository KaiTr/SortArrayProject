package SortArray;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SortArray {

	public static void main(String[] args) throws FileNotFoundException{
		int[][] intputArray= new int[10][10];
		intputArray = readArrayFromFile();

	}
	
	public static int[][] readArrayFromFile() throws FileNotFoundException{
		
		//m‰‰ran massiivi mııtmed
		int[][] intArray = new int[10][10];
		
		try {
			String sCurrentLine;
			int j = 0;
			BufferedReader br = new BufferedReader(new FileReader("C:/workplace/SortArrayProject/ExampleInput"));
				
			while ((sCurrentLine = br.readLine()) != null){	
				
				for(int i = 0; i < 10; i++){					 				    
					intArray[j][i]=Character.getNumericValue(sCurrentLine.charAt(i));
				}
				j = j + 1;
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return intArray;			
	}
}
