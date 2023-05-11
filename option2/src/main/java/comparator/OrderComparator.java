package comparator;

import data.Order;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.Duration;
import java.util.Comparator;

public class OrderComparator implements Comparator<Order> {

    /**
     * This method is an implementation of the compare method
     * from the Comparator interface, is used to compare
     * two objects of the data.Order class.
     *
     * @param o1 the first object to be compared
     * @param o2 the second object to be compared
     * @return the result of the comparison
     */
    @Override
    public int compare(Order o1, Order o2) {
        BigDecimal order1;
        BigDecimal order2;
        if (o2.getPickingTime().isZero() && o1.getPickingTime().isZero()) {
            return o1.getCompleteBy().compareTo(o2.getCompleteBy());
        } else if (o2.getPickingTime().isZero()) {
            return 1;
        } else if (o1.getPickingTime().isZero()) {
            return -1;
        } else {
            order1 = o1.getOrderValue().divide(BigDecimal.valueOf(o1.getPickingTime().toMinutes()), MathContext.DECIMAL64);
            order2 = o2.getOrderValue().divide(BigDecimal.valueOf(o2.getPickingTime().toMinutes()), MathContext.DECIMAL64);

            int comparison = order1.compareTo(order2);
            if (comparison == 0) {
                return o1.getCompleteBy().compareTo(o2.getCompleteBy());
            } else {
                return -1 * comparison;
            }
        }
    }
}
