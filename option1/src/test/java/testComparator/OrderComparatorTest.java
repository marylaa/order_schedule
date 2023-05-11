package testComparator;

import comparator.OrderComparator;
import data.Order;
import org.junit.Assert;
import org.junit.Test;

public class OrderComparatorTest {

    @Test
    public void testCompare() {
        Order order1 = new Order("order-1", "0", "PT20M", "09:00");
        Order order2 = new Order("order-2", "0", "PT40M", "09:00");
        OrderComparator comparator = new OrderComparator();

        Assert.assertEquals(-1, comparator.compare(order1, order2));

        Assert.assertEquals(0, comparator.compare(order1, order1));

        Assert.assertEquals(1, comparator.compare(order2, order1));
    }
}
