package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapEnemies;

import GameEngine.MapGeneration.SmallSquare.Models.Room;
import GameEngine.Contracts.IRoom;

import java.util.List;

public class AddDemons {
    public void add(List<Room> rooms){
        var bossRoom = rooms.stream()
                .filter(r -> r.getRoomType() == IRoom.RoomType.BOSS_ROOM).findFirst().get();
        bossRoom.demons().add(new Cyberdemon());
    }
}
