import java.util.ArrayList;
import java.util.Random;



public class OpenWorld implements Observer {

	private int northSouthBoundary, eastWestBoundary;
	private PlayerLocation playerLocation;
	private ArrayList<Encounter> encounters = new ArrayList<Encounter>();


	public OpenWorld(int northSouthAxis,int eastWestAxis) {
		this.northSouthBoundary = northSouthAxis;
		this.eastWestBoundary = eastWestAxis;

		playerLocation = new PlayerLocation(northSouthBoundary, eastWestBoundary);




		playerLocation.registerObserver(this);

	}


	private void initialise() {
		ArrayList<String> encounterNames = new ArrayList<>();
		encounterNames.add("Flatlands");
		encounterNames.add("Lake");
		encounterNames.add("Wolf");
		encounterNames.add("FinishPoint");
		EncounterFactory encounterFactory= new EncounterFactory();
		Random random = new Random();

		for (int i = 0; i < northSouthBoundary; i++) {
			for (int j = 0; j < eastWestBoundary; j++) {
				int encounterGetter = random.nextInt(encounterNames.size());
				Encounter encounter = encounterFactory.createEncounter(encounterNames.get(encounterGetter));
				encounter.setEncounterCoordinates(new Coordinates(i,j));
				encounters.add(encounter);





			}


		}




		playerLocation.changeCoordinates(new Coordinates(0, 0));
		for (Encounter encounter : encounters) {
			encounter.printEncounterDetails();
		}
		System.out.println("---------------------------");
	}

	private void playerMove(int northSouthChange, int eastWestChange,Player player) {
		Coordinates initialCoordinates = playerLocation.getPlayerCoordinates();

		if(player.isGameOver() == false) {
			ifEncounterIsNearYou(player);

			this.playerLocation.changeCoordinates(new Coordinates(initialCoordinates.getNorthSouth() + northSouthChange, initialCoordinates.getEastWest() + eastWestChange));

			System.out.println("---------------------------");
		}
		else{
			System.out.println("Game is over you can't move");

		}
	}

	@Override
	public void update(PlayerLocation playerLocation) {
		this.playerLocation = playerLocation;



	}
	public void ifEncounterIsNearYou(Player player){
		Coordinates playerCoordinates = playerLocation.getPlayerCoordinates();
		for(int i =0;i< encounters.size();i++){
			if(encounters.get(i).encounterCoordinates.isEast(playerCoordinates)){
				System.out.println("To the east you " + encounters.get(i).nearbyAlert);
			}
			else if(encounters.get(i).encounterCoordinates.isSouth(playerCoordinates)){
				System.out.println("To the south you " + encounters.get(i).nearbyAlert);
			}
			else if(encounters.get(i).encounterCoordinates.isNorth(playerCoordinates)){
				System.out.println("To the north you " +encounters.get(i).nearbyAlert);
			}
			else if(encounters.get(i).encounterCoordinates.isWest(playerCoordinates)){
				System.out.println("To the west you " + encounters.get(i).nearbyAlert);
			}
			else if (encounters.get(i).encounterCoordinates.isHere(playerCoordinates )){

					encounters.get(i).effect(player);
				}
		}
	}





	public static void main(String[] args) {
		Encounter encounter = new FlatlandsEncounter();
		System.out.println(encounter.encounterName);
		OpenWorld world = new OpenWorld(2,2);
		world.initialise();
		Player player = new Player("Mohammed");
		world.playerMove(1, 0,player);
		world.playerMove(0, 1,player);





	}
}

