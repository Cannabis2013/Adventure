package Adventure.CommandInterpreter.Attack;

import GameEngine.GameEngine;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.FatalBlowException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.InvalidObjectException;
import GameEngine.Player.Exceptions.DodgedAttackException;
import GameEngine.Player.Exceptions.MissedTargetException;
import GameEngine.Player.Exceptions.WeaponNotEquippedException;

public class HandleAttack {
    PrintAttackMessages _printer = new PrintAttackMessages();

    private void attackNobody(GameEngine engine){
        try {
            engine.attack();
            var sound = engine.attackSound();
            _printer.printAttackNoBody(sound);
        } catch (WeaponNotEquippedException e) {
            _printer.printWeapNotEqupped();
        }
    }

    private void performEnemyAttack(String enemyTitle ,GameEngine engine) throws PlayerIsDeadException {
        try {
            var dmg = engine.performEnemyAttack(enemyTitle);
            _printer.printEnemyResult(enemyTitle,dmg);
        } catch (InvalidObjectException e) {
            e.printStackTrace();
        } catch (FatalBlowException e) {
            _printer.printDieMessage();
            throw new PlayerIsDeadException();
        } catch (WeaponNotEquippedException e) {
            // Ignored since enemies can't drop any items or weapons unless dealt a fatal blow
        } catch (DodgedAttackException e) {
            _printer.printPlayerDodgedAttack();
        } catch (MissedTargetException e) {
            _printer.printEnemyMissedTarget(enemyTitle);
        }
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
        } catch (WeaponNotEquippedException e) {
            _printer.printWeapNotEqupped();
            return;
        } catch (DodgedAttackException e) {
            _printer.printEnemyDodgedAttack(target);
        } catch (MissedTargetException e) {
            _printer.printPlayerMissedTarget();
        }
        performEnemyAttack(target,engine);
    }

    public void handleAttack(String command, GameEngine engine) throws PlayerIsDeadException {
        if(command.matches("attack"))
            attackNobody(engine);
        else
            attackEnemy(command,engine);
    }
}
