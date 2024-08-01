import java.awt.*;
import javax.swing.*;

public class PJSnake extends JFrame {

    public static void main(String[] args) {
        new PJSnake();
    }

    public PJSnake() {
        this.setTitle("Java Window");
        this.setDefaultCloseOperation(PJSnake.EXIT_ON_CLOSE);
        this.add(new PJSnakePanel());
        this.pack();
        this.setVisible(true);
    }

    public class PJSnakePanel extends JPanel {

        public PJSnakePanel() {
            this.setPreferredSize(new Dimension(400, 500));
            this.setBackground(Color.YELLOW);

        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.RED);
            g.fillRect(200, 250, 100, 200);
        }
    }
}
