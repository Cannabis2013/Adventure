package GameEngine.MapGeneration.MapBuilders.Map;

import GameEngine.MapGeneration.MapBuilders.Map.Door;
import GameEngine.MapGeneration.MapBuilders.Map.Room;

public class GetDoorNames {
    private String doorDetails(String orientation, Door door){
        if(door == null)
            return "";
        var msg = orientation + ": ";
        msg += door.title();
        if(door.isLocked())
            msg += " (locked)";
        else
            msg += " (not locked)";
        msg += "\n";
        return msg;
    }

    public String doorNames(Room room){
        var msg = "";
        msg += doorDetails("North",room.getNorth());
        msg += doorDetails("East",room.getEast());
        msg += doorDetails("South",room.getSouth());
        msg += doorDetails("West",room.getWest());
        return msg;
    }
}
