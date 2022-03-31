package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapEnemies;

import GameEngine.MapGeneration.SmallSquare.Map.Rooms.Room;

import java.util.List;

public class AddEnemies {
    private void populateRoom(Room room){
        var condition = true;
        var MAX_ENEMIES_PER_ROOM = 5;
        var enemyCount = 0;
        while (condition){
            var val = Math.random();
            if(val < 0.8 && enemyCount < 5){
                var enemy = new Imp(room);
                room.demons().add(enemy);
                enemyCount++;
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
