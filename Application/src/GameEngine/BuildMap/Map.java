package GameEngine.BuildMap;

import GameEngine.BuildMap.Rooms.Room;

import java.util.List;

public class Map {
    private List<Room> rooms;
    private Room startMap;

    public Map(List<Room> rooms, Room startMap) {
        this.rooms = rooms;
        this.startMap = startMap;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public Room getStartMap() {
        return startMap;
    }
}
