import data.Order;
import data.Picker;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class StoreTest {

    @Test
    public void testGetTask_SingleOrder_SinglePicker() {
        Queue<Picker> pickers = new PriorityQueue<>();
        Picker picker = new Picker("P1", "08:00", "10:00");
        pickers.add(picker);

        List<Order> orders = new ArrayList<>();
        Order order = new Order("order-1", "0", "PT30M", "09:30");
        orders.add(order);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Store.getTask(pickers, orders);

        String expectedOutput = "P1 order-1 08:00\r\n";
        Assert.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testGetTask_TwoOrders_SinglePicker() {
        Queue<Picker> pickers = new PriorityQueue<>();
        Picker picker = new Picker("P1", "08:00", "16:00");
        pickers.add(picker);

        List<Order> orders = new ArrayList<>();
        Order order1 = new Order("order-1", "10", "PT20M", "10:30");
        Order order2 = new Order("order-2", "10", "PT40M", "10:00");
        orders.add(order1);
        orders.add(order2);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Store.getTask(pickers, orders);

        String expectedOutput = "P1 order-1 08:00\r\nP1 order-2 08:20\r\n";
        Assert.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testGetTask_SingleOrder_TwoPickers() {
        Queue<Picker> pickers = new PriorityQueue<>();
        Picker picker1 = new Picker("P1", "08:00", "16:00");
        Picker picker2 = new Picker("P2", "09:00", "14:00");
        pickers.add(picker1);
        pickers.add(picker2);

        List<Order> orders = new ArrayList<>();
        Order order = new Order("order-1", "10", "PT60M", "10:30");
        orders.add(order);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Store.getTask(pickers, orders);

        String expectedOutput = "P1 order-1 08:00\r\n";
        Assert.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testStore() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        try {
            Store.store("..\\ocado_task2\\testData\\store.json", "..\\ocado_task2\\testData\\orders.json");
        } catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
        }
        String expectedOutput = "P1 order-4 09:00\r\n" +
                "P2 order-1 09:00\r\n" +
                "P2 order-3 09:15\r\n";
        Assert.assertEquals(expectedOutput, outContent.toString());
    }
}

