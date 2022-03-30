package Adventure.CommandInterpreter.Attack;

import Adventure.ScreenMessages.PrintFormatter;

public class PrintAttackMessages {
    private PrintFormatter _formatter = new PrintFormatter();

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

    public void printWeapNotEqupped(){
        var msg = "You have no weapon equipped";
        var formatted = _formatter.formatNegativeResponse(msg);
        System.out.println(formatted);
    }

    public void printPlayerDodgedAttack(){
        var msg = "You dodged";
        var formatted = _formatter.formatWhiteOnRedTight(msg);
        System.out.println(formatted);
    }

    public void printEnemyDodgedAttack(String enemyTitle){
        var msg = String.format("%s dodged your attack",enemyTitle);
        var formatted = _formatter.formatWhiteOnRedTight(msg);
        System.out.println(formatted);
    }

    public void printPlayerMissedTarget(){
        var msg = "You missed";
        var formatted = _formatter.formatWhiteOnRedTight(msg);
        System.out.println(formatted);
    }

    public void printEnemyMissedTarget(String enemyTitle){
        var msg = String.format("%s missed",enemyTitle);
        var formatted = _formatter.formatWhiteOnRedTight(msg);
        System.out.println(formatted);
    }
}
