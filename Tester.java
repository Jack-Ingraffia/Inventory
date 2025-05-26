import java.util.Scanner;
import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Inventory bag = new Inventory();
        GUI gui = new GUI();
        ArrayList<Item> removed = new ArrayList<>();

        System.out.println();
        bag.printInventory();
        System.out.println();

        String itemType = "";
        int row = -1;
        int col = -1;
        int amount = 0;

        System.out.println("Are you adding items? (y / n): ");
        String input = "";

        while (in.hasNextLine()) {
            String line = in.nextLine();

            if (line.equalsIgnoreCase("y") || line.equalsIgnoreCase("n")) {
                input = line;
                break;
            } else {
                System.out.println("Invalid input. Please enter (\"y\" or \"n\"):");
            }
        }

        while (input.equalsIgnoreCase("y")) {
            System.out.println("What item would you like to add (\"Tool\" / \"Block\" / \"Consumable\"): ");

            while (in.hasNextLine()) {
                String line = in.nextLine();

                if (line.equalsIgnoreCase("Tool") || line.equalsIgnoreCase("Block") || line.equalsIgnoreCase("Consumable")) {
                    itemType = line;
                    break;
                } else {
                    System.out.println("Invalid input. Please enter \"Tool\", \"Block\", or \"Consumable\":");
                }
            }

            System.out.println("What is the name of the item?: ");
            String itemName = in.nextLine();

            while (true) {
                System.out.println("Which row do you want the item in? (1-6): ");
                if (in.hasNextInt()) {
                    row = in.nextInt();
                    if (row >= 1 && row <= 6) {
                        break;
                    } else {
                        System.out.println("Number not in range 1-6. Try again.");
                    }
                } else {
                    System.out.println("That's not an integer. Try again.");
                    in.next();
                }
            }
            //System.out.println(row);

            while (true) {
                System.out.println("Which column do you want the item in? (1-6): ");
                if (in.hasNextInt()) {
                    col = in.nextInt();
                    if (col >= 1 && col <= 6) {
                        break;
                    } else {
                        System.out.println("Number not in range 1-6. Try again.");
                    }
                } else {
                    System.out.println("That's not an integer. Try again.");
                    in.next();
                }
            }
            //System.out.println(col);

            if (itemType.equalsIgnoreCase("Tool")) {
                Item a = new Tool(itemName);
                removed.add(bag.addItem(row, col, a));
                bag.updateQuantity(row, col, 1);

                gui.changeSpace(row,col,itemName+" (1)");
            }

            else if (itemType.equalsIgnoreCase("Block")) {
                Item a = new Block(itemName);

                while (true) {
                    System.out.println("How many are you adding? (Max ~ 100): ");
                    if (in.hasNextInt()) {
                        amount = in.nextInt();
                        if (amount >= 1 && amount <= 100) {
                            break;
                        } else {
                            System.out.println("Number not in range 1-100. Try again.");
                        }
                    } else {
                        System.out.println("That's not an integer. Try again.");
                        in.next();
                    }
                }

                removed.add(bag.addItem(row, col, a));
                bag.updateQuantity(row, col, amount);
                gui.changeSpace(row,col,itemName+" ("+amount+")");
            }

            else if (itemType.equalsIgnoreCase("Consumable")) {
                Item a = new Consumable(itemName);

                while (true) {
                    System.out.println("How many are you adding? (Max ~ 25): ");
                    if (in.hasNextInt()) {
                        amount = in.nextInt();
                        if (amount >= 1 && amount <= 25) {
                            break;
                        } else {
                            System.out.println("Number not in range 1-25. Try again.");
                        }
                    } else {
                        System.out.println("That's not an integer. Try again.");
                        in.next();
                    }
                }

                removed.add(bag.addItem(row, col, a));
                bag.updateQuantity(row, col, amount);
                gui.changeSpace(row,col,itemName+" ("+amount+")");
            }

            System.out.println();
            bag.printInventory();
            System.out.println();

            System.out.println("Are you adding more items? (y / n): ");
            while (in.hasNextLine()) {
                String line = in.next();

                if (line.equalsIgnoreCase("y") || line.equalsIgnoreCase("n")) {
                    input = line;
                    break;
                } else {
                    System.out.println("Invalid input. Please enter (\"y\" or \"n\"):");
                }
            }
            in.nextLine();
        }
        in.close();

        System.out.println();
        System.out.println("Removed Items: ");

        for (Item a : removed) {
            if (a == null) { continue; }
            else { System.out.println(a); }
        }
    }


}
