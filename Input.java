package proyecto;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Input extends JFrame implements ActionListener{
    JButton button;
    JTextField textField;
    JComboBox comboBox;

    Input(){
        button = new JButton("Submit");
        button.setFocusable(false);
        button.addActionListener(this);
        button.setBounds(10, 10, 80, 33);
        button.setFont(new Font("Consolas", Font.BOLD, 12));

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250, 40));
        textField.setFont(new Font("Consolas", Font.PLAIN, 12));
        textField.setBounds(95, 10, 300, 35);

        String[] cipherHash = {"Sha1","MD5","Sha256"};
        comboBox = new JComboBox(cipherHash);
        comboBox.setBounds(395, 10, 80, 35);

        this.add(comboBox);
        this.add(button);
        this.add(textField);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(490,220);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button) {
            cipher hash = new cipher(textField.getText(), (String) comboBox.getSelectedItem());
            hash.cifradirijillo();
            System.out.println(hash);
            PopWindow ph = new PopWindow();
            ph.setLabel(""+hash);
            ph.setSize(600,220);
        }
    }
}