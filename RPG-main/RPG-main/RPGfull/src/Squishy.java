import javax.swing.*;

public class Squishy extends Enemy{

    public Squishy(int position) {
        super(100, 20 , 4 , "Diglet");
        JLabel sprite = new JLabel();
        sprite =new JLabel("First character");
        sprite.setBounds(550,50 + (position * 65), 64,64);
        ImageIcon en1 = new ImageIcon("DIGLET.png");
        sprite.setIcon(en1);
        this.setSprite(sprite);
    }
}
