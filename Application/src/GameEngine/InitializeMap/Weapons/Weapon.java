package GameEngine.InitializeMap.Weapons;

import GameEngine.InitializeMap.LivingObjects.FatalBlowException;
import GameEngine.InitializeMap.MapItems.Item;
import GameEngine.MapObjects.MapObject;

public abstract class Weapon extends Item {
    public Weapon(String shortTitle, String title) {
        super(shortTitle, title);
    }

    protected int _damage = 0;

    public abstract String attack(MapObject targetObject) throws FatalBlowException;

    public int ammo(){return 0;}
}
