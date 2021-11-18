import javax.swing.*;

public class Main
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