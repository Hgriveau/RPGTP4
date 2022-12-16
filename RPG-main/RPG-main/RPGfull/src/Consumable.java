public abstract class Consumable extends Item{
    protected int quantity;

    public Consumable(String name, int quantity) {
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
            System.out.println("You have no more " + name + "s");
            return false;
        }
    }
    public void add(){
        quantity++;
    }

}
