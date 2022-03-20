package GameEngine.MapLogistics;

import GameEngine.BuildMap.Rooms.DoorIsLockedException;
import GameEngine.BuildMap.Rooms.Room;

public class MapTraverseTo {

    private Room tryGoNorth(Room currentRoom) throws DoorIsLockedException {
        if(currentRoom.getNorth() != null)
            return currentRoom.getNorth().getOther(currentRoom);
        else
            throw new IllegalStateException();
    }

    private Room tryGoEast(Room currentRoom) throws DoorIsLockedException {
        if(currentRoom.getEast() != null)
            return currentRoom.getEast().getOther(currentRoom);
        else
            throw new IllegalStateException();

    }

    private Room tryGoSouth(Room currentRoom) throws DoorIsLockedException {
        if(currentRoom.getSouth() != null)
            return currentRoom.getSouth().getOther(currentRoom);
        else
            throw new IllegalStateException();

    }

    private Room tryGoWest(Room currentRoom) throws DoorIsLockedException {
        if(currentRoom.getWest() != null)
            return currentRoom.getWest().getOther(currentRoom);
        else
            throw new IllegalStateException();

    }

    public Room traverse(String orientation, Room currentRoom) throws DoorIsLockedException {
        switch (orientation){
            case "north", "n" -> {return tryGoNorth(currentRoom);}
            case "east", "e" -> {return tryGoEast(currentRoom);}
            case "south", "s" -> {return tryGoSouth(currentRoom);}
            case "west", "w" -> {return tryGoWest(currentRoom);}
            default -> throw new IllegalArgumentException();
        }
    }
}
