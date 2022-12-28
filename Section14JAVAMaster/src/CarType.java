public enum CarType {
    SEDAN("Sedan","medium car",4),
    PICKUP("Pick Up","large car",2),
    STATION_WAGON("Station Wagon","large car",5);

    private final String name;
    private final String description;
    private final int doors;

    CarType(String name, String description, int doors) {
        this.name = name;
        this.description = description;
        this.doors = doors;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getDoors() {
        return doors;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", doors=" + doors ;
    }
}
