package proyecto;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class PopWindow {

    JFrame frame = new JFrame();
    JLabel label = new JLabel("successful, a txt file with a wordlist has been created!");

    PopWindow(){
        label.setBounds(20, 0, 600, 220);
        label.setForeground(Color.RED);
        label.setFont(new Font("Consolas", Font.PLAIN, 18));

        frame.add(label);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(620,220);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.black);
    }

    public void setLabel(String s) {
        label.setText(s);
    }
    public void setSize(int w, int h) {
        frame.setSize(w,h);
    }
}
