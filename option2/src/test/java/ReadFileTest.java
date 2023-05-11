import data.Order;
import data.Picker;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalTime;
import java.util.List;
import java.util.Queue;

public class ReadFileTest {

    @Test
    public void testReadFileOrders_ifNotNull() {
        JSONArray jsonArray = null;
        try {
            jsonArray = ReadFile.readFileOrders("..\\ocado_task2\\testData\\orders.json");
        } catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
        }
        Assert.assertNotNull(jsonArray);
    }

    @Test
    public void testReadFileOrders_ifWrongPath() {
        JSONArray jsonArray = null;
        try {
            jsonArray = ReadFile.readFileOrders("..\\ocado_task2\\testData\\oders.json");
        } catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
        }
        String expected = null;
        Assert.assertEquals(expected, jsonArray);
    }

    @Test
    public void testReadFileOrders_ifContainsFiveElements() {
        int actualSize = 0;
        try {
            JSONArray jsonArray = ReadFile.readFileOrders("..\\ocado_task2\\testData\\orders.json");
            actualSize = jsonArray.size();
        } catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
        }
        int expectedSize = 5;
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void testReadFileStore_ifNotNull() {
        JSONObject jsonObject = null;
        try {
            jsonObject = ReadFile.readFileStore("..\\ocado_task2\\testData\\store.json");
        } catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
        }
        Assert.assertNotNull(jsonObject);
    }

    @Test
    public void testReadFileStore_ifWrongPath() {
        JSONObject jsonObject = null;
        try {
            jsonObject = ReadFile.readFileStore("..\\ocado_task2\\testData\\stre.json");
        } catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
        }
        String expected = null;
        Assert.assertEquals(expected, jsonObject);
    }

    @Test
    public void testReadFileStore_ifContainsTwoPickers() {
        Object actualPickers = null;
        try {
            JSONObject jsonObject = ReadFile.readFileStore("..\\ocado_task2\\testData\\store.json");
            actualPickers = jsonObject.get("pickers");
        } catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
        }
        JSONArray expectedPickers = new JSONArray();
        expectedPickers.add("P1");
        expectedPickers.add("P2");
        Assert.assertEquals(expectedPickers, actualPickers);
    }

    @Test
    public void testReadOrders_ifNotNull() {
        List<Order> orders = null;
        try {
            orders = ReadFile.readOrders("..\\ocado_task2\\testData\\orders.json");
        } catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
        }
        Assert.assertNotNull(orders);
    }

    @Test
    public void testReadOrders_ifCorrectOrdersNumber() {
        int actualSize = 0;
        try {
            List<Order> orders = ReadFile.readOrders("..\\ocado_task2\\testData\\orders.json");
            actualSize = orders.size();
        } catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
        }
        int expectedSize = 5;
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void testReadOrders_ifCorrectOrderId() {
        String actualOrderId = null;
        try {
            List<Order> orders = ReadFile.readOrders("..\\ocado_task2\\testData\\orders.json");
            actualOrderId = orders.get(0).getOrderId();
        } catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
        }
        String expectedOrderId = "order-1";
        Assert.assertEquals(expectedOrderId, actualOrderId);
    }

    @Test
    public void testReadOrders_ifWrongPath() {
        List<Order> orders = null;
        try {
            orders = ReadFile.readOrders("..\\ocado_task2\\testData\\orers.json");
        } catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
        }
        Assert.assertNull(orders);
    }

    @Test
    public void testReadStore_ifNotNull() {
        Queue<Picker> pickers = null;
        try {
            pickers = ReadFile.readStore("..\\ocado_task2\\testData\\store.json");
        } catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
        }
        Assert.assertNotNull(pickers);
    }

    @Test
    public void testReadStore_ifCorrectPickersNumber() {
        int actualSize = 0;
        try {
            Queue<Picker> pickers = ReadFile.readStore("..\\ocado_task2\\testData\\store.json");
            actualSize = pickers.size();
        } catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
        }
        int expectedSize = 2;
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void testReadStore_ifCorrectPickingStartTime() {
        LocalTime actualPickingStartTime = null;
        try {
            Queue<Picker> pickers = ReadFile.readStore("..\\ocado_task2\\testData\\store.json");
            actualPickingStartTime = pickers.peek().getStartTime();
        } catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
        }
        LocalTime expectedPickingStartTime = LocalTime.parse("09:00");
        Assert.assertEquals(expectedPickingStartTime, actualPickingStartTime);
    }

    @Test
    public void testReadStore_ifWrongPath() {
        Queue<Picker> pickers = null;
        try {
            pickers = ReadFile.readStore("..\\ocado_task2\\testData\\stre.json");
        } catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
        }
        Assert.assertNull(pickers);
    }
}
