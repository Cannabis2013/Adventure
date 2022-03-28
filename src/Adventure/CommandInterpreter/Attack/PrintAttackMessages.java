package Adventure.CommandInterpreter.Attack;

import Adventure.ScreenMessages.FormatMessages;

public class PrintAttackMessages {
    private FormatMessages _formatter = new FormatMessages();

    public void printFatalMessage(){
        var msg = "You dealt a fatal blow";
        var formatted = _formatter.formatWhiteOnBrownTight(msg);
        System.out.println(formatted);
    }

    public void printResult(String sound,String result, String target){
        var msg = sound + "\n" + "You dealt " + result + " damage";
        if(!target.isEmpty())
            msg += " to " + target;
        var formatted = _formatter.formatWhiteOnRedTight(msg);
        System.out.println(formatted);
    }

    public void printDemonNotFound(){
        var msg = "Demon not found";
        var formatted = _formatter.formatNegativeResponse(msg);
        System.out.println(formatted);
    }
}
