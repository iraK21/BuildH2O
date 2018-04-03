package BuildH2O;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class TestBuildingH2O {

	public static void main(String[] args) {
	
		BuildingH2O buildingH2O = new BuildingH2O();
		System.out.println(buildingH2O.hydroxyBarrier.getParties());
	}

}

/**
 * This class encapsulates the functioning of the code.
 */
class BuildingH2O {

	int hydrogen;
	int oxygen;
	private Semaphore mutex;
	Semaphore hydrogenQueue, oxygenQueue;
	CyclicBarrier hydroxyBarrier;
	
	/**
	 * Constructor
	 */
	BuildingH2O() {
	
		mutex = new Semaphore(0);
		hydroxyBarrier = new CyclicBarrier(3);
		
	}

}

class Oxygen implements Runnable {

	private CyclicBarrier hydroxyBarrier;
	public void run() {
		try {
			hydroxyBarrier.await();
		} 
		catch(InterruptedException | BrokenBarrierException ignored) {}
		
	}

}

class Hydrogen implements Runnable {

	CyclicBarrier hydroxyBarrier;
	public void run() {
		try {
			hydroxyBarrier.await();
		} 
		catch(InterruptedException | BrokenBarrierException e) {}
	
	}	

}
