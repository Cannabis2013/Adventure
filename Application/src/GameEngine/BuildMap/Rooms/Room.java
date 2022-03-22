package GameEngine.BuildMap.Rooms;

import GameEngine.BuildMap.MapObjects.MapObject;
import GameEngine.InitializeMap.MapItems.Item;
import GameEngine.Restrictions.DoorNotFoundException;
import GameEngine.Restrictions.UnlockDoor;
import GameEngine.Utils.GetItemFromList;
import GameEngine.Utils.ItemNotFoundException;

import java.util.ArrayList;
import java.util.Optional;

public class Room extends MapObject {
    public enum RoomType {Normal,Special}
    private RoomType roomType;

    private GetItemFromList _getItem = new GetItemFromList();

    private UnlockDoor _unlockDoor = new UnlockDoor();

    public RoomType getRoomType() {
        return roomType;
    }

    public void promote(){
        roomType = RoomType.Special;
    }

    private Door north, east,south,west;
    private ArrayList<Item> items = new ArrayList<>();

    public void addItem(Item item){
        items.add(item);
    }

    public Item takeItem(String itemTitle) throws ItemNotFoundException {
        var item = _getItem.findByTitle(items,itemTitle);
        items.remove(item);
        return item;
    }

    public Door getNorth() {
        return north;
    }

    public void setNorth(Room room) {
        var door = new Door(this,room);
        this.north = door;
        room.south = door;
    }

    public Door getEast() {
        return east;
    }

    public void setEast(Room room) {
        var door = new Door(this,room);
        this.east = door;
        room.west = door;
    }

    public Door getSouth() {
        return south;
    }

    public void setSouth(Room room) {
        var door = new Door(this,room);
        this.south = door;
        room.north = door;
    }

    public Door getWest() {
        return west;
    }

    public void setWest(Room room) {
        var door = new Door(this,room);
        this.west = door;
        room.east = door;
    }

    public Room(String name, RoomType type){
        this.name = name;
        this.roomType = type;
    }

    public void tryUnlockDoor(String doorOrientation, Item item) throws WrongKeyException, DoorNotFoundException {
        _unlockDoor.tryUnlock(doorOrientation,this,item);
    }

    public String itemsAsString() {
        if(items.isEmpty())
            return "";
        StringBuilder sb = new StringBuilder();
        items.forEach(i-> sb.append(i.getTitle() + "\n"));
        return sb.toString();
    }

    public void disconnect() throws DoorIsLockedException {
        if(this.north != null)
            north.getOther(this).south = null;
        if(east != null)
            east.getOther(this).west = null;
        if(south != null)
            south.getOther(this).north = null;
        if(west != null)
            west.getOther(this).east = null;
        north = null;
        east = null;
        south = null;
        west = null;
    }
}
