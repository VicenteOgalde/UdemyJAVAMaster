public class Car {


    private String company;
    private String model;
    private Color color;
    private double cc;
    private int gasCapacity;
    private final static int numberOfWheels=4;
    private int id;
    private static int lastId;
    private CarType type;

    public Car(String company, String model) {
        this();
        this.company = company;
        this.model = model;
    }
    public Car(String company, String model,Color color){
        this(company,model);//using the other constructor
        this.color=color;
    }

    public Car() {
        this.id=++lastId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getCc() {
        return cc;
    }

    public void setCc(double cc) {
        this.cc = cc;
    }

    public int getGasCapacity() {
        return gasCapacity;
    }

    public void setGasCapacity(int gasCapacity) {
        this.gasCapacity = gasCapacity;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Car) {
            Car car = (Car) obj;
            if (this.getCompany() == car.getCompany() &&
                    this.getModel() == car.getModel()) {
                return true;
            } else {
                return false;
            }
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                "type='" + getType() + '\'' +
                "company='" + company + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", number of wheels='" + Car.numberOfWheels + '\'' +
                ", cc=" + cc +
                ", gasCapacity=" + gasCapacity +
                '}';
    }
}
