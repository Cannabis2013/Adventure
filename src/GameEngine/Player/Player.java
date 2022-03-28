package GameEngine.Player;

import GameEngine.Contracts.DoorIsLockedException;
import GameEngine.Contracts.IMap;
import GameEngine.Contracts.IRoom;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.FatalBlowException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.InvalidObjectException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.Melee.KnuckleBusterWithVolts;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.Weapon;
import GameEngine.MapGeneration.SmallSquare.Map.MapObject;
import GameEngine.Player.Exceptions.*;
import GameEngine.Player.InventoryBag.Bag;
import GameEngine.Utils.FindObjectFromList;
import GameEngine.Utils.ItemNotFoundException;
import java.util.List;

public class Player extends PlayerObject {
    private FindObjectFromList _findObject = new FindObjectFromList();
    private IRoom _currentRoom;
    private Weapon _weapon = new KnuckleBusterWithVolts();
    private Bag _bag = new Bag();

    public String weaponAsString() {return _weapon.presentate();}

    public Weapon equipped(){return _weapon;}

    @Override
    public String equip(String weaponTitle) throws EquipWeaponFailedException, ItemNotFoundException {
        _weapon = _equipWeapon.equip(weaponTitle,_weapon,_bag);
        return _weapon.title();
    }

    @Override
    public String attack(MapObject object) throws FatalBlowException, InvalidObjectException {
        return String.format("%d",_weapon.attack(object));
    }

    public IMap getCurrentMap(){return _currentRoom.map();}

    public String takeItem(String itemTitle) throws ItemNotFoundException {
        var item = _currentRoom.takeItem(itemTitle);
        _bag.add(item);
        return item.title();
    }

    public void takeAll(){
        var items = _currentRoom.items();
        _bag.add(items);
        _currentRoom.items().clear();
    }

    public String dropItem(String itemTitle) throws ItemNotFoundException {
        var item = _bag.take(itemTitle);
        _currentRoom.addItem(item);
        return item.title();
    }

    public IRoom currentRoom() {return _currentRoom;}
    public void setCurrentRoom(IRoom room) {_currentRoom = room;}

    public List<String> inventoryToString() {return _bag.itemTitles();}

    public void travelTo(String orientation) throws DoorIsLockedException, BadDirectionException, NoDoorAtOrientationException {
        _currentRoom = _traverseTo.enterAtOrientation(orientation, _currentRoom);
    }

    @Override
    public String consumeItem(String itemTitle) throws ItemNotFoundException, ItemNotConsumableException {
        return _consumeItem.consume(itemTitle,_bag,this);
    }

    public String useItem(String itemTitle, String roomObject) throws UsableNotFoundException, TargetNotFoundException, InvalidObjectException {
        return _useItem.use(itemTitle,roomObject, _currentRoom,_bag);
    }

    public String useItem(String itemTitle) throws InvalidObjectException, ItemNotUsableException, UsableNotFoundException {
        return _useItem.use(itemTitle,_bag,this);
    }
}
