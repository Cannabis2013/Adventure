package GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.MapItems;
import GameEngine.MapGeneration.MapBuilders.Map.MapObject;

public abstract class Item extends MapObject{
    protected String _itemType;

    public String itemType() {
        return _itemType;
    }

    public Item(String typeDescription, String title){
        super(title);
        _itemType = typeDescription;
    }

    public String presentate() {return _title;};
}
