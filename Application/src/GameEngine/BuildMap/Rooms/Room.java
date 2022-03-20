package GameEngine.BuildMap.Rooms;

import GameEngine.BuildMap.MapObjects.MapObject;
import GameEngine.InitializeMap.MapItems.Item;
import java.util.ArrayList;
import java.util.Optional;

public class Room extends MapObject {
    public enum RoomType {Normal,Special}
    private RoomType roomType;

    public RoomType getRoomType() {
        return roomType;
    }

    public void promote(){
        roomType = RoomType.Special;
    }

    private Door north, east,south,west;
    private ArrayList<Item> items = new ArrayList<>();

    public void addItem(Item item){
        items.add(item);
    }

    public Item takeItem(String itemTitle){
        Optional<Item> optional = items.stream().filter(i ->
                        i.getShortTitle().equalsIgnoreCase(itemTitle)  ||
                                i.getTitle().equalsIgnoreCase(itemTitle))
                .findFirst();
        if(optional.isEmpty())
            throw new IllegalArgumentException();
        items.remove(optional.get());
        return optional.get();
    }

    public Door getNorth() {
        return north;
    }

    public void setNorth(Room room) {
        var door = new Door(this,room);
        this.north = door;
        room.south = door;
    }

    public Door getEast() {
        return east;
    }

    public void setEast(Room room) {
        var door = new Door(this,room);
        this.east = door;
        room.west = door;
    }

    public Door getSouth() {
        return south;
    }

    public void setSouth(Room room) {
        var door = new Door(this,room);
        this.south = door;
        room.north = door;
    }

    public Door getWest() {
        return west;
    }

    public void setWest(Room room) {
        var door = new Door(this,room);
        this.west = door;
        room.east = door;
    }

    public Room(String name, RoomType type){
        this.name = name;
        this.roomType = type;
    }

    public String itemsAsString() {
        if(items.isEmpty())
            return "There seems to be no items of value in this room";
        StringBuilder sb = new StringBuilder();
        items.forEach(i-> sb.append(i.getTitle() + "\n"));
        return sb.toString();
    }

    public void disconnect() throws DoorIsLockedException {
        if(this.north != null)
            north.getOther(this).south = null;
        if(east != null)
            east.getOther(this).west = null;
        if(south != null)
            south.getOther(this).north = null;
        if(west != null)
            west.getOther(this).east = null;
        north = null;
        east = null;
        south = null;
        west = null;
    }
}
