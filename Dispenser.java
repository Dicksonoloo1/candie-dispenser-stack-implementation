
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dispenser extends JPanel {
    private static ArrayStack stack;

    private static JFrame frame;

    public Dispenser() {

        stack = new ArrayStack();
    }

    public void paintComponent(Graphics g) {

        g.drawRect(20, 20, 100, 310);

        if (!stack.isEmpty()) {
            int count = stack.getCount();

            for (int i = 0; i < count; i++) {

                g.setColor(Color.RED);

                g.fillOval(20, (i * 30) + 20, 100, 30);

                String text = "candy" + (count - i);
                g.setColor(Color.white);
                g.drawString(text, 65, ((i * 30) + 40));
            }
        }

        int candyHeight = 20 + stack.getCount() * 30;

        while (candyHeight < 310) {
            g.setColor(Color.black);
            int height = 310 - candyHeight;
            for (int i = 1; i <= 10; i++) {

                g.drawLine(20, candyHeight, 120, candyHeight);

                candyHeight += height / 10;

                g.drawLine(20, candyHeight - (height / 10), 120, candyHeight);
                g.drawLine(20, candyHeight, 120, candyHeight);
            }
        }
    }

    public static void main(String args[]) {

        frame = new JFrame("Candy Dispenser GUI!");

        frame.setSize(700, 400);

        JPanel panel = new Dispenser();

        panel.setSize(700, 400);

        JLabel title = new JLabel("Operations");
        title.setBounds(400, 0, 300, 30);

        JLabel msg = new JLabel();

        msg.setBounds(200, 70, 300, 30);

        JButton size = new JButton("Size");

        size.setBounds(400, 30, 100, 30);

        size.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                msg.setText("The dispenser has " + stack.getCount() + " candies.");
            }
        });

        JButton push = new JButton("Push");
        push.setBounds(400, 70, 100, 30);
        push.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (stack.isFull()) {

                    msg.setText("The dispenser is full.");
                } else {

                    stack.push();
                    frame.repaint();
                }
            }
        });

        JButton pop = new JButton("Pop");
        pop.setBounds(400, 110, 100, 30);
        pop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (stack.isEmpty()) {

                    msg.setText("The dispenser is empty.");
                } else {

                    stack.pop();
                    frame.repaint();
                }
            }
        });

        JButton top = new JButton("Top");
        top.setBounds(400, 150, 100, 30);
        top.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (stack.isEmpty()) {
                    msg.setText("The dispenser is empty.");
                } else {
                    msg.setText("The top candy is candy" + stack.getCount());
                }
            }
        });

        JButton isEmpty = new JButton("Is Empty?");
        isEmpty.setBounds(400, 190, 100, 30);
        isEmpty.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (stack.isEmpty()) {
                    msg.setText("TRUE.");
                } else {
                    msg.setText("FALSE.");
                }
            }
        });

        frame.add(msg);

        frame.add(isEmpty);
        frame.add(push);
        frame.add(size);
        frame.add(top);
        frame.add(pop);

        frame.add(panel);

        frame.setVisible(true);

    }

}
