package GameEngine.BuildMap.BuildRooms;

import GameEngine.Item.Item;

public class BuildRooms{
    static int _num = 1;
    String genString(){
        return String.format("room %d",_num++);
    }

    private Room build() {
        var room = new Room();
        room.setName(genString());
        return room;
    }

    public Rooms buildRooms(){
        var rooms = new Rooms();
        rooms.room1 = build();
        rooms.room1.addItem(new Item("phone", "Nokia 3310"));
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
