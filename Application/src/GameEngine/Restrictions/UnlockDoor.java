package GameEngine.Restrictions;

import GameEngine.BuildMap.Rooms.Door;
import GameEngine.BuildMap.Rooms.Room;
import GameEngine.BuildMap.Rooms.WrongKeyException;
import GameEngine.InitializeMap.MapItems.Item;
import GameEngine.InitializeMap.MapRestrictions.Key;

public class UnlockDoor {
    private Door getDoor(String orientation, Room room){
        switch (orientation){
            case "north", "n" : return room.getNorth();
            case "east", "e" : return room.getEast();
            case "south", "s" : return room.getSouth();
            case "west", "w" : return room.getWest();
            default: throw new IllegalArgumentException();
        }
    }

    public void tryUnlock(String orientation, Room room, Item keyAsItem) throws WrongKeyException, DoorNotFoundException {
        var key = (Key) keyAsItem;
        var door = getDoor(orientation,room);
        if(door == null)
            throw new DoorNotFoundException();
        door.unlock(key.getID());
        if(door.isLocked())
            throw new WrongKeyException();
    }
}
