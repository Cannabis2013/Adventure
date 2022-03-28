package GameEngine.MapGeneration.SmallSquare.InitializeMap.Weapons.BuildWeapons.Ranged;

import GameEngine.MapGeneration.SmallSquare.InitializeMap.Weapons.Weapon;

public abstract class RangeWeapon extends Weapon {
    protected int _ammo;
    protected int _rate = 1;

    public RangeWeapon(String shortTitle, String title) {
        super(shortTitle, title);
    }

    public int ammo() {return _ammo;}
    protected void useAmmo() {_ammo -= _rate;}
}
