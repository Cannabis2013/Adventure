package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.Melee;

public class KnuckleBusterWithVolts extends MeleeWeapon {
    public KnuckleBusterWithVolts() {
        super("electric knuckle buster");
        _damage = 2;
    }

    @Override
    public String sound() {
        return "klask";
    }

}
