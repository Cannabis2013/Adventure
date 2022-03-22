package Adventure.CommandInterpreter.General;

import Adventure.ScreenMessages.PrintHelp;
import Adventure.ScreenMessages.PrintMessages;
import Adventure.ScreenMessages.PrintRoomDetails;
import GameEngine.GameEngine;

public class HandleGeneralCommand {
    private PrintGeneralMessages _printer = new PrintGeneralMessages();
    private PrintRoomDetails _printRoomDetails = new PrintRoomDetails();
    private PrintHelp _printHelp = new PrintHelp();

    public void handle(String command, PrintMessages printMessage, GameEngine gameEngine){
        switch (command){
            case "exit" -> System.exit(0);
            case "help" -> _printHelp.print();
            case "look" -> _printRoomDetails.print(gameEngine.roomDescription(),gameEngine.roomItems());
            case "inventory" -> _printer.printInventory(gameEngine.inventory());
            default -> _printer.printBadCommand();
        }
    }
}
