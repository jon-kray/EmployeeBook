package polymorphism;

public class CarInfo  {
    public static void main(String[] args) {
        Car toyota = new Toyota();
        Car kia = new Kia();
        Car mazda = new Mazda();

        Car[] cars = new Car[3];
        cars[0] = toyota;
        cars[1] = kia;
        cars[2] = mazda;

        for (Car car : cars) {
            car.getEngineType();
        }
    }


}

