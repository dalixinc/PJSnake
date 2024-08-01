import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class PJSnake extends JFrame implements ActionListener{

    volatile int x = 200;

    public static void main(String[] args) {
        new PJSnake();
    }

    public PJSnake() {
        this.setTitle("Java Window");
        this.setDefaultCloseOperation(PJSnake.EXIT_ON_CLOSE);
        this.add(new PJSnakePanel());
        this.pack();
        this.setVisible(true);
        Timer timer = new Timer(16, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent ae) {
            x++;
            repaint();
    }

    public class PJSnakePanel extends JPanel {

        public PJSnakePanel() {
            this.setPreferredSize(new Dimension(400, 500));
            this.setBackground(Color.YELLOW);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.RED);
            g.fillRect(x, 250, 100, 200);
        }
    }
}
