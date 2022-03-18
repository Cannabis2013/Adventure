package GameEngine.Item;

public class Item {
    enum Type {
        Food,
        Weapon
    }

    private String shortTitle;
    private String title;

    public String getShortTitle() {
        return shortTitle;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return  title;
    }

    public Item(String shortTitle, String title){
        this.shortTitle = shortTitle;
        this.title = title;
    }
}
