import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class CreateLoginForm extends JFrame implements ActionListener {
    JFrame errorBox;
    JButton loginButton;
    JPanel newPanel;
    JLabel userLabel, passLabel;
    final JTextField textField1, textField2;
    JRadioButton rememberMe;

    CreateLoginForm() {

        textField1 = new JTextField(15);
        textField2 = new JPasswordField(15);

        userLabel = new JLabel();
        userLabel.setText("Username");

        passLabel = new JLabel();
        passLabel.setText("Password");


        loginButton = new JButton("Log in");
        errorBox = new JFrame();
        rememberMe = new JRadioButton("Remember me");

        newPanel = new JPanel(new GridLayout(3, 1));
        newPanel.add(userLabel);
        newPanel.add(textField1);
        newPanel.add(passLabel);
        newPanel.add(textField2);
        newPanel.add(loginButton);
        newPanel.add(rememberMe);

        add(newPanel, BorderLayout.CENTER);

        loginButton.addActionListener(this);
        setTitle("Forekomst Programmet");
    }

    public void actionPerformed(ActionEvent ae) {
        String userValue = textField1.getText();
        String passValue = textField2.getText();

        if (userValue.equals("Sander") && passValue.equals("test")) {

            Watch page = new Watch();

            page.setVisible();
            setVisible(false); // skjuler CreateLoginForm

            JLabel wel_label = new JLabel("Velkommen: " + userValue);
            page.getContentPane().add(wel_label);
        } else {
            errorBox.setSize(200, 300);
            JOptionPane.showMessageDialog(errorBox, "Feil passord eller brukernavn");


        }
    }
}