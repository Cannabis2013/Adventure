package GameEngine;

import GameEngine.MapGeneration.SmallSquare.Map.Rooms.DoorIsLockedException;
import GameEngine.MapGeneration.MapGenerator;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.FatalBlowException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.InvalidObjectException;
import GameEngine.MapGeneration.SmallSquare.Map.Map;
import GameEngine.Player.Exceptions.*;
import GameEngine.Player.Player;
import GameEngine.Utils.ItemNotFoundException;

import java.util.List;

public class GameEngine {
    private MapGenerator _mapGenerator = new MapGenerator();
    private Player _player = new Player();
    private Map _map;

    public void init(){
        _map = _mapGenerator.build();
        _player.setCurrentRoom(_map.initialRoom());
    }

    public void travel(String orientation) throws IllegalArgumentException, IllegalStateException, DoorIsLockedException, BadDirectionException, NoDoorAtOrientationException {
        _player.travelTo(orientation);
    }

    public String roomDescription() {
        return _player.currentRoom().description();
    }

    public String doorNames(){
        return _player.currentRoom().doorTitles();
    }

    public String takeItem(String itemTitle) throws ItemNotFoundException {
        return _player.takeItem(itemTitle);
    }

    public void takeAll(){
        _player.takeAll();
    }

    public String dropItem(String itemTitle) throws ItemNotFoundException {
        return _player.dropItem(itemTitle);
    }

    public String eatItem(String itemTitle) throws ItemNotFoundException, ItemNotConsumableException, PlayerHealthFullException {
        return _player.consumeItem(itemTitle);
    }

    public List<String> roomItems(){
        return _player.currentRoom().itemsAsString();
    }

    public List<String> inventory(){
        return _player.inventoryToString();
    }

    public int health() {
        return _player.health();
    }

    public String useItem(String item, String target) throws UsableNotFoundException, TargetNotFoundException, InvalidObjectException {
        return _player.useItem(item,target);
    }

    public String useItem(String item) throws ItemNotUsableException, InvalidObjectException, UsableNotFoundException {
        return _player.useItem(item);
    }

    public String equipWeapon(String weapon) throws EquipWeaponFailedException, ItemNotFoundException {
        return _player.equip(weapon);
    }

    public String attack() throws WeaponNotEquippedException {
        return _player.attack();
    }

    public String attack(String target) throws InvalidObjectException, FatalBlowException, WeaponNotEquippedException, DodgedAttackException, MissedTargetException {
        var demon = _player.currentRoom().demon(target);
        return _player.attack(demon);
    }

    public String equippedWeapon(){
        return _player.weaponAsString();
    }

    public List<String> roomEnemies() {
        return _player.currentRoom().demonsAsStrings();
    }

    public String attackSound(){
        return _player.equipped().sound();
    }

    public String performEnemyAttack(String enemyTitle) throws InvalidObjectException, FatalBlowException, WeaponNotEquippedException, DodgedAttackException, MissedTargetException {
        var demon = _player.currentRoom().demon(enemyTitle);
        return demon.attack(_player);
    }
}
