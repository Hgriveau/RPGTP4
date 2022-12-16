import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean Attack, SpecialAttack, Couscous, CillitBang, Parry;
    public boolean Select1, Select2, Select3, Select4, Select5;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {




    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_A){
            Attack = true;
            

        }
        if(code == KeyEvent.VK_Q){
            Couscous = true;

        }
        if(code == KeyEvent.VK_S){
            SpecialAttack = true;

        }
        if(code == KeyEvent.VK_D){
            CillitBang = true;

        }
        if(code == KeyEvent.VK_P){
            Parry = true;

        }
        if(code == KeyEvent.VK_1){
            Select1 = true;

        }
        if(code == KeyEvent.VK_2){
            Select2 = true;

        }
        if(code == KeyEvent.VK_3){
            Select3 = true;

        }
        if(code == KeyEvent.VK_4){
            Select4 = true;

        }
        if(code == KeyEvent.VK_5){
            Select5 = true;

        }



    }

    public void resetKeys() {
        this.Attack = false;
        this.SpecialAttack = false;
        this.Couscous = false;
        this.CillitBang = false;
        this.Parry = false;
        this.Select1 = false;
        this.Select2 = false;
        this.Select3 = false;
        this.Select4 = false;
        this.Select5 = false;
    }
}