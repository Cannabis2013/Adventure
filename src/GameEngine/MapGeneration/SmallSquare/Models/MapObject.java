package GameEngine.MapGeneration.SmallSquare.Models;

import GameEngine.Contracts.IObjectEntity;

public class MapObject implements IObjectEntity {
    private static int _objectIndex = 0;
    private int _id;
    @Override
    public int id() {return _id;}

    public MapObject(String title){
        _objectIndex++;
        _id = _objectIndex;
        _title = String.format("%s %d",title, _id);
    }

    protected String _title;
    @Override
    public String title(){return _title;}
}
