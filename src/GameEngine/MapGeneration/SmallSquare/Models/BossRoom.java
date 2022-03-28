package GameEngine.MapGeneration.SmallSquare.Models;

import GameEngine.Contracts.IMap;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapEnemies.Cyberdemon;

public class BossRoom extends Room{
    public BossRoom(RoomType type, IMap parentMap) {
        super(type, parentMap);
        demons().add(new Cyberdemon(this));
        setDescription("""
                Ohh shit. There is definitely something wrong here.
                
                It seems that you have finally made it - to hell.
                
                Fire all over the place, tall pillars decorated with ancient glyphs, and this
                overwhelming loud noise of some machinery stomping - so violently that the earth
                shakes beneath you.
                
                Furthermore, the place is filled with flying burning skulls screaming.
                
                But here is the big problem. Among flying skulls and fire, you observe this
                enormous beast, that is half animal, and half machine.
                
                It has no forearms, but is instead equipped with two daunting rocket launchers. And
                by the way, it is 20 meters high.
                
                Ohh. You know this fellar. It's the Cyberdemon that you have defeated so many times - with so
                much effort. At least that is what you thought. Now you have to fight this beast again.
                """);
    }
}
