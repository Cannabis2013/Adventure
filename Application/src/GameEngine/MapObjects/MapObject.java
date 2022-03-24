package GameEngine.MapObjects;

public class MapObject {
    protected String _title;
    protected String _description;

    public String title(){return _title;}

    public String description() {return _description;}
    public void setDescription(String description) {_description = description;}
}
