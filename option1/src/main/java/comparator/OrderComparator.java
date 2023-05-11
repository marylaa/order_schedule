package comparator;

import data.Order;

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
        int comparison = o1.getCompleteBy().compareTo(o2.getCompleteBy());
        if (comparison == 0) {
            return o1.getPickingTime().compareTo(o2.getPickingTime());
        } else {
            return comparison;
        }
    }
}
