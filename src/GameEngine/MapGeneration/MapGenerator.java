package GameEngine.MapGeneration;

import GameEngine.Contracts.IObjectEntity;
import GameEngine.MapGeneration.SmallSquare.BuildSmallSquared;
import GameEngine.MapGeneration.SmallSquare.Map.Map;
import GameEngine.MapGeneration.SmallSquare.Map.Rooms.Node;

import java.util.ArrayList;
import java.util.List;

public class MapGenerator {
    private BuildSmallSquared _mapBuilder = new BuildSmallSquared();

    private List<IObjectEntity> getDoors(Node room){
        var doors = new ArrayList<IObjectEntity>();
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

    private void populateRoomObjects(Map map){
        var rooms = map.rooms();
        rooms.forEach(r -> {
            var roomObjects = new ArrayList<IObjectEntity>();
            var doors = getDoors(r);
            roomObjects.addAll(doors);
            roomObjects.addAll(r.items());
            roomObjects.addAll(r.demons());
            r.setRoomObjects(roomObjects);
        });
    }

    public Map build(){
        var map = _mapBuilder.build();
        populateRoomObjects(map);
        return map;
    }
}
