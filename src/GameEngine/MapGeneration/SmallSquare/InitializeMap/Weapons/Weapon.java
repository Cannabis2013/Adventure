package GameEngine.MapGeneration.SmallSquare.InitializeMap.Weapons;

import GameEngine.Contracts.IObjectEntity;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.LivingObjects.FatalBlowException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Item;

public abstract class Weapon extends Item {
    public Weapon(String shortTitle, String title) {
        super(shortTitle, title);
    }

    protected int _damage = 0;

    public abstract String attack(IObjectEntity target) throws FatalBlowException;

    public int ammo(){return 0;}
}
