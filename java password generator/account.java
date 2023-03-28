import java.io.FileWriter;
import java.io.Serializable;
public class account implements Serializable {
    private Passwords password;
    private String username;
    private String email;
    private String appName;
    private int passwordLength;
    public static FileWriter writer;

    public account(String username, String email, String appName, int passwordLength){
        this.passwordLength = passwordLength;
        Passwords password = new Passwords(this.passwordLength);
        this.password = password;
        this.appName = appName;
        this.email = email;
        this.username = username;
        try {
            writer = new FileWriter("note.txt");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public Passwords getPassword(){
        return this.password;
    }
    public String getUsername(){
        return this.username;
    }
    public String getEmail(){
        return this.email;
    }
    public String getAppName(){
        return this.appName;
    }

    public String toString(){
        String formatted = "";

        formatted += "App Name: " + getAppName() + "\n";
        formatted += "E-mail: " + getEmail() + "\n";
        formatted += "Username: " + getUsername() + "\n";
        formatted += "Password: " + getPassword().getPassword() + "\n";
        formatted += "-------------------------------------------------------------------------------------------------------------------------";
        
        return formatted;
    }
    public void writeFile(){
        try {
            writer.write(this.toString());
            writer.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }

}
