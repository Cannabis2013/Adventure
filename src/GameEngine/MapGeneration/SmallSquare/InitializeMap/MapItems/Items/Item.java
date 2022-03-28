package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items;

import GameEngine.Contracts.IPresentable;
import GameEngine.MapGeneration.SmallSquare.Map.MapObject;

public abstract class Item extends MapObject implements IPresentable {

    public Item(String title){
        super(title);
    }

    @Override
    public String presentate() {return _title;}

}
