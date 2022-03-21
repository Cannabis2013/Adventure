package GameEngine.Player;

import GameEngine.BuildMap.Rooms.DoorIsLockedException;
import GameEngine.BuildMap.Rooms.Room;
import GameEngine.BuildMap.Rooms.WrongKeyException;
import GameEngine.InitializeMap.MapItems.Item;
import GameEngine.MapLogistics.MapTraverseTo;
import GameEngine.Restrictions.DoorNotFoundException;
import GameEngine.Utils.GetItemFromList;
import GameEngine.Utils.ItemNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private MapTraverseTo _traverseTo = new MapTraverseTo();
    private GetItemFromList _getItem = new GetItemFromList();
    private Room currentRoom;
    private List<Item> inventory = new ArrayList<>();

    public List<Item> getInventory() {
        return inventory;
    }

    public Item getItemFromInventory(String title) throws ItemNotFoundException {
        var item = _getItem.findByTitle(inventory,title);
        return item;
    }

    public void pickItem(String itemTitle) throws ItemNotFoundException {
        var item = currentRoom.takeItem(itemTitle);
        inventory.add(item);
    }

    public void dropItem(String itemTitle) throws ItemNotFoundException {
        var item = _getItem.findByTitle(inventory,itemTitle);
        inventory.remove(item);
        currentRoom.addItem(item);
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        currentRoom = room;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        inventory.forEach(i-> sb.append(i.getTitle() + "\n"));
        return sb.toString();
    }

    public void goInDirection(String orientation) throws DoorIsLockedException {
        currentRoom = _traverseTo.traverse(orientation,currentRoom);
    }

    public void tryUnlockDoor(String doorOrientation, String key) throws WrongKeyException, DoorNotFoundException, ItemNotFoundException {
        var item = _getItem.findByTitle(inventory,key);
        currentRoom.tryUnlockDoor(doorOrientation,item);
    }
}
