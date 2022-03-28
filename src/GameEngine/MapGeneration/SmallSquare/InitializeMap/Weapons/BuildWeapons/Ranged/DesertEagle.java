package GameEngine.MapGeneration.SmallSquare.InitializeMap.Weapons.BuildWeapons.Ranged;

public class DesertEagle extends RangeWeapon {
    public DesertEagle() {
        super("Pistol", "desert eagle");
        _damage = 3;
        _ammo = 7;
    }

    @Override
    public String sound() {
        if(ammo() > 0)
            return "Bang!!";
        else
            return "click";
    }
}
