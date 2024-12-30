public class Barista extends Thread{
    private CoffeeShop coffeeShop;

    public Barista(CoffeeShop coffeeShop) {
        this.coffeeShop = coffeeShop;
    }
    @Override
    public void run() {
        //purpose of while(true) : simulates real life coffee shop that prepares orders until interruption happens(exception)
        while(true){
            try{
                coffeeShop.prepareOrder();
            }
            catch (InterruptedException e){
                e.printStackTrace();
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
