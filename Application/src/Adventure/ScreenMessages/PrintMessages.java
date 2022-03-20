package Adventure.ScreenMessages;

public class PrintMessages {
    MessageBuilder builder = new MessageBuilder();
    FormatMessages formatter = new FormatMessages();
    private Printer printer = new Printer();

    public void printIntro(){
        var msg = builder.buildIntroMsg();
        var formattedMsg = formatter.formatIntro(msg);
        printer.printLine(formattedMsg);
    }

    public void printPressButtonCommand(){
        var msg = builder.buildPressKeyMsg();
        var formattedMsg = formatter.formatPressButton(msg);
        printer.printLine(formattedMsg);
    }

    public void printHelp()
    {
        var msg = builder.buildHelpMsg();
        var formattedMsg = formatter.formatHelp(msg);
        printer.printLine(formattedMsg);
    }

    public void printRoomInfo(String description, String items){
        var msg = builder.buildRoomDescription(description);
        var formattedMsg = formatter.formatRoomInfo(msg + items);
        printer.printLine(formattedMsg);
    }

    public void printCommandLine(){
        var msg = formatter.formatCommandLine("Command->");
        printer.print(msg);
    }

    public void printBadCommand(){
        var msg = builder.buildBadCommand();
        var formattedMsg = formatter.formatNegativeResponse(msg);
        printer.printLine(formattedMsg);
    }

    public void printBadDirection(){

        var msg = builder.buildBadDirection();
        var formattedMsg = formatter.formatNegativeResponse(msg);
        printer.printLine(formattedMsg);
    }

    public void printItemNotInRoom(String badItemTitle){
        var msg = builder.buildBadRoomPick(badItemTitle);
        var formattedMsg = formatter.formatNegativeResponse(msg);
        printer.printLine(msg);
    }

    public void printItemNotInInventory(String badItemTitle){
        var msg = builder.buildBadInventoryPick(badItemTitle);
        var formattedMsg = formatter.formatNegativeResponse(msg);
        printer.printLine(formattedMsg);
    }

    public void printInventory(String inventory){
        printer.printLine(inventory);
    }

    public void printLockedDoorMsg(){
        var msg = builder.buildLocked();
        var formatted = formatter.formatNegativeResponse(msg);
        printer.printLine(formatted);
    }

    public void printWrongKey(){
        var msg = builder.buildWrongKey();
        var formatted = formatter.formatNegativeResponse(msg);
        printer.printLine(formatted);
    }

    public void printItemNotInInventory(){
        var msg = builder.buildItemNotInInventory();
        var formatted = formatter.formatNegativeResponse(msg);
        printer.printLine(formatted);
    }

    public void printDoorNotFound(){
        var msg = builder.buildDoorNotFound();
        var formatted = formatter.formatNegativeResponse(msg);
        printer.printLine(formatted);
    }

    public void printDoorUnlocked(){
        var msg = builder.buildDoorUnlocked();
        var formatted = formatter.formatNegativeResponse(msg);
        printer.printLine(formatted);
    }
}
