package Adventure.MapBuilder;

import Adventure.Room.Room;

import java.util.Random;

public class MapBuilder {
    private RoomBuilder _roomBuilder = new RoomBuilder();
    private RoomConnector _roomConnector = new RoomConnector();

    private Rooms buildRooms(){
        var rooms = new Rooms();
        rooms.room1 = _roomBuilder.build();
        rooms.room2 = _roomBuilder.build();
        rooms.room3 = _roomBuilder.build();
        rooms.room4 = _roomBuilder.build();
        rooms.room5 = _roomBuilder.build();
        rooms.room6 = _roomBuilder.build();
        rooms.room7 = _roomBuilder.build();
        rooms.room8 = _roomBuilder.build();
        rooms.room9 = _roomBuilder.build();
        return rooms;
    }

    private void connectRoom5(Rooms rooms)
    {
        var room5 = rooms.room5;
        var rand = new Random();
        var num = rand.nextInt(4) + 1;
        switch (num){
            case 1 -> {_roomConnector.connectRoomNorth(room5,rooms.room2);}
            case 2 -> {_roomConnector.connectRoomEast(room5,rooms.room6);}
            case 3 -> {_roomConnector.connectRoomSouth(room5,rooms.room8);}
            case 4 -> {_roomConnector.connectRoomWest(room5,rooms.room4);}
        }
    }

    private Rooms buildMap(Rooms rooms){
        _roomConnector.connectRoomEast(rooms.room1, rooms.room2);
        _roomConnector.connectRoomEast(rooms.room2,rooms.room3);
        _roomConnector.connectRoomSouth(rooms.room3,rooms.room6);
        _roomConnector.connectRoomSouth(rooms.room6,rooms.room9);
        _roomConnector.connectRoomWest(rooms.room9,rooms.room8);
        _roomConnector.connectRoomWest(rooms.room8,rooms.room7);
        _roomConnector.connectRoomNorth(rooms.room7,rooms.room4);
        _roomConnector.connectRoomNorth(rooms.room4,rooms.room1);
        connectRoom5(rooms);
        return rooms;
    }

    public Room build(){
        var rooms = buildRooms();
        buildMap(rooms);
        return rooms.room1;
    };
}
