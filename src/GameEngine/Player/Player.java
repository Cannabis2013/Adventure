package GameEngine.Player;

import GameEngine.Contracts.IMap;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.LivingObjects.FatalBlowException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.LivingObjects.Human;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Consumable;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.InvalidObjectException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Item;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Usable;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.Weapons.Weapon;
import GameEngine.Contracts.DoorIsLockedException;
import GameEngine.MapGeneration.SmallSquare.Models.MapObject;
import GameEngine.Contracts.IRoom;
import GameEngine.Utils.GetItemFromList;
import GameEngine.Utils.ItemNotFoundException;
import GameEngine.Utils.ObjectNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Player extends Human {
    private MapTraverseTo _traverseTo = new MapTraverseTo();
    private GetItemFromList _getItem = new GetItemFromList();
    private IRoom currentRoom;
    private Weapon _weapon = new KnuckleBusterWithVolts();
    private final List<Item> _inventory = new ArrayList<>();

    public Player(String name) {
        super(name);
    }

    public String weaponAsString() {return _weapon.presentate();}

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
    public String attack(MapObject object) throws FatalBlowException, InvalidObjectException {
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

    public IRoom getCurrentRoom() {return currentRoom;}
    public void setCurrentRoom(IRoom room) {currentRoom = room;}

    public List<String> inventoryToString() {
        return _inventory.stream().map(i -> i.presentate()).toList();
    }

    public void travelTo(String orientation) throws DoorIsLockedException, BadDirectionException, NoDoorAtOrientationException {
        currentRoom = _traverseTo.traverse(orientation, currentRoom);
    }

    @Override
    public String consumeItem(String itemTitle) throws ItemNotFoundException, InvalidObjectException {
        Item item = _getItem.takeByTitle(_inventory, itemTitle);
        if (item instanceof Consumable) {
            var food = (Consumable) item;
            return food.consume(this);
        }
        throw new InvalidObjectException();
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
}
