import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import java.util.Scanner;
import java.util.ArrayList;


/*
 * This program contains the main method and is mainly concerned with:
 * 1) output for the user to read
 * 2) input from the user to be used in the 'Shapes' class to perform the calculations
 */


public class Dialogue {
	public static Finch myFinchDraws = new Finch(); // new Finch instance to be used in this program
	public static Scanner userInput = new Scanner(System.in);
	public static ArrayList<Shapes> shapeList = new ArrayList<Shapes>(); // an ArrayList to store multiple shapes drawn
	public static int triangleNumber, squareNumber = 0; // used to keep track of the number of squares & triangles drawn
	public static double triangleArea, squareArea, largestArea = 0; // the largest area out of the shapes drawn by the user
	static String Password; //if String is required for userInput
	static int Passcode; //if integer is required for userInput
	
	
	public static void main(String[] args) {
		while (myFinchDraws.isFinchLevel() == false) {
			System.out.println("Finch not level with floor! Please place Finch level with floor.");
		}
		if (myFinchDraws.isFinchLevel() == true) {
			System.out.println("Welcome to Draw Shapes!");
		}
		int round = 0;
		while (round < 1) {
			Password = "empty"; //resetting
			System.out.println("Please enter: ");
			System.out.println("[ S ] to draw a Square!");
			System.out.println("[ T ] to draw a Triangle!");
			System.out.println("[ Q ] to quit the program.");
			System.out.println("Shape: ");
			userInput(2);
			
			if (Password.matches("S") || Password.matches("s")) {
				System.out.println("You have entered: [ " + Password + " ]");
				System.out.println("A Square will be drawn!");
				inputSquare();
				System.out.println("Would you like to draw another shape or would you like to quit?"); //loops the program or quits
			} else if (Password.matches("T") || Password.matches("t")) {
				System.out.println("You have entered: [ " + Password + " ]");
				System.out.println("A Triangle will be drawn!");
				inputTriangle();
				System.out.println("Would you like to draw another shape or would you like to quit?"); //loops the program or quits
			} else if (Password.matches("Q") || Password.matches("q")) {
				System.out.println("You have entered: [ " + Password + " ]");
				System.out.println("The program will now Quit.");
				round = 1;
				Quit();
			} else {
				System.out.println("ERROR! Wrong option. Please Try again."); // error message
			}
		}
	}	
	
	static void inputSquare() {
		
		int round = 0; 
		while (round < 1) {
			System.out.println("Please enter the desired length of the sides of the Square.");
			System.out.println("Reminder: The length of the side should be between 15cm and 85cm.");
			System.out.println("Side Length: ");
			userInput(1);
			
			if (Passcode >= 15 && Passcode <= 85) { // input for side should be within specified range otherwise will display error message
				System.out.println("The sides of the Square will be: " + Passcode + "cm");
				
				round++;
			} else {
				System.out.println("Error! Wrong value entered.");
				System.out.println("Please re-enter different values the within specified range. ");
			}
			
		}
		shapeList.add(new Shapes(Passcode));
	}

	static void inputTriangle() {
		int [] sides = new int[3]; //input for sides of triangle
		int i = 1;
		char side = 'a'; //lets the user know which side of the triangle they are giving length input for
		int round = 0;
		while (round < 3) {
			System.out.println("Please enter the desired lengths of the sides of the Triangle.");
			System.out.println("Reminder: The lengths of the sides should be between 15cm and 85cm.");
			System.out.println("Side " + side + " length: " );
			userInput(1);
			
			if(Passcode >= 15 && Passcode <= 85) {
				sides[i-1] = Passcode;
				i++; // increases number to be used inside array sides
				round++;// increases round number
				side++; // increases the char 'a' to 'b' to 'c'
			} else {
				System.out.println("Error! Wrong value entered.");
				System.out.println("Please re-enter different values the within specified range. ");
			}
			Passcode = 0;
		}
		shapeList.add(new Shapes(sides[0], sides[1], sides[2]));
	}
	
	static void userInput(int option) {
		String input = userInput.nextLine(); //Scanner used to obtain user input.
		if (option==1) { //if integer response is needed
			if (input.matches("[0-9]+")) { //if its a number
				Passcode = Integer.parseInt(input); //save to savedNum variable. Change to integer.
			}
		} else if (option==2) { //if string response is needed
			Password = input; //pass straight to savedChar variable.
		}
	}

	
	static void Quit() {
		myFinchDraws.setLED(255, 0, 0, 2000);
		System.out.println("Here is your Work of Art!");
		System.out.println("*****************************************************");
		
		System.out.println("Number: Square/Triangle ---> " + squareNumber + "/" + triangleNumber);
		if (squareNumber == triangleNumber) {
			System.out.println("Sqaures and Triangles drew!");
		} else if (squareNumber > triangleNumber) {
			System.out.println("You prefered drawing Squares!");
		} else { 
			System.out.println("You prefered drawing Triangles!");
		}
			
		System.out.println("Largest Square drawn was: " + squareArea + " sqaured centimetres.");
		System.out.println("Largest Triangle drawn was: " + triangleArea + " sqaured centimetres.");
		
		if (squareArea > triangleArea) {
		System.out.println("Largest shape drawn was: " + squareArea);
			} else {
				System.out.println("Largest shape drawn was: " + triangleArea);
			}
		myFinchDraws.quit();
	}	
	
	
}
	
	
			
			
	