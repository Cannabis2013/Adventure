package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapEnemies;

import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.Ranged.RocketLauncher;
import GameEngine.MapGeneration.SmallSquare.Map.Rooms.Room;

public class Cyberdemon extends Enemy {
    public Cyberdemon(Room currentRoom) {
        super("Cyberdemon");
        _weapon = new RocketLauncher();
        _health = 30;
        _currentRoom = currentRoom;
        _hitChance = 0.6;
    }
}