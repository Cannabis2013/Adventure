package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.Ranged;

public class RocketLauncher extends RangeWeapon{
    public RocketLauncher() {
        super("Bazooka");
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
