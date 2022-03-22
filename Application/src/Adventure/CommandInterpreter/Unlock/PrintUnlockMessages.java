package Adventure.CommandInterpreter.Unlock;

import Adventure.ScreenMessages.FormatMessages;

public class PrintUnlockMessages {
    FormatMessages formatter = new FormatMessages();

    public void printDoorNotFound(){
        var msg = "there is no door at that orientation";
        var formatted = formatter.formatNegativeResponse(msg);
        System.out.println(formatted);
    }

    public void printDoorUnlocked(){
        var msg = "Door is open";
        var formatted = formatter.formatNegativeResponse(msg);
        System.out.println(formatted);
    }

    public void printWrongKey(){
        var formatted = formatter.formatNegativeResponse("Wrong key");
        System.out.println(formatted);
    }

    public void printBadCommand(){
        var msg = "!!!! Bad command. Please try again. !!!!";
        var formatted = formatter.formatNegativeResponse(msg);
        System.out.println(formatted);
    }

    public void printKeyNotFound(){
        var msg = "You don't posses that key";
        var formatted = formatter.formatNegativeResponse(msg);
        System.out.println(formatted);
    }
}
