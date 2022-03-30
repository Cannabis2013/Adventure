package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapEnemies;

import GameEngine.MapGeneration.SmallSquare.Map.Rooms.Room;
import java.util.List;

public class AddEnemies {
    private void populateRoom(Room room){
        var condition = true;
        while (condition){
            var val = Math.random();
            if(val < 0.7){
                var enemy = new Imp(room);
                room.demons().add(enemy);
            }
            else{
                condition = false;
            }
        }
    }

    public void add(List<Room> rooms) {
        rooms.forEach(r -> populateRoom(r));
    }
}
