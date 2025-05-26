public class Block implements StackableItem {
    private String name;
    private int maxStack;

    public Block(String name) {
        this.name = name;
        this.maxStack = 100;
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
