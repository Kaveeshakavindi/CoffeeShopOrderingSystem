public class Customer extends Thread{
    private CoffeeShop coffeeShop;

    public Customer(CoffeeShop coffeeShop) {
        this.coffeeShop = coffeeShop;
    }

    @Override
    public void run() {
        int counter = 0;
        while(true){
            try{
                coffeeShop.placeOrder("order "+ counter);
                counter ++;
            }
            catch(InterruptedException e){
                e.printStackTrace();
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
