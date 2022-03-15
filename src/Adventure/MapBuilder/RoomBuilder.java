package Adventure.MapBuilder;

import Adventure.Room.Room;

public class RoomBuilder {
    static int _num = 1;
    String genString(){
        return String.format("Room %d",_num++);
    }

    public Room build() {
        var room = new Room();
        room.name = genString();
        return room;
    }
}
