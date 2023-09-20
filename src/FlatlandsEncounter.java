public class FlatlandsEncounter extends Encounter{

   public FlatlandsEncounter(){
       encounterName = "Flatlands";
       nearbyAlert = "boring open planes";



   }


    @Override
    public void effect(Player player) {
        System.out.println("Nothing has happened");
    }
}
