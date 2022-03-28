package GameEngine.MapGeneration.SmallSquare.Models;

import GameEngine.Contracts.IMap;
import GameEngine.Contracts.IRoom;

import java.util.List;

public class Map implements IMap {
    private List<Room> _rooms;
    private IRoom _initialRoom;

    @Override
    public List<IRoom> rooms() {
        return _rooms.stream().map(r -> (IRoom)r).toList();
    }
    public void setRooms(List<Room> rooms) {_rooms = rooms;}

    @Override
    public IRoom initialRoom() {
        return _initialRoom;
    }
    public void setInitialRoom(IRoom room) {_initialRoom = room;}

}
