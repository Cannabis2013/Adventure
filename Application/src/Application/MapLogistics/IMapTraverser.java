package Application.MapLogistics;

import ApplicationBuilder.BuildMap.BuildRooms.Room;

public interface IMapTraverser {
    Room traverse(String orientation, Room currentRoom);
}
