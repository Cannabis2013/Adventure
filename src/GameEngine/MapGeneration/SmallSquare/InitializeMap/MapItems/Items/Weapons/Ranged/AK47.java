package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.Ranged;

public class AK47 extends RangeWeapon{

    public AK47() {
        super("AK47");
        _ammo = 30;
        _damage = 5;
        _rate = 3;
    }

    @Override
    public String sound() {
        if(ammo() > 0)
            return "Ratata!";
        else
            return "click click";
    }

}
