package Adventure.CommandInterpreter.Attack;

import GameEngine.GameEngine;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.FatalBlowException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.InvalidObjectException;

public class HandleAttack {
    PrintAttackMessages _printer = new PrintAttackMessages();

    private void attackNobody(GameEngine engine){
        try {
            var damageDone = engine.attack("");
            var sound = engine.attackSound();
            _printer.printResult(sound,damageDone,"");
        } catch (FatalBlowException e) {
            _printer.printFatalMessage();
        } catch (InvalidObjectException e) {
            _printer.printDemonNotFound();
        }
    }

    private void attackEnemy(String command, GameEngine engine){
        var target = command.substring(7);
        try {
            var damageDone = engine.attack(target);
            var sound = engine.attackSound();
            _printer.printResult(sound,damageDone,target);
        } catch (FatalBlowException e) {
            _printer.printFatalMessage();
        } catch (InvalidObjectException e) {
            // Print message
        }
    }



    public void handleAttack(String command, GameEngine engine){
        if(command.matches("attack"))
            attackNobody(engine);
        else
            attackEnemy(command,engine);
    }
}
