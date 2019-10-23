package ee.taltech.iti0202.parking.car;

import ee.taltech.iti0202.parking.parkinglot.ParkingLot;

/**
 * Represents a car with priority and size.
 * The size can be one of 1, 2, 4 (the code doesn't have to validate it).
 * This class implements Comparable interface.
 * This allows objects to be sorted in priority queue (or for sorting in general).
 * Cars with highest priority will be taken first, then with the "priority" priority
 * and then all the common cars.
 * If there are cars with the same priority, prefer cars with lower size.
 * So highest-1 (priority status-size) comes before highest-2 which comes before priority-1.
 */
public class Car implements Comparable<Car> {

    private PriorityStatus priority;
    private int size;
    private ParkingLot parkingLot;
    public enum PriorityStatus {
        HIGHEST, PRIORITY, COMMON
    }
    int priorityValue;

    @Override
    public int compareTo(Car o) {
        int diff = priorityValue - o.priorityValue;
        if (diff == 0) {
            return o.size - size;
        }
        return diff;
    }

    public Car(PriorityStatus status, int size) {
        this.priority = status;
        this.size = size;
        this.parkingLot = null;
        switch (status) {
            case HIGHEST:
                this.priorityValue = 2;
                break;
            case PRIORITY:
                this.priorityValue = 1;
                break;
            default:
                this.priorityValue = 0;
        }
    }

    /**
     * Gets the priority of the car.
     * @return PriorityStatus
     */
    public PriorityStatus getPriorityStatus() {
        return this.priority;
    }

    /**
     * Gets the size of the car.
     * @return Size.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Finish parking. This car has finished parking.
     * The car should be removed from parking lot
     * (its slots will be empty).
     * Returns false, if the car is not parked currently.
     * Otherwise returns true.
     * @return True if the car was parking, false otherwise.
     */
    public boolean unpark() {
        if (this.getParked()) {
            this.parkingLot = null;
            return true;
        }
        return false;
    }

    public boolean setParked(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        return true;
    }
    public boolean getParked() {
        return this.parkingLot != null;
    }

    public String toString() {
        StringBuilder stringToReturn = new StringBuilder();
        switch (this.priority) {
            case PRIORITY:
                stringToReturn.append("P");
                break;
            case HIGHEST:
                stringToReturn.append("H");
                break;
            default:
                stringToReturn.append("C");
        }
        stringToReturn.append(this.size);
        return stringToReturn.toString();
    }

}
