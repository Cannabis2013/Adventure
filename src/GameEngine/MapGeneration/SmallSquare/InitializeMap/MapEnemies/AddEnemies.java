package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapEnemies;

import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.RandomRoomsPopulator;
import GameEngine.MapGeneration.SmallSquare.Models.Room;

import java.util.List;

public class AddEnemies extends RandomRoomsPopulator {

    private void populateRoom(Room room){
        var condition = true;
        while (condition){
            var val = Math.random();
            if(val < 0.5){
                var enemy = new Imp(room);
                room.demons().add(enemy);
            }
            else{
                condition = false;
            }
        }
    }

    @Override
    public void add(List<Room> rooms) {
        rooms.forEach(r -> populateRoom(r));
    }
}
