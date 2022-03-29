package Adventure.CommandInterpreter.Attack;

import Adventure.ScreenMessages.FormatMessages;

public class PrintAttackMessages {
    private FormatMessages _formatter = new FormatMessages();

    public void printFatalMessage(){
        var msg = "You dealt a fatal blow";
        var formatted = _formatter.formatWhiteOnBrownTight(msg);
        System.out.println(formatted);
    }

    public void printAttackNoBody(String sound){
        var msg = sound + "\n" + "You must be mad at the air surrounding you. It must be the bad smell.";
        var formatted = _formatter.formatWhiteOnRedTight(msg);
        System.out.println(formatted);
    }

    public void printAttackDemon(String sound, String result, String target){
        var msg = sound + "\n" + "You dealt " + result + " damage";
        if(!target.isEmpty())
            msg += " to " + target;
        var formatted = _formatter.formatWhiteOnRedTight(msg);
        System.out.println(formatted);
    }

    public void printEnemyResult(String enemyTitle, String damage){
        var msg =  String.format("%s hit you and dealt %s damage to you", enemyTitle,damage);
        var formatted = _formatter.formatWhiteOnRedTight(msg);
        System.out.println(formatted);
    }

    public void printDemonNotFound(){
        var msg = "Demon not found";
        var formatted = _formatter.formatNegativeResponse(msg);
        System.out.println(formatted);
    }

    public void printInvalidTarget(){
        var msg = "You can't attack this!";
        var formatted = _formatter.formatNegativeResponse(msg);
        System.out.println(formatted);
    }

    public void printDieMessage(){
        var msg = "You have been dealt a fatal blow! RIP!";
        var formatted = _formatter.formatNegativeResponse(msg);
        System.out.println(formatted);
    }
}
