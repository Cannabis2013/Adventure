package GameEngine.InitializeMap.MapItems;

public class Item {
    public enum Type {
        Consumable,
        Usable
    }

    private String shortTitle;
    private String title;
    private Type type;

    public String getShortTitle() {
        return shortTitle;
    }

    public String getTitle() {
        return title;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type newType) {
        type = newType;
    }

    @Override
    public String toString() {
        return  title;
    }

    public Item(String shortTitle, String title){
        this.shortTitle = shortTitle;
        this.title = title;
        this.type = Type.Usable;
    }
}
