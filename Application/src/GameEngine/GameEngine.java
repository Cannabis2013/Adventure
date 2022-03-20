package GameEngine;

import GameEngine.BuildMap.Rooms.DoorIsLockedException;
import GameEngine.BuildMap.Rooms.Room;
import GameEngine.BuildMap.BuildMap;
import GameEngine.BuildMap.Rooms.WrongKeyException;
import GameEngine.InitializeMap.InitializeMap;
import GameEngine.InitializeMap.MapItems.Item;
import GameEngine.MapLogistics.MapTraverseTo;
import GameEngine.Player.ItemNotInInventoryException;
import GameEngine.Player.Player;
import GameEngine.Restrictions.DoorNotFoundException;
import GameEngine.Restrictions.UnlockDoor;

public class GameEngine {
    private Player player = new Player();
    private BuildMap _buildMap = new BuildMap();
    private InitializeMap _initializeMap = new InitializeMap();
    private MapTraverseTo _traverseTo = new MapTraverseTo();
    private UnlockDoor _unlockDoor = new UnlockDoor();

    public GameEngine(){
        var map = _buildMap.build();
        _initializeMap.initialize(map.getRooms());
        player.setCurrentRoom(map.getStartMap());
    }

    public void traverseTo(String orientation) throws IllegalArgumentException, IllegalStateException, DoorIsLockedException {
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

    public String roomItems(){
        return player.getCurrentRoom().itemsAsString();
    }

    public String inventory(){
        return player.toString();
    }

    public void unlock(String doorOrientation, String key) throws WrongKeyException, ItemNotInInventoryException, DoorNotFoundException {
        var item = player.getItemFromInventory(key);
        _unlockDoor.tryUnlock(doorOrientation,player.getCurrentRoom(),item);
    }
}
