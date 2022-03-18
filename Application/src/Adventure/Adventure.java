package Adventure;

import Adventure.Printer.Printer;
import Adventure.StringBuilders.BadCommand.BuildBadCmdMessage;
import Adventure.StringBuilders.BadDirection.BuildBadWayMessage;
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

    protected void printBadDirection(){
        var msgBuilder = new BuildBadWayMessage();
        printer.printLine(msgBuilder.build());
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

    private void handleGoCommand(String orientation){
        try {
            gameEngine.traverseTo(orientation);
            printDescription();
        } catch (IllegalArgumentException e){
            printBadCommand();
        } catch (IllegalStateException e){
            printBadDirection();
        }
    }

    private void interpretCommand(String command){
        switch (command){
            case "exit" -> System.exit(0);
            case "help" -> printHelp();
            case "look" -> printDescription();
            case "go north" -> handleGoCommand("north");
            case "go east" -> handleGoCommand("east");
            case "go south" -> handleGoCommand("south");
            case "go west" -> handleGoCommand("west");
            default -> printBadCommand();
        }
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
        }
    }
}
