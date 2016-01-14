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
	 * 
	 * </pre>
	 */
	public static void main(String[] args) throws FileNotFoundException{
		
		int[][] inputArray= new int[10][10];
		int[][] outputArray= new int[10][10];
		int[][] rowSumArray= new int[10][3];
		int[][] colSumArray= new int[3][10];
		int[][] rowSortArray= new int[10][3];
		int[][] colSortArray= new int[3][10];
		
		System.out.println("Reading input from : 'C:/workplace/SortArrayProject/devnotes/ExampleInput'");
		inputArray = readArrayFromFile();
		
		System.out.println("Calculating Row SUM");
		rowSumArray = countRowSum(inputArray);
		
		System.out.println("Calculating Column SUM");
		colSumArray = countColSum(inputArray);	
		
		System.out.println("Sorting Row SUM Array");
		rowSortArray = sortRow(rowSumArray);
		
		System.out.println("Sorting Column SUM Array");
		colSortArray = sortCol(colSumArray);
		
		System.out.println("Building output Array");
		outputArray = buildOutputArray(rowSortArray,colSortArray,inputArray);
		
		System.out.println("Writing result out");
		if(writeOut(outputArray)){
			System.out.println("Check output : C:/esimene/output.txt'");
		}
		
	}
	
	/**
	 * @param rowSortArray
	 * @param colSortArray
	 * @param inputArray
	 * @return outputArray
	 * 
	 * <pre>
	 * Ehitab väljaminevat massiivi
	 * </pre>
	 */
	public static int[][] buildOutputArray(int [][] rowSortArray,int [][] colSortArray, int [][] inputArray){
		
		int[][] afterRowSort= new int[10][10];
		int[][] outputArray= new int[10][10];
		int currentRow = 0;
		int destinationRow = 0;
		int currentCol = 0;
		int destinationCol = 0;		
	
		for(int i = 0; i < 10; i++) {
			currentRow = rowSortArray[i][1];

			destinationRow = i;
			
			for(int j = 0; j < 10; j++) {
				afterRowSort[destinationRow][j] = inputArray[currentRow][j];
						
			}			
		}

		for(int r = 0; r < 10; r++) {
			currentCol = colSortArray[1][r];
			destinationCol = r;
			
			for(int k = 0; k < 10; k++) {
				outputArray[k][destinationCol] = afterRowSort[k][currentCol];
						
			}			
		}		

		return outputArray;
	}
	
	/**
	 * @param intBasic
	 * @param intToCompare
	 * @return x
	 * 
	 * <pre>
	 * Võrdlen kahte sisendina saadud täisarvu, tagastab TRUE juhul kui esimesena sisseantud 
	 * täisarv on suurem kui teisena sisseantud täisarv 
	 * <p/re>
	 */
	public static boolean compareInt (int intBasic, int intToCompare){
		boolean x = false;

		 if (intBasic > intToCompare){
			 x = true;
		 } 
			return x;
	}
	
	/**
	 * @param rowNumber
	 * @param sArray
	 * @return sArray
	 * 
	 * <pre>
	 * 
	 * <pre>
	 */
	public static int[][] upperRecursionRow(int rowNumber, int [][] sArray){

		if (compareInt (sArray[rowNumber][2], sArray[rowNumber-1][2])){
			switchRows(rowNumber, rowNumber-1, sArray);
			
			int newRowNumber = rowNumber-1;
			if (newRowNumber != 0){
				upperRecursionRow(newRowNumber, sArray);

			}
		}
		
		return sArray;
		
	}
	
	/**
	 * @param colNumber
	 * @param sArray
	 * @return sArray
	 * 
	 * <pre>
	 * 
	 * <pre>
	 */
	public static int[][] upperRecursionCol(int colNumber, int [][] sArray){
		
		if (compareInt (sArray[2][colNumber], sArray[2][colNumber-1])){
			switchCols(colNumber, colNumber-1, sArray);
			
			int newColNumber = colNumber-1;
			if (newColNumber != 0){
				upperRecursionCol(newColNumber, sArray);	
			}
		}
		
		return sArray;
		
	}
	
	/**
	 * @param startRow
	 * @param endRow
	 * @param sArray
	 * @return sArray
	 * 
	 * <pre>
	 * 
	 * <pre>
	 */
	public static int [][] switchRows(int startRow, int endRow, int [][] sArray){
		int z = 0;
		z = sArray[startRow][1];
		sArray[startRow][1] = sArray[endRow][1];
		sArray[endRow][1] = z;
		z = 0;
		z = sArray[startRow][2];
		sArray[startRow][2] = sArray[endRow][2];
		sArray[endRow][2] = z;

		return sArray;
				
	} 
	/**
	 * @param startCol
	 * @param endCol
	 * @param sArray
	 * @return sArray
	 * 
	 * <pre>
	 * 
	 * <pre>
	 */
	public static int [][] switchCols(int startCol, int endCol, int [][] sArray){
		int z = 0;
		z = sArray[1][startCol];
		sArray[1][startCol] = sArray[1][endCol];
		sArray[1][endCol] = z;
		z = 0;
		z = sArray[2][startCol];
		sArray[2][startCol] = sArray[2][endCol];
		sArray[2][endCol] = z;
		
		return sArray;
				
	} 
	/**
	 * @param rowSumArray
	 * @return rowSumArray
	 * 
	 * <pre>
	 * Looping rows SUM Array
	 * Tsükeldab ridade summade massiivi
	 * Algatab väärtuste järjestamist suurimast summast vähemani
	 * </pre>
	 */
	public static int [][] sortRow (int [][] rowSumArray){
		int row1 = 0;
		int row2 = 0;

		for(int i = 0; i < 10; i++) {
			if(i != 9){
				row1 = rowSumArray[i][2];
				row2 = rowSumArray[i+1][2];

				if (compareInt(row2, row1)){
					rowSumArray =switchRows(i+1,i,rowSumArray);
					if (i != 0){
						rowSumArray  =upperRecursionRow(i, rowSumArray);
					}
				}
			} 
		}
		
		return rowSumArray;
	}
	
	/**
	 * @param colSumArray
	 * @return colSumArray
	 * 
	 * <pre>
	 * Looping columns SUM Array
	 * Tsükeldab veergude summade massiivi
	 * Algatab väärtuste järjestamist suurimast summast vähemani
	 * </pre>
	 */
	public static int [][] sortCol (int [][] colSumArray){
		int col1 = 0;
		int col2 = 0;
		
		for(int i = 0; i < 10; i++) {
			if(i != 9){
				col1 = colSumArray[2][i];
				col2 = colSumArray[2][i+1];
				if (compareInt(col2, col1)){
					colSumArray =switchCols(i+1, i,colSumArray);
					if (i != 0){
						colSumArray =upperRecursionCol(i, colSumArray);
					}
					
				}
			} 
		}
		
		
		return colSumArray;
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
	 * Opens file from constant location : "C:/workplace/SortArrayProject/devnotes/ExampleInput"
	 * read all chars (1/0) into int-array
	 * </pre>
	 */
	public static int[][] readArrayFromFile() throws FileNotFoundException{
		

		int[][] intArray = new int[10][10];
		
		try {
			String sCurrentLine;
			int j = 0;
			BufferedReader br = new BufferedReader(new FileReader("C:/workplace/SortArrayProject/devnotes/ExampleInput"));
	
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
			System.out.println(" ");
			System.out.println("TÄNAN! ");
			System.out.println(" ");
			System.out.println("Kai Trumm ");
			System.out.println(" ");
			System.out.println("Tulemus: ");
			writer.println("autor: Kai Trumm");
			writer.println("");


			for(int i = 0; i < 10; i++) {
				for(int j = 0; j < 10; j++) {
					outputRow=outputRow + outputArray[i][j];
				}	

				writer.println(outputRow);
				System.out.println(outputRow);

				outputRow="";
			}

			writer.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Destination file : 'C:/esimene/output.txt' is missing");
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			System.out.println("Encoding : 'UTF-8' is unsupported");
			e.printStackTrace();
		}
		return true;

			
	}
}
