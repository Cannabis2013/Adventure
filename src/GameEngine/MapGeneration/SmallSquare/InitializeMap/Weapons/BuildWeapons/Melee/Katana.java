package GameEngine.MapGeneration.SmallSquare.InitializeMap.Weapons.BuildWeapons.Melee;

import GameEngine.MapGeneration.SmallSquare.InitializeMap.Weapons.MeleeWeapon;

public class Katana extends MeleeWeapon{

    public Katana(String shortTitle, String title) {
        super("Sword", "Katana");
        _damage = 5;
    }

}
