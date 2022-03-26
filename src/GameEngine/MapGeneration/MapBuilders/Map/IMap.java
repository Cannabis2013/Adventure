package GameEngine.MapGeneration.MapBuilders.Map;

import java.util.List;

public interface IMap {
    List<Room> rooms();
    Room initialRoom();
    void setInitialRoom(Room room);
}
