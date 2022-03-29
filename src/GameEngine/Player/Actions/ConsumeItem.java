package GameEngine.Player.Actions;

import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Consumables.IConsumable;
import GameEngine.Player.Character;
import GameEngine.Player.Exceptions.ItemNotConsumableException;
import GameEngine.Player.InventoryBag.Bag;
import GameEngine.Utils.ItemNotFoundException;

public class ConsumeItem {
    public String consume(String itemTitle, Bag bag, Character player) throws ItemNotFoundException, ItemNotConsumableException {
        var item = bag.take(itemTitle);
        if (item instanceof IConsumable) {
            var food = (IConsumable) item;
            return food.consume(player);
        }
        throw new ItemNotConsumableException();
    }
}
