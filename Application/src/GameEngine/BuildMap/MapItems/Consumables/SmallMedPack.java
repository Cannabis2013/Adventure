package GameEngine.BuildMap.MapItems.Consumables;

import GameEngine.Player.Player;

public class SmallMedPack implements IConsumable{
    @Override
    public void consume(Player player) {
        if(player.getHealth() != 100){
            var playerHealth = player.getHealth();
            playerHealth += 25;
            player.setHealth(playerHealth);
        }
    }
}
