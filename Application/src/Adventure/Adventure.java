package Adventure;

import Adventure.Printer.Printer;
import Adventure.StringBuilders.BadCommand.BuildBadCmdMessage;
import Adventure.StringBuilders.BadDirection.BuildBadDirectionMessage;
import Adventure.StringBuilders.BadItem.BuildItemNotInInventoryMsg;
import Adventure.StringBuilders.BadItem.BuildItemNotInRoomMsg;
import Adventure.StringBuilders.CommandLine.BuildCommandMessage;
import Adventure.StringBuilders.Descriptions.BuildDescriptMessage;
import Adventure.StringBuilders.Help.BuildHelpMessage;
import Adventure.StringBuilders.Intro.BuildIntroMessage;
import GameEngine.GameEngine;
import java.util.Scanner;

public class Adventure{

    protected Printer printer = new Printer();
    protected Scanner inputReader = new Scanner(System.in);
    protected GameEngine gameEngine = new GameEngine();
    protected void printIntro(){
        var msgBuilder = new BuildIntroMessage();
        printer.printLine(msgBuilder.build());
    }

    protected void printHelp()
    {
        var helpMsg = new BuildHelpMessage().build();
        printer.printLine(helpMsg);
    }

    protected void printDescription(){
        var description = gameEngine.roomDescription();
        description += "\n\n" + gameEngine.getRoomItemsAsString();
        var msg = new BuildDescriptMessage().build(description);
        printer.printLine(msg);
    }

    protected void printCommandLine(){
        var msg = new BuildCommandMessage().build();
        printer.print(msg);
    }

    protected void printBadCommand(){
        var badMsg = new BuildBadCmdMessage().build();
        printer.printLine(badMsg);
    }

    private void printBadDirection(){
        var msgBuilder = new BuildBadDirectionMessage();
        printer.printLine(msgBuilder.build());
    }

    private void printItemNotInRoom(String badItemTitle){
        var msgBuilder = new BuildItemNotInRoomMsg();
        printer.printLine(msgBuilder.build(badItemTitle));
    }

    private void printItemNotInInventory(String badItemTitle){
        var msgBuilder = new BuildItemNotInInventoryMsg();
        printer.printLine(msgBuilder.build(badItemTitle));
    }

    protected String readCommand(){
        printCommandLine();
        String command = inputReader.nextLine();
        return command;
    }

    protected void haltUntilPressed(){
        printer.print("Press any key to continue");
        inputReader.nextLine();
    }

    private void handleGoCommand(String command){
        try {
            gameEngine.traverseTo(command.substring(4));
        } catch (IllegalArgumentException e){
            printBadCommand();
        } catch (IllegalStateException e){
            printBadDirection();
        }
    }

    private void handleTakeCommand(String command){
        String reduced = command.substring(5);
        try {
            gameEngine.takeItem(reduced);
        } catch (IllegalArgumentException e) {
            printItemNotInRoom(reduced);
        }
    }
    private void handleDropCommand(String command){
        String reduced = command.substring(5);
        try {
            gameEngine.dropItem(reduced);
        } catch (IllegalArgumentException e) {
            printItemNotInInventory(reduced);
        }
    }

    private void handleGeneralCommands(String command){
        switch (command){
            case "exit" -> System.exit(0);
            case "help" -> printHelp();
            case "look" -> printDescription();
            case "inventory" -> printer.printLine(gameEngine.getInventoryAsString());
            default -> printBadCommand();
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

    public void run(){
        gameEngine.init();
        printIntro();
        haltUntilPressed();
        printHelp();
        while (true)
        {
            var command = readCommand();
            interpretCommand(command);
            printDescription();
        }
    }
}
