import javax.swing.*;

public class Boss extends Enemy{

    public Boss() {
        super(500, 15 , 4 , "The Collector");
        //sprites
        JLabel sprite = new JLabel();
        sprite = new JLabel("Boss");
        sprite.setBounds(500,100, 200,200);
        ImageIcon bos1 = new ImageIcon("Boss.png");
        sprite.setIcon(bos1);
        this.setSprite(sprite);

    }

    public void specialAttack(Combatant target){
        target.takeDamage(attack * 2);
    }
}

