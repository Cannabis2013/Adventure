package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items;

import GameEngine.Contracts.IObjectEntity;
import GameEngine.Contracts.IPresentable;

public class Item implements IPresentable, IObjectEntity {
    private static int _id = 0;

    @Override
    public int id() {return _id;}
    private String _title;

    public Item(String title){
        _id++;
        _title = String.format("%s %d",title, _id);
    }
    public String title(){return _title;}

    public String presentate() {return _title;}
}
