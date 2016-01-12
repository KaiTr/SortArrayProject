package SortArray;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

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
		int[][] outputArray= new int[10][10];
		int[][] rowSumArray= new int[10][3];
		int[][] colSumArray= new int[3][10];
		
		System.out.println("Reading input from : 'C:/workplace/SortArrayProject/ExampleInput'");
		inputArray = readArrayFromFile();
		
		System.out.println("Calculating Row SUM");
		rowSumArray = countRowSum(inputArray);
		
		System.out.println("Calculating Column SUM");
		colSumArray = countColSum(inputArray);	
		
		System.out.println("Writing result out");
		if(writeOut(outputArray)){
			System.out.println("Check output : C:/esimene/output.txt'");
		}
		
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
	
	/**
	 * @param outputArray
	 * 
	 * <pre>
	 * Input is sorted Array.
	 * Writing Array into textfile.
	 * Destination: 'C:/esimene/output.txt'
	 * </pre>
	 */
	public static boolean writeOut(int [][] outputArray){
				
		PrintWriter writer;
		
		try {
			writer = new PrintWriter("C:/esimene/output.txt", "UTF-8");
			String outputRow="";
			for(int i = 0; i < 10; i++) {
				for(int j = 0; j < 10; j++) {
					outputRow=outputRow + outputArray[i][j];
				}	
				
				writer.println(outputRow);
				outputRow="";
			}

			writer.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Destianation file : 'C:/esimene/output.txt' is missing");
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			System.out.println("Encoding : 'UTF-8' is unsupported");
			e.printStackTrace();
		}
		return true;

			
	}
}
