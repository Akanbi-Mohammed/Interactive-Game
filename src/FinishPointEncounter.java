public class FinishPointEncounter extends Encounter{

    public FinishPointEncounter(){
        encounterName = "Finish point";
        nearbyAlert = "see a golden beam of light";
        setEncounterCoordinates(new Coordinates(2,2));


    }


    @Override
    public void effect(Player player) {
        System.out.println("You have reached your goal");
        player.setGameOver(true);

    }

}
