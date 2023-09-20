
public abstract class Encounter{
	Coordinates encounterCoordinates;
	String encounterName;
	public String nearbyAlert;

	public void setEncounterCoordinates(Coordinates encounterCoordinates) {
		this.encounterCoordinates = encounterCoordinates;
	}



	public abstract void effect(Player player);
	public void printEncounterDetails() {
		System.out.println(encounterName + " "+ encounterCoordinates.toString());
	}

}
