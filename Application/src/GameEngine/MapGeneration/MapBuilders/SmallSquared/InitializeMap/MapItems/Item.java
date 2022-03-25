package GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.MapItems;
import GameEngine.MapGeneration.MapBuilders.Map.MapObject;

public abstract class Item extends MapObject implements IPresentable{
    private static int _id = 0;
    protected String _itemType;

    public int id() {
        return _id;
    }

    public String itemType() {
        return _itemType;
    }

    public Item(String typeDescription, String title){
        _itemType = typeDescription;
        _title = title;
        _id++;
    }
}
