public class EncounterFactory {
    public Encounter createEncounter(String encounterName){
        Encounter encounter = null;
        if (encounterName.equalsIgnoreCase("Wolf")) {
            encounter = new WolfEncounter();

        }
        else if (encounterName.equalsIgnoreCase("Flatlands")) {
            encounter = new FlatlandsEncounter();

        }
        else if (encounterName.equalsIgnoreCase("Lake")) {
            encounter = new LakeEncounter();

        }
        else if (encounterName.equalsIgnoreCase("FinishPoint")) {
            encounter = new FinishPointEncounter();

        }
        return encounter;


    }
}
