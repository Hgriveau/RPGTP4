import javax.swing.*;

public abstract class Hero extends Combatant{
    public Food food;
    public int healingMultiplicator = 1;

    public Hero(int health, int attack, int defense, String name) {
        super(health, attack, defense, name);
        this.food = new Food();

    }

    public void gainHealth(int healing){
        int youpi = healing + health;
        if(youpi > maxHealth) {
            youpi = maxHealth;
        }
        this.health = youpi;
    }

    public void defenseUp(){
        isDefenseUp = true;
    }

    public void defenseDown(){
        isDefenseUp = false;
    }

    public void normalAttack(Combatant target){
        target.takeDamage(attack);
    }
    public abstract void specialAttack(Combatant combatant);


    public boolean eatFood(){
        if (food.use()) {
            gainHealth(15 * healingMultiplicator);
            return true;
        }
        else {
            return false;
        }

    }

    public void healMultip(){
        healingMultiplicator = healingMultiplicator + 1 ;
    }


    public void reset() {
        this.health = maxHealth;
        this.isDefenseUp = false;
    }
}
