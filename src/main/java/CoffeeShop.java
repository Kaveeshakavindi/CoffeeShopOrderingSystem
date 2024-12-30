import java.util.LinkedList;
import java.util.Queue;

public class CoffeeShop {
    private final Queue<String> orderQueue;
    private int capacity = 0;

    public CoffeeShop(int capacity) {
        this.capacity = capacity;
        this.orderQueue = new LinkedList<>();
    }

    public synchronized void placeOrder(String order) throws  InterruptedException{
        //check if queue is full
        //if full wait
        while(orderQueue.size() == capacity){
            wait();
        }
        orderQueue.add(order);
        System.out.println("order placed: " + order);
        notifyAll();
    }

    public void prepareOrder() throws InterruptedException{
        //if 0 wait
        while(orderQueue.isEmpty()){
            //not in correct state to do operation
            wait();
        }
        //now in correct state to do operation
        //update resource variables | update state indicator
        String order = orderQueue.poll();
        System.out.println("order prepared: " + order);
        //notify
        notifyAll();
    }
}
