package GameEngine.Player;

import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.FatalBlowException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.InvalidObjectException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.Weapon;
import GameEngine.MapGeneration.SmallSquare.Map.Map;
import GameEngine.MapGeneration.SmallSquare.Map.Rooms.DoorIsLockedException;
import GameEngine.MapGeneration.SmallSquare.Map.Rooms.Room;
import GameEngine.Player.Exceptions.*;
import GameEngine.Utils.ItemNotFoundException;

import java.util.List;

public class Player extends Character {

    public Player() {
        super("Player");
        _dodgeChange = 0.25;
        _hitChance = 0.8;
        _health = 100;
    }

    public String weaponAsString(){
        if(_weapon == null)
            return "No weapons equipped";
        return _weapon.presentate();
    }

    public Weapon equipped(){return _weapon;}

    public String equip(String weaponTitle) throws EquipWeaponFailedException, ItemNotFoundException {
        _weapon = _equipWeapon.equip(weaponTitle,_weapon,_bag);
        return _weapon.title();
    }

    public String attack() throws WeaponNotEquippedException {
        if(_weapon == null)
            throw new WeaponNotEquippedException();
        return String.format("%d",_weapon.attack());
    }

    public Map getCurrentMap(){return _currentRoom.map();}

    @Override
    public void die() throws FatalBlowException {
        throw new FatalBlowException();
    }

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

    public Room currentRoom() {return _currentRoom;}
    public void setCurrentRoom(Room room) {_currentRoom = room;}

    public List<String> inventoryToString() {return _bag.itemTitles();}

    public void travelTo(String orientation) throws DoorIsLockedException, BadDirectionException, NoDoorAtOrientationException {
        _currentRoom = (Room) _traverseTo.enterAtOrientation(orientation, _currentRoom);
    }

    public String consumeItem(String itemTitle) throws ItemNotFoundException, ItemNotConsumableException, PlayerHealthFullException {
        if(health() >= 100)
            throw new PlayerHealthFullException();
        return _consumeItem.consume(itemTitle,_bag,this);
    }

    public String useItem(String itemTitle, String roomObject) throws UsableNotFoundException, TargetNotFoundException, InvalidObjectException {
        return _useItem.use(itemTitle,roomObject, _currentRoom,_bag);
    }

    public String useItem(String itemTitle) throws InvalidObjectException, ItemNotUsableException, UsableNotFoundException {
        return _useItem.use(itemTitle,_bag,this);
    }
}
