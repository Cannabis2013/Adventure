package Adventure.CommandInterpreter.General;

import Adventure.ScreenMessages.FormatMessages;

import java.util.List;

public class PrintGeneralMessages {
    FormatMessages _formatter = new FormatMessages();

    public void printInventory(List<String> inventory){
        var msg = "";
        var formatted = "";
        if(!inventory.isEmpty())
            msg = inventory.stream().reduce("",(str,title) -> str + title + "\n");
        else
            msg = "No items in inventory";
        formatted = _formatter.formatWhiteOnGreenTight(msg);
        System.out.println(formatted);
    }

    public void printHealth(int health) {
        String msg = "Health:";
        String formattedString = "";
        msg += String.format("\n\nYou have %s health.", health);
        formattedString = _formatter.formatWhiteOnGreenLoose(msg);
        System.out.println(formattedString);
    }

    public void printBadCommand(){
        var msg = "!!!! Bad command. Please try again. !!!!";
        var formatted = _formatter.formatNegativeResponse(msg);
        System.out.println(formatted);
    }
}
