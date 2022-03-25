package GameEngine.BuildMap.Map;

import GameEngine.BuildMap.Rooms.Room;
import GameEngine.MapObjects.MapObject;

import java.util.List;

public class Map implements IMap {
    private List<Room> _rooms;
    private Room _initialRoom;

    @Override
    public List<Room> rooms() {
        return _rooms;
    }
    public void setRooms(List<Room> rooms) {_rooms = rooms;}

    @Override
    public Room initialRoom() {
        return _initialRoom;
    }
    public void setInitialRoom(Room room) {_initialRoom = room;}

}
