public class WolfEncounter extends Encounter {

    public WolfEncounter(){
        encounterName = "Wolf";
        nearbyAlert = "hear distant howling.";



    }


    @Override
    public void effect(Player player) {
        System.out.println("You are attacked by wolves");
        player.takeDamage(20);
    }
}
