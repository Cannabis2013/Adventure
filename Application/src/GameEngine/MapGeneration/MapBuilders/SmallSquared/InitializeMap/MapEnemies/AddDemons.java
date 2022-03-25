package GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.MapEnemies;

import GameEngine.MapGeneration.MapBuilders.Map.Room;

import java.util.List;

public class AddDemons {
    public void add(List<Room> rooms){
        var bossRoom = rooms.stream()
                .filter(r -> r.getRoomType() == Room.RoomType.BossRoom).findFirst().get();
        bossRoom.demons().add(new Cyberdemon());
    }
}
