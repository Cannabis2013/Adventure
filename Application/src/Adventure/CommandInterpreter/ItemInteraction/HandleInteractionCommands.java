package Adventure.CommandInterpreter.ItemInteraction;

import GameEngine.GameEngine;
import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.MapItems.InvalidObjectException;
import GameEngine.Utils.ItemNotFoundException;

public class HandleInteractionCommands {
    private PrintInteractionMessages _printer = new PrintInteractionMessages();

    private void takeOneItem(String itemTitle, GameEngine engine){
        try {
            engine.takeItem(itemTitle);
            _printer.printItemTaken(itemTitle);
        } catch (ItemNotFoundException e) {
            _printer.printItemNotInRoom(itemTitle);
        }
    }

    public void handleTake(String command, GameEngine engine){
        String itemTitle = command.substring(5);
        if(itemTitle.equals("all"))
            engine.takeAll();
        else
            takeOneItem(itemTitle,engine);

    }

    public void handleDrop(String command,  GameEngine gameEngine){
        String args = command.substring(5);
        try {
            var itemTitle = gameEngine.dropItem(args);
            _printer.printItemDropped(itemTitle);
        } catch (ItemNotFoundException e) {
            _printer.printItemNotInInventory(args);
        }
    }

    public void handleEat(String command, GameEngine gameEngine) {
        String args = command.substring(4);
        try {
            String itemTitle = gameEngine.eatItem(args);
            _printer.printItemEaten(itemTitle);
        } catch (ItemNotFoundException | InvalidObjectException e) {
            _printer.printItemNotConsumable(args);
        }
    }
}
