package proyecto;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.swing.JFrame;

public class Window extends JFrame implements ActionListener{
    Button button1, button2, button3, button4, button5, button6;
    public Window() {

        button1 = new Button();
        button1.setBounds(80, 230, 160, 70);
        button1.addActionListener(this);
        button1.setText("Generador de Hashes");

        button2 = new Button();
        button2.setBounds(315, 230, 160, 70);
        button2.addActionListener(this);
        button2.setText("Creckeo de Hashes");

        button3 = new Button();
        button3.setBounds(550, 230, 160, 70);
        button3.addActionListener(this);
        button3.setText("Ping Sweep");

        button4 = new Button();
        button4.setBounds(80, 380, 160, 70);
        button4.addActionListener(this);
        button4.setText("Generador de Wordlists");

        button5 = new Button();
        button5.setBounds(315, 380, 160, 70);
        button5.addActionListener(this);
        button5.setText("Generador de Shell");

        button6 = new Button();
        button6.setBounds(550, 380, 160, 70);
        button6.addActionListener(this);
        button6.setText("Content Discovery");

        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.black);
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(false);
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(button5);
        this.add(button6);
//		this.getContentPane().setBackground(new Color()); Valores RGB 0, 0, 0 o en hexadecimal
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //Wordlists
        if(e.getSource()==button4) {
            PopWindow window = new PopWindow();
            wordlist w1 = new wordlist(100, 8);
            try {
                w1.generate();
                System.out.println(w1.toString());
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
        }

        //Hashes
        else if(e.getSource()==button1){
            Input input = new Input();
        }

        //Ping Sweep
        else if(e.getSource() == button3){
            pingsweep ping1 = new pingsweep(new StringBuilder("192.168.1.0"),10);
            ping1.ping();
        }

        //Content Discovery
        else if(e.getSource() == button6){
            discovery d1 = new discovery("http://testphp.vulnweb.com");
            try {
                d1.bruteforce();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        //Shells
        else if(e.getSource() == button5){
            shells s1 = new shells(1,"192.168.15.15","1234");
            s1.shellify();
            System.out.println(s1);
        }
    }
}