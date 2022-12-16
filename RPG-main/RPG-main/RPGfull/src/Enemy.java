import javax.swing.*;

public abstract class Enemy extends Combatant {

    public Enemy(int health, int attack, int defense, String name) {
        super(health, attack, defense, name);
    }

    public void normalAttack(Combatant target) {
        target.takeDamage(attack);
    }

}
