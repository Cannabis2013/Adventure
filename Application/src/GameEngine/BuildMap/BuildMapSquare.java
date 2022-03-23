package GameEngine.BuildMap;

import GameEngine.BuildMap.Connect.ConnectSquared;
import GameEngine.BuildMap.Map.IMap;
import GameEngine.BuildMap.Map.Map;
import GameEngine.BuildMap.Rooms.BuildRooms;
import GameEngine.BuildMap.Rooms.Room;

import java.util.List;
import java.util.Random;

public class BuildMapSquare {
    private BuildRooms _buildRooms = new BuildRooms();
    private ConnectSquared _connectRooms = new ConnectSquared();

    private List<Room> buildRooms(int count, IMap map){
        var rooms = _buildRooms.build(count,map);
        _connectRooms.connect(rooms);
        return rooms;
    }

    private Room randomizeInitialRoom(List<Room> rooms){
        var normals = rooms.stream()
                .filter(r -> r.getRoomType() == Room.RoomType.Normal)
                .toList();
        var rand = new Random();
        var randIndex = rand.nextInt(normals.size());
        return normals.get(randIndex);
    }

    public Map build(){
        var map = new Map();
        var rooms = buildRooms(9,map);
        map.setRooms(rooms);
        var initialRoom = randomizeInitialRoom(map.rooms());
        map.setInitialRoom(initialRoom);
        return map;
    }
}
