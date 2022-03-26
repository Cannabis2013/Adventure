package GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.Weapons;

import GameEngine.MapGeneration.MapBuilders.Map.MapObject;
import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.LivingObjects.FatalBlowException;
import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.MapItems.Item;

public abstract class Weapon extends Item {
    public Weapon(String shortTitle, String title) {
        super(shortTitle, title);
    }

    protected int _damage = 0;

    public abstract String attack(MapObject targetObject) throws FatalBlowException;

    public int ammo(){return 0;}
}
