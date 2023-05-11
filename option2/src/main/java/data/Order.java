package data;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

public class Order {
    private String orderId;
    private Duration pickingTime;
    private LocalTime completeBy;
    private BigDecimal orderValue;

    /**
     * This method is a constructor for the data.Order class.
     *
     * @param orderId        order id
     * @param value          order value
     * @param pickingTime    order picking time
     * @param completeByTime order to be completed
     */
    public Order(String orderId, String value, String pickingTime, String completeByTime) {
        this.orderId = orderId;
        this.pickingTime = Duration.parse(pickingTime);
        this.completeBy = LocalTime.parse(completeByTime);
        this.orderValue = new BigDecimal(value);
    }

    /**
     * Getter for order id.
     *
     * @return order id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * Getter for order picking time.
     *
     * @return order picking time
     */
    public Duration getPickingTime() {
        return pickingTime;
    }

    /**
     * Getter for order to be completed time.
     *
     * @return order to be completed time
     */
    public LocalTime getCompleteBy() {
        return completeBy;
    }

    /**
     * Getter for order value.
     *
     * @return order value
     */
    public BigDecimal getOrderValue() {
        return orderValue;
    }
}
