package GameEngine.MapGeneration.SmallSquare.Utils;

import GameEngine.MapGeneration.SmallSquare.Map.Rooms.Door;
import GameEngine.MapGeneration.SmallSquare.Map.Rooms.Room;

public class GetDoorNames {
    private String doorDetails(String orientation, Door door){
        if(door == null)
            return "";
        var msg = orientation + ": ";
        msg += door.presentate();
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
