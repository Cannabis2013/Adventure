package ApplicationBuilder.AssembleMapBuilder.BuildMap.RoomConnector;

import ApplicationBuilder.AssembleMapBuilder.BuildMap.BuildRooms.Rooms;

public class ConnectRegularRooms extends AbstractConnectRooms {

    public void connect(Rooms rooms){
        connectRoomEast(rooms.room1, rooms.room2);
        connectRoomEast(rooms.room2,rooms.room3);
        connectRoomSouth(rooms.room3,rooms.room6);
        connectRoomSouth(rooms.room6,rooms.room9);
        connectRoomWest(rooms.room9,rooms.room8);
        connectRoomWest(rooms.room8,rooms.room7);
        connectRoomNorth(rooms.room7,rooms.room4);
        connectRoomNorth(rooms.room4,rooms.room1);
    }
}
