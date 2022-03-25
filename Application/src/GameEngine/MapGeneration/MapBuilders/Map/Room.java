package GameEngine.MapGeneration.MapBuilders.Map;

import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.LivingObjects.Demon;
import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.MapItems.Item;
import GameEngine.Utils.GetItemFromList;
import GameEngine.Utils.ItemNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Room extends MapObject {
    private static int _num = 0;
    private Door north, east,south,west;
    private List<Item> _items = new ArrayList<>();
    private RoomType _roomType;
    private IMap _parentMap;
    private List<MapObject> _roomObjects = new ArrayList<>();
    private boolean _sealed;
    private List<Demon> _demons = new ArrayList<>();

    public List<Demon> demons() {return _demons;}
    public List<String> demonsAsString() {
        return _demons.stream().map(d -> d.presentate()).toList();
    }
    public boolean isSealed() {return _sealed;}
    public void setSealed(boolean sealed) {_sealed = sealed;}
    public List<MapObject> roomObjects() {
        return _roomObjects;
    }
    public enum RoomType {Normal, BossRoom;}

    public Room(RoomType type, IMap parentMap){
        _title = String.format("Room %d",_num);
        _roomType = type;
        _parentMap = parentMap;

    }

    public RoomType getRoomType() {return _roomType;}

    public String doorTitles() {return new GetDoorNames().doorNames(this);}

    public IMap map() {return _parentMap;}

    public void promote(){_roomType = RoomType.BossRoom;}

    public void addItem(Item item){
        _items.add(item);}

    public Item takeItem(int itemID) throws ItemNotFoundException {
        var item = _getItem.findByID(_items,itemID);
        _items.remove(item);
        return item;
    }

    public List<Item> items() {return _items;}

    public List<String> itemsAsString() {
        var items = _items.stream().map(i -> i.presentate()).toList();
        return items;
    }

    public void disconnect() {
        if(this.north != null)
            north.other(this).south = null;
        if(east != null)
            east.other(this).west = null;
        if(south != null)
            south.other(this).north = null;
        if(west != null)
            west.other(this).east = null;
        north = null;
        east = null;
        south = null;
        west = null;
    }

    private GetItemFromList _getItem = new GetItemFromList();

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
