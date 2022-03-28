package GameEngine.Player;

import GameEngine.Contracts.DoorIsLockedException;
import GameEngine.Contracts.IMap;
import GameEngine.Contracts.IRoom;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.FatalBlowException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.InvalidObjectException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Item;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.Melee.KnuckleBusterWithVolts;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.Weapon;
import GameEngine.MapGeneration.SmallSquare.Map.MapObject;
import GameEngine.Player.Exceptions.*;
import GameEngine.Utils.FindObjectFromList;
import GameEngine.Utils.ItemNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Player extends PlayerObject {
    private FindObjectFromList _findObject = new FindObjectFromList();
    private IRoom _currentRoom;
    private Weapon _weapon = new KnuckleBusterWithVolts();
    private final List<Item> _inventory = new ArrayList<>();

    public String weaponAsString() {return _weapon.presentate();}

    public Weapon equipped(){return _weapon;}

    @Override
    public String equip(String weaponTitle) throws EquipWeaponFailedException, ItemNotFoundException {
        _weapon = _equipWeapon.equip(weaponTitle,_weapon,_findObject,_inventory);
        return _weapon.title();
    }

    @Override
    public String attack(MapObject object) throws FatalBlowException, InvalidObjectException {
        return String.format("%d",_weapon.attack(object));
    }

    public IMap getCurrentMap(){return _currentRoom.map();}

    public String takeItem(String itemTitle) throws ItemNotFoundException {
        var item = _currentRoom.takeItem(itemTitle);
        _inventory.add(item);
        return item.title();
    }

    public void takeAll(){
        var items = _currentRoom.items();
        _inventory.addAll(items);
        _currentRoom.items().clear();
    }

    public String dropItem(String itemTitle) throws ItemNotFoundException {
        var item = _findObject.findItemByTitle(_inventory,itemTitle);
        _inventory.remove(item);
        _currentRoom.addItem(item);
        return item.title();
    }

    public IRoom currentRoom() {return _currentRoom;}
    public void setCurrentRoom(IRoom room) {_currentRoom = room;}

    public List<String> inventoryToString() {
        return _inventory.stream().map(i -> i.presentate()).toList();
    }

    public void travelTo(String orientation) throws DoorIsLockedException, BadDirectionException, NoDoorAtOrientationException {
        _currentRoom = _traverseTo.enterAtOrientation(orientation, _currentRoom);
    }

    @Override
    public String consumeItem(String itemTitle) throws ItemNotFoundException, ItemNotConsumableException {
        return _consumeItem.consume(itemTitle,_findObject,_inventory,this);
    }

    public String useItem(String itemTitle, String roomObject) throws UsableNotFoundException, TargetNotFoundException, InvalidObjectException {
        return _useItem.use(itemTitle,roomObject, _currentRoom,_findObject,_inventory);
    }

    public String useItem(String itemTitle) throws InvalidObjectException, ItemNotFoundException, ItemNotUsableException {
        return _useItem.use(itemTitle,_findObject,_inventory,this);
    }
}
