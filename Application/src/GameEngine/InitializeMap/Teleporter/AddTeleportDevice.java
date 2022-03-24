package GameEngine.InitializeMap.Teleporter;

import GameEngine.BuildMap.Rooms.Room;
import GameEngine.InitializeMap.MapItems.Item;
import GameEngine.InitializeMap.MapItems.RandomRoomsPopulator;
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
