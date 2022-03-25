package Adventure.CommandInterpreter.ItemInteraction;

import Adventure.ScreenMessages.FormatMessages;

public class PrintInteractionMessages {
    private FormatMessages _formatter = new FormatMessages();

    public void printItemNotInRoom(String itemTitle){
        var msg = String.format("There is nothing like %s to take around here",itemTitle);
        var formatted = _formatter.formatNegativeResponse(msg);
        System.out.println(formatted);
    }

    public void printItemNotInInventory(String itemTitle){
        var msg = String.format("You don't have anything like %s in your inventory",itemTitle);
        var formatted = _formatter.formatNegativeResponse(msg);
        System.out.println(formatted);
    }

    public void printItemNotConsumable(String itemTitle) {
        String msg = String.format("%s is not a consumable item", itemTitle);
        String formatted = _formatter.formatNegativeResponse(msg);
        System.out.println(formatted);
    }

    public void printItemTaken(String itemTitle){
        var msg = String.format("You have taken %s.",itemTitle);
        var formatted = _formatter.formatWhiteOnRedTight(msg);
        System.out.println(formatted);
    }

    public void printItemDropped(String itemTitle){
        var msg = String.format("You dropped %s.",itemTitle);
        var formatted = _formatter.formatWhiteOnRedTight(msg);
        System.out.println(formatted);
    }

    public void printItemEaten(String itemTitle) {
        var msg = String.format("You ate %s",itemTitle);
        var formatted = _formatter.formatWhiteOnRedTight(msg);
        System.out.println(formatted);
    }

    public void printBadCommand(){
        var msg = "!!!! Bad command. Please try again. !!!!";
        var formatted = _formatter.formatNegativeResponse(msg);
        System.out.println(formatted);
    }
}
