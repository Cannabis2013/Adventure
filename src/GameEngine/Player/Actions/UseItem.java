package GameEngine.Player.Actions;

import GameEngine.Contracts.IObjectEntity;
import GameEngine.Contracts.IRoom;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.InvalidObjectException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Item;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Usables.Usable;
import GameEngine.Player.Exceptions.ItemNotUsableException;
import GameEngine.Player.Exceptions.TargetNotFoundException;
import GameEngine.Player.Exceptions.UsableNotFoundException;
import GameEngine.Player.InventoryBag.Bag;
import GameEngine.Player.PlayerObject;
import GameEngine.Utils.ItemNotFoundException;

public class UseItem {
    IObjectEntity findTarget(IRoom room, String title) throws TargetNotFoundException {
        var obj = room.roomObjects().stream()
                .filter(o -> o.title().equals(title))
                .findFirst();
        if(obj.isEmpty())
            throw new TargetNotFoundException();
        return obj.get();
    }

    private Item findItemFromBag(Bag bag, String itemTitle) throws UsableNotFoundException {
        try {
            return bag.get(itemTitle);
        } catch (ItemNotFoundException e) {
            e.printStackTrace();
            throw new UsableNotFoundException();
        }
    }

    public String use(String itemTitle, String targetObject, IRoom currentRoom, Bag bag) throws TargetNotFoundException, UsableNotFoundException, InvalidObjectException {
        var roomObjects = currentRoom.roomObjects();
        IObjectEntity roomItem = findTarget(currentRoom,targetObject);
        var item = findItemFromBag(bag,itemTitle);
        if(item instanceof Usable){
            var usable = (Usable) item;
            return usable.useOn(roomItem);
        }
        throw new InvalidObjectException();
    }
    public String use(String itemTitle, Bag bag, PlayerObject player) throws InvalidObjectException, ItemNotUsableException, UsableNotFoundException {
        var item = findItemFromBag(bag,itemTitle);
        if(item instanceof Usable){
            var usable = (Usable) item;
            return usable.useOn(player);
        }
        throw new ItemNotUsableException();
    }
}
