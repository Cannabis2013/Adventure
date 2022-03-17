package ApplicationBuilder.AssembleMapBuilder.Contracts.BuildMap;

import Application.BuildMap.IBuildMap;
import ApplicationBuilder.AssembleMapBuilder.BuildMap.BuildRooms.Room;
import ApplicationBuilder.AssembleMapBuilder.BuildMap.BuildRooms.Rooms;
import ApplicationBuilder.AssembleMapBuilder.Contracts.BuildRooms.IBuildRooms;
import ApplicationBuilder.AssembleMapBuilder.Contracts.ConnectRooms.IConnectRooms;
import ApplicationBuilder.AssembleMapBuilder.Contracts.RoomDescriptions.IUpdateRoomDescriptor;

public abstract class AbstractBuildMap implements IBuildMap<Room> {
    protected IBuildRooms<Rooms> _roomBuilder;
    public void setRoomBuilder(IBuildRooms<Rooms> builder) {_roomBuilder = builder;}

    protected IConnectRooms _connectRegularRooms;
    public void setConnectRegularRooms(IConnectRooms connector) {_connectRegularRooms = connector;}

    protected IConnectRooms _connectSpecialRooms;
    public void setConnectSpecialRooms(IConnectRooms connector) {_connectSpecialRooms = connector;}

    protected IUpdateRoomDescriptor<Room> _updateRoomDescriptions;
    public void setUpdateRoomDescriptions(IUpdateRoomDescriptor<Room> updater) {_updateRoomDescriptions = updater;}

    protected IUpdateRoomDescriptor<Room> _updateSpecialRoomDescriptions;
    public void setUpdateSpecialRoomDescriptions(IUpdateRoomDescriptor<Room> updater) {_updateSpecialRoomDescriptions = updater;}
}
