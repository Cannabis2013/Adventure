package GameEngine.InitializeMap.Weapon;

import GameEngine.MapObjects.MapObject;

public class RangeWeap extends Weapon {
    private final int _ammo;

    public RangeWeap(String shortTitle, String title, int ammo) {
        super(shortTitle, title);
        _ammo = ammo;
    }

    @Override
    public String attack(MapObject object) {
        return null;
    }

    public int ammo() {
        return _ammo;
    }
}
