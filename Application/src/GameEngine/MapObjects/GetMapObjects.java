package GameEngine.MapObjects;

import GameEngine.BuildMap.Map.IMap;
import GameEngine.BuildMap.Rooms.Room;

import java.util.ArrayList;
import java.util.List;

public class GetMapObjects {
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

    public void populateRoomObjects(IMap map){
        var rooms = map.rooms();
        rooms.forEach(r -> {
            var roomObjects = r.roomObjects();
            roomObjects.addAll(getDoors(r));
            r.items().forEach(i -> roomObjects.add(i));
        });
    }
}
