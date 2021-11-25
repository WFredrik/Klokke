import javax.swing.*;
import java.awt.event.*;

public class Clicker extends JFrame implements ActionListener {
    JFrame clickWindow;
    JButton clickButton;
    JButton resetButton;
    JTextField counterText;

    Clicker() {
        clickButton = new JButton("Click!");
        resetButton = new JButton("Reset");
        counterText = new JTextField();
        clickWindow = new JFrame("Clicker");
        clickWindow.setLocation(595,350);
        clickWindow.add(clickButton);
        clickWindow.add(resetButton);
        clickWindow.add(counterText);
        clickWindow.setSize(250, 200);
        clickWindow.setVisible(true);
        clickWindow.setLayout(null);

        counterText.setBounds(60, 30, 120, 20);

        clickButton.setBounds(19, 100, 100, 50);
        resetButton.setBounds(134, 100, 100, 50);

        clickButton.addActionListener(this::actionPerformed);
        resetButton.addActionListener(this::actionPerformed2);

    }

    int counter = 1;

    public void actionPerformed(ActionEvent e) {
        counterText.setText(counter + " Clicks");
        counter++;
    }

    public void actionPerformed2(ActionEvent e) {
        counter = 0;
        counterText.setText(counter + " Clicks");
    }

}
