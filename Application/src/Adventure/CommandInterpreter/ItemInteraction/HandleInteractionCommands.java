package Adventure.CommandInterpreter.ItemInteraction;

import GameEngine.GameEngine;
import GameEngine.Utils.ItemNotFoundException;

public class HandleInteractionCommands {
    private PrintInteractionMessages _printer = new PrintInteractionMessages();

    public void handleTake(String command, GameEngine gameEngine){
        String args = command.substring(5);
        try {
            var itemTitle = gameEngine.takeItem(args);
            _printer.printItemTaken(itemTitle);
        } catch (ItemNotFoundException e) {
            _printer.printItemNotInRoom(args);
        }
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
}
