package GameEngine.BuildMap.MapItems.Consumables;

import GameEngine.Player.Player;

public class LargeMedPack implements IConsumable{
    @Override
    public void consume(Player player) {
        var playerHealth = player.getHealth();
        playerHealth += 50;
        player.setHealth(playerHealth);
    }
}
