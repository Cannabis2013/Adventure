package GameEngine.BuildMap.Rooms;

import GameEngine.BuildMap.Map.IMap;
import GameEngine.InitializeMap.MapItems.Item;
import GameEngine.MapObjects.MapObject;
import GameEngine.Restrictions.DoorNotFoundException;
import GameEngine.Restrictions.UnlockDoor;
import GameEngine.Utils.GetItemFromList;
import GameEngine.Utils.ItemNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Room extends MapObject {
    private Door north, east,south,west;
    private List<Item> _items = new ArrayList<>();
    private RoomType _roomType;
    private IMap _parentMap;
    private boolean _sealed;

    public boolean isSealed() {return _sealed;}
    public void setSealed(boolean sealed) {_sealed = sealed;}

    public enum RoomType {Normal,Special;}

    public Room(String name, RoomType type, IMap parentMap){
        _title = name;
        _roomType = type;
        _parentMap = parentMap;
    }

    public RoomType getRoomType() {return _roomType;}

    public String doorTitles() {return new GetDoorNames().doorNames(this);}

    public IMap map() {return _parentMap;}

    public void promote(){_roomType = RoomType.Special;}

    public void addItem(Item item){
        _items.add(item);}

    public Item takeItem(String itemTitle) throws ItemNotFoundException {
        var item = _getItem.findByTitle(_items,itemTitle);
        _items.remove(item);
        return item;
    }

    public void tryUnlockDoor(String doorOrientation, Item item) throws WrongKeyException, DoorNotFoundException {
        _unlockDoor.tryUnlock(doorOrientation,this,item);
    }

    public List<Item> items() {return _items;}

    public String itemsAsString() {
        if(_items.isEmpty())
            return "";
        StringBuilder sb = new StringBuilder();
        _items.forEach(i-> sb.append(i.title() + "\n"));
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

    private GetItemFromList _getItem = new GetItemFromList();
    private UnlockDoor _unlockDoor = new UnlockDoor();

    public Door getNorth() {return north;}
    public Door getEast() {return east;}
    public Door getWest() {return west;}
    public Door getSouth() {return south;}

    public void setNorth(Room room) {
        var door = new Door(this,room);
        this.north = door;
        room.south = door;
    }

    public void setEast(Room room) {
        var door = new Door(this,room);
        this.east = door;
        room.west = door;
    }

    public void setSouth(Room room) {
        var door = new Door(this,room);
        this.south = door;
        room.north = door;
    }

    public void setWest(Room room) {
        var door = new Door(this,room);
        this.west = door;
        room.east = door;
    }
}
