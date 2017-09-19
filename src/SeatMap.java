//Joshua Demetri

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SeatMap {
	String[][] nameList;

	public SeatMap() {
		readFile(); //Reads in data from the names.dat file
	}
	
	public String getName(int row, int col) {
		return nameList[row][col];
	}
	
	private void readFile() {
		try {
			File namesFile = new File("src/names.dat");
			Scanner input = new Scanner(namesFile);
			int colLength = 0;
			for(; input.hasNext();) {
				input.nextLine();
				colLength++;
			}
			colLength = colLength / 6; //Gets the total number of names then divides by 6 to get the length of each column
			input.close();
			input = new Scanner(namesFile);
			
			nameList = new String[colLength][6];
			for(int i = 0; i < colLength; i++) { //Loop for downward or column length
				System.out.println("");
				for(int j = 0; j < 6; j++) { //Loop for sideways or row length
					if(input.hasNextLine()) { //Makes sure there is a new line availible in the file
						System.out.print(" (" + i + "," + j + ")");
						System.out.print(nameList[i][j] = input.nextLine());
					}
				}
			}
			input.close();
		} catch (IOException e) {
		    System.err.println("IOException in reading input file!!!");
		}
	}
	
	public static void main(String[] args) {
		SeatMap chart = new SeatMap();
		Scanner userIn = new Scanner(System.in);  // Reading from System.in
		System.out.println("\n\nWhat seat do you want to see the student for? 'row, col': ");
		String rowCol = userIn.next();
		userIn.close();
		String[] rowColList = rowCol.split(",[ ]*");
		System.out.println("Student at " + rowCol + " is " + chart.getName(Integer.parseInt(rowColList[0]), Integer.parseInt(rowColList[1])));
	}
}
