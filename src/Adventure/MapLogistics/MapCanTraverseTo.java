package Adventure.MapLogistics;

import Adventure.Room.Room;

public class MapCanTraverseTo {
    public boolean canTraverseNorth(Room room){
        return room.getNorth() != null;
    }
    public boolean canTraverseEast(Room room){
        return room.getEast() != null;
    }
    public boolean canTraverseSouth(Room room){
        return room.getSouth() != null;
    }
    public boolean canTraverseWest(Room room){
        return room.getWest() != null;
    }
}
