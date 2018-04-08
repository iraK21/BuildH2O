package BuildH2O;

//import java.util.concurrent.Semaphore;
//import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;

public class Solution {

    public static void main(String[] args) {

        BuildingH2O buildingH2O = new BuildingH2O();
        //	System.out.println(buildingH2O.hydroxyBarrier.getParties());
    }

}

/**
 * This class encapsulates the functioning of the code.
 */

class BuildingH2O {

    static int hydrogen =4;
    int oxygen = 4;
    java.util.concurrent.Semaphore mutex;
    java.util.concurrent.Semaphore hydrogenQueue, oxygenQueue;
    static java.util.concurrent.CyclicBarrier hydroxyBarrier;

    /**
     * Constructor
     */

    BuildingH2O() {

        mutex = new java.util.concurrent.Semaphore(0);
        hydroxyBarrier = new java.util.concurrent.CyclicBarrier(4);
        System.out.println("Initial Oxygen number :"+oxygen);
        System.out.println("Initial Hydrogen number :"+hydrogen);

        //Objects of classes
        Oxygen o = new Oxygen();
        Hydrogen1 h1 = new Hydrogen1();
        Hydrogen2 h2 = new Hydrogen2();

        //Condition for H2O to form
        while(oxygen != 0 && hydrogen >1 ) {
            System.out.println("Oxygen Left:"+oxygen+" Hydrogen Left:"+hydrogen);

            //Creation of thread
            Thread OxygenThread = new Thread(o);
            Thread HydrogenOneThread = new Thread(h1);
            Thread HydrogenTwoThread = new Thread(h2);

            OxygenThread.start();
            HydrogenOneThread.start();
            HydrogenTwoThread.start();
            try
            {
                //Reducing the number of Oxygen and Hydrogen after creation of a H2O molecule
                oxygen--;
                hydrogen--;
                hydrogen--;
                hydroxyBarrier.await();
            }
            catch (InterruptedException | BrokenBarrierException e)
            {
                e.printStackTrace();
            }

            System.out.println("Oxygen number :"+oxygen);
            System.out.println("Hydrogen number :"+hydrogen);

            hydroxyBarrier.reset();
        }
    }

}

class Oxygen implements Runnable {

    public void run() {
        try {
            BuildingH2O.hydroxyBarrier.await();
        }
        catch(InterruptedException | java.util.concurrent.BrokenBarrierException e) {}

    }

}

class Hydrogen1 implements Runnable {



    public void run() {
        try {
            BuildingH2O.hydroxyBarrier.await();
        }
        catch(InterruptedException | java.util.concurrent.BrokenBarrierException e) {}

    }

}
class Hydrogen2 implements Runnable {

    public void run() {
        try {
            BuildingH2O.hydroxyBarrier.await();
        }
        catch(InterruptedException | java.util.concurrent.BrokenBarrierException e) {}

    }

}
