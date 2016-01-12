package SortArray;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author KaiTr
 * 
 * 
 * 
 */
public class SortArray {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 * 
	 * <pre>
	 * {@link #countRowSum(int [][] inputArray)}
	 * {@link #countColSum(int [][] inputArray)}
	 * {@link #readArrayFromFile()}
	 * </pre>
	 */
	public static void main(String[] args) throws FileNotFoundException{
		
		int[][] inputArray= new int[10][10];
		inputArray = readArrayFromFile();
		countRowSum(inputArray);
		countColSum(inputArray);		
		
	}
	
	/**
	 * @param inputArray
	 * @return rowSumArray int[10][3]
	 * 
	 * <pre>
	 * current row-number, start row-number, row-sum
	 *
	 * Sum of "1" elements in input-array per row
	 * </pre>
	 */
	public static int [][] countRowSum(int [][] inputArray) {
		
		
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
	
	/**
	 * @param inputArray
	 * @return colSumArray int[3][10]
	 * 
	 * <pre>
	 * current column-number, start column-number, column-sum
	 * 
	 * Sum of "1" elements in input-array per column
	 * </pre>
	 */
	public static int [][] countColSum(int [][] inputArray) {
		

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

		return colSumArray;	
		 		
	}
	
	/**
	 * @return intArray
	 * @throws FileNotFoundException
	 * 
	 * <pre>
	 * Opens file from constant location : "C:/workplace/SortArrayProject/ExampleInput"
	 * read all chars (1/0) into int-array
	 * </pre>
	 */
	public static int[][] readArrayFromFile() throws FileNotFoundException{
		

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
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return intArray;			
	}
}
