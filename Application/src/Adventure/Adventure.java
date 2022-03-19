package Adventure;

import Adventure.Printer.PrintMessages;
import GameEngine.GameEngine;
import java.util.Scanner;

public class Adventure{
    private PrintMessages printMessage = new PrintMessages();
    private Scanner inputReader = new Scanner(System.in);
    private GameEngine gameEngine = new GameEngine();

    protected String readCommand(){
        String command = inputReader.nextLine();
        return command;
    }

    private void handleGoCommand(String command){
        try {
            gameEngine.traverseTo(command.substring(3));
            printMessage.printRoomInfo(gameEngine.roomDescription(),gameEngine.roomItems());
        } catch (IllegalArgumentException e){
            printMessage.printBadCommand();
        } catch (IllegalStateException e){
            printMessage.printBadDirection();
        }
    }

    private void handleTakeCommand(String command){
        String reduced = command.substring(5);
        try {
            gameEngine.takeItem(reduced);
        } catch (IllegalArgumentException e) {
            printMessage.printItemNotInRoom(reduced);
        }
    }
    private void handleDropCommand(String command){
        String reduced = command.substring(5);
        try {
            gameEngine.dropItem(reduced);
        } catch (IllegalArgumentException e) {
            printMessage.printItemNotInInventory(reduced);
        }
    }

    private void handleGeneralCommands(String command){
        switch (command){
            case "exit" -> System.exit(0);
            case "help" -> printMessage.printHelp();
            case "look" -> printMessage.printRoomInfo(gameEngine.roomDescription(),gameEngine.roomItems());
            case "inventory" -> printMessage.printInventory(gameEngine.inventory());
            default -> printMessage.printBadCommand();
        }
    }

    private void interpretCommand(String command){
        if(command.startsWith("go"))
            handleGoCommand(command);
        else if(command.startsWith("take"))
            handleTakeCommand(command);
        else if(command.startsWith("drop"))
            handleDropCommand(command);
        else
            handleGeneralCommands(command);
    }

    private void pressButton(){
        printMessage.printPressButtonCommand();
        inputReader.nextLine();
    }

    public void run(){
        gameEngine.init();
        printMessage.printIntro();
        pressButton();
        printMessage.printHelp();
        pressButton();
        while (true)
        {
            printMessage.printCommandLine();
            var command = readCommand();
            interpretCommand(command);
        }
    }
}
