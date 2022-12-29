public class CarImpl {
    public static void main(String[] args) {

    Car car= new Car();
    Car car2 = new Car("mazda","gt1",Color.RED);
    car2.setType(CarType.SEDAN);
    car.setCompany("mazda");
    //car.setModel("gt1");

        System.out.println("override method equals= "+car.equals(new String("hello")));
        System.out.println("== by reference "+(car==car2));
        System.out.println(car.getModel());
        System.out.println(car2);
        System.out.println(car);

        switch (car2.getType()){
            case PICKUP:
                System.out.println("im a pickup");
                break;
            case STATION_WAGON:
                System.out.println("im a station wagon");
                break;
            case SEDAN:
                System.out.println("im a sedan");
                break;
        }





    }
}
