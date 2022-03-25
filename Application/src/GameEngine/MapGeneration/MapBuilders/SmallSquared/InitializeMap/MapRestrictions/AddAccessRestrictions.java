package GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.MapRestrictions;

import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.MapItems.Item;
import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.MapItems.RandomRoomsPopulator;
import GameEngine.MapGeneration.MapBuilders.Map.Room;

import java.util.List;

public class AddAccessRestrictions extends RandomRoomsPopulator {
    private MapAccessRestrictions _restrictMap = new MapAccessRestrictions();

    public void add(List<Room> rooms){
        var keys = _restrictMap.restrict(rooms)
                .stream().map(k -> (Item) k).toList();
        var normals = rooms.stream()
                .filter(r -> r.getRoomType() == Room.RoomType.NORMAL_ROOM).toList();
        addItems(normals,keys);
    }
}
