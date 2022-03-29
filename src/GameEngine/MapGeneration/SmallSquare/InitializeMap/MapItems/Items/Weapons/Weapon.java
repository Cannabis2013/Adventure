package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons;

import GameEngine.Contracts.IObjectEntity;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Item;

public abstract class Weapon extends Item {
    public Weapon(String title) {
        super(title);
        _type = title;
    }

    protected int _damage = 0;

    private final String _type;

    public int ammo(){return 0;}
    public abstract int attack();
    public abstract int attack(IObjectEntity target) throws FatalBlowException, InvalidObjectException;

    public abstract String sound();

    public String type() {
        return _type;
    }
}
