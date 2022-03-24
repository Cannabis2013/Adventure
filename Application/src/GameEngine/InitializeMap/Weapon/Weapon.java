package GameEngine.InitializeMap.Weapon;

import GameEngine.InitializeMap.MapItems.Item;
import GameEngine.MapObjects.MapObject;

public abstract class Weapon extends Item {
    public Weapon(String shortTitle, String title) {
        super(shortTitle, title);
    }

    public abstract String attack(MapObject object);

    public int ammo(){return 0;}
}
