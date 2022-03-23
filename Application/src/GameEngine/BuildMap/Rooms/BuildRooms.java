package GameEngine.BuildMap.Rooms;

import GameEngine.BuildMap.Map.IMap;
import GameEngine.BuildMap.Map.Map;

import java.util.ArrayList;
import java.util.List;

public class BuildRooms{
    private int _num = 1;
    String genString(){
        return String.format("room %d",_num++);
    }

    private Room normal(IMap map) {
        var room = new Room(genString(), Room.RoomType.Normal, map);

        return room;
    }

    public List<Room> build(int count, IMap map){
        var rooms = new ArrayList<Room>();
        for (var i = 0;i < count;i++)
            rooms.add(normal(map));
        return rooms;
    }
}
