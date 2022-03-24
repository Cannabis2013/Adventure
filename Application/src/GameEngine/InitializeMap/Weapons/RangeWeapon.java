package GameEngine.InitializeMap.Weapons;

public abstract class RangeWeapon extends Weapon {
    private int _ammo;

    public RangeWeapon(String shortTitle, String title, int ammo) {
        super(shortTitle, title);
        _ammo = ammo;
    }

    public int ammo() {
        return _ammo;
    }

    public void useAmmo(int value) {_ammo -= value;}
}
