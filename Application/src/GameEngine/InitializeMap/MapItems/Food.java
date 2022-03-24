package GameEngine.InitializeMap.MapItems;

public class Food extends Item {
    private int hp_change;
    public Food(String shortTitle, String title, int hp) {
        super(shortTitle, title);
        setType(Type.Consumable);
        hp_change = hp;
    }

    public int getHp_change() {
        return hp_change;
    }
}
