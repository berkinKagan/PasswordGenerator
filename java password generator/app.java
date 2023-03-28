
import java.io.File;
import java.awt.Desktop;

import javax.swing.JOptionPane;
public class app {
    public static void main(String[] args) {
        
        String username = JOptionPane.showInputDialog("Enter Your Username");
        String email = JOptionPane.showInputDialog("Enter Your E-mail");
        String appName = JOptionPane.showInputDialog("Enter the App Name");
        int passwordLength = Integer.parseInt(JOptionPane.showInputDialog("Enter the Password length"));


        account acc = new account(username, email, appName, passwordLength);
        
        Desktop desktop = Desktop.getDesktop();
        File file = new File("note.txt");
        acc.writeFile();
        try {
            desktop.open(file);
        } catch (Exception e) {
            // TODO: handle exception
        }
       

       
        
        
    }    
}
