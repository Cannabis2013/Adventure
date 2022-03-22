package GameEngine.MapLogistics;

import GameEngine.BuildMap.Rooms.DoorIsLockedException;
import GameEngine.BuildMap.Rooms.Room;

public class MapTraverseTo {

    private Room tryGoNorth(Room currentRoom) throws DoorIsLockedException, NoDoorAtOrientationException {
        if(currentRoom.getNorth() != null)
            return currentRoom.getNorth().getOther(currentRoom);
        else
            throw new NoDoorAtOrientationException();
    }

    private Room tryGoEast(Room currentRoom) throws DoorIsLockedException, NoDoorAtOrientationException {
        if(currentRoom.getEast() != null)
            return currentRoom.getEast().getOther(currentRoom);
        else
            throw new NoDoorAtOrientationException();

    }

    private Room tryGoSouth(Room currentRoom) throws DoorIsLockedException, NoDoorAtOrientationException {
        if(currentRoom.getSouth() != null)
            return currentRoom.getSouth().getOther(currentRoom);
        else
            throw new NoDoorAtOrientationException();

    }

    private Room tryGoWest(Room currentRoom) throws DoorIsLockedException, NoDoorAtOrientationException {
        if(currentRoom.getWest() != null)
            return currentRoom.getWest().getOther(currentRoom);
        else
            throw new NoDoorAtOrientationException();

    }

    public Room traverse(String orientation, Room currentRoom) throws DoorIsLockedException, BadDirectionException, NoDoorAtOrientationException {
        switch (orientation){
            case "north" -> {return tryGoNorth(currentRoom);}
            case "east" -> {return tryGoEast(currentRoom);}
            case "south" -> {return tryGoSouth(currentRoom);}
            case "west" -> {return tryGoWest(currentRoom);}
            default -> throw new BadDirectionException();
        }
    }
}
