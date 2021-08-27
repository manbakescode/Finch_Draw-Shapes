
import java.io.*;


public class WritingToTextFile {

	public static void main(String[] args) throws IOException {
		
		File file = new File ("TextFile.txt");
		FileWriter fw = new FileWriter (file);
		PrintWriter pw = new PrintWriter(fw);
	
		pw.println("Here is your Work of Art!");
		pw.println("*****************************************************");
		
		pw.println("Number: Square/Triangle ---> " + Dialogue.squareNumber + "/" + Dialogue.triangleNumber);
		if (Dialogue.squareNumber == Dialogue.triangleNumber) {
			pw.println("Sqaures and Triangles drew!");
		} else if (Dialogue.squareNumber > Dialogue.triangleNumber) {
			System.out.println("You prefered drawing Squares!");
		} else { 
			System.out.println("You prefered drawing Triangles!");
		}
			
		pw.println("Largest Square drawn was: " + Dialogue.squareArea + " sqaured centimetres.");
		pw.println("Largest Triangle drawn was: " + Dialogue.triangleArea + " sqaured centimetres.");
		
		if (Dialogue.squareArea > Dialogue.triangleArea) {
		pw.println("Largest shape drawn was: " + Dialogue.squareArea);
			} else {
				pw.println("Largest shape drawn was: " + Dialogue.triangleArea);
			}
	
	
		pw.close();
	
	}

}
