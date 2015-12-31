package javaapplication19;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Oval extends Shapes {

    public Oval(int x1, int y1, int x2, int y2, Color color) {
        super(x1, y1, x2, y2, color);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(this.getColor());
        g2d.drawOval(Math.min(this.getX1(), this.getX2()), Math.min(this.getY1(), this.getY2()), Math.abs(this.getX1() - this.getX2()), Math.abs(this.getY1() - this.getY2()));
    }
        Shapes getCopy(Shapes r) {
		Oval nOval = new Oval( getX1(), getY1(), getX2(), getY2(),getColor());
		nOval.setFlag(this.isFlag());
		return nOval;
}
}
