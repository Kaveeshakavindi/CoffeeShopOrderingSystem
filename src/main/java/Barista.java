class Barista implements Runnable {
    private final CoffeeShop coffeeShop;

    public Barista(CoffeeShop coffeeShop) {
        this.coffeeShop = coffeeShop;
    }

    @Override
    public void run() {
        try {
            //continuously process orders
            while (true) {
                //barista prepares an order from the queue
                coffeeShop.prepareOrder();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Barista thread interrupted.");
        }
    }
}