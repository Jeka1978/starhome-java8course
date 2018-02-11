package effectively_final;

import lab1.Action;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Evgeny Borisov
 */
public class MyFrame extends JFrame {


    public MyFrame(final String name)  {
        JButton button = new JButton("click to Change Color");
        setSize(300,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().setBackground(Color.RED);

            }
        });
        add(button,BorderLayout.NORTH);


        setVisible(true);
    }

    public static void main(String[] args) {

        new MyFrame("NAYA");

    }
}
