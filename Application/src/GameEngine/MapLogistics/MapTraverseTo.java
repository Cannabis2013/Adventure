package GameEngine.MapLogistics;

import GameEngine.BuildMap.BuildRooms.Room;

public class MapTraverseTo {
    boolean canTraverse(Room room) {return room != null;}

    private Room tryGoNorth(Room currentRoom)
    {
        boolean canTraverse = canTraverse(currentRoom.getNorth());
        if(!canTraverse)
            throw new IllegalStateException();
        else
            return currentRoom.getNorth();
    }

    private Room tryGoEast(Room currentRoom)
    {
        boolean canTraverse = canTraverse(currentRoom.getEast());
        if(!canTraverse)
            throw new IllegalStateException();
        else
            return currentRoom.getEast();
    }

    private Room tryGoSouth(Room currentRoom)
    {
        boolean canTraverse = canTraverse(currentRoom.getSouth());
        if(!canTraverse)
            throw new IllegalStateException();
        else
            return currentRoom.getSouth();
    }

    private Room tryGoWest(Room currentRoom)
    {
        boolean canTraverse = canTraverse(currentRoom.getWest());
        if(!canTraverse)
            throw new IllegalStateException();
        else
            return currentRoom.getWest();
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
