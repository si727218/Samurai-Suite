package proyecto;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;


public class Button extends JButton {
    public Button() {

        Font customFont;
        customFont = new Font("Consolas", Font.PLAIN, 12);

        this.setFocusable(false);
        this.setFont(customFont);
        this.setForeground(new Color(255,0,0));
        this.setBackground(new Color(15,15,15));
        this.setBorder(BorderFactory.createEtchedBorder (8, new Color(100,0,0), new Color(100,0,0)));
    }
}
