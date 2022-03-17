package ApplicationBuilder.AssembleMapBuilder.BuildMap;

import ApplicationBuilder.AssembleMapBuilder.BuildMap.BuildRooms.Room;
import ApplicationBuilder.AssembleMapBuilder.BuildMap.BuildRooms.Rooms;
import ApplicationBuilder.AssembleMapBuilder.Contracts.BuildMap.AbstractBuildMap;

public class BuildMap extends AbstractBuildMap {

    private void initializeMap(Rooms room) {
        _updateRoomDescriptions.updateRecursive(room.room1);
        _updateSpecialRoomDescriptions.update(room.room5);
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
