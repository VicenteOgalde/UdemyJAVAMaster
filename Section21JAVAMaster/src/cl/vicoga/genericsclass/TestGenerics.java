package cl.vicoga.genericsclass;

public class TestGenerics {
    public static void main(String[] args) {

        Truck<Animal> truck = new Truck(2);
        truck.addObj(new Animal("tt","dog"));
        truck.addObj(new Animal("xx","dog"));
        truck.addObj(new Animal("zz","dog"));


        truck.forEach(System.out::println);

        Truck<Car> truckCar = new Truck(2);
        truckCar.addObj(new Car("mazda"));
        truckCar.addObj(new Car("toyota"));
        truckCar.addObj(new Car("kia"));

        truckCar.forEach(System.out::println);



    }
}
