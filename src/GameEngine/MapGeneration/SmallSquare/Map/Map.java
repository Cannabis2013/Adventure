package GameEngine.MapGeneration.SmallSquare.Map;

import GameEngine.MapGeneration.SmallSquare.Map.Rooms.Room;
import java.util.List;

public class Map {
    private List<Room> _rooms;
    private Room _initialRoom;

    public List<Room> rooms() {return _rooms;}
    public void setRooms(List<Room> rooms) {_rooms = rooms;}

    public Room initialRoom() {return _initialRoom;}

    public void setInitialRoom(Room room) {_initialRoom = room;}
}
