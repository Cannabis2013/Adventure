package GameEngine.BuildMap;

import java.util.ArrayList;

public class BuildRooms{
    private AddRandomRoomDescription _addNormalDescription = new AddRandomRoomDescription();
    static int _num = 1;
    String genString(){
        return String.format("room %d",_num++);
    }

    private Room normal() {
        var room = new Room(genString(), Room.Type.Normal);
        room.setName(genString());
        _addNormalDescription.add(room);
        return room;
    }

    private Room special() {
        var room = new Room(genString(), Room.Type.Special);
        room.setName(genString());
        return room;
    }

    public ArrayList<Room> buildNormals(int count){
        var rooms = new ArrayList<Room>();
        for (var i = 0;i < count;i++)
            rooms.add(normal());
        return rooms;
    }

    public ArrayList<Room> buildSpecials(int count){
        var rooms = new ArrayList<Room>();
        for (var i = 0;i < count;i++)
            rooms.add(special());
        return rooms;
    }
}
