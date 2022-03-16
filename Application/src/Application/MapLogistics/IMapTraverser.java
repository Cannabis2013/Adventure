package Application.MapLogistics;

import ApplicationBuilder.AssembleMapBuilder.BuildMap.BuildRooms.Room;

public interface IMapTraverser {
    Room traverse(String orientation, Room currentRoom);
}
