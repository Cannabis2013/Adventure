package GameEngine.MapGeneration.SmallSquare.InitializeMap.Weapons.BuildWeapons;

import GameEngine.MapGeneration.SmallSquare.InitializeMap.Weapons.BuildWeapons.Ranged.AK47;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.Weapons.BuildWeapons.Ranged.DesertEagle;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.Weapons.BuildWeapons.Ranged.Mag7;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.Weapons.Weapon;

import java.util.Random;

public class BuildRandomWeapon {
    private int getRandomIndex(int count){
        var random = new Random();
        var randIndex = random.nextInt(count);
        return randIndex;
    }

    public Weapon build(){
        var randIndex = getRandomIndex(3);
        switch (randIndex){
            case 0 -> {return new AK47();}
            case 1 -> {return new DesertEagle();}
            case 2 -> {return new Mag7();}
            default -> {return null;}
        }
    }
}
