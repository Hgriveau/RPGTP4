import javax.swing.*;

public class Mage extends SpellCaster{

    public Mage(int position) {
        super(100, 25, 3, "Mage");
        JLabel sprite = new JLabel();
        sprite =new JLabel("First character");
        sprite.setBounds(175 - (position *25),200, 64,64);
        ImageIcon spr3 = new ImageIcon("ZELDA.png");
        sprite.setIcon(spr3);
        this.setSprite(sprite);
    }

    @Override
    public void specialAttack(Combatant target){
        if (looseMana(20)) {
            target.takeDamage(attack * 2);
        }
    }


}
