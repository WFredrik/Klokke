import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;


class CreateLoginForm extends JFrame implements ActionListener
{
    JFrame errorBox;
    JButton b1;
    JPanel newPanel;
    JLabel userLabel, passLabel;
    final JTextField  textField1, textField2;


    CreateLoginForm()
    {
        errorBox = new JFrame();
        userLabel = new JLabel();
        userLabel.setText("Username");

        textField1 = new JTextField(15);

        passLabel = new JLabel();
        passLabel.setText("Password");

        textField2 = new JPasswordField(15);

        b1 = new JButton("Log in");

        newPanel = new JPanel(new GridLayout(3, 1));
        newPanel.add(userLabel);
        newPanel.add(textField1);
        newPanel.add(passLabel);
        newPanel.add(textField2);
        newPanel.add(b1);

        add(newPanel, BorderLayout.CENTER);

        b1.addActionListener(this);
        setTitle("Forekomst Programmet");
    }

    public void actionPerformed(ActionEvent ae)
    {
        String userValue = textField1.getText();
        String passValue = textField2.getText();

        if (userValue.equals("Sander") && passValue.equals("test")) {

            Watch page = new Watch();

            page.setVisible(true);

            JLabel wel_label = new JLabel("Velkommen: "+userValue);
            page.getContentPane().add(wel_label);
        }
        else{
            errorBox.setSize(200,300);
            JOptionPane.showMessageDialog(errorBox, "Feil passord eller brukernavn");


        }
    }
}
class LoginFormDemo
{
    public static void main(String args[])
    {
        try
        {
            CreateLoginForm form = new CreateLoginForm();
            form.setSize(250,130);
            form.setVisible(true);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
