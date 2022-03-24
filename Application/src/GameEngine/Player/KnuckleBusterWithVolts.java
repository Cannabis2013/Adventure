package GameEngine.Player;

import GameEngine.InitializeMap.LivingObjects.FatalBlowException;
import GameEngine.InitializeMap.LivingObjects.Organism;
import GameEngine.InitializeMap.Weapons.MeleeWeapon;
import GameEngine.MapObjects.MapObject;

public class KnuckleBusterWithVolts extends MeleeWeapon {
    public KnuckleBusterWithVolts() {
        super("knuckle buster", "electric knuckle buster");
    }

    @Override
    public String attack(MapObject targetObject) throws FatalBlowException {
        if(targetObject == null)
            return "zzzh";
        if(targetObject instanceof Organism)
            ((Organism) targetObject).takeHealth(1);
        return "KAAPOW!!!";
    }
}
