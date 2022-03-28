package GameEngine.MapGeneration.SmallSquare.Utils;

import GameEngine.MapGeneration.SmallSquare.Models.Door;
import GameEngine.MapGeneration.SmallSquare.Models.Room;

public class GetDoorNames {
    private String doorDetails(String orientation, Door door){
        if(door == null)
            return "";
        var msg = orientation + ": ";
        msg += door.title();
        msg += door.isLocked() ? " (locked)" : " (not locked)";
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
