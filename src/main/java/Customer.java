//class implements the Runnable interface
class Customer implements Runnable {
    private final CoffeeShop coffeeShop;//shared CoffeeShop resource
    private final String order; //order to be placed

    public Customer(CoffeeShop coffeeShop, String order) {
        this.coffeeShop = coffeeShop;
        this.order = order;
    }

    @Override
    public void run() {
        try {
            //customer places an order in the queue
            coffeeShop.placeOrder(order);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Customer thread interrupted.");
        }
    }
}