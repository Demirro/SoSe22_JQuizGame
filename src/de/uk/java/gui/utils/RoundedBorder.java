package de.uk.java.gui.utils;

import javax.swing.border.Border;
import java.awt.*;

public class RoundedBorder implements Border {
    private int radius;
    public RoundedBorder(int radius) {
        this.radius = radius;
    }
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.LIGHT_GRAY);
        g.drawRoundRect(x,y,width-1,height-1,radius,radius);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(0,0,0,0);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }
}
