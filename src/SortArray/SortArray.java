package SortArray;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SortArray {

	public static void main(String[] args) throws FileNotFoundException{
		
		int[][] inputArray= new int[10][10];
		inputArray = readArrayFromFile();
		countRowSum(inputArray);
		countColSum(inputArray);
		
		
	}
	public static int [][] countRowSum(int [][] inputArray) {
		
		//loen yhtede arvu igas reas
		int[][] rowSumArray= new int[10][3];
		int summa = 0;
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				summa = summa+inputArray[i][j];
			}
			rowSumArray[i][0] = i;
			rowSumArray[i][1] = i;
			rowSumArray[i][2] = summa;
			summa = 0;
		}
		return rowSumArray;		
	}
	public static int [][] countColSum(int [][] inputArray) {
		
		//loen yhtede arvu igas veerus
		int[][] colSumArray= new int[3][10];
		int summa = 0;
		
		for(int j = 0; j < 10; j++) {
			for(int i = 0; i < 10; i++) {
				summa = summa+inputArray[i][j];
			}
			colSumArray[0][j] = j;
			colSumArray[1][j] = j;
			colSumArray[2][j] = summa;
			summa = 0;
			
		}	
//		System.out.print(colSumArray[2][8]);
		return colSumArray;
		
		
		 
		
	}
	public static int[][] readArrayFromFile() throws FileNotFoundException{
		
		//määran massiivi mõõtmed
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
