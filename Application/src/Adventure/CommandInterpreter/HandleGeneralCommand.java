package Adventure.CommandInterpreter;

import Adventure.ScreenMessages.PrintMessages;
import GameEngine.GameEngine;

public class HandleGeneralCommand {
    public void handle(String command, PrintMessages printMessage, GameEngine gameEngine){
        switch (command){
            case "exit" -> System.exit(0);
            case "help" -> printMessage.printHelp();
            case "look" -> printMessage.printRoomInfo(gameEngine.roomDescription(),gameEngine.roomItems());
            case "inventory" -> printMessage.printInventory(gameEngine.inventory());
            default -> printMessage.printBadCommand();
        }
    }
}
