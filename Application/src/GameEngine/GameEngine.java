package GameEngine;

import GameEngine.BuildMap.BuildMap;
import GameEngine.BuildMap.Rooms.DoorIsLockedException;
import GameEngine.MapLogistics.BadDirectionException;
import GameEngine.MapLogistics.NoDoorAtOrientationException;
import GameEngine.Utils.ItemNotFoundException;
import GameEngine.BuildMap.Rooms.WrongKeyException;
import GameEngine.InitializeMap.InitializeMap;
import GameEngine.Player.Player;
import GameEngine.Restrictions.DoorNotFoundException;

public class GameEngine {
    private Player player = new Player();
    private BuildMap _buildMap = new BuildMap();
    private InitializeMap _initializeMap = new InitializeMap();

    public GameEngine(){
        var map = _buildMap.build();
        _initializeMap.initialize(map.getRooms());
        player.setCurrentRoom(map.getStartMap());
    }

    public void traverseTo(String orientation) throws IllegalArgumentException, IllegalStateException, DoorIsLockedException, BadDirectionException, NoDoorAtOrientationException {
        player.goInDirection(orientation);
    }

    public String roomDescription() {
        return player.getCurrentRoom().getDescription();
    }

    public void takeItem(String itemTitle) throws ItemNotFoundException {
        player.takeItem(itemTitle);
    }

    public void dropItem(String itemTitle) throws ItemNotFoundException {
        player.dropItem(itemTitle);
    }

    public String roomItems(){
        return player.getCurrentRoom().itemsAsString();
    }

    public String inventory(){
        return player.getInventoryAsString();
    }

    public void unlock(String doorOrientation, String key) throws WrongKeyException, ItemNotFoundException, DoorNotFoundException {
        player.tryUnlockDoor(doorOrientation,key);
    }
}
