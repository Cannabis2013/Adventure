package GameEngine.Player;

import GameEngine.BuildMap.Map.IMap;
import GameEngine.BuildMap.Rooms.DoorIsLockedException;
import GameEngine.BuildMap.Rooms.Room;
import GameEngine.BuildMap.Rooms.WrongKeyException;
import GameEngine.InitializeMap.MapItems.IConsumable;
import GameEngine.InitializeMap.MapItems.IUsable;
import GameEngine.InitializeMap.MapItems.InvalidObjectException;
import GameEngine.InitializeMap.MapItems.Item;
import GameEngine.MapLogistics.BadDirectionException;
import GameEngine.MapLogistics.MapTraverseTo;
import GameEngine.MapLogistics.NoDoorAtOrientationException;
import GameEngine.MapObjects.MapObject;
import GameEngine.Restrictions.DoorNotFoundException;
import GameEngine.Utils.GetItemFromList;
import GameEngine.Utils.ItemNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Player extends MapObject {
    private MapTraverseTo _traverseTo = new MapTraverseTo();
    private GetItemFromList _getItem = new GetItemFromList();
    private Room currentRoom;
    private final List<Item> inventory = new ArrayList<>();
    private int health = 50;

    public List<Item> getInventory() {return inventory;}

    public IMap getCurrentMap(){
        return currentRoom.map();
    }

    public String takeItem(String itemTitle) throws ItemNotFoundException {
        var item = currentRoom.takeItem(itemTitle);
        inventory.add(item);
        return item.title();
    }

    public String dropItem(String itemTitle) throws ItemNotFoundException {
        var item = _getItem.findByTitle(inventory,itemTitle);
        inventory.remove(item);
        currentRoom.addItem(item);
        return item.title();
    }

    public String consumeItem(String itemTitle) throws ItemNotFoundException, InvalidObjectException {
        Item item = _getItem.findByTitle(inventory, itemTitle);
        if (item instanceof IConsumable) {
            var food = (IConsumable) item;
            return food.consume(this);
        }
        throw new ItemNotFoundException();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        currentRoom = room;
    }

    public String getInventoryAsString() {
        StringBuilder sb = new StringBuilder();
        inventory.forEach(i-> sb.append(i.title() + "\n"));
        return sb.toString();
    }

    public void travelTo(String orientation) throws DoorIsLockedException, BadDirectionException, NoDoorAtOrientationException {
        currentRoom = _traverseTo.traverse(orientation,currentRoom);
    }

    public void tryUnlockDoor(String doorOrientation, String key) throws WrongKeyException, DoorNotFoundException, ItemNotFoundException {
        var item = _getItem.findByTitle(inventory,key);
        currentRoom.tryUnlockDoor(doorOrientation,item);
    }

    public int getHealth() {
        return health;
    }

    public void addHealth(int num) {
        health += num;
    }

    public void setHealth(int num) {
        health = num;
    }
    public String useItem(String itemTitle, MapObject object) throws ItemNotFoundException, InvalidObjectException {
        var item = _getItem.findByTitle(inventory,itemTitle);
        if(item instanceof IUsable){
            var usable = (IUsable) item;
            return usable.use(object);
        }
        throw new ItemNotFoundException();
    }
}
