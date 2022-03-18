package GameEngine.Player;

import GameEngine.BuildMap.BuildRooms.Room;
import GameEngine.Item.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Player {
    private Room currentRoom;
    private List<Item> inventory = new ArrayList<>();

    public List<Item> getInventory() {
        return inventory;
    }

    public void pickItem(Item item){
        inventory.add(item);
    }

    public Item dropItem(String itemTitle){
        Optional<Item> optional = inventory.stream().filter(i ->
                        i.getShortTitle() == itemTitle || i.getTitle() == itemTitle)
                .findFirst();
        if(optional.isEmpty())
            throw new IllegalArgumentException();
        inventory.remove(optional.get());
        return optional.get();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        currentRoom = room;
    }
}
