package Adventure.CommandInterpreter.Attack;

import Adventure.ScreenMessages.FormatMessages;

public class PrintAttackMessages {
    private FormatMessages _formatter = new FormatMessages();

    public void printFatalMessage(){
        var msg = "You dealt a fatal blow";
        var formatted = _formatter.formatWhiteOnBrownTight(msg);
        System.out.println(formatted);
    }

    public void printResult(String result){
        var formatted = _formatter.formatWhiteOnRedTight(result);
        System.out.println(formatted);
    }
}
