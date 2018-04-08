package BuildH2O;
 
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class BuildingH2O {

    int hydrogen;
    int oxygen;
    Semaphore hydrogenQueue, oxygenQueue;
    CyclicBarrier hydroxyBarrier;

    /**
     * Constructor
     */
    public BuildingH2O() {

        hydroxyBarrier = new CyclicBarrier(3);
        hydrogen = oxygen = 0;
        hydrogenQueue = new Semaphore(0);
        oxygenQueue = new Semaphore(0);
    }

    void makeWaterMolecule() {
        System.out.println("Water molecule Produced!");
        hydrogen = 0;
        oxygen = 0;
        hydroxyBarrier.reset();
    }

}
