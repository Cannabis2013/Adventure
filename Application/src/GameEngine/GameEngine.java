package GameEngine;

import GameEngine.BuildMap.BuildRooms.Room;
import GameEngine.BuildMap.BuildMap;
import GameEngine.MapLogistics.MapTraverseTo;

public class GameEngine {
    private Room _currentRoom;

    private BuildMap _buildMap = new BuildMap();

    private MapTraverseTo _traverseTo = new MapTraverseTo();

    public void init(){_currentRoom = _buildMap.build();}

    public void traverseTo(String orientation) throws IllegalArgumentException, IllegalStateException {
        _currentRoom = _traverseTo.traverse(orientation,_currentRoom);
    }

    public String roomDescription() {
        return _currentRoom.getDescription();
    }
}
