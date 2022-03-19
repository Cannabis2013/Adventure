package GameEngine.BuildMap.MapDescriptions;

import java.util.ArrayList;
import java.util.List;

public class SpecialMapDescriptions {
    private final ArrayList<String> specialDescriptions = new ArrayList<>();

    public SpecialMapDescriptions() {
        specialDescriptions.add("You are overwhelmed by the shine of all the gold present in this room.");
        specialDescriptions.add("You are to fight the boss *Peter - The lord of bad practices*");
        specialDescriptions.add("You enter a room with a stair that leads up to heaven - at least that is what you hope for.");
        specialDescriptions.add("""
                Ohh shit. There is definitely something wrong here.
                
                It seems that you have finally made it - to hell.
                
                Fire all over the place, tall pillars decorated with ancient glyphs, and this
                overwhelming loud noise of some machinery stomping - so violently that the earth
                shakes beneath you.
                
                Furthermore, the place is filled with flying burning skulls screaming.
                
                But here is the big problem. Among flying skulls and fire, you observe this
                enormeus beast, that is half animal, and half machinery.
                
                It has no forearms, but is instead equipped with two daunting rocket launchers. And
                by the way, it is 20 meters high.
                
                Ohh. You know this fellar. It's the Cyberdemon that you have defeated so many times - with so
                much effort. At least that is what you thought. Now you have to fight this beast again.
                """);
    }

    public int count(){
        return specialDescriptions.size();
    }

    public ArrayList<String> descriptions() {
        return specialDescriptions;
    }

}
