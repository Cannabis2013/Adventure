package ApplicationBuilder.Application;

import Application.BuildMap.IBuildMap;
import Application.MapLogistics.IMapTraverser;
import ApplicationBuilder.BuildMap.BuildRooms.Room;
import Application.IApplication;

public abstract class AbstractApplication implements IApplication {
    protected Room _currentRoom;

    protected IBuildMap<Room> _buildMap;
    public void setMapBuilder(IBuildMap<Room> builder) {_buildMap = builder;}

    protected IMapTraverser _traverseTo;
    public void setMapTraverser(IMapTraverser traverser) {_traverseTo = traverser;}
}
