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
        var msg = "Press any key to continue";
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
        var msg = description + "\n\n";
        var formattedMsg = formatter.formatRoomInfo(msg + items);
        printer.printLine(formattedMsg);
    }

    public void printCommandLine(){
        var msg = formatter.formatCommandLine("Command->");
        printer.print(msg);
    }

    public void printBadCommand(){
        var msg = "!!!! Bad command. Please try again. !!!!";
        var formattedMsg = formatter.formatNegativeResponse(msg);
        printer.printLine(formattedMsg);
    }

    public void printBadDirection(){

        var msg = "you can not go that way";
        var formattedMsg = formatter.formatNegativeResponse(msg);
        printer.printLine(formattedMsg);
    }

    public void printItemNotInRoom(String itemTitle){
        var msg = String.format("There is nothing like %s to take around here",itemTitle);
        var formattedMsg = formatter.formatNegativeResponse(msg);
        printer.printLine(msg);
    }

    public void printItemNotInInventory(String itemTitle){
        var msg = String.format("You don't have anything like %s in your inventory",itemTitle);
        var formattedMsg = formatter.formatNegativeResponse(msg);
        printer.printLine(formattedMsg);
    }

    public void printInventory(String inventory){
        printer.printLine(inventory);
    }

    public void printLockedDoorMsg(){
        var msg = "Door is locked";
        var formatted = formatter.formatNegativeResponse(msg);
        printer.printLine(formatted);
    }

    public void printItemNotInInventory(){
        var msg = "You don't posses that item";
        var formatted = formatter.formatNegativeResponse(msg);
        printer.printLine(formatted);
    }

    public void printDoorNotFound(){
        var msg = "there is no door at that orientation";
        var formatted = formatter.formatNegativeResponse(msg);
        printer.printLine(formatted);
    }

    public void printDoorUnlocked(){
        var msg = "Door is open";
        var formatted = formatter.formatNegativeResponse(msg);
        printer.printLine(formatted);
    }

    public void printNegativeResponse(String msg){
        var formatted = formatter.formatNegativeResponse(msg);
        printer.printLine(formatted);
    }
}
