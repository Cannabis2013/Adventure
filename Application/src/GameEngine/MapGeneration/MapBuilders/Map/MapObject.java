package GameEngine.MapGeneration.MapBuilders.Map;

public class MapObject {
    protected String _title;
    public final String title(){return _title;}

    protected String _description;
    public String description() {return _description;}
    public void setDescription(String description) {_description = description;}
}
