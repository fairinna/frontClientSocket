import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Inna on 12/4/2018.
 */
public class UserClientSide {

    private String userName, password;






    public UserClientSide() {
    }

    public UserClientSide(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public void writeSendToServerNamePass(OutputStream outputStream) throws IOException {
        byte[] userNameBytes = userName.getBytes();
        outputStream.write(userNameBytes.length);
        outputStream.write(userNameBytes);

        byte[] passwordBytes = password.getBytes();
        outputStream.write(passwordBytes.length);
        outputStream.write(passwordBytes);

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
