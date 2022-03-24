package GameEngine.MapObjects;

public class MapObject {
    protected String _description;

    protected String _title;
    public String title(){return _title;}

    public String description() {return _description;}
    public void setDescription(String description) {_description = description;}
}
