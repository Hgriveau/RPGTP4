public class Weapon extends Item {
    protected int quantity;

    public Weapon(String name, int quantity) {
        super(name);
        this.quantity = quantity;
    }

    public boolean use(){
        int quantitymin = 0;
        if(quantity > quantitymin){
            quantity--;
            return true;
        }
        else {
            System.out.println("No more " + name + " left");
            return false;
        }
    }

    public void add(){
        quantity++;
    }
    public void startOver(){
        quantity = 5;
    }
}

