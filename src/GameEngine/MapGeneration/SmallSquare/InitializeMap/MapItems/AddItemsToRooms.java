package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems;

import GameEngine.Contracts.IRoom;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Consumables.Food.Banana;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Item;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Usables.Teleporter.TeleportDevice;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.Melee.Katana;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.Melee.KnuckleBusterWithVolts;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.Ranged.AK47;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.Ranged.DesertEagle;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.Ranged.Mag7;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.Weapon;
import GameEngine.MapGeneration.SmallSquare.Map.Rooms.Room;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class AddItemsToRooms {
    private List<Integer> randomIndexes(int bound){
        var indexes = IntStream.range(0,bound - 1).boxed().toList();
        var l = new ArrayList<Integer>(indexes);
        Collections.shuffle(l);
        return l;
    }

    protected void addItems(List<Room> rooms, List<Item> items){
        var randIndexes = randomIndexes(rooms.size());
        var i = 0;
        var ite = items.listIterator();
        while (ite.hasNext()){
            var item = ite.next();
            if(i >= randIndexes.size()){
                randIndexes = randomIndexes(rooms.size());
                i = 0;
            }
            var index = randIndexes.get(i++);
            rooms.get(index).addItem(item);
        }
    }

    private Weapon instantiateRandomWeapon(){
        var random = new Random();
        var randIndex = random.nextInt(5);
        switch (randIndex){
            case 0 -> {return new AK47();}
            case 1 -> {return new DesertEagle();}
            case 2 -> {return new Mag7();}
            case 3 -> {return new Katana();}
            case 4 -> {return new KnuckleBusterWithVolts();}
            default -> {return null;}
        }
    }

    private List<Item> buildTeleporters(int count){
        var teleporters = new ArrayList<Item>();
        for (var i = 0;i <count;i++)
            teleporters.add(new TeleportDevice());
        return teleporters;
    }

    private List<Item> buildWeapons(int count){
        var weapons = new ArrayList<Item>(count);
        for (var i = 0;i < count;i++)
            weapons.add(instantiateRandomWeapon());
        return weapons;
    }

    private List<Item> buildConsumables(int count){
        var consumables = new ArrayList<Item>(count);
        for (var i = 0; i < count;i++)
            consumables.add(new Banana());
        return consumables;
    }

    private List<Room> getNonRestricted(List<Room> rooms){
        var nonRestricted = rooms.stream()
                .filter(r -> r.getRoomType() == IRoom.RoomType.NORMAL_ROOM
                        && !r.isSealed()).toList();
        return nonRestricted;
    }


    public void add(List<Room> rooms) {
        var weapons = buildWeapons(15);
        addItems(rooms,weapons);
        var nonRestricted = getNonRestricted(rooms);
        var teleporters = buildTeleporters(4);
        addItems(nonRestricted,teleporters);
        var consumables = buildConsumables(18);
        addItems(rooms,consumables);
    }
}
