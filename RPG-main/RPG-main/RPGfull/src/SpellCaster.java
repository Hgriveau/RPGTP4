import javax.swing.*;

public abstract class SpellCaster extends Hero {
    public Potion potion;
    protected int mana;
    public final int manaMax = 100;


    public SpellCaster(int health, int attack, int defense, String name) {
        super(health, attack, defense, name);
        this.mana = 100;
        this.potion = new Potion();
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public boolean looseMana(int manaCost){
        if(manaCost > mana){
            return false;
        }
        else {
            mana -= manaCost;
            return true;
        }
    }
    public abstract void specialAttack(Combatant combatant);

    public void gainMana(int healingMana){
        int yipee = healingMana + mana;
        if(yipee > manaMax) {
            yipee = manaMax;
        }
        this.mana = yipee;
    }

    public boolean drinkPotion(){
        if (potion.use()) {
            gainMana(12 * healingMultiplicator);
            return true;
        }
        else {
            return false;
        }

    }

    @Override
    public String decrireleheroactuel(){
        return "HP: " + health + " | ATK: " + attack + " | DEF: " + defense + " | Name: " + name + " | Mana: " + mana;
    }
@Override
    public void reset() {
        super.reset();
        this.mana = manaMax;

    }
}
