public class Consumable implements StackableItem {

    private String name;
    private int maxStack;

    public Consumable(String name) {
        this.name = name;
        this.maxStack = 25;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isStackable() {
        return true;
    }

    @Override
    public int getMaxStack() {
        return maxStack;
    }

    @Override
    public String toString() {
        return name;
    }
}
