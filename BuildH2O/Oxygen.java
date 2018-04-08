package BuildH2O;

import java.util.concurrent.BrokenBarrierException;

public class Oxygen implements Runnable {

    private BuildingH2O buildingH2O;

    public Oxygen(BuildingH2O buildingH2O) {
        this.buildingH2O = buildingH2O;
    }

    public void run() {

        try {
            buildingH2O.hydroxyBarrier.await();

            if(buildingH2O.hydrogen > 1) {

                buildingH2O.hydrogenQueue.release(2);
                buildingH2O.hydrogen-=2;
                buildingH2O.makeWaterMolecule();
            }

            else {
                buildingH2O.oxygen++;
                buildingH2O.oxygenQueue.acquire();
                buildingH2O.makeWaterMolecule();
            }

        } catch (InterruptedException | BrokenBarrierException ignored) {}

    }
}
