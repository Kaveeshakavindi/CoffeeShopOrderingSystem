import java.util.LinkedList;
import java.util.Queue;

class CoffeeShop {
    //shared order queue
    private final Queue<String> orderQueue = new LinkedList<>();
    //maximum queue capacity
    private final int capacity;

    public CoffeeShop(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void placeOrder(String order) throws InterruptedException {
        //monitor: Ensure mutual exclusion while adding orders
        while (orderQueue.size() == capacity) {
            System.out.println("Queue is full.");
            wait();//wait until space becomes available
        }
        orderQueue.add(order);// Add the order to the queue
        System.out.println("Order placed: " + order);
        notifyAll();//notify waiting threads (e.g., Baristas)
    }

    public synchronized String prepareOrder() throws InterruptedException {
        //monitor: Ensure mutual exclusion while removing orders
        while (orderQueue.isEmpty()) {
            System.out.println("Queue is empty.");
            wait();//wait if the queue is empty
        }
        String order = orderQueue.poll();//retrieve and remove the next order
        System.out.println("Order prepared: " + order);
        notifyAll();//notify waiting threads (e.g., Customers)
        return order;
    }
}