package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapEnemies;

import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.Ranged.RocketLauncher;
import GameEngine.MapGeneration.SmallSquare.Map.Rooms.Room;
import GameEngine.Player.Character;

public class Cyberdemon extends Character {
    public Cyberdemon(Room currentRoom) {
        super("Cyberdemon");
        _weapon = new RocketLauncher();
        _health = 30;
        _currentRoom = currentRoom;
    }
}
