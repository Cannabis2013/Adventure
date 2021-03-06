package Adventure.CommandInterpreter.ItemUsage;

import Adventure.ScreenMessages.PrintFormatter;

public class PrintUsageMessages {
    private PrintFormatter _formatter = new PrintFormatter();
    public void printInvalidObject(){
        var msg = "Can't use this item on that";
        var formatted = _formatter.formatNegativeResponse(msg);
        System.out.println(formatted);
    }

    public void printTargetNotFound(){
        var msg = "Can't use item on something I can't see. Sorry.";
        var formatted = _formatter.formatNegativeResponse(msg);
        System.out.println(formatted);
    }

    public void printUsableNotFound(String itemTitle){
        var msg = String.format("You don't have anything like %s in your inventory",itemTitle);
        var formatted = _formatter.formatNegativeResponse(msg);
        System.out.println(formatted);
    }

    public void printNotUsable(String itemTitle){
        var msg = itemTitle + " not usable";
        var formatted = _formatter.formatNegativeResponse(msg);
        System.out.println(formatted);
    }

    public void printResult(String result){
        var formatted = _formatter.formatWhiteOnDarkRedLoose(result);
        System.out.println(formatted);
    }
}
