package Adventure.MapBuilder;

import Adventure.Room.Room;

public class RoomConnector {
    public void connectRoomNorth(Room southOf, Room northOf) {
        southOf.north = northOf;
        northOf.south = southOf;
    }

    public void connectRoomEast(Room westOf, Room eastOf) {
        westOf.east = eastOf;
        eastOf.west = westOf;
    }

    public void connectRoomSouth(Room northOf, Room southOf) {
        northOf.south = southOf;
        southOf.north = northOf;
    }

    public void connectRoomWest(Room eastOf, Room westOf) {
        eastOf.west = westOf;
        westOf.east = eastOf;
    }
}
