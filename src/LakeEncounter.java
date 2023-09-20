
public class LakeEncounter extends Encounter {
    public LakeEncounter(){
        encounterName = "Lake";
        nearbyAlert = "there is a vast expanse of water";



    }



    @Override
    public void effect(Player player) {
        System.out.println("The water is icy cold");
        player.takeDamage(10);

    }
}
