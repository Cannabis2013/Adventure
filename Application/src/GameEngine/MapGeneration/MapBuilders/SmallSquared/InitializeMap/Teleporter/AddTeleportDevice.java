package GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.Teleporter;

import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.MapItems.Item;
import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.MapItems.RandomRoomsPopulator;
import GameEngine.MapGeneration.MapBuilders.Map.Room;

import java.util.ArrayList;
import java.util.List;

public class AddTeleportDevice extends RandomRoomsPopulator {
    private List<Item> buildTeleporters(int count){
        var teleporters = new ArrayList<Item>();
        for (var i = 0;i <count;i++)
            teleporters.add(new TeleportDevice());
        return teleporters;
    }

    public void add(List<Room> rooms){
        var normals = rooms.stream()
                .filter(r -> r.getRoomType() == Room.RoomType.Normal
                && !r.isSealed()).toList();
        var teleporters = buildTeleporters(2);
        teleporters.add(new TeleportDevice());
        addItems(normals,teleporters);
    }
}
