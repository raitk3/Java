package ee.taltech.iti0202.parking;

import ee.taltech.iti0202.parking.car.Car;
import ee.taltech.iti0202.parking.parkinglot.MultiLevelParkingLot;
import ee.taltech.iti0202.parking.parkinglot.PriorityParkingLot;
import ee.taltech.iti0202.parking.parkinglot.SmallCarParkingLot;

import java.util.PriorityQueue;

public class Demo {

    public static void main(String[] args) {
        City tallinn = new City("Tallinn");
        City tartu = new City("Tartu");
        SmallCarParkingLot europark = new SmallCarParkingLot(4, 2);
        tallinn.addParkingLot(europark);
        Car ch1 = new Car(Car.PriorityStatus.HIGHEST, 1);
        Car ch2 = new Car(Car.PriorityStatus.HIGHEST, 2);
        Car ch4 = new Car(Car.PriorityStatus.HIGHEST, 4);
        Car cp1 = new Car(Car.PriorityStatus.PRIORITY, 1);
        Car cp2 = new Car(Car.PriorityStatus.PRIORITY, 2);


        PriorityQueue<Car> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(cp1);
        priorityQueue.add(ch2);
        priorityQueue.add(cp2);
        priorityQueue.add(ch1);
        priorityQueue.add(ch4);
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
        /*
        H1
        H2
        H4
        P1
        P2
        */

        System.out.println(tartu.parkCar(ch1));  // Optional.empty
        System.out.println(tallinn.parkCar(ch2));  // Optional.empty
        System.out.println(tallinn.parkCar(ch1));  // Optional[europark]
        System.out.println(tallinn.parkCar(ch1));  // Optional.empty
        System.out.println(europark.getParkedCars()); //[H1]

        PriorityParkingLot priorityParkingLot = new PriorityParkingLot(1, 3);

        tallinn.addParkingLot(priorityParkingLot);

        System.out.println(tallinn.parkCar(ch4)); // Optional[priorityParkingLot]
        Car cc4 = new Car(Car.PriorityStatus.COMMON, 4);
        Car cp4 = new Car(Car.PriorityStatus.PRIORITY, 4);
        System.out.println(tallinn.parkCar(cc4)); // Optional[priorityParkingLot]
        System.out.println(tallinn.parkCar(cp4)); // Optional[priorityParkingLot]
        Car ch42 = new Car(Car.PriorityStatus.HIGHEST, 4);
        System.out.println(tallinn.parkCar(ch42)); // Optional[priorityParkingLot]

        System.out.println(priorityParkingLot.getTable());
        /*
        H4H4..
        H4H4..

        */

        // let's send one car home
        System.out.println(ch4.unpark()); // true

        // now another H4 parks
        System.out.println(priorityParkingLot.getTable());
        /*
        H4H4..
        H4H4..

        */

        System.out.println(ch4.unpark());  // false, there's no such car parked
        System.out.println(ch42.unpark());  // true

        System.out.println(priorityParkingLot.getTable());
        /*
        P4P4..
        P4P4..

         */
        MultiLevelParkingLot multiLevelParkingLot = new MultiLevelParkingLot(1, 2, 2);
        multiLevelParkingLot.addToQueue(new Car(Car.PriorityStatus.COMMON, 2));
        multiLevelParkingLot.addToQueue(new Car(Car.PriorityStatus.COMMON, 1));
        System.out.println(multiLevelParkingLot.getTable());
        /*
        C2C1
        C2..
        ---
        ....
        ....

        */
        multiLevelParkingLot.addToQueue(new Car(Car.PriorityStatus.HIGHEST, 1));
        multiLevelParkingLot.addToQueue(new Car(Car.PriorityStatus.HIGHEST, 2));
        multiLevelParkingLot.addToQueue(new Car(Car.PriorityStatus.COMMON, 2));
        multiLevelParkingLot.addToQueue(new Car(Car.PriorityStatus.HIGHEST, 2));
        System.out.println(multiLevelParkingLot.getTable());
        /*
        C2C1
        C2H1
        ---
        H2C2
        H2C2
        */
    }
}
