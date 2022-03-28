package GameEngine.MapGeneration.SmallSquare.InitializeMap.Weapons.BuildWeapons.Ranged;

public class RocketLauncher extends RangeWeapon{
    public RocketLauncher() {
        super("Rocket launcher", "Bazooka",
                "Woof", "Click");
        _ammo = 50;
        _damage = 10;
    }
}
