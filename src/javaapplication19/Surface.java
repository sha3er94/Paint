package javaapplication19;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Surface extends JPanel implements ActionListener {

    ArrayList<Shapes> history = new ArrayList<Shapes>();
    Stack<ArrayList<Shapes>> undo = new Stack<ArrayList<Shapes>>();
    Stack<ArrayList<Shapes>> redo = new Stack<ArrayList<Shapes>>();
    ArrayList<Shapes> shape = new ArrayList<Shapes>();

    int x, action = 0;
    int y;
    int w;
    int h;
    int s=0;
    Color c = (Color.BLACK), fc = (Color.WHITE);
    JButton lbtn, rbtn, obtn, cbtn, fbtn, SMbtn, Ubtn, Rbtn, Sbtn, Lbtn,SEbtn,Dbtn;

    public Surface() {

        setBorder(BorderFactory.createLineBorder(Color.black));
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);

        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(Color.DARK_GRAY);
        JPanel btnPanel1 = new JPanel();
        btnPanel1.setBackground(Color.DARK_GRAY);

        Box thebox = Box.createHorizontalBox();
        Box thebox1 = Box.createVerticalBox();

        lbtn = new JButton("Line");
        rbtn = new JButton("Rectangle");
        cbtn = new JButton("Colors");
        obtn = new JButton("Oval");
        SMbtn = new JButton("Move  ");
        Ubtn = new JButton("Undo  ");
        Rbtn = new JButton("Redo  ");
        Sbtn = new JButton("Save  ");
        Lbtn = new JButton("Load  ");
        SEbtn = new JButton("Select");
        Dbtn = new JButton("Delete");
        lbtn.addActionListener(this);
        rbtn.addActionListener(this);
        cbtn.addActionListener(this);
        obtn.addActionListener(this);
        SMbtn.addActionListener(this);
        Ubtn.addActionListener(this);
        Rbtn.addActionListener(this);
        Sbtn.addActionListener(this);
        Lbtn.addActionListener(this);
        SEbtn.addActionListener(this);
        Dbtn.addActionListener(this);
        thebox.add(lbtn);
        thebox.add(rbtn);
        thebox.add(obtn);
        thebox.add(cbtn);
        thebox1.add(Lbtn);
        thebox1.add(Sbtn);
        thebox1.add(SEbtn);
        thebox1.add(Ubtn);
        thebox1.add(Rbtn);
        thebox1.add(SMbtn);
        thebox1.add(Dbtn);

        btnPanel.add(thebox);
        btnPanel1.add(thebox1);

        this.add(btnPanel, BorderLayout.SOUTH);
        this.add(btnPanel1, BorderLayout.WEST);
        undo.push(new ArrayList<Shapes>());
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                                if(s==1){
                    int a=e.getX();
                    int b=e.getY();
                    for(Shapes q:shape) {
                        if( a >= q.getX1() && a <= q.getX2() && b >= q.getY1() && b <= q.getY2()|| a <= q.getX1() && a >= q.getX2() && b >= q.getY1() && b <= q.getY2() || a <= q.getX1() && a >= q.getX2() && b <= q.getY1() && b >=q.getY2())
                            q.setColor(Color.GREEN);
                        s=0;
                    }
                    
                }
                x = e.getX();
                y = e.getY();
                if (e.getSource() == Ubtn) {
                    action = 4;
                    int shapeIndex = undo();
                    shape.remove(shapeIndex);
                    setCursor(
                    Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
                if (e.getSource() == Rbtn) {
                    action = 5;
                    ArrayList<Shapes> redoshape = redo();
                    Shapes redoShape = redoshape.get(0);
                    shape.add(redoShape);
                    setCursor(
                    Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
                if (e.getSource() == Dbtn){
                    action = 6;
                    Shapes q=select(x,y);
                    Shapes temp=q;
                    delete(q);
                    if (e.getSource() == Ubtn){
                shape.add(temp);
                repaint();
            }
                }
                setCursor(
                    Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            public void mouseReleased(MouseEvent e) {

                w = e.getX();
                h = e.getY();
                if (action == 1) {
                    shape.add(new Lines(x, y, w, h, c));
                } else if (action == 2) {
                    shape.add(new Rectangles(x, y, w, h, c));
                } else if (action == 3) {
                    shape.add(new Oval(x, y, w, h, c));
                } else if (action == 4) {
                    action = 4;

                }
                
                repaint();
                setCursor(
                    Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
            

        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                w = e.getX();
                h = e.getY();
                repaint();
                setCursor(
                    Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
            }

        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == lbtn) {
            action = 1;
        } else if (e.getSource() == rbtn) {
            action = 2;
        } else if (e.getSource() == obtn) {
            action = 3;
        } else if (e.getSource() == cbtn) {
            c = JColorChooser.showDialog(null, "pick your color", c);
        } else if (e.getSource() == Ubtn && !shape.isEmpty()) {
            action = 4;
            int shapeIndex = undo();
            shape.remove(shapeIndex);
        } 
        else if (e.getSource() == Rbtn  && !redo.isEmpty()) {
            action = 5;
            ArrayList<Shapes> redoshape = redo();
            Shapes redoShape = redoshape.get(0);
            shape.add(redoShape);

        } 
        else if (e.getSource() == Dbtn){
                    action = 6;
                    Shapes q=select(x,y);
                    Shapes temp=q;
                    delete(q);
            if (e.getSource() == Ubtn){
                shape.add(temp);
                repaint();
            }
                    
        }
        else if (e.getSource() == SEbtn) {
            s = 1;}
        else if (e.getSource() == Sbtn) {
            try {
                save();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Surface.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource() == Lbtn) {
            load();

        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.LIGHT_GRAY);
        if (action == 1) {
            g2d.drawLine(x, y, w, h);
        } else if (action == 2) {
            g2d.drawRect(Math.min(x, w), Math.min(y, h), Math.abs(x - w), Math.abs(y - h));
        } else if (action == 3) {
            g2d.drawOval(Math.min(x, w), Math.min(y, h), Math.abs(x - w), Math.abs(y - h));
        }

        for (Shapes s : shape) {
            if (undo.isEmpty()) {
                undo.push(new ArrayList<Shapes>());
            }
            g2d.setColor(Color.LIGHT_GRAY);
            if (action == 1) {
                g2d.drawLine(x, y, w, h);
            } else if (action == 2) {
                g2d.drawRect(Math.min(x, w), Math.min(y, h), Math.abs(x - w), Math.abs(y - h));
            } else if (action == 3) {
                g2d.drawOval(Math.min(x, w), Math.min(y, h), Math.abs(x - w), Math.abs(y - h));
            }

            s.paint(g);
        }
    }

    public int undo() {
        ArrayList<Shapes> history = new ArrayList<Shapes>();
        int i = shape.size() - 1;
        System.out.println("Index : " + i);
        Shapes nshape = shape.get(i);
        history.add(nshape);
        undo.push(history);
        redo.push(history);
        System.out.println("Size : " + shape.size());

        System.out.println(history.size() + " :history");
        return i;
    }

    public ArrayList<Shapes> redo() {
        ArrayList<Shapes> nshape = redo.pop();

        System.out.println("Size : " + shape.size());
        return nshape;
    }
    public Shapes select(int a, int b){
                    for(Shapes q:shape) {
                        if( a >= q.getX1() && a <= q.getX2() && b >= q.getY1() && b <= q.getY2()|| a <= q.getX1() && a >= q.getX2() && b >= q.getY1() && b <= q.getY2() || a <= q.getX1() && a >= q.getX2() && b <= q.getY1() && b >=q.getY2())
                        {
                            q.setColor(Color.GREEN);
                            return q;
                        }   
                        s=0;
    }
                return null;    
    }
    public void delete (Shapes selected){
        for (int i=0 ; i<shape.size();i++){
            if (selected == shape.get(i)){
                //ArrayList<Shapes> history = new ArrayList<Shapes>();
                shape.remove(i);
                history.add(selected);
                undo.push(history);
                redo.push(history);
            }
        }
    
            }
    public void save() throws FileNotFoundException {

        XML f = new XML();
        Save t2 = new Save();
        f.write(shape, t2.load());
    }

    public void load() {
        Load t = new Load();
        XML f = new XML();
        try {
            shape = f.load(t.load());
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        repaint();
    }

}
