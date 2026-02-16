package core.mate.academy.model;

public class Truck extends Machine {
    private int circles;

    public Truck() {
    }

    public int getCircles() {
        return circles;
    }

    public void setCircles(int circles) {
        this.circles = circles;
    }

    @Override
    public void doWork() {
        System.out.println("Truck started to work");
    }

}
