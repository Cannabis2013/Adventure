package GameEngine.MapGeneration.MapBuilders.Map;

public class MapObject {
    private static int _objectIndex = 0;
    private int _id;
    public int id() {return _id;}

    public MapObject(String title){
        _objectIndex++;
        _id = _objectIndex;
        _title = String.format("%s %d",title, _id);
    }

    protected String _title;
    public final String title(){return _title;}

    protected String _description;
    public String description() {return _description;}
    public void setDescription(String description) {_description = description;}
}
