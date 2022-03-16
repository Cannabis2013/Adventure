package Adventure;

import Adventure.Printer.Printer;
import Adventure.StringBuilders.BadCommand.BuildBadCmdMessage;
import Adventure.StringBuilders.BadDirection.BuildBadWayMessage;
import Adventure.StringBuilders.CommandLine.BuildCommandMessage;
import Adventure.StringBuilders.Descriptions.BuildDescriptMessage;
import Adventure.StringBuilders.Help.BuildHelpMessage;
import Adventure.StringBuilders.Intro.BuildIntroMessage;
import Application.IApplication;
import java.util.Scanner;

public abstract class AbstractAdventure {

    protected Printer printer = new Printer();
    protected Scanner inputReader = new Scanner(System.in);
    protected IApplication application;
    public void setEngine(IApplication app) {application = app;}

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
        var description = application.roomDescription();
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

    public abstract void run();
}
