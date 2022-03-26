package GameEngine.MapLogistics;

import GameEngine.MapGeneration.MapBuilders.Map.DoorIsLockedException;
import GameEngine.MapGeneration.MapBuilders.Map.Node;

public class MapTraverseTo {

    private Node tryGoNorth(Node currentRoom) throws DoorIsLockedException, NoDoorAtOrientationException {
        if(currentRoom.getNorth() != null)
            return currentRoom.getNorth().getOther(currentRoom);
        else
            throw new NoDoorAtOrientationException();
    }

    private Node tryGoEast(Node currentRoom) throws DoorIsLockedException, NoDoorAtOrientationException {
        if(currentRoom.getEast() != null)
            return currentRoom.getEast().getOther(currentRoom);
        else
            throw new NoDoorAtOrientationException();

    }

    private Node tryGoSouth(Node currentRoom) throws DoorIsLockedException, NoDoorAtOrientationException {
        if(currentRoom.getSouth() != null)
            return currentRoom.getSouth().getOther(currentRoom);
        else
            throw new NoDoorAtOrientationException();

    }

    private Node tryGoWest(Node currentRoom) throws DoorIsLockedException, NoDoorAtOrientationException {
        if(currentRoom.getWest() != null)
            return currentRoom.getWest().getOther(currentRoom);
        else
            throw new NoDoorAtOrientationException();

    }

    public Node traverse(String orientation, Node currentRoom) throws DoorIsLockedException, BadDirectionException, NoDoorAtOrientationException {
        switch (orientation){
            case "north" -> {return tryGoNorth(currentRoom);}
            case "east" -> {return tryGoEast(currentRoom);}
            case "south" -> {return tryGoSouth(currentRoom);}
            case "west" -> {return tryGoWest(currentRoom);}
            default -> throw new BadDirectionException();
        }
    }
}
