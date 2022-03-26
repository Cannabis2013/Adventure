package GameEngine.Player;

import GameEngine.MapGeneration.MapBuilders.Map.MapObject;
import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.LivingObjects.FatalBlowException;
import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.LivingObjects.Organism;
import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.Weapons.MeleeWeapon;

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
