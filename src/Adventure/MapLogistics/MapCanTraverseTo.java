package Adventure.MapLogistics;

import Adventure.Room.Room;

public class MapCanTraverseTo {
    public boolean canTraverseNorth(Room room){
        return room.north != null;
    }
    public boolean canTraverseEast(Room room){
        return room.east != null;
    }
    public boolean canTraverseSouth(Room room){
        return room.south != null;
    }
    public boolean canTraverseWest(Room room){
        return room.west != null;
    }
}
