package ApplicationBuilder.BuildMap;

import ApplicationBuilder.BuildMap.BuildRooms.Rooms;
import ApplicationBuilder.BuildMap.BuildRooms.Room;

public class BuildMap extends AbstractMapBuilder {

    public void initializeMap(Rooms room) {
        _updateRoomDescriptor.update(room.room1,_mapDescriptions,true);
        _updateRoomDescriptor.update(room.room5,_specialMapDescriptions,false);
    }

    private void connectRooms(Rooms rooms){
        _connectRegularRooms.connect(rooms);
        _connectSpecialRooms.connect(rooms);
    }

    @Override
    public Room build(){
        var rooms = _roomBuilder.buildRooms();
        connectRooms(rooms);
        initializeMap(rooms);
        return rooms.room1;
    }
}
