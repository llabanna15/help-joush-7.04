/**
 * Description for 7.04 Weight project
 *
 * @author (Your Name)
 * @version (The Date)
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class WeightOnPlanetV1
{
    // write static methods here
    // Note: formula for finding weight on a planet:  Earth weight divided by Gravity constant times surface gravity
	
	public static double[] getGravity() throws IOException{
	
		File gravity1 = new File ("gravity1.txt");
	
		Scanner inFile = new Scanner(gravity1);
	
		double[] gravity = new double[8];
	
		String[] gravitytext = new String[8];
	
		for(int n = 0; n < gravity.length; n++ ){
			gravitytext[n] = inFile.next();
			gravity[n] = Double.parseDouble(gravitytext[n]);
		}
		
		inFile.close();
	
		return gravity;
	}
	
	public static double [] calcWeight(double earthWeight, double [] gravity){
		
		double[] weight = new double[8];
		
		for(int n = 0; n < gravity.length; n++){// this was your problem, you forgot "n++" the loop was never ending. 
							//also, n <= made it go to 8, which throws an OutOfBounds because the array only goes to 7
			weight[n] = earthWeight / 6.673 * Math.pow(10, -11) * gravity[n];
		}
		
		return weight;
		
	}
	
	public static void printResults(String[] names, double[] gravity, double[] weight){
		System.out.println("\t My Weight on the Planets");
		System.out.println("  Planet \t Gravity \t Weight(lbs)");
		System.out.println("-----------------------------------------");
		for(int n = 0; n < gravity.length; n++){//same thing here, n <= made it go to 8, which throws an OutOfBounds because the array only goes to 7
		System.out.printf("  %s \t %.2f \t %.2f\n", names[n], gravity[n], weight[n]);
		}
	}
	
    public static void main(String[] args)throws IOException
	{

		// Extension idea... instead of hard coding the weight, you may prompt the user for input.

		double earthWeight = 100; // initialize Earth weight to 100 lbs.

		String[] names = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto"};
		double[] gravity = getGravity(); 							// static method you write
		double[] weight = calcWeight(earthWeight, gravity);  // static method you write
		printResults(names, gravity, weight); 					// static method you write
		
		//something is wrong with your calcWeight method, but i'll let you do that.

    } //end main
}//end class
