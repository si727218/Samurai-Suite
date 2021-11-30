package proyecto;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI {
    public static void main(String[] args) {
        Font customFont;
        JPanel panel;
        JLabel textLabel;
        Window window = new Window();
        try{
            // load a custom font in your project folder
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/proyecto/IBM-Logo.ttf")).deriveFont(30f); //NOTA el path de la tipografía se debe modificar
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/proyecto/IBM-Logo.ttf"))); //NOTA el path de la tipografía se debe modificar
        }
        catch(IOException | FontFormatException e){

        }
        customFont = new Font("IBM Logo", Font.PLAIN, 75);
        String fonts[] =
                GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        panel = new JPanel();
        panel.setBounds(0, 20, 800, 650);
        panel.setBackground(Color.BLACK);


        textLabel = new JLabel("Samurai");
        textLabel.setBackground(Color.black);
        textLabel.setForeground(Color.RED);
        textLabel.setFont(customFont);
        panel.add(textLabel);

        window.add(panel);

        window.setVisible(true);
    }
}