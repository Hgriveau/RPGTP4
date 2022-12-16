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
                "<html>" + "Welcome!" + "<br/>" + " " + "<br/>" +
                        "You first get to choose the number of heroes you play with," + "<br/>" + " you will then be sent on a battle field to fight monsters." +
                        "<br/>" +
                        "After 5 ROUNDS, you will have to fight a boss." +
                         "<br/>" + " " + "<br/>" +" Good luck!" +"<br/>" +" "+ "<br/>" + "DISCLAIMER : If the buttons are pressed TOO FAST, the game stops working."  +
                        "<br/>" + "Graphics are mine but I DO NOT OWN any of the characters drawn." + "</html>");

        Object[] possibilities = {"1", "2", "3","4","5"};
        String s = (String)JOptionPane.showInputDialog(
                game,
                "How many heroes do you want to play with?",
                "Customized Dialog",
                JOptionPane.PLAIN_MESSAGE,null,
                possibilities,
                "4");
        System.out.println("nombre de joueurs " + s);
        game.startGame(Integer.parseInt(s));




    }
}