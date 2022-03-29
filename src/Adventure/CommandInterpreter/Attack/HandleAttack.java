package Adventure.CommandInterpreter.Attack;

import GameEngine.GameEngine;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.FatalBlowException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.InvalidObjectException;

public class HandleAttack {
    PrintAttackMessages _printer = new PrintAttackMessages();

    private void attackNobody(GameEngine engine){
        var damageDone = engine.attack();
        var sound = engine.attackSound();
        _printer.printAttackNoBody(sound);
    }

    private void attackEnemy(String command, GameEngine engine) throws PlayerIsDeadException {
        var target = command.substring(7);
        try {
            var damageDone = engine.attack(target);
            var sound = engine.attackSound();
            _printer.printAttackDemon(sound,damageDone,target);
        } catch (FatalBlowException e) {
            _printer.printFatalMessage();
            return;
        } catch (InvalidObjectException e) {
            _printer.printInvalidTarget();
            return;
        }
        // Enemy performs his move
        try {
            var dmg = engine.performEnemyAttack(target);
            _printer.printEnemyResult(target,dmg);
        } catch (InvalidObjectException e) {
            e.printStackTrace();
        } catch (FatalBlowException e) {
            _printer.printDieMessage();
            throw new PlayerIsDeadException();
        }
    }

    public void handleAttack(String command, GameEngine engine) throws PlayerIsDeadException {
        if(command.matches("attack"))
            attackNobody(engine);
        else
            attackEnemy(command,engine);
    }
}
