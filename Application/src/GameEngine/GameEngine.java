package GameEngine;

import GameEngine.BuildMap.BuildMapSquare;
import GameEngine.BuildMap.Map.IMap;
import GameEngine.BuildMap.Rooms.DoorIsLockedException;
import GameEngine.InitializeMap.MapItems.InvalidObjectException;
import GameEngine.MapLogistics.BadDirectionException;
import GameEngine.MapLogistics.NoDoorAtOrientationException;
import GameEngine.Player.EquipWeaponFailedException;
import GameEngine.Player.Player;
import GameEngine.Utils.FindObjectByTitle;
import GameEngine.Utils.ItemNotFoundException;
import GameEngine.Utils.ObjectNotFoundException;

public class GameEngine {
    private Player _player = new Player("");
    private IMap _map;

    public GameEngine(){
        _map = new BuildMapSquare().build();
        _player.setCurrentRoom(_map.initialRoom());
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

    public String eatItem(String itemTitle) throws ItemNotFoundException, InvalidObjectException {
        return _player.consumeItem(itemTitle);
    }

    public String roomItems(){
        return _player.getCurrentRoom().itemsAsString();
    }

    public String inventory(){
        return _player.inventoryToString();
    }

    public int health() {
        return _player.getHealth();
    }

    public String useItem(String item, String target) throws ItemNotFoundException, ObjectNotFoundException, InvalidObjectException {
        var findObject = new FindObjectByTitle();
        var targetItem = findObject.find(_map.objects(),target);
        return _player.useItem(item,targetItem);
    }

    public String useItem(String item) throws InvalidObjectException, ItemNotFoundException {
        return _player.useItem(item, _player);
    }

    public String equipWeapon(String weapon) throws EquipWeaponFailedException, ItemNotFoundException {
        return _player.equip(weapon);
    }
}
