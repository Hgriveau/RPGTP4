import javax.swing.*;

public class Healer extends SpellCaster{

    public Healer(int position) {
        super(100, 15, 5, "Healer");
//sprites
        JLabel sprite = new JLabel();
        sprite =new JLabel("First character");
        sprite.setBounds(175 - (position *25),275, 64,64);
        ImageIcon spr4 = new ImageIcon("CARBUNKL.png");
        sprite.setIcon(spr4);
        this.setSprite(sprite);

    }

    @Override
    public void specialAttack(Combatant target){
        if (looseMana(20)) {
            ((Hero) target).gainHealth(attack * 2);
        }
    }

}
