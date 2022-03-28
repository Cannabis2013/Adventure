package GameEngine.Player.Actions;

import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Consumables.Consumable;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Item;
import GameEngine.Player.Exceptions.ItemNotConsumableException;
import GameEngine.Player.PlayerObject;
import GameEngine.Utils.FindObjectFromList;
import GameEngine.Utils.ItemNotFoundException;

import java.util.List;

public class ConsumeItem {
    public String consume(String itemTitle, FindObjectFromList _findObject,
                          List<Item> _inventory, PlayerObject player) throws ItemNotFoundException, ItemNotConsumableException {
        var item = _findObject.findItemByTitle(_inventory, itemTitle);
        _inventory.remove(item);
        if (item instanceof Consumable) {
            var food = (Consumable) item;
            return food.consume(player);
        }
        throw new ItemNotConsumableException();
    }
}
