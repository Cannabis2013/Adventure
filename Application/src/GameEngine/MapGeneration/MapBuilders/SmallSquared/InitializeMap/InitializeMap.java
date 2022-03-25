package GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap;

import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.MapDescriptions.AddMapDescriptions;
import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.MapEnemies.AddDemons;
import GameEngine.MapGeneration.MapBuilders.Map.Room;
import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.MapRestrictions.AddAccessRestrictions;
import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.Teleporter.AddTeleportDevice;
import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.Weapons.AddWeapons;

import java.util.List;

public class InitializeMap {
    private AddMapDescriptions _addDescriptions = new AddMapDescriptions();
    private AddAccessRestrictions _addAccessRestrictions = new AddAccessRestrictions();
    private AddTeleportDevice _addTeleport = new AddTeleportDevice();
    private AddWeapons _addWeapons = new AddWeapons();
    private AddDemons _addDemons = new AddDemons();
    public void initialize(List<Room> rooms){
        _addDescriptions.add(rooms);
        _addAccessRestrictions.add(rooms);
        _addTeleport.add(rooms);
        _addWeapons.add(rooms);
        _addDemons.add(rooms);
    }
}
