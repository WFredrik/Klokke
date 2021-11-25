import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;


class CreateLoginForm extends JFrame implements ActionListener, KeyListener {
    JFrame errorBox;
    JButton loginButton;
    JPanel newPanel;
    JLabel userLabel, passLabel;
    final JTextField textField1, textField2;


    CreateLoginForm() {
        textField1 = new JTextField(15);
        textField2 = new JPasswordField(15);
        userLabel = new JLabel();
        userLabel.setText("Username");
        passLabel = new JLabel();
        passLabel.setText("Password");
        loginButton = new JButton("Log in");
        errorBox = new JFrame();
        newPanel = new JPanel(new GridLayout(3, 1));
        newPanel.add(userLabel);
        newPanel.add(textField1);
        newPanel.add(passLabel);
        newPanel.add(textField2);
        newPanel.add(loginButton);

        add(newPanel, BorderLayout.CENTER);

        setTitle("Forekomst Programmet");
        textField1.addKeyListener(this);
        textField2.addKeyListener(this);
        loginButton.addKeyListener(this);
        loginButton.addActionListener(this);
        setLocation(595,350);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }


    public void actionPerformed(ActionEvent ae) {
        String userValue = textField1.getText();
        String passValue = textField2.getText();

        if (userValue.equals("Sander") && passValue.equals("test")) {
            Watch page = new Watch();

            page.setVisible();
            setVisible(false); // skjuler CreateLoginForm

            JLabel wel_label = new JLabel("Velkommen: " + userValue);
            final List contentPane = page.getContentPane();
            // Comment Terje: contentPane is null !!!
            //  Noe er feil i deres Watch-class
            contentPane.add(wel_label);
        } else {
            errorBox.setSize(200, 300);
            JOptionPane.showMessageDialog(errorBox, "Feil passord eller brukernavn");
        }
    }

    private void showKey(String eventType, KeyEvent e) {
        final char keyChar = e.getKeyChar();
        if (keyChar == '\n') {
            System.out.println(eventType + ": ENTER");
        } else {
            System.out.println(eventType + ": " + keyChar);
        }
    }

    private void checkKey(KeyEvent e) {
        if (e.getKeyChar() == '\n') {
            loginButton.doClick();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // showKey("keyTyped", e);
        checkKey(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // showKey("keyPressed", e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // showKey("keyReleased", e);
    }
}