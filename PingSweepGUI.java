package proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PingSweepGUI extends JFrame implements ActionListener {
    JButton button;
    JTextField textField1;
    JTextField textField2;
    PingSweepGUI(){
        button = new JButton("Submit");
        button.setFocusable(false);
        button.addActionListener(this);
        button.setBounds(193, 90, 100, 50);
        button.setFont(new Font("Consolas", Font.BOLD, 12));

        textField1 = new JTextField();
        textField1.setPreferredSize(new Dimension(250, 40));
        textField1.setFont(new Font("Consolas", Font.PLAIN, 12));
        textField1.setBounds(95, 10, 300, 35);
        textField1.setText("Network IP Address: ");

        textField2 = new JTextField();
        textField2.setPreferredSize(new Dimension(250, 40));
        textField2.setFont(new Font("Consolas", Font.PLAIN, 12));
        textField2.setBounds(95, 50, 300, 35);
        textField2.setText("Number of Hosts to Map: ");

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
            int host;
            host =Integer.parseInt(textField2.getText());
            pingsweep ping1 = new pingsweep(new StringBuilder(textField1.getText()),host);
            ping1.ping();
            JFrame frame = new JFrame("PingSweep");
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            JTextArea textArea = new JTextArea(5, 10);
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);

            textArea.append("Host alive:"+ "\n");
            textArea.append("------------------------------"+ "\n");

            while(!pingsweep.positives.isEmpty())
                textArea.append(pingsweep.positives.poll()+ "\n");

            textArea.setCaretPosition(textArea.getDocument().getLength());

            frame.add(textArea);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }

    }
}
