import javax.swing.*;

public class Hunter extends Hero{
    public Weapon weapon;

    public Hunter(int position) {
        super(100, 20, 5, "Hunter");
        this.weapon = new Weapon("Arrows", 5);
        JLabel sprite = new JLabel();
        sprite =new JLabel("Second character");
        sprite.setBounds(100 - (position *25),115, 64,64);
        ImageIcon spr2 = new ImageIcon("HANZO.png");
        sprite.setIcon(spr2);
        this.setSprite(sprite);
    }
    @Override
    public void specialAttack(Combatant target){
        if (weapon.use()) {
            target.takeDamage(attack * 2);
        }

    }
    @Override
    public void reset() {
        super.reset();
        this.weapon = new Weapon("Arrows", 5);
    }

}

