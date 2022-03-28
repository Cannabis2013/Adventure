package GameEngine.MapGeneration.SmallSquare.InitializeMap.Weapons.BuildWeapons.Ranged;

public class AK47 extends RangeWeapon{

    public AK47() {
        super("Assault rifle", "AK47", "Ratata", "click click");
        _ammo = 30;
        _damage = 5;
        _rate = 3;
    }
}
