package BuildH2O;

import java.util.concurrent.BrokenBarrierException;

public class Hydrogen implements Runnable {

    private BuildingH2O buildingH2O;

    public Hydrogen(BuildingH2O buildingH2O) {
        this.buildingH2O = buildingH2O;
    }

    @Override
    public void run() {

        try {
            buildingH2O.hydroxyBarrier.await();

            if(buildingH2O.hydrogen > 0 && buildingH2O.oxygen > 0) {
                buildingH2O.hydrogenQueue.release();
                buildingH2O.hydrogen--;
                buildingH2O.oxygenQueue.release();
                buildingH2O.oxygen--;
                buildingH2O.makeWaterMolecule();
            }

            else {
                buildingH2O.hydrogen++;
                buildingH2O.hydrogenQueue.acquire();
                buildingH2O.makeWaterMolecule();
            }

        } catch (InterruptedException | BrokenBarrierException ignored) {}

    }

}
