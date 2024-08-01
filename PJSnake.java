import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class PJSnake extends JFrame implements ActionListener{

    int cell_size = 40;
    int cell_number = 20;

    public static void main(String[] args) {
        new PJSnake();
    }

    public PJSnake() {
        this.setTitle("Java Window");
        this.setDefaultCloseOperation(PJSnake.EXIT_ON_CLOSE);
        this.add(new PJSnakePanel());
        this.pack();
        this.setVisible(true);
        //Timer timer = new Timer(16, this);
        //timer.start();
    }

    public void actionPerformed(ActionEvent ae) {
    }

    public class PJSnakePanel extends JPanel {

        public PJSnakePanel() {
            this.setPreferredSize(new Dimension(cell_number * cell_size, cell_number * cell_size));
            this.setBackground(new Color(175, 215, 70));
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            new Apple().drawApple(g);
        }
    }

    class Apple {
        int appleX = 5;
        int appleY = 4;

        public void drawApple(Graphics g) {
            g.setColor(new Color(126, 155, 114));
            g.fillRect(appleX, appleY, cell_size, cell_size  );
        }
    }
}
