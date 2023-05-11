package data;

import java.time.LocalTime;

public class Picker implements Comparable<Picker> {
    private String id;
    private LocalTime startTime;
    private LocalTime stopTime;
    private LocalTime actualTime;

    /**
     * This method is a constructor for the data.Picker class.
     *
     * @param id               picker id
     * @param pickingStartTime picking start time
     * @param pickingStopTime  picking stop time
     */
    public Picker(String id, String pickingStartTime, String pickingStopTime) {
        this.id = id;
        this.startTime = LocalTime.parse(pickingStartTime);
        this.stopTime = LocalTime.parse(pickingStopTime);
        this.actualTime = LocalTime.parse(pickingStartTime);
    }

    /**
     * Getter for picker id.
     *
     * @return picker id
     */
    public String getId() {
        return id;
    }

    /**
     * Getter for picking start time.
     *
     * @return picking start time
     */
    public LocalTime getStartTime() {
        return startTime;
    }

    /**
     * Getter for picking stop time.
     *
     * @return picking stop time
     */
    public LocalTime getStopTime() {
        return stopTime;
    }

    /**
     * Getter for picking actual time.
     *
     * @return picking actual time
     */
    public LocalTime getActualTime() {
        return actualTime;
    }

    /**
     * Setter for picking actual time.
     *
     * @return picking actual time
     */
    public void setActualTime(LocalTime actualTime) {
        this.actualTime = actualTime;
    }

    /**
     * This method is an implementation of the compareTo method
     * from the Comparable interface, is used to define the
     * natural ordering of objects of the data.Picker class.
     *
     * @param o the object to be compared.
     * @return an integer value based on the comparison result
     */
    @Override
    public int compareTo(Picker o) {
        return this.actualTime.compareTo(o.getActualTime());
    }
}
