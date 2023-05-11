import data.Order;
import data.Picker;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReadFile {

    /**
     * This method reads a JSON file from the path and parses
     * its content, returns data as a JSONArray object.
     *
     * @param path the specified path of a JSON file
     * @return the parsed data as a JSONArray object
     * @throws IOException
     * @throws ParseException
     */
    public static JSONArray readFileOrders(String path) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray data = (JSONArray) parser.parse(new FileReader(path));
        return data;
    }

    /**
     * This method reads a JSON file from the path and parses
     * its content, returns data as a JSONObject.
     *
     * @param path the specified path of a JSON file
     * @return the parsed data as a JSONObject
     * @throws IOException
     * @throws ParseException
     */
    public static JSONObject readFileStore(String path) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject data = (JSONObject) parser.parse(new FileReader(path));
        return data;
    }


    /**
     * This method is used for reading a JSON file
     * and parsing it into a List of data.Order objects.
     *
     * @param path the specified path of a JSON file
     * @return List of data.Order objects
     * @throws IOException
     * @throws ParseException
     */
    public static List<Order> readOrders(String path) throws IOException, ParseException {
        JSONArray data = readFileOrders(path);
        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            JSONObject object = (JSONObject) data.get(i);
            String orderId = (String) object.get("orderId");
            String orderValue = (String) object.get("orderValue");
            String pickingTime = (String) object.get("pickingTime");
            String completeBy = (String) object.get("completeBy");

            orders.add(new Order(orderId, orderValue, pickingTime, completeBy));
        }
        return orders;
    }

    /**
     * This method is used for reading a JSON file
     * and parsing it into a Queue of data.Picker objects.
     *
     * @param path the specified path of a JSON file
     * @return Queue of data.Picker objects.
     * @throws IOException
     * @throws ParseException
     */
    public static Queue<Picker> readStore(String path) throws IOException, ParseException {
        JSONObject data = readFileStore(path);
        Queue<Picker> pickers = new PriorityQueue<>();

        String pickingStartTime = (String) data.get("pickingStartTime");
        String pickingEndTime = (String) data.get("pickingEndTime");

        JSONArray pickersArray = (JSONArray) data.get("pickers");
        for (int j = 0; j < pickersArray.size(); j++) {
            String pickerId = (String) pickersArray.get(j);
            pickers.add(new Picker(pickerId, pickingStartTime, pickingEndTime));
        }
        return pickers;
    }
}
