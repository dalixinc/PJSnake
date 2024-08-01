import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Random;

public class PJSnake extends JFrame implements ActionListener{

    int cell_size = 40;
    int cell_number = 20;
    Random random = new Random();

    public static void main(String[] args) {
        new PJSnake();
        Vector2 v1 = new Vector2(7, 8);
        Vector2 v2 = new Vector2(2, 3);
        Vector2 sum = new Vector2(0, 0);
        sum = sum.add(v1, v2);
        System.out.println(sum.x + " , " + sum.y);
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

    class Apple {private
        int appleX = random.nextInt(cell_number -1);
        int appleY = random.nextInt(cell_number -1);

        public void drawApple(Graphics g) {
            g.setColor(new Color(126, 155, 114));
            g.fillRect(appleX * cell_size, appleY * cell_size, cell_size, cell_size  );
        }
    }

    class Vector2 {

         int x;
         int y;

         Vector2(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Vector2 add (Vector2 v1, Vector2 v2) {
            return new Vector2(v1.x + v2.x, v1.y + v2.y);
        }
    }
}
