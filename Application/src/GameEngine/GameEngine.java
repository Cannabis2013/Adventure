package GameEngine;

import GameEngine.BuildMap.BuildRooms.Room;
import GameEngine.BuildMap.BuildMap;
import GameEngine.MapLogistics.MapTraverseTo;
import GameEngine.Player.Player;

public class GameEngine {
    private Player player = new Player();

    private BuildMap _buildMap = new BuildMap();
    private MapTraverseTo _traverseTo = new MapTraverseTo();

    public void init(){
        Room startRoom = _buildMap.build();
        player.setCurrentRoom(startRoom);
    }

    public void traverseTo(String orientation) throws IllegalArgumentException, IllegalStateException {
        Room newRoom = _traverseTo.traverse(orientation,player.getCurrentRoom());
        player.setCurrentRoom(newRoom);
    }

    public String roomDescription() {
        return player.getCurrentRoom().getDescription();
    }
}
