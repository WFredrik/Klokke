import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.EventHandler;
import java.text.*;
import java.util.*;
import java.util.List;

import static jdk.nashorn.internal.objects.NativeWeakSet.add;


class Watch implements Runnable{
    public boolean setVisable;
    JFrame f;
    JFrame GA;
    Thread t=null;
    int hours=0, minutes=0, seconds=0;
    String timeString = "";
    JButton b;
    JButton g;
    JButton k;
    JMenu menu, submenu;
    JMenuItem i1, i2, i3, i4, i5;

    Watch(){
        f=new JFrame();
        GA = new JFrame();

        k = new JButton();
        k.setBounds(100,50, 100,50);
        k.setText("Credits");
        k.addActionListener(this::buttonListen2);

        g = new JButton();
        g.setBounds(100,150,100,50);
        g.setText("Close window");
        g.addActionListener(this::buttonListen);

        t = new Thread(this);
        t.start();

        b=new JButton();
        b.setBounds(100,100,100,50);

        f.add(b);
        f.add(k);
        f.add(g);
        f.setSize(300,400);
        f.setLayout(null);
        f.setVisible(true);

        GA.setSize(200, 300);
        GA.setVisible(false);
        add(b, BorderLayout.CENTER);

        JMenuBar mb=new JMenuBar();
        menu=new JMenu("Meny");
        i1=new JMenuItem("Sander");
        i2=new JMenuItem("Marcus");
        i3=new JMenuItem("Joachim");
        i4=new JMenuItem("Fredrik");
        i5=new JMenuItem("Terje");
        menu.add(i1); menu.add(i2); menu.add(i3);
        menu.add(i4); menu.add(i5);
        mb.add(menu);
        f.setJMenuBar(mb);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);



    }

    private void buttonListen2(ActionEvent actionEvent) {
        ImageIcon icon = new ImageIcon("images//olga.png");
        JOptionPane.showMessageDialog(GA, "Laget av de flotte gutta fra Backend","Credits",JOptionPane.INFORMATION_MESSAGE, icon);

    }

    private void buttonListen(ActionEvent actionEvent) {
        System.exit(0);
    }



    public void run() {
        try {
            while (true) {

                Calendar cal = Calendar.getInstance();
                hours = cal.get( Calendar.HOUR_OF_DAY );
                if ( hours > 12 ) hours -= 12;
                minutes = cal.get( Calendar.MINUTE );
                seconds = cal.get( Calendar.SECOND );

                SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
                Date date = cal.getTime();
                timeString = formatter.format( date );

                printTime();

                t.sleep( 1000 );  // interval given in milliseconds
            }
        }
        catch (Exception e) { }
    }

    public void printTime(){
        b.setText(timeString);
    }

    public <E> List getContentPane() {
        return null;
    }

    public void setVisible(boolean b) {
    }



    //public static void main(String[] args) {
       // new Watch();



    //}
}