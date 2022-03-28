package GameEngine.MapGeneration.SmallSquare.InitializeMap.Weapons.BuildWeapons.Ranged;

public class Mag7 extends RangeWeapon{
    public Mag7() {
        super("shotgun", "Mag7");
        _ammo = 7;
        _damage = 10;
    }

    @Override
    public String sound() {
        if(ammo() > 0)
            return "Bang!!";
        else
            return "click";
    }

}
