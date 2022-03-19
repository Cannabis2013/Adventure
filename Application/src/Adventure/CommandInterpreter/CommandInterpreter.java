package Adventure.CommandInterpreter;

import Adventure.ScreenMessages.PrintMessages;
import GameEngine.BuildMap.Rooms.DoorIsLockedException;
import GameEngine.GameEngine;

public class CommandInterpreter {
    private GameEngine gameEngine = new GameEngine();

    private void handleGoCommand(String command, PrintMessages printMessage){
        try {
            gameEngine.traverseTo(command.substring(3));
            printMessage.printRoomInfo(gameEngine.roomDescription(),gameEngine.roomItems());
        } catch (IllegalArgumentException e){
            printMessage.printBadCommand();
        } catch (IllegalStateException e){
            printMessage.printBadDirection();
        } catch (DoorIsLockedException e){
            printMessage.printLockedDoorMsg(e.getMessage());
        }
    }

    private void handleTakeCommand(String command, PrintMessages printMessage){
        String reduced = command.substring(5);
        try {
            gameEngine.takeItem(reduced);
        } catch (IllegalArgumentException e) {
            printMessage.printItemNotInRoom(reduced);
        }
    }
    private void handleDropCommand(String command, PrintMessages printMessage){
        String reduced = command.substring(5);
        try {
            gameEngine.dropItem(reduced);
        } catch (IllegalArgumentException e) {
            printMessage.printItemNotInInventory(reduced);
        }
    }

    private void handleGeneralCommands(String command, PrintMessages printMessage){
        switch (command){
            case "exit" -> System.exit(0);
            case "help" -> printMessage.printHelp();
            case "look" -> printMessage.printRoomInfo(gameEngine.roomDescription(),gameEngine.roomItems());
            case "inventory" -> printMessage.printInventory(gameEngine.inventory());
            default -> printMessage.printBadCommand();
        }
    }

    public void interpret(String command, PrintMessages printer){
        if(command.startsWith("go"))
            handleGoCommand(command,printer);
        else if(command.startsWith("take"))
            handleTakeCommand(command,printer);
        else if(command.startsWith("drop"))
            handleDropCommand(command,printer);
        else
            handleGeneralCommands(command,printer);
    }
}
