package Adventure.MapInitialization;

import java.util.ArrayList;
import java.util.List;

public class MapSpecialRepository {
    private List<String> specialDescriptions = new ArrayList<>();

    public MapSpecialRepository() {
        specialDescriptions.add("You are overwhelmed by the shine of all the gold present in this room.");
        specialDescriptions.add("You are to fight the boss *Peter - The lord of bad practices*");
        specialDescriptions.add("You enter a room with a stair that leads up to heaven - at least that is what you hope for.");
    }

    public List<String> getSpecialDescriptions() {
        return specialDescriptions;
    }

}
