package GameEngine.BuildMap;

import java.util.ArrayList;

public class BuildRooms{
    private int _num = 1;
    String genString(){
        return String.format("room %d",_num++);
    }

    private Room normal() {
        var room = new Room(genString(), Room.Type.Normal);
        return room;
    }

    public ArrayList<Room> build(int count){
        var rooms = new ArrayList<Room>();
        for (var i = 0;i < count;i++)
            rooms.add(normal());
        return rooms;
    }
}
