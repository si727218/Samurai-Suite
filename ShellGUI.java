package proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShellGUI extends JFrame implements ActionListener {
    JButton button;
    JTextField textField1;
    JTextField textField2;
    JComboBox comboBox;

    ShellGUI(){
        button = new JButton("Submit");
        button.setFocusable(false);
        button.addActionListener(this);
        button.setBounds(193, 120, 100, 50);
        button.setFont(new Font("Consolas", Font.BOLD, 12));

        textField1 = new JTextField();
        textField1.setPreferredSize(new Dimension(250, 40));
        textField1.setFont(new Font("Consolas", Font.PLAIN, 12));
        textField1.setBounds(95, 10, 300, 35);
        textField1.setText("Insert host IP: ");

        textField2 = new JTextField();
        textField2.setPreferredSize(new Dimension(250, 40));
        textField2.setFont(new Font("Consolas", Font.PLAIN, 12));
        textField2.setBounds(95, 50, 300, 35);
        textField2.setText("Insert logical port: ");

        String[] cipherHash = {"Bash","nc"};
        comboBox = new JComboBox(cipherHash);
        comboBox.setBounds(95, 90, 80, 35);

        this.add(button);
        this.add(textField1);
        this.add(textField2);
        this.add(comboBox);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(490,220);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            int type;
            if ((String) comboBox.getSelectedItem() == "Bash"){
                type = 1;
            }
            else{
                type = 2;
            }
            shells s1 = new shells(type,textField1.getText(),textField2.getText());
            s1.shellify();

            JFrame frame = new JFrame("Shell");
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            JTextArea textArea = new JTextArea(5, 10);
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);

            textArea.append("Generated shell:"+ "\n");
            textArea.append("------------------------------"+ "\n");

            textArea.append(String.valueOf(s1));

            textArea.setCaretPosition(textArea.getDocument().getLength());

            frame.add(textArea);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }

    }
}
