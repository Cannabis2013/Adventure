package Adventure.CommandInterpreter.ItemInteraction;

import Adventure.ScreenMessages.PrintMessages;
import GameEngine.Utils.ItemNotFoundException;
import GameEngine.GameEngine;

public class HandleInteractionCommands {
    private PrintInteractionMessages _printer = new PrintInteractionMessages();

    public void handleTakeCommand(String command, GameEngine gameEngine){
        String args = command.substring(5);
        try {
            gameEngine.takeItem(args);
        } catch (ItemNotFoundException e) {
            _printer.printItemNotInRoom(args);
        }
    }
    public void handleDrop(String command,  GameEngine gameEngine){
        String args = command.substring(5);
        try {
            gameEngine.dropItem(args);
        } catch (ItemNotFoundException e) {
            _printer.printItemNotInInventory(args);
        }
    }
}
