package GameEngine.MapGeneration.SmallSquare.Models;

import GameEngine.Contracts.IObjectEntity;
import GameEngine.MapGeneration.SmallSquare.Utils.GetDoorNames;
import GameEngine.Contracts.IMap;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.LivingObjects.Demon;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Item;
import GameEngine.Utils.GetItemFromList;
import GameEngine.Utils.ItemNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Room extends Node {
    private List<Item> _items = new ArrayList<>();
    private RoomType _roomType;
    private IMap _parentMap;
    private List<IObjectEntity> _roomObjects = new ArrayList<>();
    private boolean _sealed;
    private List<Demon> _demons = new ArrayList<>();
    private String _description;
    private GetItemFromList _getItem = new GetItemFromList();

    public String description() {return _description;}
    public void setDescription(String description) {_description = description;}

    @Override
    public List<Demon> demons() {return _demons;}
    @Override
    public List<String> demonsAsString() {
        return _demons.stream().map(d -> d.title()).toList();
    }

    @Override
    public boolean isSealed() {return _sealed;}
    @Override
    public void setSealed(boolean sealed) {_sealed = sealed;}

    @Override
    public List<IObjectEntity> roomObjects() {
        return _roomObjects;
    }

    @Override
    public void setRoomObjects(List<IObjectEntity> objects) {
        _roomObjects = objects;
    }

    public Room(RoomType type, IMap parentMap){
        super("room");
        _roomType = type;
        _parentMap = parentMap;
    }

    @Override
    public RoomType getRoomType() {return _roomType;}

    @Override
    public String doorTitles() {return new GetDoorNames().doorNames(this);}

    @Override
    public IMap map() {return _parentMap;}

    @Override
    public void promote(){_roomType = RoomType.BOSS_ROOM;}

    @Override
    public void addItem(Item item){
        _items.add(item);}

    @Override
    public Item takeItem(String itemTitle) throws ItemNotFoundException {
        var item = _getItem.findByTitle(_items,itemTitle);
        _items.remove(item);
        return item;
    }

    @Override
    public List<Item> items() {return _items;}

    @Override
    public List<String> itemsAsString() {
        var items = _items.stream().map(i -> i.presentate()).toList();
        return items;
    }
}
