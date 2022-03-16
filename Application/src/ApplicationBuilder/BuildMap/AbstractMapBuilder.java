package ApplicationBuilder.BuildMap;

import Application.BuildMap.BuildRooms.IBuildRooms;
import Application.BuildMap.ConnectRooms.IConnectRooms;
import Application.BuildMap.IBuildMap;
import Application.BuildMap.RoomDescriptions.IDescriptionsRepository;
import Application.BuildMap.RoomDescriptions.IUpdateRoomDescriptor;
import ApplicationBuilder.BuildMap.BuildRooms.Room;
import ApplicationBuilder.BuildMap.BuildRooms.Rooms;

public abstract class AbstractMapBuilder implements IBuildMap<Room> {
    protected IBuildRooms<Rooms> _roomBuilder;
    public void setRoomBuilder(IBuildRooms<Rooms> builder) {_roomBuilder = builder;}

    protected IConnectRooms _connectRegularRooms;
    public void setConnectRegularRooms(IConnectRooms connector) {_connectRegularRooms = connector;}
    protected IConnectRooms _connectSpecialRooms;
    public void setConnectSpecialRooms(IConnectRooms connector) {_connectSpecialRooms = connector;}

    protected IUpdateRoomDescriptor<Room> _updateRoomDescriptor;
    public void setUpdateRoomDescriptor(IUpdateRoomDescriptor<Room> updater) {_updateRoomDescriptor = updater;}

    protected IDescriptionsRepository _mapDescriptions;
    public void setOrdinaryMapDescriptions(IDescriptionsRepository repo) {_mapDescriptions = repo;}
    protected IDescriptionsRepository _specialMapDescriptions;
    public void setSpecialMapDescriptions(IDescriptionsRepository repo) {_specialMapDescriptions = repo;}
}
