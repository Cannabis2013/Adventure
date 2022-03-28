package GameEngine.Player.Actions;

import GameEngine.Contracts.IObjectEntity;
import GameEngine.Contracts.IRoom;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.InvalidObjectException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Item;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Usables.Usable;
import GameEngine.Player.Exceptions.ItemNotUsableException;
import GameEngine.Player.Exceptions.TargetNotFoundException;
import GameEngine.Player.Exceptions.UsableNotFoundException;
import GameEngine.Player.PlayerObject;
import GameEngine.Utils.FindObjectFromList;
import GameEngine.Utils.ItemNotFoundException;
import GameEngine.Utils.ObjectNotFoundException;

import java.util.List;

public class UseItem {
    public String use(String itemTitle, String roomObject, IRoom currentRoom,
                      FindObjectFromList _findObject, List<Item> _inventory) throws TargetNotFoundException, UsableNotFoundException, InvalidObjectException {
        var roomObjects = currentRoom.roomObjects();
        IObjectEntity roomItem = null;
        try {
            roomItem = _findObject.findObjectByTitle(roomObjects, roomObject);
        } catch (ObjectNotFoundException e) {
            throw new TargetNotFoundException();
        }
        IObjectEntity item = null;
        try {
            item = _findObject.findItemByTitle(_inventory,itemTitle);
        } catch (ItemNotFoundException e) {
            throw new UsableNotFoundException();
        }
        if(item instanceof Usable){
            var usable = (Usable) item;
            return usable.useOn(roomItem);
        }
        throw new InvalidObjectException();
    }
    public String use(String itemTitle, FindObjectFromList _findObject,
                      List<Item> _inventory, PlayerObject player) throws ItemNotFoundException, InvalidObjectException, ItemNotUsableException {
        var item = _findObject.findItemByTitle(_inventory,itemTitle);
        if(item instanceof Usable){
            var usable = (Usable) item;
            return usable.useOn(player);
        }
        throw new ItemNotUsableException();
    }
}
