package GameEngine.InitializeMap.MapItems;
import GameEngine.MapObjects.MapObject;

public class Item extends MapObject{
    
    protected String _itemType;

    public String itemType() {
        return _itemType;
    }

    public Item(String typeDescription, String title){
        _itemType = typeDescription;
        _title = title;
    }
}
