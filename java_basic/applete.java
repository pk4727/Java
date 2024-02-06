 import java.applet.Applet;
 import java.awt.*;
 import java.awt.event.*;
 public class applete extends Applet implements ActionListener
 {
     TextField t1 = new TextField(10);
     TextField t2 = new TextField(10);
     TextField t3 = new TextField(10);
     Label l1=new Label("first no");
     Label l2=new Label("second no");
     Label l3=new Label("sum");
     Button b=new Button("Add");
     public void init()
     {
         add(l1);
         add(t1);
         add(l2);
         add(t2);
         add(l3);
         add(t3);
         add(b);
         b.addActionListener(this);
     }
     @Override
     public void actionPerformed(ActionEvent e)
     {
         if(e.getSource()==b)
         {
             int n1=Integer.parseInt(t1.getText());
             int n2=Integer.parseInt(t1.getText());
             t3.setText(" "+(n1+n2));
         }
         throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
     }
 }


 // only work in old version
 // for run compile it then use "appletviewer name.java"