package Adventure.CommandInterpreter.General;

import Adventure.ScreenMessages.FormatMessages;

public class PrintGeneralMessages {
    FormatMessages _formatter = new FormatMessages();

    public void printInventory(String inventory){
        var msg = "Inventory:";
        var formatted = "";
        if(!inventory.isEmpty()){
            msg += "\n\n" + inventory;
            formatted = _formatter.formatWhiteOnGreenLoose(msg);
        }
        else{
            msg = "No items in inventory";
            formatted = _formatter.formatWhiteOnGreenTight(msg);
        }
        System.out.println(formatted);
    }

    public void printBadCommand(){
        var msg = "!!!! Bad command. Please try again. !!!!";
        var formatted = _formatter.formatNegativeResponse(msg);
        System.out.println(formatted);
    }
}
