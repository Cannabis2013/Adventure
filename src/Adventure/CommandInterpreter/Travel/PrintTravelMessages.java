package Adventure.CommandInterpreter.Travel;

import Adventure.ScreenMessages.PrintFormatter;

public class PrintTravelMessages {
    private PrintFormatter _formatter = new PrintFormatter();

    public void printBadCommand(){
        var msg = "!!!! Bad command. Please try again. !!!!";
        var formatted = _formatter.formatNegativeResponse(msg);
        System.out.println(formatted);
    }

    public void printBadOrientation(){

        var msg = "you can not go that way";
        var formatted = _formatter.formatNegativeResponse(msg);
        System.out.println(formatted);
    }

    public void printLockedDoor(){
        var msg = "Door is locked";
        var formatted = _formatter.formatNegativeResponse(msg);
        System.out.println(formatted);
    }
}
