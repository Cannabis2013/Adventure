package Adventure.CommandInterpreter.ItemInteraction;

import Adventure.ScreenMessages.FormatMessages;

public class PrintInteractionMessages {
    private FormatMessages formatter = new FormatMessages();

    public void printItemNotInRoom(String itemTitle){
        var msg = String.format("There is nothing like %s to take around here",itemTitle);
        var formatted = formatter.formatNegativeResponse(msg);
        System.out.println(formatted);
    }

    public void printItemNotInInventory(String itemTitle){
        var msg = String.format("You don't have anything like %s in your inventory",itemTitle);
        var formatted = formatter.formatNegativeResponse(msg);
        System.out.println(formatted);
    }
}
