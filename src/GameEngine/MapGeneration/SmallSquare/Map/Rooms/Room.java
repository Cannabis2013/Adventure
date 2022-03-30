package GameEngine.MapGeneration.SmallSquare.Map.Rooms;

import GameEngine.Contracts.IObjectEntity;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Item;
import GameEngine.MapGeneration.SmallSquare.Map.Map;
import GameEngine.MapGeneration.SmallSquare.Utils.GetDoorNames;
import GameEngine.Player.Character;
import GameEngine.Utils.ItemNotFoundException;
import GameEngine.Utils.TakeItemFromList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Room extends Node {
    public enum RoomType {NORMAL_ROOM, BOSS_ROOM, END_ROOM;}
    private List<Item> _items = new ArrayList<>();
    private RoomType _roomType;
    private Map _parentMap;
    private List<IObjectEntity> _roomObjects = new ArrayList<>();
    private boolean _sealed;
    private List<Character> _demons = new ArrayList<>();
    private String _description;
    private TakeItemFromList _findObject = new TakeItemFromList();

    public String description() {return _description;}
    public void setDescription(String description) {_description = description;}

    public Character demon() {
        if(_demons.isEmpty())
            return null;
        Collections.shuffle(_demons);
        return _demons.get(0);
    }

    public Character demon(String title) {
        var demon =_demons.stream()
                .filter(d -> d.title().equals(title)).findFirst();
        if(!demon.isPresent())
            return null;
        return demon.get();
    }

    public List<Character> demons() {return _demons;}

    public List<String> demonsAsStrings() {
        return _demons.stream().map(d -> d.presentate()).toList();
    }

    public boolean isSealed() {return _sealed;}
    public void setSealed(boolean sealed) {_sealed = sealed;}

    public List<IObjectEntity> roomObjects() {return _roomObjects;}

    public void setRoomObjects(List<IObjectEntity> objects) {_roomObjects = objects;}

    public Room(RoomType type, Map parentMap){
        super("room");
        _roomType = type;
        _parentMap = parentMap;
    }

    public RoomType getRoomType() {return _roomType;}

    public String doorTitles() {return new GetDoorNames().doorNames(this);}

    public Map map() {return _parentMap;}

    public void promote(){_roomType = RoomType.BOSS_ROOM;}

    public void addItem(Item item){_items.add(item);}

    public Item takeItem(String itemTitle) throws ItemNotFoundException {
        return _findObject.take(_items,itemTitle);
    }

    public List<Item> items() {return _items;}

    public List<String> itemsAsString() {
        var items = _items.stream().map(i -> ((Item) i).presentate()).toList();
        return items;
    }
}
