package ApplicationBuilder.AssembleMapBuilder.BuildMap;

import Application.BuildMap.BuildRooms.IBuildRooms;
import Application.BuildMap.ConnectRooms.IConnectRooms;
import Application.BuildMap.IBuildMap;
import Application.BuildMap.RoomDescriptions.IUpdateRoomDescriptor;
import ApplicationBuilder.AssembleMapBuilder.BuildMap.BuildRooms.Rooms;
import ApplicationBuilder.AssembleMapBuilder.BuildMap.BuildRooms.Room;

public class BuildMap implements IBuildMap<Room> {

    private IBuildRooms<Rooms> _roomBuilder;
    public void setRoomBuilder(IBuildRooms<Rooms> builder) {_roomBuilder = builder;}

    private IConnectRooms _connectRegularRooms;
    public void setConnectRegularRooms(IConnectRooms connector) {_connectRegularRooms = connector;}

    private IConnectRooms _connectSpecialRooms;
    public void setConnectSpecialRooms(IConnectRooms connector) {_connectSpecialRooms = connector;}

    private IUpdateRoomDescriptor<Room> _updateRoomDescriptions;
    public void setUpdateRoomDescriptions(IUpdateRoomDescriptor<Room> updater) {_updateRoomDescriptions = updater;}

    private IUpdateRoomDescriptor<Room> _updateSpecialRoomDescriptions;
    public void setUpdateSpecialRoomDescriptions(IUpdateRoomDescriptor<Room> updater) {_updateSpecialRoomDescriptions = updater;}


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
