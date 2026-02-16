package core.mate.academy.model;

public class Excavator extends Machine {
    private int maxHeight;

    public Excavator() {
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    @Override
    public void doWork() {
        System.out.println("Excavator started to work");
    }

}
