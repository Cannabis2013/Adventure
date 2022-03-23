package GameEngine.InitializeMap.MapRestrictions;

import GameEngine.InitializeMap.MapItems.Item;


public class Key extends Item {
    private static int ID = 0;
    public Key(String title) {
        super("key", title);
        ID++;
    }

    public int getID() {
        return ID;
    }
}
