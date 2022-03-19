package GameEngine.BuildMap;

import GameEngine.BuildMap.Connect.ConnectSquared;
import GameEngine.BuildMap.Rooms.BuildRooms;
import GameEngine.BuildMap.Rooms.Room;

import java.util.List;
import java.util.Random;

public class BuildMap {
    private BuildRooms _buildRooms = new BuildRooms();
    private ConnectSquared _connectRooms = new ConnectSquared();

    private Room startMap(List<Room> rooms){
        var normals = rooms.stream()
                .filter(r -> r.getType() == Room.Type.Normal)
                .toList();
        var rand = new Random();
        var randIndex = rand.nextInt(normals.size());
        return normals.get(randIndex);
    }

    public Map build(){
        var rooms = _buildRooms.build(9);
        _connectRooms.connect(rooms);
        var startMap = startMap(rooms);
        return new Map(rooms,startMap);
    }
}
