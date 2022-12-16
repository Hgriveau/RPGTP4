import javax.swing.*;

public class Warrior extends Hero{

    public Warrior(int position) {
        super(100, 15, 7, "Warrior");
        //sprites
        JLabel sprite = new JLabel();
        sprite =new JLabel("First character");
        sprite.setBounds(175 - (position * 25),50, 64,64);
        ImageIcon spr1 = new ImageIcon("YASUO.png");
        sprite.setIcon(spr1);
        this.setSprite(sprite);

    }
    @Override
    public void specialAttack(Combatant target){
        target.takeDamage(attack * 2);
    }

}
