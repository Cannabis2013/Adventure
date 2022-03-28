package Adventure.CommandInterpreter.General;

import Adventure.ScreenMessages.PrintHelp;
import Adventure.ScreenMessages.PrintRoomDetails;
import GameEngine.GameEngine;

public class HandleGeneralCommand {
    private PrintGeneralMessages _printer = new PrintGeneralMessages();
    private PrintRoomDetails _printRoomDetails = new PrintRoomDetails();
    private PrintHelp _printHelp = new PrintHelp();

    private void printRoomDetails(GameEngine engine){
        var description = engine.roomDescription();
        var roomEnemies = engine.roomEnemies();
        var roomItems = engine.roomItems();
        var doorTitles = engine.doorNames();
        var equipped = engine.equippedWeapon();
        _printRoomDetails.print(description,roomEnemies,roomItems,doorTitles,equipped);
    }

    public void handle(String command, GameEngine engine){
        switch (command){
            case "exit" -> System.exit(0);
            case "help" -> _printHelp.print();
            case "look" -> printRoomDetails(engine);
            case "inventory" -> _printer.printInventory(engine.inventory());
            case "health" -> _printer.printHealth(engine.health());
            default -> _printer.printBadCommand();
        }
    }
}
