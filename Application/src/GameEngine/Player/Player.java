package GameEngine.Player;

import GameEngine.MapGeneration.MapBuilders.Map.IMap;
import GameEngine.MapGeneration.MapBuilders.Map.DoorIsLockedException;
import GameEngine.MapGeneration.MapBuilders.Map.Room;
import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.LivingObjects.FatalBlowException;
import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.LivingObjects.Human;
import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.MapItems.Consumable;
import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.MapItems.Usable;
import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.MapItems.InvalidObjectException;
import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.MapItems.Item;
import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.Weapons.Weapon;
import GameEngine.MapLogistics.BadDirectionException;
import GameEngine.MapLogistics.MapTraverseTo;
import GameEngine.MapLogistics.NoDoorAtOrientationException;
import GameEngine.MapGeneration.MapBuilders.Map.MapObject;
import GameEngine.Utils.FindObjectByTitle;
import GameEngine.Utils.GetItemFromList;
import GameEngine.Utils.ItemNotFoundException;
import GameEngine.Utils.ObjectNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Player extends Human {
    private MapTraverseTo _traverseTo = new MapTraverseTo();
    private GetItemFromList _getItem = new GetItemFromList();
    private Room currentRoom;
    private Weapon _weapon = new KnuckleBusterWithVolts();
    private final List<Item> _inventory = new ArrayList<>();

    public Player(String name) {
        super(name);
    }

    @Override
    public String equip(String weaponTitle) throws ItemNotFoundException, EquipWeaponFailedException {
        var weapon = _getItem.findByTitle(_inventory,weaponTitle);
        if(!(weapon instanceof Weapon))
            throw new EquipWeaponFailedException();
        if(_weapon != null)
            _inventory.add(_weapon);
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

    public String takeItem(int itemTitle) throws ItemNotFoundException {
        var item = currentRoom.takeItem(itemTitle);
        _inventory.add(item);
        return item.title();
    }

    public void takeAll(){
        var items = currentRoom.items();
        _inventory.addAll(items);
        currentRoom.items().clear();
    }

    public String dropItem(String itemTitle) throws ItemNotFoundException {
        var item = _getItem.findByTitle(_inventory,itemTitle);
        _inventory.remove(item);
        currentRoom.addItem(item);
        return item.title();
    }

    public Room getCurrentRoom() {return currentRoom;}
    public void setCurrentRoom(Room room) {currentRoom = room;}

    public List<String> inventoryToString() {
        return _inventory.stream().map(i -> i.presentate()).toList();
    }

    public void travelTo(String orientation) throws DoorIsLockedException, BadDirectionException, NoDoorAtOrientationException {
        currentRoom = _traverseTo.traverse(orientation,currentRoom);
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

    public String useItem(String itemTitle, String roomObject) throws ItemNotFoundException, InvalidObjectException, ObjectNotFoundException {
        var roomObjects = currentRoom.roomObjects();
        var findObject = new FindObjectByTitle();
        var roomItem = findObject.find(roomObjects, roomObject);
        var item = _getItem.findByTitle(_inventory,itemTitle);
        if(item instanceof Usable){
            var usable = (Usable) item;
            return usable.useOn(roomItem);
        }
        throw new ItemNotFoundException();
    }

    public String useItem(String itemTitle) throws InvalidObjectException, ItemNotFoundException {
        var item = _getItem.findByTitle(_inventory,itemTitle);
        if(item instanceof Usable){
            var usable = (Usable) item;
            return usable.useOn(this);
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
