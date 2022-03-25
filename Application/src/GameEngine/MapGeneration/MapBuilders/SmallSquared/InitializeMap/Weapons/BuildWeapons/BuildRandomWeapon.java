package GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.Weapons.BuildWeapons;

import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.Weapons.BuildWeapons.Ranged.AK47;
import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.Weapons.BuildWeapons.Ranged.DesertEagle;
import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.Weapons.BuildWeapons.Ranged.Mag7;
import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.Weapons.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BuildRandomWeapon {
    private List<Weapon> _weapons;

    private List<Weapon> buildWeapons(){
        var weapons = new ArrayList<Weapon>();
        weapons.add(new Mag7());
        weapons.add(new AK47());
        weapons.add(new DesertEagle());
        return weapons;
    }

    private int getRandomIndex(int count){
        var random = new Random();
        var randIndex = random.nextInt(count);
        return randIndex;
    }

    public BuildRandomWeapon(){
        _weapons = buildWeapons();
    }

    public Weapon build(){
        var randIndex = getRandomIndex(_weapons.size());
        var randomWeapon = _weapons.get(randIndex);
        return randomWeapon;
    }
}
