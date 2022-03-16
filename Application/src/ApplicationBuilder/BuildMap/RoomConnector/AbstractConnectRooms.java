package ApplicationBuilder.BuildMap.RoomConnector;

import Application.BuildMap.ConnectRooms.IConnectRooms;
import ApplicationBuilder.BuildMap.BuildRooms.Room;

public abstract class AbstractConnectRooms implements IConnectRooms {
    protected void connectRoomNorth(Room southOf, Room northOf) {
        southOf.setNorth(northOf);
        northOf.setSouth(southOf);
    }

    protected void connectRoomEast(Room westOf, Room eastOf) {
        westOf.setEast(eastOf);
        eastOf.setWest(westOf);
    }

    protected void connectRoomSouth(Room northOf, Room southOf) {
        northOf.setSouth(southOf);
        southOf.setNorth(northOf);
    }

    protected void connectRoomWest(Room eastOf, Room westOf) {
        eastOf.setWest(westOf);
        westOf.setEast(eastOf);
    }
}
