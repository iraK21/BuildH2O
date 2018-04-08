package BuildH2O;

public class TestBuildingH2O {

	public static void main(String[] args) {

		BuildH2O.BuildingH2O buildingH2O = new BuildH2O.BuildingH2O();

		for (int i = 0; i < 100; i++) {
			if(i%2 == 0) {
				BuildH2O.Hydrogen hydrogen = new BuildH2O.Hydrogen(buildingH2O);
				Thread thread = new Thread(hydrogen);
				thread.start();
			}
			else {
				BuildH2O.Oxygen oxygen = new BuildH2O.Oxygen(buildingH2O);
				Thread thread = new Thread(oxygen);
				thread.start();
			}
		}

	}

}

