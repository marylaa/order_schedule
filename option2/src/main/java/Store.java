import comparator.OrderComparator;
import data.Order;
import data.Picker;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Store {

    /**
     * This method reads the store and order JSON files, creates
     * a Queue of data.Picker objects and a sorted List of data.Order objects.
     * Then it allocates tasks to data.Picker objects.
     *
     * @param storePath the specified path of a JSON file with store data
     * @param orderPath the specified path of a JSON file with orders
     * @throws IOException
     * @throws ParseException
     */
    public static void store(String storePath, String orderPath) throws IOException, ParseException {
        Queue<Picker> pickers = ReadFile.readStore(storePath);
        List<Order> orders = ReadFile.readOrders(orderPath);

        OrderComparator orderComparator = new OrderComparator();
        Collections.sort(orders, orderComparator);

        getTask(pickers, orders);
    }

    /**
     * This method is responsible for assigning data.Order objects to data.Picker objects
     * and outputting the results to the console.
     *
     * @param pickers a Queue of data.Picker objects
     * @param orders  a List of data.Order objects
     */
    public static void getTask(Queue<Picker> pickers, List<Order> orders) {
        int size = orders.size();
        for (int i = 0; i < size; i++) {
            Order order = orders.get(0);
            LocalTime completeBy = order.getCompleteBy();
            Duration pickingTime = order.getPickingTime();

            Picker picker = pickers.poll();
            LocalTime actualTime = picker.getActualTime();
            LocalTime stopTime = picker.getStopTime();

            LocalTime plus = actualTime.plus(pickingTime);
            if ((plus.isBefore(completeBy) || plus.equals(completeBy)) && (plus.isBefore(stopTime) || plus.equals(stopTime))) {
                picker.setActualTime(plus);
                System.out.println(picker.getId() + " " + order.getOrderId() + " " + actualTime);
            }
            pickers.offer(picker);
            orders.remove(0);
        }
    }
}
