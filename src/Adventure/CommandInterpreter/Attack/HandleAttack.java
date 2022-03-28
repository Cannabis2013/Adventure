package Adventure.CommandInterpreter.Attack;

import GameEngine.GameEngine;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.LivingObjects.FatalBlowException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.InvalidObjectException;

public class HandleAttack {
    PrintAttackMessages _printer = new PrintAttackMessages();
    public void handleAttack(String command, GameEngine engine){
        try {
            var result = engine.attack();
            _printer.printResult(result);
        } catch (FatalBlowException e) {
            _printer.printFatalMessage();
        } catch (InvalidObjectException e) {
            // Print message
        }
    }
}
