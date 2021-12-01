package proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ContentDiscoveryGUI extends JFrame implements ActionListener {
    JButton button;
    JTextField textField1;
    JTextField textField2;

    ContentDiscoveryGUI(){
        button = new JButton("Submit");
        button.setFocusable(false);
        button.addActionListener(this);
        button.setBounds(193, 90, 100, 50);
        button.setFont(new Font("Consolas", Font.BOLD, 12));

        textField1 = new JTextField();
        textField1.setPreferredSize(new Dimension(250, 40));
        textField1.setFont(new Font("Consolas", Font.PLAIN, 12));
        textField1.setBounds(95, 10, 300, 35);
        textField1.setText("Insert URL: ");

        textField2 = new JTextField();
        textField2.setPreferredSize(new Dimension(250, 40));
        textField2.setFont(new Font("Consolas", Font.PLAIN, 12));
        textField2.setBounds(95, 50, 300, 35);
        textField2.setText("Insert the wordlist: ");


        this.add(button);
        this.add(textField1);
        this.add(textField2);

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
            discovery d1 = new discovery(textField1.getText(),textField2.getText());
            try {
                d1.bruteforce();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            JFrame frame = new JFrame("Content Discovery");
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            JTextArea textArea = new JTextArea(5, 10);
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);

            textArea.append("Content discovered:"+ "\n");
            textArea.append("------------------------------"+ "\n");

            while(!discovery.positives.isEmpty())
                textArea.append("Content discovered on: "+discovery.positives.poll()+"\n");

            textArea.setCaretPosition(textArea.getDocument().getLength());

            frame.add(textArea);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    }
}
