package org.example.creationaldesignpattern;

/*
The builder pattern is a design pattern that allows for the step-by-step creation of complex
objects using the correct sequence of actions. The construction is controlled by a director object
that only needs to know the type of object it is to create.
 */

class House{

    // mandatory fields
    private int doors;
    private int windows;
    // optional fields
    private boolean isTiles;
    private boolean isGarden;

    // private constructor so that we can create the object with the help of builder only
    private House(HouseBuilder houseBuilder) {
        this.doors = houseBuilder.doors;
        this.windows = houseBuilder.windows;
        this.isTiles = houseBuilder.isTiles;
        this.isGarden = houseBuilder.isGarden;
    }

    public int getDoors() {
        return doors;
    }

    public int getWindows() {
        return windows;
    }

    public boolean isTiles() {
        return isTiles;
    }

    public boolean isGarden() {
        return isGarden;
    }

    @Override
    public String toString() {
        return "House{" +
                "doors=" + doors +
                ", windows=" + windows +
                ", isTiles=" + isTiles +
                ", isGarden=" + isGarden +
                '}';
    }

    // Builder class
    static class HouseBuilder{

        // mandatory fields
        private int doors;
        private int windows;
        // optional fields
        private boolean isTiles;
        private boolean isGarden;

        // mandatory field constructor
        public HouseBuilder(int doors, int windows) {
            this.doors = doors;
            this.windows = windows;
        }

        public HouseBuilder setTiles(boolean isTiles){
            this.isTiles = isTiles;
            return this;
        }

        public HouseBuilder setGarden(boolean garden) {
            this.isGarden = garden;
            return this;
        }

        public House build(){
            return new House(this);
        }
    }
}

public class BuilderDesignPattern {

    public static void main(String[] args) {
        House house = new
                House.HouseBuilder(2,4)
                .setTiles(true)
                .build();
        System.out.println(house);
    }
}
