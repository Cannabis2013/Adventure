package GameEngine.Player;

import GameEngine.BuildMap.Map.IMap;
import GameEngine.BuildMap.Rooms.DoorIsLockedException;
import GameEngine.BuildMap.Rooms.Room;
import GameEngine.BuildMap.Rooms.WrongKeyException;
import GameEngine.InitializeMap.LivingObjects.FatalBlowException;
import GameEngine.InitializeMap.LivingObjects.Human;
import GameEngine.InitializeMap.MapItems.Consumable;
import GameEngine.InitializeMap.MapItems.Usable;
import GameEngine.InitializeMap.MapItems.InvalidObjectException;
import GameEngine.InitializeMap.MapItems.Item;
import GameEngine.InitializeMap.Weapons.Weapon;
import GameEngine.MapLogistics.BadDirectionException;
import GameEngine.MapLogistics.MapTraverseTo;
import GameEngine.MapLogistics.NoDoorAtOrientationException;
import GameEngine.MapObjects.MapObject;
import GameEngine.Restrictions.DoorNotFoundException;
import GameEngine.Utils.GetItemFromList;
import GameEngine.Utils.ItemNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Player extends Human {
    private MapTraverseTo _traverseTo = new MapTraverseTo();
    private GetItemFromList _getItem = new GetItemFromList();
    private Room currentRoom;
    private Weapon _weapon;
    private final List<Item> _inventory = new ArrayList<>();

    public Player(String name) {
        super(name);
    }

    @Override
    public String equip(String weaponTitle) throws ItemNotFoundException, EquipWeaponFailedException {
        var weapon = _getItem.findByTitle(_inventory,weaponTitle);
        if(!(weapon instanceof Weapon))
            throw new EquipWeaponFailedException();
        _weapon = (Weapon) weapon;
        return weaponTitle;
    }


    @Override
    public String attack(MapObject object) throws FatalBlowException {
        return _weapon.attack(object);
    }

    public List<Item> inventory() {return _inventory;}

    public IMap getCurrentMap(){
        return currentRoom.map();
    }

    public String takeItem(String itemTitle) throws ItemNotFoundException {
        var item = currentRoom.takeItem(itemTitle);
        _inventory.add(item);
        return item.title();
    }

    public String dropItem(String itemTitle) throws ItemNotFoundException {
        var item = _getItem.findByTitle(_inventory,itemTitle);
        _inventory.remove(item);
        currentRoom.addItem(item);
        return item.title();
    }

    public Room getCurrentRoom() {return currentRoom;}
    public void setCurrentRoom(Room room) {currentRoom = room;}

    public String inventoryToString() {
        StringBuilder sb = new StringBuilder();
        _inventory.forEach(i-> sb.append(i.title() + "\n"));
        return sb.toString();
    }

    public void travelTo(String orientation) throws DoorIsLockedException, BadDirectionException, NoDoorAtOrientationException {
        currentRoom = _traverseTo.traverse(orientation,currentRoom);
    }

    public void tryUnlockDoor(String doorOrientation, String key) throws WrongKeyException, DoorNotFoundException, ItemNotFoundException {
        var item = _getItem.findByTitle(_inventory,key);
        currentRoom.tryUnlockDoor(doorOrientation,item);
    }

    @Override
    public String consumeItem(String itemTitle) throws ItemNotFoundException, InvalidObjectException {
        Item item = _getItem.findByTitle(_inventory, itemTitle);
        if (item instanceof Consumable) {
            var food = (Consumable) item;
            return food.consume(this);
        }
        throw new ItemNotFoundException();
    }

    public String useItem(String itemTitle, MapObject object) throws ItemNotFoundException, InvalidObjectException {
        var item = _getItem.findByTitle(_inventory,itemTitle);
        if(item instanceof Usable){
            var usable = (Usable) item;
            return usable.use(object);
        }
        throw new ItemNotFoundException();
    }

    @Override
    public int takeHealth(int dmg) throws FatalBlowException {
        _health -= dmg;
        if(_health < 0)
            throw new FatalBlowException();
        return dmg;
    }
}
