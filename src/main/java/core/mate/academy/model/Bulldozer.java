package core.mate.academy.model;

public class Bulldozer extends Machine {
    private int maxWeight;

    public Bulldozer() {
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    @Override
    public void doWork() {
        System.out.println("Bulldozer started to work");
    }

}
