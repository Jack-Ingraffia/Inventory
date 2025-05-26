import javax.swing.*;
import java.awt.*;

public class GUI {
    private JLabel[][] spaces = new JLabel[6][6];
    private JFrame frame;

    public GUI() {
        frame = new JFrame("Bag");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);

        JPanel panel = new JPanel(new GridLayout(6,6,4,4));
        frame.add(panel);

        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 6; col++) {
                JLabel space = new JLabel("Empty", SwingConstants.CENTER);
                space.setBorder(BorderFactory.createLineBorder(Color.BLUE));
                space.setOpaque(true);
                space.setBackground(Color.LIGHT_GRAY);
                space.setFont(new Font("Impact", Font.PLAIN, 18));
                spaces[row][col] = space;
                panel.add(space);
            }
        }
        frame.setVisible(true);
    }

    public void changeSpace(int row, int col, String text) {
        spaces[row-1][col-1].setText(text);
    }
}
