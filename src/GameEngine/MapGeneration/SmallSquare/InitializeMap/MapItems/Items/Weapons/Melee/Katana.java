package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.Melee;

public class Katana extends MeleeWeapon{

    public Katana() {
        super("Katana");
        _damage = 5;
    }

    @Override
    public String sound() {
        return "swiscch";
    }

}
