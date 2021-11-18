import javax.swing.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


class Watch implements Runnable {
    JFrame mainWindow;
    JFrame creditsWindow;
    Thread threadOne;
    int hours = 0, minutes = 0, seconds = 0;
    String timeString = "";
    JButton watchWindow;
    JButton closeButton;
    JButton creditsButton;
    JMenu menu;
    JMenuItem i1, i2, i3, i4, i5;

    Watch() {
        mainWindow = new JFrame();
        creditsWindow = new JFrame();

        creditsButton = new JButton();
        creditsButton.setBounds(70, 50, 100, 50);
        creditsButton.setText("Credits");
        creditsButton.addActionListener(this::buttonListen2);

        closeButton = new JButton();
        closeButton.setBounds(70, 150, 100, 50);
        closeButton.setText("Close Window");
        closeButton.addActionListener(this::buttonListen);

        threadOne = new Thread(this);
        threadOne.start();

        watchWindow = new JButton();
        watchWindow.setBounds(70, 100, 100, 50);

        mainWindow.add(watchWindow);
        mainWindow.add(creditsButton);
        mainWindow.add(closeButton);
        mainWindow.setSize(250, 300);
        mainWindow.setLayout(null);
        mainWindow.setVisible(true);

        creditsWindow.setSize(200, 300);
        creditsWindow.setVisible(false);
        //add(b, BorderLayout.CENTER);

        JMenuBar mb = new JMenuBar();
        menu = new JMenu("Meny");
        i1 = new JMenuItem("Sander");
        i2 = new JMenuItem("Marcus");
        i3 = new JMenuItem("Joachim");
        i4 = new JMenuItem("Fredrik");
        i5 = new JMenuItem("Terje");
        menu.add(i1);
        menu.add(i2);
        menu.add(i3);
        menu.add(i4);
        menu.add(i5);
        mb.add(menu);
        mainWindow.setJMenuBar(mb);
        mainWindow.setSize(230, 300);
        mainWindow.setLayout(null);
        mainWindow.setVisible(true);


    }

    private void buttonListen2(ActionEvent actionEvent) {
        ImageIcon icon = new ImageIcon("images//olga.png");
        JOptionPane.showMessageDialog(creditsWindow, "Laget av de flotte gutta fra Backend", "Credits", JOptionPane.INFORMATION_MESSAGE, icon);

    }

    private void buttonListen(ActionEvent actionEvent) {
        System.exit(0);
    }


    public void run() {
        try {
            while (true) {

                Calendar cal = Calendar.getInstance();
                hours = cal.get(Calendar.HOUR_OF_DAY);
                minutes = cal.get(Calendar.MINUTE);
                seconds = cal.get(Calendar.SECOND);

                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                Date date = cal.getTime();
                timeString = formatter.format(date);

                printTime();

                Thread.sleep(1000);  // interval given in milliseconds
            }
        } catch (Exception ignored) {
        }
    }

    public void printTime() {
        watchWindow.setText(timeString);
    }

    public List getContentPane() {
        return null;
    }

    public void setVisible() {
    }

}