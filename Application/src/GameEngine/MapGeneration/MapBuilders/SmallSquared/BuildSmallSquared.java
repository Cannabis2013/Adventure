package GameEngine.MapGeneration.MapBuilders.SmallSquared;

import GameEngine.MapGeneration.MapBuilders.Map.IMap;
import GameEngine.MapGeneration.MapBuilders.Map.Map;
import GameEngine.MapGeneration.MapBuilders.IMapBuilder;
import GameEngine.MapGeneration.MapBuilders.Map.Room;
import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.InitializeMap;
import GameEngine.MapGeneration.MapBuilders.SmallSquared.Utils.PromoteToBossRoom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BuildSmallSquared implements IMapBuilder {
    private int _num = 1;
    private InitializeMap _initMap = new InitializeMap();
    private PromoteToBossRoom _promoteToBoss = new PromoteToBossRoom();

    private List<Room> buildRooms(IMap map){
        var rooms = new ArrayList<Room>();
        for (var i = 0;i < 9;i++)
            rooms.add(new Room(Room.RoomType.NORMAL_ROOM, map));
        return rooms;
    }

    private Room randomizeInitialRoom(List<Room> rooms){
        var normals = rooms.stream()
                .filter(r -> r.getRoomType() == Room.RoomType.NORMAL_ROOM)
                .toList();
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

    public IMap build() {
        var map = new Map();
        var rooms = buildRooms(map);
        map.setRooms(rooms);
        connectRooms(rooms,0,0,0);
        _promoteToBoss.promote(rooms,bound(rooms));
        map.setInitialRoom(randomizeInitialRoom(rooms));
        _initMap.initialize(map.rooms());
        return map;
    }
}
