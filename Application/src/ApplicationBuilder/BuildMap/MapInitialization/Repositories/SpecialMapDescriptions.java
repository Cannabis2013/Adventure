package ApplicationBuilder.BuildMap.MapInitialization.Repositories;

import Application.BuildMap.RoomDescriptions.IDescriptionsRepository;

import java.util.ArrayList;
import java.util.List;

public class SpecialMapDescriptions implements IDescriptionsRepository {
    private List<String> specialDescriptions = new ArrayList<>();

    public SpecialMapDescriptions() {
        specialDescriptions.add("You are overwhelmed by the shine of all the gold present in this room.");
        specialDescriptions.add("You are to fight the boss *Peter - The lord of bad practices*");
        specialDescriptions.add("You enter a room with a stair that leads up to heaven - at least that is what you hope for.");
    }

    @Override
    public List<String> descriptions() {
        return specialDescriptions;
    }

}
