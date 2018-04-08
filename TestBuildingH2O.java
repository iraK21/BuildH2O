package OSProject;

import OSProject.BuildH2O.BuildingH2O;
import OSProject.BuildH2O.Hydrogen;
import OSProject.BuildH2O.Oxygen;

public class TestBuildingH2O {

	public static void main(String[] args) {

		BuildingH2O buildingH2O = new BuildingH2O();

		for (int i = 0; i < 100; i++) {
			if(i%2 == 0) {
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

	}

}

