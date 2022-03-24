package GameEngine.BuildMap;

import GameEngine.BuildMap.Connect.ConnectSquared;
import GameEngine.BuildMap.Map.Map;
import GameEngine.BuildMap.Rooms.BuildRooms;
import GameEngine.BuildMap.Rooms.Room;
import GameEngine.InitializeMap.InitializeMap;
import GameEngine.MapObjects.GetMapObjects;

import java.util.List;
import java.util.Random;

public class BuildMapSquare {
    private BuildRooms _buildRooms = new BuildRooms();
    private ConnectSquared _connectRooms = new ConnectSquared();

    private List<Room> setRooms(int count, Map map){
        var rooms = _buildRooms.build(count,map);
        _connectRooms.connect(rooms);
        map.setRooms(rooms);
        var initialRoom = randomizeInitialRoom(map.rooms());
        map.setInitialRoom(initialRoom);
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

    private void populateMap(Map map){
        var initMap = new InitializeMap();
        initMap.initialize(map.rooms());
        var getObjects = new GetMapObjects();
        map.setObjects(getObjects.assemble(map));
    }

    public Map build(){
        var map = new Map();
        setRooms(9,map);
        populateMap(map);
        return map;
    }
}
