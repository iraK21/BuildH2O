package BuildH2O;

import BuildH2O.BuildH2O.*;
import java.util.Scanner;

public class TestBuildingH2O {

	public static void main(String[] args) throws InterruptedException {

		Scanner scanner = new Scanner(System.in);
		BuildingH2O buildingH2O = new BuildingH2O();

		System.out.print("Enter the number of oxygen threads you want to produce: ");
		int molecules = scanner.nextInt();
		System.out.print("Enter the amount of time for which you want the main thread to sleep (in seconds): ");
		int time = scanner.nextInt();

		for (int i = 0; i < 3*molecules; i++) {
			if(i%3 != 0) {
				Hydrogen hydrogen = new Hydrogen(buildingH2O);
				Thread thread = new Thread(hydrogen);
				thread.start();
			}
			else {
				Oxygen oxygen = new Oxygen(buildingH2O);
				Thread thread = new Thread(oxygen);
				thread.start();
			}
		}

		Thread.sleep(time*1000);
		scanner.close();
		System.exit(0);

	}

}
/*
Output:Enter the number of oxygen threads you want to produce: 
10
Enter the amount of time for which you want the main thread to sleep (in seconds): 
2 
Hydrogen atom 1 waiting at barrier.
Hydrogen atom 2 waiting at barrier.
Hydrogen atom 3 waiting at barrier.
Hydrogen atom 4 waiting at barrier.
Hydrogen atom 5 waiting at barrier.
Hydrogen atom 6 waiting at barrier.
Hydrogen atom 7 waiting at barrier.
Hydrogen atom 8 waiting at barrier.
Hydrogen atom 9 waiting at barrier.
Hydrogen atom 18 waiting at barrier.
Oxygen atom 9 waiting at barrier.
Water molecule Produced!
Hydrogen atom 17 waiting at barrier.
Oxygen atom 8 waiting at barrier.
Hydrogen atom 16 waiting at barrier.
Oxygen atom 7 waiting at barrier.
Hydrogen atom 15 waiting at barrier.
Oxygen atom 6 waiting at barrier.
Hydrogen atom 14 waiting at barrier.
Water molecule Produced!
Oxygen atom 5 waiting at barrier.
Hydrogen atom 13 waiting at barrier.
Oxygen atom 4 waiting at barrier.
Hydrogen atom 12 waiting at barrier.
Water molecule Produced!
Oxygen atom 3 waiting at barrier.
Hydrogen atom 11 waiting at barrier.
Oxygen atom 2 waiting at barrier.
Hydrogen atom 10 waiting at barrier.
Water molecule Produced!
Oxygen atom 1 waiting at barrier.
Water molecule Produced!
 */
