package ApplicationBuilder.BuildMap.BuildRooms;

import Application.BuildMap.BuildRooms.IBuildRooms;

public class BuildRooms implements IBuildRooms<Rooms> {
    static int _num = 1;
    String genString(){
        return String.format("room %d",_num++);
    }

    private Room build() {
        var room = new Room();
        room.setName(genString());
        return room;
    }

    @Override
    public Rooms buildRooms(){
        var rooms = new Rooms();
        rooms.room1 = build();
        rooms.room2 = build();
        rooms.room3 = build();
        rooms.room4 = build();
        rooms.room5 = build();
        rooms.room6 = build();
        rooms.room7 = build();
        rooms.room8 = build();
        rooms.room9 = build();
        return rooms;
    }
}
