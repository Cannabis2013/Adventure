package GameEngine.BuildMap.BuildRooms;

import GameEngine.Item.Item;

import java.util.ArrayList;
import java.util.Optional;

public class Room {
    private String name;
    private String description;
    private Room north = null;
    private Room east = null;
    private Room south = null;
    private Room west = null;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Room getNorth() {
        return north;
    }

    public void setNorth(Room north) {
        this.north = north;
        north.south = this;
    }

    public Room getEast() {
        return east;
    }

    public void setEast(Room east) {
        this.east = east;
        east.west = this;
    }

    public Room getSouth() {
        return south;
    }

    public void setSouth(Room south) {
        this.south = south;
        south.north = this;
    }

    public Room getWest() {
        return west;
    }

    public void setWest(Room west) {
        this.west = west;
        west.east = this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        items.forEach(i-> sb.append(i.getTitle() + "\n"));
        return sb.toString();
    }
}
