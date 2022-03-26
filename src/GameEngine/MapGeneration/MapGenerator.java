package GameEngine.MapGeneration;

import GameEngine.MapGeneration.MapBuilders.Map.IMap;
import GameEngine.MapGeneration.MapBuilders.Map.MapObject;
import GameEngine.MapGeneration.MapBuilders.Map.Room;
import GameEngine.MapGeneration.MapBuilders.SmallSquared.BuildSmallSquared;

import java.util.ArrayList;
import java.util.List;

public class MapGenerator {
    private BuildSmallSquared _mapBuilder = new BuildSmallSquared();

    private List<MapObject> getDoors(Room room){
        var doors = new ArrayList<MapObject>();
        if(room.getNorth() != null)
            doors.add(room.getNorth());
        if(room.getEast() != null)
            doors.add(room.getEast());
        if(room.getSouth() != null)
            doors.add(room.getSouth());
        if(room.getWest() != null)
            doors.add(room.getWest());
        return doors;
    }

    private void populateRoomObjects(IMap map){
        var rooms = map.rooms();
        rooms.forEach(r -> {
            var roomObjects = r.roomObjects();
            roomObjects.addAll(getDoors(r));
            r.items().forEach(i -> roomObjects.add(i));
        });
    }

    public IMap build(){
        var map = _mapBuilder.build();
        populateRoomObjects(map);
        return map;
    }
}
