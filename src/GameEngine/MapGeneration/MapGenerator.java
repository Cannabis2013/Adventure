package GameEngine.MapGeneration;

import GameEngine.Contracts.IMap;
import GameEngine.Contracts.IObjectEntity;
import GameEngine.Contracts.IRoom;
import GameEngine.MapGeneration.SmallSquare.BuildSmallSquared;
import GameEngine.MapGeneration.SmallSquare.Models.MapObject;
import java.util.ArrayList;
import java.util.List;

public class MapGenerator {
    private BuildSmallSquared _mapBuilder = new BuildSmallSquared();

    private List<MapObject> getDoors(IRoom room){
        var doors = new ArrayList<MapObject>();
        if(room.getNorth() != null)
            doors.add((MapObject) room.getNorth());
        if(room.getEast() != null)
            doors.add((MapObject)room.getEast());
        if(room.getSouth() != null)
            doors.add((MapObject)room.getSouth());
        if(room.getWest() != null)
            doors.add((MapObject) room.getWest());
        return doors;
    }

    private void populateRoomObjects(IMap map){
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

    public IMap build(){
        var map = _mapBuilder.build();
        populateRoomObjects(map);
        return map;
    }
}
