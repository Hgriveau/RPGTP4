import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Game  game = new Game();
        JOptionPane.showMessageDialog(game,
                "welcome");

        Object[] possibilities = {"1", "2", "3","4","5"};
        String s = (String)JOptionPane.showInputDialog(
                game,
                "How many heroes do you want to play with?",
                "Customized Dialog",
                JOptionPane.PLAIN_MESSAGE,null,
                possibilities,
                "4");
        System.out.println("nombre de joueurs" + s);
        game.startGame(Integer.parseInt(s));




    }
}