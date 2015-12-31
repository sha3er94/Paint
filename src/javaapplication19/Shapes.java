
package javaapplication19;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

 public abstract class Shapes extends JComponent{
    
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private Color color;
    private boolean flag = false;


	

    
    public Shapes(int x1,int y1,int x2,int y2,Color color) {
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
        this.color=color;
    }
    
    public int getX1() {
        return this.x1;
    }
     public void setX1(int x) {
         this.x1=x;
    }
     
      public int getY1() {
        return this.y1;
    }
     public void setY1(int x) {
         this.y1=x;
    }
     
      public int getX2() {
        return this.x2;
    }
     public void setX2(int x) {
         this.x2=x;
    }
    
      public int getY2() {
        return this.y2;
    }
     public void setY2(int x) {
         this.y2=x;
    }
     
      public Color getColor() {
        return this.color;
    }
     public void setColor(Color c) {
         this.color=c;
    }

     public boolean isFlag() {
		return flag;
	}
     public void setFlag(boolean flag) {
		this.flag = flag;
	}
    public void paint(Graphics g) {
       }
    abstract Shapes getCopy(Shapes r);

}


