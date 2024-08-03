import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Random;

public class PJSnake extends JFrame implements ActionListener {

    int cell_size = 40;
    int cell_number = 20;
    Random random = new Random();

    public static void main(String[] args) {
        new PJSnake();
        /* Vector2 v1 = new Vector2(7, 8);
        Vector2 v2 = new Vector2(2, 3);
        Vector2 sum = new Vector2(0, 0);
        sum = sum.add(v1, v2);
        System.out.println(sum.x + " , " + sum.y);

        Vector2 v3 = new Vector2(5, 5);
        Vector2 v4 = v3.add(v2);
        System.out.println(v4.x + " , " + v4.y); */
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

        Apple apple;
        Snake snake;

        public PJSnakePanel() {
            this.setPreferredSize(new Dimension(cell_number * cell_size, cell_number * cell_size));
            this.setBackground(new Color(175, 215, 70));

            // DRAW OBJECTS
            apple = new Apple();
            snake = new Snake();
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            apple.drawApple(g);
            snake.drawSnake(g);
        }
    }

    private class Snake {
        Vector2[] body = {new Vector2(5, 10), new Vector2(6, 10), new Vector2(7, 10)};

        public void drawSnake(Graphics g) {
            for (Vector2 s : body) {
                g.setColor(new Color(183, 121, 122));
                g.fillRect(s.x * cell_size, s.y * cell_size, cell_size, cell_size);
            }
        }
    }

    private class Apple {
        int appleX = random.nextInt(cell_number -1);
        int appleY = random.nextInt(cell_number -1);
        Vector2 applePos = new Vector2(appleX, appleY);

        public void drawApple(Graphics g) {
            g.setColor(new Color(126, 166, 114));
            g.fillRect(applePos.x * cell_size, applePos.y * cell_size, cell_size, cell_size);
        }
    }
}

class Vector2 {

        int x;
        int y;

        Vector2() {
            this(0, 0);
        }

        Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    static Vector2 add(Vector2 v1, Vector2 v2) {
        return new Vector2(v1.x + v2.x, v1.y + v2.y);
    }

    Vector2 add(Vector2 addend) {
        return new Vector2(this.x + addend.x, this.y + addend.y);
    }
}
