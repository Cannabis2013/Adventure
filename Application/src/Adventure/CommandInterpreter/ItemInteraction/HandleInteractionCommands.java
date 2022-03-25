package Adventure.CommandInterpreter.ItemInteraction;

import GameEngine.GameEngine;
import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.MapItems.InvalidObjectException;
import GameEngine.Utils.ItemNotFoundException;

public class HandleInteractionCommands {
    private PrintInteractionMessages _printer = new PrintInteractionMessages();

    private void takeOneItem(String itemID, GameEngine engine){
        int id = Integer.parseInt(itemID);
        try {
            var itemTitle = engine.takeItem(id);
            _printer.printItemTaken(itemTitle);
        } catch (ItemNotFoundException e) {
            _printer.printItemNotInRoom(itemID);
        }
    }

    public void handleTake(String command, GameEngine engine){
        String arg = command.substring(5);
        if(!arg.matches("^\\d+$"))
            _printer.printBadCommand();
        else if(arg.equals("all"))
            engine.takeAll();
        else
            takeOneItem(arg,engine);

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
