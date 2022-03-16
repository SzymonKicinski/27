package Gearbox;

import java.util.ArrayList;

public class Gearbox {

    private boolean clustchIsIn;
    private ArrayList<Gear> gears;
    private int maxGears;
    private int currentGear = 0;
    private boolean clutchIsIn;

    public void operateClutch(Boolean irOnOut) {
        this.clustchIsIn = irOnOut;
    }

    public Gearbox(int maxGears) {
        this.maxGears = maxGears;
        this.gears = new ArrayList<Gear>();
        Gear neutral = new Gear(0, 0.0);
        this.gears.add(neutral);

        for(int i=0; i<maxGears; i++) {
            addGear(i, i * 5.3);
        }
    }

    public void addGear(int number, double ratio) {
        if ((number > 0) && number <= maxGears) {
            gears.add(new Gear(number, ratio));
        }
    }

    public void changeGearVoid(int newGear) {
        if ((newGear >= 0) && (newGear < gears.size()) && (clustchIsIn)) {
            currentGear = newGear;
            System.out.println("Gear " + newGear + " selected");
        } else {
            System.out.println("Grind!");
            currentGear = 0;
        }
    }

    public double wheelSpeed(int revs) {
        if (clustchIsIn) {
            System.out.println("Scream!!!");
            return 0.0;
        }
        return revs * gears.get(currentGear).getRatio();
    }

    private class Gear {
        private int gearNumber;
        private double ratio;

        public Gear(int gearNumber, double ratio) {
            this.gearNumber = gearNumber;
            this.ratio = ratio;
        }

        public double driveSpeed(int revs) {
            return revs * (this.ratio);
        }


        public int getGearNumber() {
            return gearNumber;
        }

        public void setGearNumber(int gearNumber) {
            this.gearNumber = gearNumber;
        }

        public double getRatio() {
            return ratio;
        }

        public void setRatio(double ratio) {
            this.ratio = ratio;
        }
    }
}
