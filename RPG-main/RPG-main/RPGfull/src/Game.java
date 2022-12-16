import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game  extends JFrame implements Runnable {
    public List<Hero> heroes;
    public List<Enemy> enemies;

    int FPS = 60;

    Hero currentHero;
    Enemy currentEnemy;
    Combatant target;
    attackMode currentAttackMode = attackMode.None;
    public boolean endTurn = false;
    public boolean isEnnemyTurn = false;
    JLabel l1,l2,l3,l4,l5,background;
    int playerNumber = 0;

    int turn = 1;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    public Game() {
        heroes = new ArrayList<Hero>();
        enemies = new ArrayList<Enemy>();
        this.setPreferredSize(new Dimension(800,600));
        this.setBackground(Color.GRAY);
        this.addKeyListener(keyH);
        this.setFocusable(true);

        l1=new JLabel();
        l1.setBounds(0,370, 500,200);
        ImageIcon icon = new ImageIcon("Cmd.png");
        l1.setIcon(icon);
        //Info Panel

        l2=new JLabel();
        l2.setBounds(500,350, 300,250);

        //Dialog Panel
        l3=new JLabel();
        l3.setBounds(0,325, 800,60);

        //turn label
        l4=new JLabel();
        l4.setBounds(0,0, 100,32);


        background =new JLabel("First character");
        background.setBounds(0,0, 800,600);
        ImageIcon bckg = new ImageIcon("back.png");
        background.setIcon(bckg);





    }


    public void startGame(int n) {
        playerNumber = n;
        for (int i = 0; i < n; i++) {
            int rnd = new Random().nextInt(4);
            switch (rnd) {
                case 0:
                    heroes.add(new Warrior(i));
                    break;
                case 1:
                    heroes.add(new Mage(i));
                    break;
                case 2:
                    heroes.add(new Hunter(i));
                    break;
                case 3:
                    heroes.add(new Healer(i));
                    break;
            }
        }

        for (int i = 0; i < n ; i++) {
            enemies.add(new Squishy(i));
        }
        currentHero = heroes.get(0);
        currentEnemy = enemies.get(0);
        target = null;
        gameThread = new Thread(this);
        gameThread.start();


        this.add(l1); this.add(l2);this.add(l3);this.add(l4);

        for (Hero hero : heroes) {
            this.add(hero.getSprite());
        }

        for(Enemy e : enemies){
            this.add(e.getSprite());
        }

        this.setSize(800,600);

        //this.remove(sprite1);
        this.setLayout(null);
        this.setVisible(true);


    }

    public void updateStats(){
        String stats = "<html>";
        for (Hero hero : heroes) {
            if (hero == currentHero) {
                stats += ">>";
            }
            stats += hero.decrireleheroactuel() + "<br/>";
        }
        stats += "<font color='Red'>";
        for (Enemy enemy : enemies) {
            stats += enemy.decrireleheroactuel() + "<br/>";
        }
        stats += "</font>" +
                "</html>";
        l2.setText(stats);
    }

    public void update(){
        l4.setText("ROUND : " + turn);
        if (!isEnnemyTurn) {
            if (keyH.Attack) {
                currentAttackMode = attackMode.Simple;
                l3.setText("you are doing an attack, select enemy 1-5?");
            } else if (keyH.SpecialAttack) {
                currentAttackMode = attackMode.Special;
                l3.setText("you are doing a special attack, select target 1-5?");
            } else if (keyH.Couscous) {
                currentHero.eatFood();
                l3.setText("you are eating couscous");

                endTurn = true;
            } else if (keyH.CillitBang) {
                if (currentHero instanceof SpellCaster) {
                    ((SpellCaster) currentHero).drinkPotion();
                    l3.setText("you are drinking cillit bang");
                    endTurn = true;
                }
                else {
                    l3.setText("you are not a spellcaster!");
                }

            } else if (keyH.Parry) {
                currentHero.defenseUp();
                l3.setText("you are parrying");
                endTurn = true;
            } else if (keyH.Select1) {
                if (currentHero instanceof Healer && attackMode.Special == currentAttackMode) {
                    target = heroes.size() > 0 ?  heroes.get(0) : null;
                    if (target != null ) l3.setText("you are healing " + target.getName());
                } else {
                    target = enemies.size() > 0 ?  enemies.get(0) : null;
                    if (target != null ) l3.setText("you are kicking " + target.getName() + "'s butt");
                }
            } else if (keyH.Select2) {
                if (currentHero instanceof Healer && attackMode.Special == currentAttackMode) {
                    target = heroes.size() > 1 ?  heroes.get(1) : null;
                    if (target != null ) l3.setText("you are healing " + target.getName());
                } else {
                    target = enemies.size() > 1 ?   enemies.get(1) : null;
                    if (target != null ) l3.setText("you are kicking " + target.getName() + "'s butt");
                }
            } else if (keyH.Select3) {
                if (currentHero instanceof Healer && attackMode.Special == currentAttackMode) {
                    target = heroes.size() > 2 ?   heroes.get(2) : null;
                    if (target != null ) l3.setText("you are healing " + target.getName());
                } else {
                    target = enemies.size() > 2 ?   enemies.get(2) : null;
                    if (target != null ) l3.setText("you are kicking " + target.getName() + "'s butt");
                }
            } else if (keyH.Select4) {
                if (currentHero instanceof Healer && attackMode.Special == currentAttackMode) {
                    target = heroes.size() > 3 ?   heroes.get(3) : null;
                    if (target != null ) l3.setText("you are healing " + target.getName());
                } else {
                    target = enemies.size() > 3 ?   enemies.get(3) : null;
                    if (target != null ) l3.setText("you are kicking " + target.getName() + "'s butt");
                }
            } else if (keyH.Select5) {
                if (currentHero instanceof Healer && attackMode.Special == currentAttackMode) {
                    target = heroes.size() > 4 ?   heroes.get(4) : null;
                    if (target != null ) l3.setText("you are healing " + target.getName());
                } else {
                    target = enemies.size() > 4 ?  enemies.get(4) : null;
                    if (target != null )
                        l3.setText("you are kicking " + target.getName() + "'s butt");
                }
            }

            if (target != null && currentAttackMode != attackMode.None) {
                if (currentAttackMode == attackMode.Simple) {
                    currentHero.normalAttack(target);
                } else if (currentAttackMode == attackMode.Special) {
                    System.out.printf("current hero: %s and target :%s%n", currentHero, target);
                    currentHero.specialAttack(target);
                }
                currentAttackMode = attackMode.None;
                System.out.println("Done with the target");
                target = null;
                endTurn = true;
            }
        }
        else {
            Random rand = new Random(); //instance of random class
            int upperbound = playerNumber;
            int int_random = rand.nextInt(upperbound);
            Hero randomHeroTarget = heroes.get(int_random);

            if(currentEnemy instanceof Squishy) {
                currentEnemy.normalAttack(randomHeroTarget);
            }
            else{
                int randomAtck = rand.nextInt(2);
                if(randomAtck == 0){
                    currentEnemy.normalAttack(randomHeroTarget);
                }
                else{
                    ((Boss)currentEnemy).specialAttack(randomHeroTarget);
                }

            }
            endTurn = true;
            l3.setText("enemy has attacked");
        }
        updateStats();
        this.add(background);
        keyH.resetKeys();
    }

    public void run(){

        double drawInterval = 1000000000 / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread != null) {

            //update
            update();

            if (endTurn){
                endTurn = false;
                if (!isEnnemyTurn) {
                    int index = heroes.indexOf(currentHero);
                    if (index == heroes.size() - 1){
                        currentHero = heroes.get(0);
                        isEnnemyTurn = true;
                    }
                    else {
                        currentHero = heroes.get(index + 1);
                    }

                }
                else {
                    int index = enemies.indexOf(currentEnemy);
                    if (index == enemies.size() - 1){
                        currentEnemy = enemies.get(0);
                        isEnnemyTurn = false;
                        for (Hero hero : heroes){
                            hero.defenseDown();
                        }

                    }
                    else {
                        currentEnemy = enemies.get(index + 1);
                    }

                }
            }




            //describe states of heroes and enemies
            for (Hero hero : heroes) {
                if (hero.health <= 0) {
                    this.remove(hero.sprite);
                }
            }
            heroes.removeIf(hero -> hero.health <= 0);

            for (Enemy enemy : enemies) {
                if (enemy.health <= 0) {
                    this.remove(enemy.sprite);
                }
            }
            enemies.removeIf(enemy -> enemy.health <= 0);

            if (heroes.size() == 0){
                l3.setText("you lost the game");
                    JOptionPane.showMessageDialog(this, "YOU LOST, TRY AGAIN");
                System.out.println("You lose");
                gameThread = null;
            }
            else if (enemies.size() == 0){
                l3.setText("you won");
                System.out.println("You win");
                nextTurn();
            }
            //draw
            repaint();


            double remainingTime = nextDrawTime - System.nanoTime();
            remainingTime = remainingTime / 1000000;
            try {

                if (remainingTime < 0){
                    remainingTime = 0;
                }


                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;



            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    private void nextTurn() {
        turn++;
        if (turn > 5){
                l3.setText("you won the game, congratulations");
            JOptionPane.showMessageDialog(this, "YOU WON THE GAME, CONGRATULATIONS");
                gameThread = null;
                return;
        }

        Object[] possibilities = {"DAMAGE UP", "DEF UP", "HEALING UP","MORE COUSCOUS!","ARROWS NB UP"};
        String c = (String)JOptionPane.showInputDialog(
                this,
                "Choose your buff, you deserve it!",
                "Customized Dialog",
                JOptionPane.PLAIN_MESSAGE,null,
                possibilities,
                "DAMAGE UP");
        switch (c){
            case "DAMAGE UP":
                for (Hero hero : heroes){
                    hero.attack += 5 ;
                }
                break;
            case "DEF UP":
                for (Hero hero : heroes){
                    hero.defense += 5 ;
                }
                break;
            case "HEALING UP":
                for (Hero hero : heroes){
                    hero.healingMultiplicator += 1;
                }
                break;
            case "MORE COUSCOUS!":
                for (Hero hero : heroes){
                    hero.food.quantity += 3;
                }
                break;
            case "ARROWS NB UP":
                for (Hero hero : heroes){
                    if (hero instanceof Hunter){
                        ((Hunter)hero).weapon.quantity += 3;
                    }
                }
                break;

        }

        if (turn <5){
            for (Hero hero : heroes){
                hero.reset();
            }
            for (int i = 0; i < playerNumber ; i++) {
                enemies.add(new Squishy(i));
                this.add(enemies.get(i).sprite);
            }

            currentHero = heroes.get(0);
            currentEnemy = enemies.get(0);
            isEnnemyTurn = false;
            endTurn = false;
            updateStats();
        }
        else if (turn == 5){
            JOptionPane.showMessageDialog(this, "BOSS FIGHT, GOOD LUCK");
            for (Hero hero : heroes){
                hero.reset();
            }
            enemies.add(new Boss());
            this.add(enemies.get(0).sprite);

            currentHero = heroes.get(0);
            currentEnemy = enemies.get(0);
            isEnnemyTurn = false;
            endTurn = false;
            updateStats();
        }

    }


}
