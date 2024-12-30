public class Main {
    public static void main(String[] args) {
        CoffeeShop coffeeShop = new CoffeeShop(5);

        Barista barista1 = new Barista(coffeeShop);
        Barista barista2 = new Barista(coffeeShop);
        Customer customer1 = new Customer(coffeeShop);
        Customer customer2 = new Customer(coffeeShop);
        Customer customer3 = new Customer(coffeeShop);

        barista1.start();
        barista2.start();
        customer1.start();
        customer2.start();
        customer3.start();
    }
}
