public class Car {


    private String company;
    private String model;
    private String color;
    private double cc;
    private int gasCapacity;

    public Car(String company, String model) {
        this.company = company;
        this.model = model;
    }
    public Car(String company, String model,String color){
        this(company,model);//using the other constructor
        this.color=color;
    }

    public Car() {

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
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

    @Override
    public boolean equals(Object obj) {
        Car car= (Car) obj;
        if(this.getCompany()== car.getCompany()&&
        this.getModel()==car.getModel()){
            return true;
        }else{
            return false;
        }

    }
}
