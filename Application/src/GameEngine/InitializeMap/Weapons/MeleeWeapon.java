package GameEngine.InitializeMap.Weapons;

import GameEngine.MapObjects.MapObject;

public class MeleeWeapon extends Weapon {

    public MeleeWeapon(String shortTitle, String title) {
        super(shortTitle, title);
    }

    @Override
    public String attack(MapObject object) {
        return null;
    }
}
