package Adventure.CommandInterpreter.Attack;

import GameEngine.GameEngine;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.LivingObjects.FatalBlowException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.InvalidObjectException;
import GameEngine.MapGeneration.SmallSquare.Models.DemonNotFoundException;

public class HandleAttack {
    PrintAttackMessages _printer = new PrintAttackMessages();

    private void attackNobody(GameEngine engine){
        try {
            var damageDone = engine.attack();
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
        } catch (DemonNotFoundException e) {
            e.printStackTrace();
        }
    }



    public void handleAttack(String command, GameEngine engine){
        if(command.matches("attack"))
            attackNobody(engine);
        else
            attackEnemy(command,engine);
    }
}
