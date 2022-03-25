package GameEngine.MapGeneration.MapBuilders.Map;

import GameEngine.MapGeneration.MapBuilders.Map.Room;

import java.util.List;

public interface IMap {
    List<Room> rooms();
    Room initialRoom();
    void setInitialRoom(Room room);
}
