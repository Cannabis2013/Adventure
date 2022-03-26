package GameEngine.MapGeneration.MapBuilders.Map;

import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.LivingObjects.Demon;
import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.MapItems.Item;
import GameEngine.Utils.GetItemFromList;
import GameEngine.Utils.ItemNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Room extends Node {
    private List<Item> _items = new ArrayList<>();
    private RoomType _roomType;
    private IMap _parentMap;
    private List<MapObject> _roomObjects = new ArrayList<>();
    private boolean _sealed;
    private List<Demon> _demons = new ArrayList<>();

    public List<Demon> demons() {return _demons;}
    public List<String> demonsAsString() {
        return _demons.stream().map(d -> d.title()).toList();
    }
    public boolean isSealed() {return _sealed;}
    public void setSealed(boolean sealed) {_sealed = sealed;}
    public List<MapObject> roomObjects() {
        return _roomObjects;
    }
    public enum RoomType {Normal, BossRoom;}

    public Room(RoomType type, IMap parentMap){
        super("room");
        _roomType = type;
        _parentMap = parentMap;

    }

    public RoomType getRoomType() {return _roomType;}

    public String doorTitles() {return new GetDoorNames().doorNames(this);}

    public IMap map() {return _parentMap;}

    public void promote(){_roomType = RoomType.BossRoom;}

    public void addItem(Item item){
        _items.add(item);}

    public Item takeItem(String itemTitle) throws ItemNotFoundException {
        var item = _getItem.findByTitle(_items,itemTitle);
        _items.remove(item);
        return item;
    }

    public List<Item> items() {return _items;}

    public List<String> itemsAsString() {
        var items = _items.stream().map(i -> i.presentate()).toList();
        return items;
    }

    private GetItemFromList _getItem = new GetItemFromList();


}
