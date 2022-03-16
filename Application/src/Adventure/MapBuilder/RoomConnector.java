package Adventure.MapBuilder;

import Adventure.Room.Room;

public class RoomConnector {
    public void connectRoomNorth(Room southOf, Room northOf) {
        southOf.setNorth(northOf);
        northOf.setSouth(southOf);
    }

    public void connectRoomEast(Room westOf, Room eastOf) {
        westOf.setEast(eastOf);
        eastOf.setWest(westOf);
    }

    public void connectRoomSouth(Room northOf, Room southOf) {
        northOf.setSouth(southOf);
        southOf.setNorth(northOf);
    }

    public void connectRoomWest(Room eastOf, Room westOf) {
        eastOf.setWest(westOf);
        westOf.setEast(eastOf);
    }
}
