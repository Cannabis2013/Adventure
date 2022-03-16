package Adventure.MapLogistics;

import Adventure.Room.Room;

public class MapTraverseTo {
    MapCanTraverseTo canTraverse = new MapCanTraverseTo();

    private Room tryGoNorth(Room currentRoom)
    {
        boolean canTraverse = this.canTraverse.canTraverseNorth(currentRoom);
        if(!canTraverse)
            throw new IllegalStateException();
        else
            return currentRoom.getNorth();
    }

    private Room tryGoEast(Room currentRoom)
    {
        boolean canTraverse = this.canTraverse.canTraverseEast(currentRoom);
        if(!canTraverse)
            throw new IllegalStateException();
        else
            return currentRoom.getEast();
    }

    private Room tryGoSouth(Room currentRoom)
    {
        boolean canTraverse = this.canTraverse.canTraverseSouth(currentRoom);
        if(!canTraverse)
            throw new IllegalStateException();
        else
            return currentRoom.getSouth();
    }

    private Room tryGoWest(Room currentRoom)
    {
        boolean canTraverse = this.canTraverse.canTraverseWest(currentRoom);
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
            default -> {throw new IllegalArgumentException();}
        }
    }
}
