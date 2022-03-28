package GameEngine.MapGeneration.SmallSquare.InitializeMap.Weapons.BuildWeapons.Ranged;

public class RocketLauncher extends RangeWeapon{
    public RocketLauncher() {
        super("Rocket launcher", "Bazooka");
        _ammo = 50;
        _damage = 10;
    }

    @Override
    public String sound() {
        if(ammo() > 0)
            return "Swoop";
        else
            return "click";
    }
}
