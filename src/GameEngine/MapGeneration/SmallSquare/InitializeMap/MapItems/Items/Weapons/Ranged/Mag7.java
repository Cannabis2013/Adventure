package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.Ranged;

public class Mag7 extends RangeWeapon{
    public Mag7() {
        super("Mag7");
        _ammo = 7;
        _damage = 25;
    }

    @Override
    public String sound() {
        if(ammo() > 0)
            return "Bang!!";
        else
            return "click";
    }

}
