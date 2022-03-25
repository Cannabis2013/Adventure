package GameEngine.BuildMap.Map;

import GameEngine.BuildMap.Rooms.Room;
import GameEngine.MapObjects.MapObject;

import java.util.List;

public interface IMap {
    List<Room> rooms();
    Room initialRoom();
}
