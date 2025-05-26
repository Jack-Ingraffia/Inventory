public class Tool implements Item {
    private String name;

    public Tool(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isStackable() {
        return false;
    }

    @Override
    public String toString() {
        return name;
    }
}
