package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems;

import GameEngine.MapGeneration.SmallSquare.Models.MapObject;

public abstract class Item extends MapObject {
    protected String _itemType;

    public String itemType() {
        return _itemType;
    }

    public Item(String typeDescription, String title){
        super(title);
        _itemType = typeDescription;
    }

    //public String presentate() {return _title;};
    public String presentate() {return _title;}

}
