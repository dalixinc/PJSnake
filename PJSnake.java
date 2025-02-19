import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Random;

public class PJSnake extends JFrame {
    int cell_size = 40;
    int cell_number = 20;
    Random random = new Random();

    public static void main(String[] args) {
        new PJSnake();
    }

    public PJSnake() {
        this.setTitle("Java Window");
        this.setDefaultCloseOperation(PJSnake.EXIT_ON_CLOSE);
        this.add(new PJSnakePanel());
        this.pack();
        this.setIgnoreRepaint(true);
        this.setVisible(true);
    }

    public class PJSnakePanel extends JPanel implements ActionListener, KeyListener {
        Apple apple;
        Snake snake;
        
        public PJSnakePanel() {
            this.setPreferredSize(new Dimension(cell_number * cell_size, cell_number * cell_size));
            this.setBackground(new Color(175, 215, 70));
            this.setFocusable(true);

            // DRAW OBJECTS
            apple = new Apple();
            snake = new Snake();

            //TIMER
            Timer timer = new Timer(150, this);
            timer.start();

            //KEY INPUT
            this.addKeyListener(this);
        }

        public void checkCollision() {
            if (snake.body[0].isEqual(apple.applePos)) {
                System.out.println("Schnacking!!!");
                this.apple.createRandomApple();
                snake.addBlock = true;
            }
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            apple.drawApple(g);
            snake.drawSnake(g);
        }

        public void actionPerformed(ActionEvent ae) {
            snake.moveSnake();
            this.checkCollision();
        }

        public void keyPressed(KeyEvent ke) {
            int keyCode = ke.getKeyCode();
            if (keyCode == KeyEvent.VK_UP) snake.direction = new Vector2(0, -1); 
            if (keyCode == KeyEvent.VK_DOWN) snake.direction = new Vector2(0, 1); 
            if (keyCode == KeyEvent.VK_LEFT) snake.direction = new Vector2(-1, 0); 
            if (keyCode == KeyEvent.VK_RIGHT) snake.direction = new Vector2(1, 0); 
        }

        public void keyReleased(KeyEvent ke) {}
        public void keyTyped(KeyEvent ke) {}
    }

    private class Snake {
        Vector2[] body = {new Vector2(5, 10), new Vector2(6, 10), new Vector2(7, 10)};
        Vector2 direction = new Vector2(1, 0);
        boolean addBlock = false;

        public void moveSnake() {
            int copySize = this.body.length;

            if (addBlock) {
                copySize ++;
                addBlock = false;
            } 

            Vector2[] body_copy = new Vector2[copySize];
            System.arraycopy(this.body, 0, body_copy, 1, copySize - 1);
            body_copy[0] = new Vector2(body[0].x, body[0].y).add(direction);
            this.body = body_copy;
            repaint();
         }

        public void drawSnake(Graphics g) {
            for (Vector2 s : body) {
                g.setColor(new Color(183, 121, 122));
                g.fillRect(s.x * cell_size, s.y * cell_size, cell_size, cell_size);
            }
        }
    }

    private class Apple {
        
        Vector2 applePos;

        Apple() {
            createRandomApple();
        }

        public void createRandomApple() {
            int appleX = random.nextInt(cell_number -1);
            int appleY = random.nextInt(cell_number -1);
            applePos = new Vector2(appleX, appleY);
        }

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result * x * y * y;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Vector2))
            return false;
        Vector2 other = (Vector2)o;
        return (x == other.x && y == other.y);
    }

    public boolean isEqual(Vector2 v) {
        if (this == v || (this.x == v.x && this.y == v.y)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return "x = " + x + " y = " + y;
    }
}