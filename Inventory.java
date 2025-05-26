public class Inventory {
    private Item[][] grid;
    private int[][] quantity;

    public Inventory() {
        grid = new Item[6][6];
        quantity = new int[6][6];
    }

    public void printInventory() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == null) { System.out.print("[    ]" + quantity[i][j] + " "); }
                else { System.out.print("[" +grid[i][j] + "]" + quantity[i][j] + " "); }
            }
            System.out.println();
        }
    }

    public Item addItem(int row, int col, Item item) {
        Item a = null;
        if (!(item.equals(grid[row-1][col-1]))) {
            a = grid[row-1][col-1];
        }
        grid[row-1][col-1] = item;

        return a;
    }

    public void updateQuantity(int row, int col, int amount) {
        quantity[row-1][col-1] = amount;
    }
}
