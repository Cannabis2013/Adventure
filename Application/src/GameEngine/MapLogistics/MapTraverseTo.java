package GameEngine.MapLogistics;

import GameEngine.BuildMap.Room;

public class MapTraverseTo {

    private Room tryGoNorth(Room currentRoom)
    {
        if(currentRoom.getNorth() != null)
            return currentRoom.getNorth();
        else
            throw new IllegalStateException();

    }

    private Room tryGoEast(Room currentRoom)
    {
        if(currentRoom.getEast() != null)
            return currentRoom.getEast();
        else
            throw new IllegalStateException();

    }

    private Room tryGoSouth(Room currentRoom)
    {
        if(currentRoom.getSouth() != null)
            return currentRoom.getSouth();
        else
            throw new IllegalStateException();

    }

    private Room tryGoWest(Room currentRoom)
    {
        if(currentRoom.getWest() != null)
            return currentRoom.getWest();
        else
            throw new IllegalStateException();

    }

    public Room traverse(String orientation, Room currentRoom)
    {
        switch (orientation){
            case "north" -> {return tryGoNorth(currentRoom);}
            case "east" -> {return tryGoEast(currentRoom);}
            case "south" -> {return tryGoSouth(currentRoom);}
            case "west" -> {return tryGoWest(currentRoom);}
            default -> throw new IllegalArgumentException();
        }
    }
}
