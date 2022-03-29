package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapEnemies;

import GameEngine.Contracts.IRoom;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.Ranged.RocketLauncher;
import GameEngine.Player.Character;

public class Cyberdemon extends Character {
    public Cyberdemon(IRoom currentRoom) {
        super("Cyberdemon");
        _weapon = new RocketLauncher();
        _health = 30;
        _currentRoom = currentRoom;
    }
}
