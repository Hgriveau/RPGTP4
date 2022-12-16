import javax.swing.*;

public abstract class Combatant {

    protected String name;
    public boolean isDefenseUp = false;
    protected int health;
    final int maxHealth = 100;
    protected int attack;
    protected int defense;

    public JLabel sprite;

    public JLabel getSprite() {
        return sprite;
    }

    public void setSprite(JLabel sprite) {
        this.sprite = sprite;
    }

    public Combatant(int health, int attack, int defense, String name) {
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public void takeDamage(int damage) {
        int newDefense = defense;
        if (isDefenseUp){
            newDefense += 10;
        }
        int bobo = damage - newDefense;
        if (bobo < 0) {
            bobo = 0;
        }
        var newHealth = health - bobo;
        if (newHealth < 0) {
            newHealth = 0;
        }
        health = newHealth;
    }

    public String decrireleheroactuel(){
        return "HP: " + health + " | ATK: " + attack + " | DEF: " + defense + " | Name: " + name;
    }


}
