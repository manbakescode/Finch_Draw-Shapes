/*
 * This class program contains the constructor methods for the square and triangle
 * as well as the calculation methods which is received from the 'Main' class
 */
public class Shapes {
	public String shapeName;
	public int[] shapeSide; 
	public int[] shapeAngle; // 4 for square, 3 for triangle 
	
	
	
	public Shapes (int side) { // constructor method for square, all 4 sides are equal
		this.shapeName = "Square";
		this.shapeSide = new int[4];
		this.shapeSide[0] = side;
		this.shapeSide[1] = side;
		this.shapeSide[2] = side;
		this.shapeSide[3] = side;

		calculateSqaure();
		Dialogue.squareNumber++; // increases the number of squares drawn
		
	}
	
	void calculateSqaure() {
			//all 4 angles in a square equals 90 degrees
			this.shapeAngle = new int [4];
			this.shapeAngle[0] = 90;
			this.shapeAngle[1] = 90;
			this.shapeAngle[2] = 90;
			this.shapeAngle[3] = 90;
			squareArea();
			drawSquareShape();
	}
	
	public void squareArea() { // calculate area for square
		double Area = this.shapeSide[0] * this.shapeSide[1]; // Side of square multiplied by side of square
		if (Dialogue.squareArea < Area) { // is existing squareArea is smaller than calculated area, override.
			Dialogue.squareArea = Area;
		}
	}
		

	
	void drawSquareShape() {
		System.out.println("Commencing drawing Square shape after the beep!");
		Dialogue.myFinchDraws.buzz(400, 1000);
			goForward(this.shapeSide[0]);
			goRotate(this.shapeAngle[0]);
			goForward(this.shapeSide[0]);
			goRotate(this.shapeAngle[0]);
			goForward(this.shapeSide[0]);
			goRotate(this.shapeAngle[0]);
			goForward(this.shapeSide[0]);
		Dialogue.myFinchDraws.buzz(800, 1000);
		System.out.println("Drawing Completed!");
		}
	
	public Shapes (int sidea, int sideb, int sidec) { // constructor method for triangle
		this.shapeName = "Triangle";
		this.shapeSide = new int[3]; //triangle has 3 sides
		this.shapeSide[0] = sidea;
		this.shapeSide[1] = sideb;
		this.shapeSide[2] = sidec;
		calculateTriangle();
	}

	void calculateTriangle() {
		if(triangleValidity() == 0) { // error message if inputted sides cannot form triangle
			System.out.println("Error! Cannot form triangle with inputted values!");
			System.out.println("Please re-enter different values.");
			Dialogue.inputTriangle(); //returns to main class to allow user to input different values
		} else {
			triangleArea();
			System.out.println("Success! Sides given can form a triangle!");
			Dialogue.triangleNumber++; // increase count for triangles after triangle validity method
		}
		
		this.shapeAngle = new int[3];
		
		int a = this.shapeSide[0];
		int b = this.shapeSide[1];
		int c = this.shapeSide[2];
		int A ;
		int B ;
		int C ;
		
		A = (int) Math.acos((b * b + c * c - a * a) / (2 * b * c)); //calculating Angle A using Cosine Rule
		//Math.sin takes in radians 
		B = (int) Math.acos((a * a + c * c - b * b) / (2 * a * c)); //calculating B using Sine Rule
		C = 180 - (A + B); // angles in a triangle add up to 180 degrees
		
		//assigning angles
		this.shapeAngle[0] = C;
		this.shapeAngle[1] = A;
		this.shapeAngle[2] = B;
		
		drawTriangleShape(); 
		}
	
	public int triangleValidity() { //check whether sides can form a triangle
		int a = this.shapeSide[0];
		int b = this.shapeSide[1];
		int c = this.shapeSide[2];
		
		if (a + b <= c || a + c <= b || b + c <= a) {
			return 0; // for invalid side pairings
		} else {
			return 1; // for valid side pairings
		}
	}
	
	public void triangleArea() { // calculate area for triangle using the heron's formula
		int A = this.shapeSide[0];
		int B = this.shapeSide[1];
		int C = this.shapeSide[2];
		double S = (A + B + C)/2;
		double Area = Math.sqrt(S*(S-A)*(S-B)*(S-C));
		if (Dialogue.triangleArea < Area) { // is existing triangleArea is smaller than calculated area, override.
			Dialogue.triangleArea = Area;
		}
	}
		
	
		
	void drawTriangleShape() {
		System.out.println("Commencing drawing Triangle shape after the beep!");
		Dialogue.myFinchDraws.buzz(400, 1000);
			goForward(this.shapeSide[0]);
			goRotate(this.shapeAngle[0]);
			goForward(this.shapeSide[1]);
			goRotate(this.shapeAngle[1]);
			goForward(this.shapeSide[2]);
			goRotate(this.shapeAngle[2]);// Don't need to turn final angle but might as well
		Dialogue.myFinchDraws.buzz(800, 1000);
		System.out.println("Drawing Completed!");

	}
	

	

	
	void goForward(int side) {
		//calculating the time needed to cover inputted distance
		
		int sideTime = (int) Math.round(side*100);
		
		Dialogue.myFinchDraws.setWheelVelocities(80, 80, sideTime);
	}
	
	void goRotate (int angle) {
		//calculating the time needed to rotated said angle of shape
		
		int angleTime = (int) Math.round(angle*20);
		
		Dialogue.myFinchDraws.setWheelVelocities(-80, 0, angleTime); //Right wheel 
	}
	
	public int getSide(int side) {
		return this.shapeSide[side-1]; // we initialised the sides to be (4 for square & 3 for triangle) but arrays start form 0
	}
	
	public double getAngles(int angle) {
		return this.shapeAngle[angle-1];
	}
}

	

