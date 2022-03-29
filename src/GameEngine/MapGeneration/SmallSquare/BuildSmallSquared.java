package GameEngine.MapGeneration.SmallSquare;

import GameEngine.Contracts.IMap;
import GameEngine.Contracts.IRoom;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.InitializeMap;
import GameEngine.MapGeneration.SmallSquare.Map.Map;
import GameEngine.MapGeneration.SmallSquare.Map.Rooms.Room;
import GameEngine.MapGeneration.SmallSquare.Utils.AddBossRoom;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BuildSmallSquared {
    private InitializeMap _initMap = new InitializeMap();
    private AddBossRoom _setBossRoom = new AddBossRoom();

    private List<Room> buildRooms(IMap map){
        var rooms = new ArrayList<Room>(9);
        for (var i = 0;i < 9;i++)
            rooms.add(new Room(IRoom.RoomType.NORMAL_ROOM, map));
        return rooms;
    }

    private Room randomizeInitialRoom(List<Room> rooms){
        var normals = rooms.stream()
                .filter(r -> r.getRoomType() == Room.RoomType.NORMAL_ROOM).toList();
        var rand = new Random();
        var randIndex = rand.nextInt(normals.size());
        return normals.get(randIndex);
    }

    private int bound(List<Room> rooms){
        return  (int) Math.sqrt(rooms.size() + 1);
    }

    private void connectWest(List<Room> rooms, int index, Room room, int x){
        var eastOf = rooms.get(index - 1);
        room.setWest(eastOf);
    }

    private void connectNorth(List<Room> rooms, int index, Room room, int y){
        var indexOfNorthRoom = index - bound(rooms);
        var northRoom = rooms.get(indexOfNorthRoom);
        room.setNorth(northRoom);
    }

    private void connectRooms(List<Room> rooms, int index, int x, int y){
        if(x >= bound(rooms))
        {
            x = 0;
            y++;
        }
        if(index >= rooms.size())
            return;
        var room = rooms.get(index);
        if(x > 0)
            connectWest(rooms,index,room,x);
        if(y > 0)
            connectNorth(rooms,index,room,y);
        connectRooms(rooms,++index,++x,y);
    }

    public Map build() {
        var map = new Map();
        var rooms = buildRooms(map);
        connectRooms(rooms,0,0,0);
        _setBossRoom.set(map,rooms,bound(rooms));
        _initMap.initialize(rooms);
        map.setRooms(rooms);
        map.setInitialRoom(randomizeInitialRoom(rooms));
        return map;
    }
}
