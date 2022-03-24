package GameEngine.InitializeMap.MapItems;
import GameEngine.MapObjects.MapObject;

public abstract class Item extends MapObject{
    protected String _itemType;

    public String itemType() {
        return _itemType;
    }

    public Item(String shortTitle, String title){
        _itemType = shortTitle;
        _title = title;
    }
}
