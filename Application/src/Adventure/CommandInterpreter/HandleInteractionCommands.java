package Adventure.CommandInterpreter;

import Adventure.ScreenMessages.PrintMessages;
import GameEngine.GameEngine;

public class HandleInteractionCommands {
    public void handleTakeCommand(String command, PrintMessages printMessage, GameEngine gameEngine){
        String reduced = command.substring(5);
        try {
            gameEngine.takeItem(reduced);
        } catch (IllegalArgumentException e) {
            printMessage.printItemNotInRoom(reduced);
        }
    }
    public void handleDrop(String command, PrintMessages printMessage, GameEngine gameEngine){
        String reduced = command.substring(5);
        try {
            gameEngine.dropItem(reduced);
        } catch (IllegalArgumentException e) {
            printMessage.printItemNotInInventory(reduced);
        }
    }
}
