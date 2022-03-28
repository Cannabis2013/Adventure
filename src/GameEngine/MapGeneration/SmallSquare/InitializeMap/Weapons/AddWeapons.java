package GameEngine.MapGeneration.SmallSquare.InitializeMap.Weapons;

import GameEngine.MapGeneration.SmallSquare.Models.Room;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.RandomRoomsPopulator;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.Weapons.BuildWeapons.BuildRandomWeapon;

import java.util.List;

public class AddWeapons extends RandomRoomsPopulator {
    private BuildRandomWeapon _buildRandomWeapon = new BuildRandomWeapon();

    private void populateRoom(Room room){
        var condition = true;
        while (condition){
            var val = Math.random();
            if(val < 0.5){
                var weapon = _buildRandomWeapon.build();
                room.addItem(weapon);
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
