package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items;

import GameEngine.Contracts.IObjectEntity;
import GameEngine.Contracts.IPresentable;

public abstract class Item implements IPresentable, IObjectEntity {
    private static int _objectIndex = 0;
    protected int _id;

    @Override
    public int id() {return _id;}

    public Item(String title){
        _objectIndex++;
        _id = _objectIndex;
        _title = String.format("%s %d",title, _id);
    }

    protected String _title;
    @Override
    public String title(){return _title;}

    @Override
    public String presentate() {return _title;}


}
