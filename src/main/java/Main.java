public class Main {
    public static void main(String[] args) {
        //create a CoffeeShop with a queue capacity of 5
        // ``(shared Resource: Limited Order Queue
        CoffeeShop coffeeShop = new CoffeeShop(5);

        //create Customer threads (multiple Customers can place orders simultaneously)
        Thread customer1 = new Thread(new Customer(coffeeShop, "1"));
        Thread customer2 = new Thread(new Customer(coffeeShop, "2"));
        Thread customer3 = new Thread(new Customer(coffeeShop, "3"));
        Thread customer4 = new Thread(new Customer(coffeeShop, "4"));
        Thread customer5 = new Thread(new Customer(coffeeShop, "5"));
        Thread customer6 = new Thread(new Customer(coffeeShop, "6"));
        Thread customer7 = new Thread(new Customer(coffeeShop, "7"));

        //create Barista threads (multiple Baristas can prepare orders simultaneously)
        Thread barista1 = new Thread(new Barista(coffeeShop));
        Thread barista2 = new Thread(new Barista(coffeeShop));

        //start threads
        customer1.start();
        customer2.start();
        customer3.start();
        customer4.start();
        customer5.start();
        customer6.start();
        customer7.start();
        barista1.start();
        barista2.start();
    }
}