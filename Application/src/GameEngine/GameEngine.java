package GameEngine;

import GameEngine.BuildMap.BuildMapSquare;
import GameEngine.BuildMap.Map.IMap;
import GameEngine.BuildMap.Rooms.DoorIsLockedException;
import GameEngine.BuildMap.Rooms.WrongKeyException;
import GameEngine.InitializeMap.InitializeMap;
import GameEngine.InitializeMap.MapItems.InvalidObjectException;
import GameEngine.MapLogistics.BadDirectionException;
import GameEngine.MapLogistics.NoDoorAtOrientationException;
import GameEngine.MapObjects.GetMapObjects;
import GameEngine.Player.Player;
import GameEngine.Restrictions.DoorNotFoundException;
import GameEngine.Utils.FindObjectByTitle;
import GameEngine.Utils.ItemNotFoundException;
import GameEngine.Utils.ObjectNotFoundException;

public class GameEngine {
    private Player _player = new Player();
    private IMap _map;

    public GameEngine(){
        var buildMap = new BuildMapSquare();
        var map = buildMap.build();
        var initMap = new InitializeMap();
        initMap.initialize(map.rooms());
        _player.setCurrentRoom(map.initialRoom());
        var getObjects = new GetMapObjects();
        map.setObjects(getObjects.assemble(map));
        _map = map;
    }

    public void traverseTo(String orientation) throws IllegalArgumentException, IllegalStateException, DoorIsLockedException, BadDirectionException, NoDoorAtOrientationException {
        _player.travelTo(orientation);
    }

    public String roomDescription() {
        return _player.getCurrentRoom().description();
    }

    public String doorNames(){
        return _player.getCurrentRoom().doorTitles();
    }

    public String takeItem(String itemTitle) throws ItemNotFoundException {
        return _player.takeItem(itemTitle);
    }

    public String dropItem(String itemTitle) throws ItemNotFoundException {
        return _player.dropItem(itemTitle);
    }

    public String roomItems(){
        return _player.getCurrentRoom().itemsAsString();
    }

    public String inventory(){
        return _player.getInventoryAsString();
    }

    public void unlock(String doorOrientation, String key) throws WrongKeyException, ItemNotFoundException, DoorNotFoundException {
        _player.tryUnlockDoor(doorOrientation,key);
    }

    public String useItem(String item, String target) throws ItemNotFoundException, ObjectNotFoundException, InvalidObjectException {
        var findObject = new FindObjectByTitle();
        var targetItem = findObject.find(_map.objects(),target);
        return _player.useItem(item,targetItem);
    }

    public String useItem(String item) throws InvalidObjectException, ItemNotFoundException {
        return _player.useItem(item, _player);
    }
}
