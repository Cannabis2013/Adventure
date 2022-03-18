package GameEngine;

import GameEngine.BuildMap.BuildRooms.Room;
import GameEngine.BuildMap.BuildMap;
import GameEngine.Item.Item;
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

    public void takeItem(String itemTitle) throws IllegalArgumentException{
        Item item = player.getCurrentRoom().takeItem(itemTitle);
        player.pickItem(item);
    }

    public void dropItem(String itemTitle) throws IllegalArgumentException{
        Item itemToDrop = player.dropItem(itemTitle);
        player.getCurrentRoom().addItem(itemToDrop);
    }

    public String getRoomItemsAsString(){
        return player.getCurrentRoom().toString();
    }

    public String getInventoryAsString(){
        return player.toString();
    }
}
